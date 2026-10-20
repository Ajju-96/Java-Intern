import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FactorialTest {

    @Test
    public void findFactorial(){
        Factorial f = new Factorial();
        int actualFactorial = f.factorial(3);
        assertEquals(6, actualFactorial);
    }

}