package com.payrollsystem.motorph;

public interface SalaryCalculator {
    double calculateSalary(Employee employee);  // For fixed salary
    double calculateSalary(Employee employee, double hoursWorked);  // For salary based on hours worked
    double calculateGrossSalary(Employee employee);  // For calculating gross salary
    double calculateGrossSalary(Employee employee, double hoursWorked);  // For calculating gross salary based on hours worked
    double calculateDeductions(Employee employee);  // For calculating deductions
}
