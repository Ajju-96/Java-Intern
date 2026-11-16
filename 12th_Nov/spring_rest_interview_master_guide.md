# Comprehensive Spring Boot & REST Architecture Interview Guide
### Prepared for Tier-1 Product Companies (FAANG / Tier-1 Tech Interviews)

---

## 1. Core REST Architecture & Principles

### 1.1 What is REST, and what makes an API RESTful?
**Technical Definition:**  
REST (**RE**presentational **S**tate **T**ransfer) is an architectural style—introduced by Roy Fielding in his 2000 doctoral dissertation—for distributed hypermedia systems. An API is strictly considered **RESTful** when it adheres to architectural constraints governing resource identification, manipulation through representations, self-descriptive messages, and hypermedia controls (HATEOAS).

**Key Elements:**
*   **Resources as First-Class Citizens:** Everything is modeled as a discrete resource identified by a Uniform Resource Identifier (URI) (e.g., `/api/v1/orders/42`).
*   **Representations:** Clients interact not with the raw underlying storage or database schema, but with standard serialized representations (typically `application/json`, `application/xml`, or Protobuf).
*   **Standard HTTP Semantics:** State transitions are requested via standardized HTTP methods (`GET`, `POST`, `PUT`, `PATCH`, `DELETE`) with semantically standard HTTP status codes (`2xx`, `4xx`, `5xx`).

**Industry Example:**  
Instead of creating RPC-style RPC endpoints like `POST /getUserDetailsById?id=10` or `POST /deleteUser`, a RESTful API standardizes around resources and HTTP verbs:
*   `GET /users/10` $\rightarrow$ Fetch user 10.
*   `DELETE /users/10` $\rightarrow$ Remove user 10.

---

### 1.2 The Six Architectural Constraints of REST
REST is defined by six architectural constraints. Adhering to these is what gives REST systems high scalability, modifiability, and loose coupling.

| Principle | Technical Meaning | Real-World / Architectural Impact |
| :--- | :--- | :--- |
| **1. Statelessness** | The server stores no conversational client state between cycles. Every request must be self-contained. | Enables horizontal scaling behind an L4/L7 load balancer with zero sticky-session reliance. |
| **2. Client-Server Separation** | Complete separation of concerns: Client owns UI/interaction state; Server owns business logic and persistence. | Both components evolve independently (e.g., swapping a React web frontend for a mobile iOS app with zero backend changes). |
| **3. Uniform Interface** | A consistent, predictable contract across endpoints using standard URIs, standard HTTP verbs, and self-descriptive messages. | Decouples clients from backend implementation details; simplifies API consumability and tooling (SDKs, Swagger). |
| **4. Cacheability** | Responses must implicitly or explicitly define themselves as cacheable or non-cacheable (`Cache-Control`, `ETag`). | Dramatically lowers server latency and upstream bandwidth by serving requests directly from CDNs, proxies, or client caches. |
| **5. Layered System** | Architecture composed of hierarchical layers (Proxies, Gateways, Load Balancers, Firewalls). The client cannot tell if it is connected directly to the origin server. | Enables transparent insertion of security (WAF), load balancing, and rate limiting layers without altering client/server code. |
| **6. Code on Demand (Optional)** | The server can temporarily extend or customize client functionality by transferring executable code (e.g., JavaScript scripts, WebAssembly). | Rarely used in typical microservices REST APIs, but standard in web browsers downloading frontend scripts dynamically. |

---

### 1.3 Statelessness in REST: Architecture & Scalability
**Technical Definition:**  
Statelessness dictates that every incoming request from a client to a server must contain **all the context, authorization credentials, and parameters** required to understand and satisfy the request. The server must never store HTTP session context (`HttpSession`) across requests in memory.

```
[ Client ]
    │
    │  Request 1: GET /profile (Auth: Bearer JWT_TOKEN)
    ▼
[ Load Balancer (Round Robin) ] ──▶ [ Pod A (Stateless) ] ──▶ Validates Token Signature (Local CPU)
    │
    │  Request 2: GET /orders (Auth: Bearer JWT_TOKEN)
    ▼
[ Load Balancer (Round Robin) ] ──▶ [ Pod B (Stateless) ] ──▶ Validates Token Signature (Local CPU)
```

