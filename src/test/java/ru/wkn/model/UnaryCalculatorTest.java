package ru.wkn.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class UnaryCalculatorTest {

    private UnaryCalculator unaryCalculator;

    @Before
    public void initComponents() {
        unaryCalculator = new UnaryCalculator(3);
    }

    @Test
    public void testRoundedSumOperation() {
        assertEquals(Double.valueOf(unaryCalculator.sum(4.385954, 3.346)), Double.valueOf(7.732));
        assertNotEquals(unaryCalculator.sum(4.385954, 3.346), 7.731954);
        assertEquals(Double.valueOf(unaryCalculator.sum(4.3333, 3.1111)), Double.valueOf(7.444));
    }

    @Test(expected = NumberFormatException.class)
    public void testExceptionCatching() throws NumberFormatException {
        unaryCalculator.setRoundingAccuracy(0);
    }
}
