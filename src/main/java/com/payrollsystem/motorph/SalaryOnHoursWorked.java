package com.payrollsystem.motorph;

public class SalaryOnHoursWorked implements SalaryCalculator {
    @Override
    public double calculateSalary(Employee employee) {
        double hourlyRate = employee.getHourlyRate();
        int hoursWorked = 160; // Example: Fixed hours
        return hourlyRate * hoursWorked;
    }
}