**Why it is critical for High Availability & Elasticity:**
1. **Zero Session Replication Overhead:** When state is stored on servers (like legacy J2EE cluster session sync), memory consumption grows linearly with user count, and replicating state across pods introduces significant network thrashing.
2. **Horizontal Auto-scaling:** Instances can be spawned or terminated instantly during peak loads. Any node can handle any request from any client.
3. **Resilience & Fault Tolerance:** If node `A` crashes mid-transaction, an upstream gateway can transparently retry the request against node `B` without session loss.

---

## 2. HTTP Methods, Idempotency & Status Codes

### 2.1 POST vs. PUT vs. PATCH

| Dimension | `POST` | `PUT` | `PATCH` |
| :--- | :--- | :--- | :--- |
| **Primary Semantic** | Create a new subordinate resource. | Replace/overwrite the target resource completely. | Apply a set of partial changes to an existing resource. |
| **Idempotency** | **No** (Repeated calls create duplicates). | **Yes** (Repeated calls yield identical state). | **Conditionally** (Usually non-idempotent by spec, though often implemented idempotently). |
| **Resource URI Target** | Target collection URI: `POST /api/v1/users` | Specific resource URI: `PUT /api/v1/users/42` | Specific resource URI: `PATCH /api/v1/users/42` |
| **Payload Requirement** | Initial resource attributes. | Full replacement payload. Omitted optional fields will typically be cleared/nulled out. | Differential delta only (e.g., JSON Patch RFC 6902 or partial key-value map). |

#### Deep Dive: Why PUT Replaces and PATCH Updates
*   **PUT (Idempotent Replacement):**
    ```http
    PUT /users/42 HTTP/1.1
    { "name": "Alice", "email": "alice@corp.com" }
    ```
    If `phone` previously existed on user 42 and is omitted in a strict PUT request, `phone` becomes `null` or is reset to default.
*   **PATCH (Partial Delta):**
    ```http
    PATCH /users/42 HTTP/1.1
    { "email": "alice_new@corp.com" }
    ```
    Only the `email` field is modified. All other attributes retain their current state.

---

### 2.2 Idempotency in Distributed Systems
**Formal Definition:**  
An HTTP method is **idempotent** if the intended effect on the server of $N > 0$ identical requests is the exact same as for a single request:
$$f(f(x)) = f(x)$$

*Note:* Idempotency applies to **server side state**, not the response code. For instance, calling `DELETE /orders/1` returns `204 No Content` first, and subsequent calls might return `404 Not Found`. However, the server's data state remains identical (the order is deleted). Hence, `DELETE` is idempotent.

| HTTP Method | Safe? (Read-Only) | Idempotent? | RFC Spec Details |
| :---: | :---: | :---: | :--- |
| **GET** | **Yes** | **Yes** | Retrieves representation; no side effects on server state. |
| **HEAD** | **Yes** | **Yes** | Identical to GET without body; returns headers only. |
| **PUT** | No | **Yes** | Overwrites resource. Re-running set operations yields identical state. |
| **DELETE**| No | **Yes** | Resource is transitioned to absent. Repeating yields absent state. |
| **POST** | No | **No** | Appends/creates resources. Multiple calls create multiple instances. |
| **PATCH** | No | **Depends** | Non-idempotent if using relative operations (e.g., `{"op": "increment", "value": 5}`). Idempotent if absolute (`{"email": "x"}`). |

---

### 2.3 Designing an Idempotent POST Architecture (Payment & Order Engines)
Because network partitions are inevitable (the client sends money, the server charges the card, but the network drops before the `200 OK` returns), clients will retry. To prevent double-charging:

#### The Idempotency Key Architecture
```
[ Client ]                [ API Gateway / App Server ]              [ Distributed Store (Redis) / DB ]
    │                                  │                                           │
    │  POST /checkout                  │                                           │
    │  Header: Idempotency-Key: K-123  │                                           │
    ├─────────────────────────────────▶│                                           │
    │                                  │── SETNX "idemp:K-123", "IN_PROGRESS" ────▶│
    │                                  │   (TTL: 120s)                             │
    │                                  │◀─ Acquire Lock OK ────────────────────────┤
    │                                  │                                           │
    │                                  │── Execute DB Transaction (Deduce balance) │
    │                                  │── Write Result: "idemp:K-123" = {201, Order}
    │◀─ Return 201 Created ────────────┤                                           │
    │                                  │                                           │
    │  [RETRY DUE TO TIMEOUT]          │                                           │
    │  POST /checkout                  │                                           │
    │  Header: Idempotency-Key: K-123  │                                           │
    ├─────────────────────────────────▶│                                           │
    │                                  │── Check "idemp:K-123" ───────────────────▶│
    │                                  │◀─ Returns CACHED_RESPONSE {201, Order} ───┤
    │◀─ Return 201 Created (Cached) ───┤                                           │
```

