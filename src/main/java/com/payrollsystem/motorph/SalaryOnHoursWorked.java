package com.payrollsystem.motorph;

public class SalaryOnHoursWorked implements SalaryCalculator {

    @Override
    public double calculateSalary(Employee employee) {
        throw new UnsupportedOperationException("This method is not supported for fixed salary.");
    }

    @Override
    public double calculateSalary(Employee employee, double hoursWorked) {
        double hourlyRate = calculateHourlyRate(employee);
        return hourlyRate * hoursWorked;
    }

    @Override
    public double calculateGrossSalary(Employee employee) {
        throw new UnsupportedOperationException("This method is not supported for fixed salary.");
    }

    @Override
    public double calculateGrossSalary(Employee employee, double hoursWorked) {
        double hourlyRate = calculateHourlyRate(employee);
        return hourlyRate * hoursWorked;
    }

    @Override
    public double calculateDeductions(Employee employee) {
        SalaryDeductions salaryDeductions = new SalaryDeductions();
        return salaryDeductions.getTotalDeductions(employee.getBasicSalary());
    }

    private double calculateHourlyRate(Employee employee) {
        return employee.getBasicSalary() / 160;  // Assuming a 160-hour work month
    }
}
