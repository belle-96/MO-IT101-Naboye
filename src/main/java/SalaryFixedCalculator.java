package com.payrollsystem.motorph;

/**
 * SalaryFixedCalculator calculates salaries for employees
 * with a fixed monthly compensation.
 * 
 * This implementation does not support hourly-based salary calculations.
 */
public class SalaryFixedCalculator implements SalaryCalculator {

    /**
     * Calculates the net salary of the employee.
     * Net salary = Gross salary - Deductions.
     *
     * @param employee The employee whose salary is to be calculated.
     * @return The net salary.
     */
    @Override
    public double calculateSalary(Employee employee) {
        double gross = calculateGrossSalary(employee);
        double deductions = calculateDeductions(employee);
        return gross - deductions;
    }

    /**
     * Not supported in fixed salary calculation.
     * Throws UnsupportedOperationException if called.
     *
     * @param employee The employee.
     * @param hoursWorked Number of hours worked.
     * @return Throws exception.
     */
    @Override
    public double calculateSalary(Employee employee, double hoursWorked) {
        throw new UnsupportedOperationException("This method is not supported for fixed salary.");
    }

    /**
     * Calculates the gross salary of the employee.
     * Formula: Basic Salary + Rice Subsidy + Phone Allowance + Clothing Allowance.
     *
     * @param employee The employee.
     * @return The gross salary.
     */
    @Override
    public double calculateGrossSalary(Employee employee) {
        return employee.getBasicSalary() + employee.getRiceSubsidy() 
                + employee.getPhoneAllowance() + employee.getClothingAllowance();
    }

    /**
     * Not supported in fixed salary calculation.
     * Throws UnsupportedOperationException if called.
     *
     * @param employee The employee.
     * @param hoursWorked Number of hours worked.
     * @return Throws exception.
     */
    @Override
    public double calculateGrossSalary(Employee employee, double hoursWorked) {
        throw new UnsupportedOperationException("This method is not supported for fixed salary.");
    }

    /**
     * Calculates the total deductions for the employee based on their basic salary.
     *
     * @param employee The employee.
     * @return Total deductions.
     */
    @Override
    public double calculateDeductions(Employee employee) {
        SalaryDeductions salaryDeductions = new SalaryDeductions();
        return salaryDeductions.getTotalDeductions(employee.getBasicSalary());
    }
}