**Implementation Pattern in Spring Boot:**
1. **Client Generation:** Client generates a unique UUID `v4` before initiating a transactional operation and passes it via `Idempotency-Key` or `X-Idempotency-Key`.
2. **Distributed Lock & Verification:** A Spring `HandlerInterceptor` or `Filter` intercepts the request.
3. **Atomic State Check:**
   * If the key is new: Store it in Redis with status `IN_PROGRESS` and a short TTL (e.g., 2 minutes to guard against hanging worker threads).
   * If the key exists and is `IN_PROGRESS`: Return `409 Conflict` (concurrent duplicate request processing).
   * If the key exists and is `COMPLETED`: Short-circuit request execution and immediately return the stored HTTP status code and response payload.

---

### 2.4 Crucial HTTP Status Codes Reference

```
+---------------------------------------------------------------------------------------+
| 2xx Success       | 200 OK           | Standard successful response.                  |
|                   | 201 Created      | Resource created; include 'Location' header.   |
|                   | 202 Accepted     | Async task accepted; processing not complete.  |
|                   | 204 No Content   | Action succeeded; payload empty (PUT/DELETE).  |
+---------------------------------------------------------------------------------------+
| 3xx Redirection   | 301 Moved Perm.  | URI permanently changed.                       |
|                   | 304 Not Modified | Client cache validated via ETag/If-None-Match. |
+---------------------------------------------------------------------------------------+
| 4xx Client Error  | 400 Bad Request  | Payload validation failed or bad syntax.       |
|                   | 401 Unauthorized | Missing or invalid authentication token.      |
|                   | 403 Forbidden    | Authenticated, but lacks required role/RBAC.   |
|                   | 404 Not Found    | Target resource does not exist.                |
|                   | 409 Conflict     | State conflict (e.g., duplicate unique key).   |
|                   | 422 Unproc. Entity| Syntax correct, semantic validations failed.  |
|                   | 429 Too Many Req.| Exceeded rate limits (Token bucket / Leaky).   |
+---------------------------------------------------------------------------------------+
| 5xx Server Error  | 500 Internal Err | Uncaught exception / generic runtime failure.  |
|                   | 502 Bad Gateway  | Upstream reverse proxy received invalid answer.|
|                   | 503 Service Unavail| Service down or saturated.                   |
|                   | 504 Gateway T/O  | Upstream service timed out.                    |
+---------------------------------------------------------------------------------------+
```

#### Precise Difference: 401 Unauthorized vs. 403 Forbidden
*   **`401 Unauthorized` (Unauthenticated):** The user's identity is **unverified or unknown**. The request lacks valid authentication credentials.  
    *Analogy:* You arrive at an airport boarding gate without an ID card or ticket. You cannot be identified.
*   **`403 Forbidden` (Unauthorized Permission):** The server **knows who you are**, but you **do not possess the required privileges** to access the resource.  
    *Analogy:* You show a valid Economy Class boarding pass, but attempt to enter the VIP First Class Lounge. Your identity is verified, but access is explicitly denied.

---

## 3. Security: Authentication, Authorization & Protection

### 3.1 Authentication vs. Authorization

```
            +────────────────────────────────────────────────────────+
            |                  Incoming HTTP Request                 |
            +────────────────────────────────────────────────────────+
                                        │
                                        ▼
            +────────────────────────────────────────────────────────+
            |              STEP 1: Authentication (AuthN)            |
            |                 "Who are you presenting?"              |
            |        Validates signature, expiration, and issuer.    |
            +────────────────────────────────────────────────────────+
                                        │
                        Identity Established: User "John"
                                        │
                                        ▼
            +────────────────────────────────────────────────────────+
            |              STEP 2: Authorization (AuthZ)             |
            |               "What are you allowed to do?"            |
            |     Evaluates user roles/scopes against resource ACL.  |
            +────────────────────────────────────────────────────────+
                                        │
                 Has "ROLE_ADMIN"? ── NO ──▶ 403 Forbidden
                                   ── YES ──▶ Process Endpoint
```

