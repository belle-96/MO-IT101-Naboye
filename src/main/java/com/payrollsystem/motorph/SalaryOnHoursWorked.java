package com.payrollsystem.motorph;

/**
 * SalaryOnHoursWorked calculates salaries for employees
 * who are paid based on the number of hours worked.
 * 
 * This implementation does not support fixed salary computations.
 */
public class SalaryOnHoursWorked implements SalaryCalculator {

    /**
     * Not supported for hourly-paid employees.
     * Throws an exception if called.
     *
     * @param employee The employee.
     * @return Throws UnsupportedOperationException.
     */
    @Override
    public double calculateSalary(Employee employee) {
        throw new UnsupportedOperationException("This method is not supported for fixed salary.");
    }

    /**
     * Calculates net salary based on the hourly rate and hours worked.
     *
     * @param employee The employee.
     * @param hoursWorked Number of hours worked.
     * @return The net salary amount.
     */
    @Override
    public double calculateSalary(Employee employee, double hoursWorked) {
        double hourlyRate = calculateHourlyRate(employee);
        return hourlyRate * hoursWorked;
    }

    /**
     * Not supported for hourly-paid employees.
     * Throws an exception if called.
     *
     * @param employee The employee.
     * @return Throws UnsupportedOperationException.
     */
    @Override
    public double calculateGrossSalary(Employee employee) {
        throw new UnsupportedOperationException("This method is not supported for fixed salary.");
    }

    /**
     * Calculates gross salary based on hourly rate and hours worked.
     *
     * @param employee The employee.
     * @param hoursWorked Number of hours worked.
     * @return Gross salary amount.
     */
    @Override
    public double calculateGrossSalary(Employee employee, double hoursWorked) {
        double hourlyRate = calculateHourlyRate(employee);
        return hourlyRate * hoursWorked;
    }

    /**
     * Calculates the total deductions based on the employee's basic salary.
     *
     * @param employee The employee.
     * @return Total deduction amount.
     */
    @Override
    public double calculateDeductions(Employee employee) {
        SalaryDeductions salaryDeductions = new SalaryDeductions();
        return salaryDeductions.getTotalDeductions(employee.getBasicSalary());
    }

    /**
     * Calculates the employee’s hourly rate.
     * Assumes 160 working hours per month.
     *
     * @param employee The employee.
     * @return The hourly rate.
     */
    private double calculateHourlyRate(Employee employee) {
        return employee.getBasicSalary() / 160;  // Assuming a 160-hour work month
    }
}
