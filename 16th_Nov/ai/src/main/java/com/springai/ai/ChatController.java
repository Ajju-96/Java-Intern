
package com.springai.ai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ChatController {

    private final ChatClient chatClient;

    public ChatController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @PostMapping("/chat")
    public ChatResponse chat(@RequestBody ChatRequest request) {

        String answer = chatClient.prompt()
                .user(request.message())
                .call()
                .content();

        return new ChatResponse(answer);
    }

    public record ChatRequest(String message) {}

    public record ChatResponse(String answer) {}
}