---

### 3.2 Spring Security + JWT Stateless Execution Flow
In modern microservice architectures, API gateways and backends secure endpoints using stateless JSON Web Tokens (JWT).

#### Complete Request Filter Chain Lifecycle:
1. **Login Phase:** The client sends credentials via `POST /api/v1/auth/login`. The backend validates the password hash (via `BCryptPasswordEncoder`) and returns a cryptographically signed compact JWT token containing claims (Subject, Expiration, Roles).
2. **Subsequent API Request:** The client passes the token in the standard HTTP header:
   ```http
   Authorization: Bearer <header>.<payload>.<signature>
   ```
3. **Execution Pipeline Inside Spring Security:**
   * **`JwtAuthenticationFilter` (Custom `OncePerRequestFilter`):** Extracts the header, removes the prefix `Bearer `, and validates the cryptographic signature using the public key or shared HMAC secret.
   * **Claims Extraction:** Extracts username, expiry, and authorities (`List<GrantedAuthority>`).
   * **SecurityContext Initialization:** Constructs an `Authentication` object (`UsernamePasswordAuthenticationToken`) and loads it into the thread-local context:
     ```java
     SecurityContextHolder.getContext().setAuthentication(authToken);
     ```
   * **Filter Pipeline Traversal:** The request passes downstream to `FilterSecurityInterceptor`. If annotations like `@PreAuthorize("hasRole('ADMIN')")` are encountered, the token's authorities are verified against the required privileges.

---

### 3.3 CORS (Cross-Origin Resource Sharing)
**Technical Definition:**  
CORS is a browser-enforced security mechanism (Same-Origin Policy) that prevents malicious scripts on one origin from accessing sensitive resources on a different origin (where origin is defined by scheme, host, and port).

#### The Preflight Request (`OPTIONS`)
When a cross-origin client issues a non-simple request (e.g., using `PUT`, `DELETE`, or custom headers like `Authorization` or `Content-Type: application/json`), the browser automatically emits a preflight check:
```http
OPTIONS /api/v1/users HTTP/1.1
Origin: https://dashboard.myfrontend.com
Access-Control-Request-Method: PUT
Access-Control-Request-Headers: Authorization
```
The server must respond with appropriate CORS headers (`Access-Control-Allow-Origin`, `Access-Control-Allow-Methods`) before the browser will emit the actual payload.

**Configuring Global CORS in Spring Security 6+:**
```java
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))
            .csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
            .build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(List.of("https://app.production.com", "http://localhost:3000"));
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        config.setAllowedHeaders(List.of("Authorization", "Content-Type", "Idempotency-Key"));
        config.setAllowCredentials(true);
        config.setMaxAge(3600L); // Cache preflight checks for 1 hour

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}
```

---

### 3.4 CSRF (Cross-Site Request Forgery) & Why It Is Disabled in Pure REST APIs
**What is CSRF?**  
CSRF is an attack where an untrusted site causes a user's web browser to perform an unwanted action on a trusted site where the user is currently authenticated.

**The Browser Attack Vector:**  
CSRF exploits ambient authorization via **browser cookies**. When a browser issues a cross-site HTTP request to a target domain, it automatically attaches cookies associated with that domain. If a bank uses session cookies (`JSESSIONID`) without CSRF tokens, a hidden form submit on `evil.com` will submit authenticated requests to `bank.com/transfer`.

**When can CSRF be disabled in a REST API?**
* **CSRF must be disabled** (`http.csrf(AbstractHttpConfigurer::disable)`) when building a **stateless, token-based REST API** where clients pass access tokens via the `Authorization: Bearer <token>` header.
* **Why?** Browsers never automatically attach headers across origins. JavaScript must explicitly inject the `Authorization` header. Since `evil.com` cannot inject headers into cross-site form submissions or standard image tags, the attack vector is completely eliminated.
* **Exception:** If your REST API stores session IDs or access tokens inside standard browser cookies (`HttpOnly`), you **must** leave CSRF protection enabled and implement CSRF double-submit cookies or SameSite cookie controls (`SameSite=Strict` or `Lax`).

