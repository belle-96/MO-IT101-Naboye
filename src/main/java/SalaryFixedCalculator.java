package com.payrollsystem.motorph;

public class SalaryFixedCalculator implements SalaryCalculator {

    @Override
    public double calculateSalary(Employee employee) {
        double gross = calculateGrossSalary(employee);
        double deductions = calculateDeductions(employee);
        return gross - deductions;
    }

    @Override
    public double calculateSalary(Employee employee, double hoursWorked) {
        throw new UnsupportedOperationException("This method is not supported for fixed salary.");
    }

    @Override
    public double calculateGrossSalary(Employee employee) {
        // Basic Salary + Rice Subsidy + Phone Allowance + Clothing Allowance
        return employee.getBasicSalary() + employee.getRiceSubsidy() 
                + employee.getPhoneAllowance() + employee.getClothingAllowance();
    }

    @Override
    public double calculateGrossSalary(Employee employee, double hoursWorked) {
        throw new UnsupportedOperationException("This method is not supported for fixed salary.");
    }

    @Override
    public double calculateDeductions(Employee employee) {
        SalaryDeductions salaryDeductions = new SalaryDeductions();
        return salaryDeductions.getTotalDeductions(employee.getBasicSalary());
    }
}
