package ru.wkn.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UnaryCalculatorTest {

    private UnaryCalculator unaryCalculator;

    @Before
    public void initComponents() {
        unaryCalculator = new UnaryCalculator(3);
    }

    @Test
    public void testRoundedSumOperation() {
        double firstAddend = 4.385954;
        double secondAddend = 3.346;
        assertEquals(Double.valueOf(unaryCalculator.sum(firstAddend, secondAddend)), Double.valueOf(7.732));
    }

    @Test(expected = NumberFormatException.class)
    public void testExceptionCatching() throws NumberFormatException {
        unaryCalculator.setRoundingAccuracy(0);
    }
}