---

## 4. Production Exception Handling & Validation

### 4.1 Global Exception Handling: `@ControllerAdvice` vs. `@ExceptionHandler`

```
           [ Client sends invalid JSON ]
                         │
                         ▼
             [ DispatcherServlet ]
                         │
                         ▼
             [ Target RestController ] ──▶ Throws ResourceNotFoundException("User 10")
                         │
        ┌────────────────┴────────────────┐
        ▼                                 ▼
[ Local Handler? ]               [ Scan @RestControllerAdvice ]
(Checked within controller)     (Finds matching @ExceptionHandler)
        │                                 │
   Not Found                              ▼
        └────────────────────────▶ Returns ProblemDetails (RFC 7807)
                                   HTTP 404 Not Found
```

*   **`@ExceptionHandler`:** An annotation applied to a method to handle specific exceptions. If declared inside a single `@Controller`, it only catches exceptions thrown by that specific controller class.
*   **`@ControllerAdvice` / `@RestControllerAdvice`:** An interceptor built using Spring AOP that catches exceptions thrown across the **entire application** across all `@RequestMapping` classes.

#### Implementation using RFC 7807 (Problem Details Standard):
```java
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ProblemDetail> handleResourceNotFound(ResourceNotFoundException ex) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        problem.setTitle("Resource Not Found");
        problem.setType(URI.create("https://api.domain.com/errors/not-found"));
        problem.setProperty("timestamp", Instant.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problem);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ProblemDetail> handleValidationErrors(MethodArgumentNotValidException ex) {
        ProblemDetail problem = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        problem.setTitle("Constraint Violation");
        
        Map<String, String> fieldErrors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> 
            fieldErrors.put(error.getField(), error.getDefaultMessage())
        );
        problem.setProperty("invalidFields", fieldErrors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(problem);
    }
}
```

---

### 4.2 Data Validation: `@Valid` vs. `@Validated`

| Dimension | `@Valid` | `@Validated` |
| :--- | :--- | :--- |
| **Origin / Spec** | Standard Jakarta Bean Validation (`jakarta.validation.Valid`). | Spring Framework-specific (`org.springframework.validation.annotation.Validated`). |
| **Primary Scope** | Used on Controller RequestBodies, DTO properties, and nested objects. | Can be applied on Spring `@Service`, `@Repository`, or Controller classes. |
| **Validation Groups** | Does **not** support validation groups natively. | **Supports validation groups** (e.g., validate distinct rules on Create vs. Update). |
| **Method Parameter Validation**| Cannot trigger parameter validation directly on Spring beans. | Triggers method validation interception (`MethodValidationPostProcessor`). |

#### Enterprise Code Example: Validation Groups
```java
// Markers
public interface OnCreate {}
public interface OnUpdate {}

// DTO
public class UserRequestDto {
    @Null(groups = OnCreate.class, message = "ID must be null when creating")
    @NotNull(groups = OnUpdate.class, message = "ID is mandatory when updating")
    private Long id;

    @NotBlank(message = "Username cannot be blank")
    @Size(min = 3, max = 50)
    private String username;

    @Email(message = "Malformed email address")
    private String email;
}

// Controller
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @PostMapping
    public ResponseEntity<UserResponse> create(
        @Validated(OnCreate.class) @RequestBody UserRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> update(
        @PathVariable Long id,
        @Validated(OnUpdate.class) @RequestBody UserRequestDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }
}
```

---

### 4.3 Parameter Handling: `@PathVariable` vs. `@RequestParam`

*   **`@PathVariable` (Resource Identification):** Used to bind URI template variables directly identifying an exact resource in the hierarchy.
    *   *Path:* `GET /api/v1/tenants/99/orders/102`
    *   *Semantics:* Identifies the specific entity. The URL is uniquely anchored to resource identity.
*   **`@RequestParam` (Filtering, Sorting, Pagination, Options):** Used to retrieve query parameters (`?key=val`), form data, or optional criteria that change the projection/presentation of the resource collection.
    *   *Query:* `GET /api/v1/orders?status=PENDING&page=0&size=20&sort=createdAt,desc`
    *   *Semantics:* Modifies how resources are presented, searched, or paginated.

---

## 5. API Design, Versioning & Large Scale I/O

