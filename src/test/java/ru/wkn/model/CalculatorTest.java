package ru.wkn.model;

import org.junit.Before;
import org.junit.Test;
import ru.wkn.model.calculating.Calculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void initComponents() {
        calculator = new Calculator(3);
    }

    @Test
    public void testRoundedSumOperation() {
        assertEquals(Double.valueOf(calculator.sum(4.385954, 3.346)), Double.valueOf(7.732));
        assertNotEquals(calculator.sum(4.385954, 3.346), 7.731954);
        assertEquals(Double.valueOf(calculator.sum(4.3333, 3.1111)), Double.valueOf(7.444));
    }

    @Test(expected = NumberFormatException.class)
    public void testExceptionCatching() throws NumberFormatException {
        calculator.setRoundingAccuracy(0);
    }
}
