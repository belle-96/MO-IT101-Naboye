package com.payrollsystem.motorph;

/**
 * The SalaryCalculator interface defines methods for calculating 
 * an employee's salary, gross pay, and deductions. 
 * It supports both fixed salary and hourly-based salary computations.
 */
public interface SalaryCalculator {

    /**
     * Calculates the net salary for an employee with a fixed salary.
     * Net salary is typically the gross salary minus deductions.
     *
     * @param employee The employee whose net salary is being calculated.
     * @return The net salary amount.
     */
    double calculateSalary(Employee employee);

    /**
     * Calculates the net salary based on hours worked.
     * Used for employees paid by the hour.
     *
     * @param employee The employee.
     * @param hoursWorked The number of hours the employee worked.
     * @return The net salary based on hours worked.
     */
    double calculateSalary(Employee employee, double hoursWorked);

    /**
     * Calculates the gross salary for an employee with a fixed salary.
     *
     * @param employee The employee.
     * @return The gross salary amount.
     */
    double calculateGrossSalary(Employee employee);

    /**
     * Calculates the gross salary based on hours worked.
     * Useful for hourly wage employees.
     *
     * @param employee The employee.
     * @param hoursWorked The number of hours the employee worked.
     * @return The gross salary amount based on hours worked.
     */
    double calculateGrossSalary(Employee employee, double hoursWorked);

    /**
     * Calculates total deductions from an employee’s salary.
     * This may include taxes, contributions, and other withholdings.
     *
     * @param employee The employee.
     * @return The total deduction amount.
     */
    double calculateDeductions(Employee employee);
}