### 5.1 Pagination, Sorting, and Deep Paging Pitfalls
When querying tables containing millions of rows, returning complete datasets causes Out-Of-Memory (OOM) crashes and network saturation.

#### Offset-Based Pagination (Spring Data `Pageable`)
```java
@GetMapping
public ResponseEntity<Page<UserResponse>> getUsers(
    @PageableDefault(page = 0, size = 20, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable) {
    return ResponseEntity.ok(userService.findAll(pageable));
}
```
*Generated SQL:*
```sql
SELECT * FROM users ORDER BY created_at DESC LIMIT 20 OFFSET 100000;
```
* **The "Deep Paging" Problem:** `OFFSET 100000 LIMIT 20` requires the database engine to scan 100,020 index entries, discard the first 100,000 in memory, and return 20. Latency degrades linearly ($O(N)$) as page numbers increase.
* **Tier-1 Solution: Keyset (Seek) Pagination:** Instead of offset, use the last-seen identifier as an indexed cursor:
  ```sql
  SELECT * FROM users WHERE created_at < :lastSeenTimestamp ORDER BY created_at DESC LIMIT 20;
  ```
  This executes in $O(\log N)$ time by traversing the B-Tree index directly.

---

### 5.2 API Versioning Strategies

| Strategy | Example Pattern | Pros | Cons |
| :--- | :--- | :--- | :--- |
| **URI Path Versioning** *(Most Common)* | `/api/v1/orders`<br>`/api/v2/orders` | Extremely explicit; easy to cache at CDN/Gateway; simplest for clients to inspect. | URL pollution; violates pure hypermedia philosophy; encourages large version jumps. |
| **Header Versioning** | `X-API-Version: 2` | Preserves clean resource URIs. | Difficult to inspect directly in standard browser bars; harder to cache cleanly on CDNs without `Vary` headers. |
| **Content Negotiation** *(Accept Header)* | `Accept: application/vnd.company.v2+json` | True REST Fielding style; cleanly models representation transitions. | High complexity for client developers and testing tools (Postman, curl). |

---

### 5.3 Backward Compatibility Rules in Distributed Systems
When continuous deployment occurs across hundreds of microservices, backends are updated while clients run older contracts. Breaking contracts breaks production.

