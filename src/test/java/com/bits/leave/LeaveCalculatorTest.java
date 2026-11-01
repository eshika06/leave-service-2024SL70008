
package com.bits.leave;

import org.junit.Test;
import static org.junit.Assert.*;

public class LeaveCalculatorTest {

    LeaveCalculator calculator = new LeaveCalculator();

    // Test 1: Remaining leave calculation
    @Test
    public void testRemainingLeave() {

        int result = calculator.calculateRemainingLeave(30, 10);

        assertEquals(20, result);
    }

    // Test 2: Leave encashment calculation
    @Test
    public void testLeaveEncashment() {

        double result = calculator.calculateEncashment(60000, 5);

        assertEquals(10000.0, result, 0.001);
    }

    // Test 3: Invalid leave calculation
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidLeave() {

        calculator.calculateRemainingLeave(20, 25);
    }
}
