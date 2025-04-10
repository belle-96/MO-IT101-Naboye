package com.payrollsystem.motorph;

/**
 * The SalaryDeductions class provides methods for calculating
 * various mandatory salary deductions such as SSS, withholding tax,
 * Pag-IBIG, and PhilHealth contributions.
 */
public class SalaryDeductions {

    /**
     * Calculates the SSS (Social Security System) deduction.
     * If salary is below the ceiling (25,000), deduction is 4.5% of salary.
     * If above, the maximum deduction is based on 25,000.
     *
     * @param salary The basic salary of the employee.
     * @return The SSS deduction amount.
     */
    public double getSSSdeduction(double salary) {
        final int constant = 25000;
        return (salary < constant) ? salary * 0.045 : constant * 0.045;
    }

    /**
     * Calculates the withholding tax based on monthly salary brackets.
     * Uses progressive tax rates based on the 2023 Philippine tax table.
     *
     * @param salary The basic salary of the employee.
     * @return The withholding tax amount.
     */
    public double getWithholdingTax(double salary) {
        if (salary > 20833 && salary <= 33333) {
            return (salary - 20833) * 0.15;
        } else if (salary > 33333 && salary <= 66667) {
            return 1875 + (salary - 33333) * 0.2;
        } else if (salary > 66667 && salary <= 166667) {
            return 8541 + (salary - 66667) * 0.25;
        } else if (salary > 166667 && salary <= 666667) {
            return 33541 + (salary - 166667) * 0.3;
        } else if (salary > 666667) {
            return 183541 + (salary - 666667) * 0.35;
        }
        return 0;
    }

    /**
     * Calculates the Pag-IBIG Fund deduction.
     * If salary > 1500, deduction is 2%, otherwise 1%.
     *
     * @param salary The basic salary of the employee.
     * @return The Pag-IBIG deduction amount.
     */
    public double getPagibigDeduction(double salary) {
        return (salary > 1500) ? salary * 0.02 : salary * 0.01;
    }

    /**
     * Calculates the PhilHealth contribution.
     * Fixed at 5% of the salary.
     *
     * @param salary The basic salary of the employee.
     * @return The PhilHealth deduction amount.
     */
    public double getPhilHealthDeduction(double salary) {
        return salary * 0.05;
    }

    /**
     * Calculates the total deductions from the employee's salary.
     * This includes SSS, Pag-IBIG, PhilHealth, and withholding tax.
     *
     * @param salary The basic salary of the employee.
     * @return The total deduction amount.
     */
    public double getTotalDeductions(double salary) {
        return getSSSdeduction(salary)
                + getPagibigDeduction(salary)
                + getPhilHealthDeduction(salary)
                + getWithholdingTax(salary);
    }
}
