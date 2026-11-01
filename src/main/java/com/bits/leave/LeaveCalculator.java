
package com.bits.leave;

public class LeaveCalculator {

    // Calculates remaining employee leave balance
    public int calculateRemainingLeave(
            int totalLeave, int leaveTaken) {

        if (totalLeave < 0 || leaveTaken < 0) {
            throw new IllegalArgumentException(
                "Leave days cannot be negative");
        }

        if (leaveTaken > totalLeave) {
            throw new IllegalArgumentException(
                "Leave taken cannot exceed total leave");
        }

        return totalLeave - leaveTaken;
    }

    // Calculates leave encashment amount
    // Assumption: 30 days per month
    public double calculateEncashment(
            double monthlySalary, int encashableDays) {

        if (monthlySalary < 0 || encashableDays < 0) {
            throw new IllegalArgumentException(
                "Salary and leave days cannot be negative");
        }

        double dailySalary = monthlySalary / 30.0;

        return dailySalary * encashableDays;
    }
}
