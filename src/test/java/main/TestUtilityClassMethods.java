package test.java.main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import main.random.UtilityClass;

public class TestUtilityClassMethods {
	
    @Test
    public void divideNumbersWithoutDivideMultiplyModulus() {

        int five = UtilityClass.divide(10, 2);

        Assertions.assertEquals(5, five);
        Assertions.assertEquals(-10, UtilityClass.divide(100, -10));
        Assertions.assertNotEquals(6, five);
    }

}
