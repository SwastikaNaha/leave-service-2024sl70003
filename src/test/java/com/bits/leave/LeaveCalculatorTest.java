package com.bits.leave;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LeaveCalculatorTest {

    // Test 1: Verify leave balance calculation
    @Test
    public void testLeaveBalance() {
        int balance = LeaveCalculator.calculateLeaveBalance(30, 12);
        assertEquals(18, balance);
    }

    // Test 2: Verify leave encashment calculation
    @Test
    public void testLeaveEncashment() {
        double amount = LeaveCalculator.calculateLeaveEncashment(18, 1000.0);
        assertEquals(18000.0, amount, 0.01);
    }

    // Test 3: Verify zero leave balance
    @Test
    public void testZeroLeaveBalance() {
        int balance = LeaveCalculator.calculateLeaveBalance(20, 20);
        assertEquals(0, balance);
    }
}
