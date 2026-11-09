package com.bits.leave;
// BITS ID: 2024sl70003
public class LeaveCalculator {

    // Calculate remaining leave balance
    public static int calculateLeaveBalance(int totalLeaves, int leavesTaken) {

        if (totalLeaves < 0 || leavesTaken < 0 || leavesTaken > totalLeaves) {
            throw new IllegalArgumentException("Invalid leave details");
        }

        return totalLeaves - leavesTaken;
    }

    // Calculate leave encashment amount
    public static double calculateLeaveEncashment(int leaveBalance, double dailySalary) {

        if (leaveBalance < 0 || dailySalary < 0) {
            throw new IllegalArgumentException("Invalid leave or salary details");
        }

        return leaveBalance * dailySalary;
    }
}