**Safe (Non-Breaking) Changes:**
* Adding new, optional fields to a JSON request payload.
* Adding new fields to a response payload (assuming clients use non-strict deserialization like Jackson's `FAIL_ON_UNKNOWN_PROPERTIES = false`).
* Introducing new standalone endpoints.
* Deprecating fields using documentation while continuing to support them for a sunset period.

**Breaking Changes (Require New Versioning):**
* Renaming existing JSON property names (`account_number` $\rightarrow$ `accountId`).
* Altering field data types (e.g., converting a numeric timestamp `1700000000` to ISO-8601 string `"2026-11-12T00:00:00Z"`).
* Making an optional request parameter or body field strictly required (`@NotNull`).
* Modifying error response schemas or turning a `200 OK` into a fundamentally different structure.

---

### 5.4 Streaming Large File Uploads and Downloads
Loading a 2GB file directly into memory via `byte[]` will trigger frequent GC pauses and cause an immediate JVM `OutOfMemoryError: Java heap space`.

```
                    BAD PATTERN: In-Memory Buffering
Client ──── 2GB Payload ────▶ [ Heap Buffer (2GB) ] ────▶ JVM OOM Crash!

                    TIER-1 PATTERN: Streaming I/O
Client ──── Stream Chunk (8KB) ────▶ Ring Buffer ────▶ Stream to S3 / Disk
```

#### Streaming Download via `StreamingResponseBody`
Instead of buffering, write directly to the servlet output stream in small chunks:
```java
@GetMapping("/exports/{reportId}")
public ResponseEntity<StreamingResponseBody> streamReport(@PathVariable String reportId) {
    StreamingResponseBody responseBody = outputStream -> {
        try (InputStream inputStream = storageService.getFileStream(reportId)) {
            byte[] buffer = new byte[8192];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
                outputStream.flush();
            }
        }
    };

    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"report.csv\"")
        .contentType(MediaType.APPLICATION_OCTET_STREAM)
        .body(responseBody);
}
```

#### Enterprise Upload Pattern: S3 Pre-Signed URLs
For massive file transfers, **completely bypass the Spring Boot application server**:
1. Client requests an upload token: `POST /api/v1/files/upload-ticket`.
2. Spring Boot queries the AWS/GCP SDK to generate a temporary, cryptographically signed pre-signed URL with a 15-minute expiration.
3. Client streams the file directly to Object Storage (Amazon S3 / GCS).
4. S3 notifies the backend via Webhook or SQS once the upload completes.

---

### 5.5 Enterprise API Documentation: OpenAPI 3 / Swagger
In microservice architectures, maintaining shared contracts manually leads to drift. We use **OpenAPI 3.0** via `springdoc-openapi`:

```xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.3.0</version>
</dependency>
```

* **Contract First vs. Code First:** Tier-1 teams often define the contract via an OpenAPI YAML file first, automatically generating Java DTOs and client SDKs via the `openapi-generator-maven-plugin`. This guarantees frontend and backend teams work against a concrete contract before writing backend logic.

---

## 6. Microservices Reliability: Retries, Distributed Transactions & Resilience

### 6.1 Resilient Retries & Backoff Strategy
Retrying every failure blindly creates a **Retry Storm** (thundering herd), which can bring down a struggling upstream dependency.

```java
@Retry(name = "paymentGateway", fallbackMethod = "fallbackPayment")
public PaymentResponse executePayment(PaymentRequest request) {
    return restTemplate.postForObject(gatewayUrl, request, PaymentResponse.class);
}
```

#### Rules for Retrying:
1. **Never retry 4xx errors:** A `400 Bad Request` or `401 Unauthorized` will never succeed on retry; it wastes resources.
2. **Only retry transient 5xx/network errors:** Retry on `503 Service Unavailable`, `504 Gateway Timeout`, or socket connection resets.
3. **Always use Exponential Backoff + Jitter:**  
   $$\text{Backoff Interval} = \text{Base} \times 2^{\text{attempt}} + \text{Random Jitter}$$
   Jitter spreads retry spikes across time to prevent synchronized waves of traffic from overwhelming upstream services.

---

### 6.2 Partial Failures & The Saga Pattern
In microservices, two-phase commits (2PC) do not scale across network boundaries. When an operation spans multiple databases (e.g., Order Service, Inventory Service, Payment Service), use the **Saga Pattern**.

```
[ Choreography-Based Saga ]
   Order Service          Payment Service         Inventory Service
         │                       │                        │
         ├─── Order Created ────▶│                        │
         │                        ├─── Payment Processed ─▶│
         │                        │                        ├─── Out of Stock!
         │                        │                        │    (Raise Fault Event)
         │◀── Compensate Payment ─┴────────────────────────┘
         ▼    (Refund Transaction)
   Cancel Order
```

*   **Compensating Transactions:** A backward-recovery transaction that semantically undoes an earlier operation (e.g., if inventory reservation fails, trigger a refund transaction on the payment processor).
*   **Orchestration vs. Choreography:**
    *   **Choreography:** Services react to domain events broadcasted via Apache Kafka.
    *   **Orchestration:** A central coordinator (e.g., Temporal or Camunda workflow engine) explicitly instructs each service which step to perform next.

---

## 7. Tier-1 Interview Cheat Sheet: Quick Answers

```
Q: What makes an API idempotent?
A: An API is idempotent if sending identical requests repeatedly produces the exact
   same server state as a single invocation (e.g., PUT, DELETE, GET).

Q: How do you make a POST payment idempotent?
A: Require a unique Idempotency-Key header. Atomically check and reserve the key in
   Redis (SETNX). Cache the final outcome against the key so subsequent retries return
   the original response without re-executing business logic.

Q: 401 vs. 403?
A: 401 = Missing/invalid identity credentials (Unauthenticated).
   403 = Identity is verified, but lacks sufficient permissions/roles (Unauthorized).

Q: When do you disable CSRF in Spring Boot?
A: When designing stateless REST APIs using custom Authorization headers (Bearer tokens)
   without browser session cookies, because cross-site requests cannot inject custom headers.

Q: Deep Paging fix in SQL/Spring Data?
A: Avoid OFFSET/LIMIT for high offsets due to full index scans. Replace with Keyset/Cursor
   pagination using indexed columns (WHERE id < :cursor LIMIT :size).
```