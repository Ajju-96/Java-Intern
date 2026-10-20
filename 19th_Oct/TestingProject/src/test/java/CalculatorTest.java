import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    public void addTest(){

        Calculator c = new Calculator();
        int actualResult = c.add(20,10);

        assertEquals(30, actualResult);

    }

}