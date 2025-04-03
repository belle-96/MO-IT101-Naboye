package com.payrollsystem.motorph;

public class SalaryDeductions {

    public double getSSSdeduction(double salary) {
        final int constant = 25000;
        return (salary < constant) ? salary * 0.045 : constant * 0.045;
    }

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

    public double getPagibigDeduction(double salary) {
        return (salary > 1500) ? salary * 0.02 : salary * 0.01;
    }

    public double getPhilHealthDeduction(double salary) {
        return salary * 0.05;
    }

    public double getTotalDeductions(double salary) {
        return getSSSdeduction(salary)
                + getPagibigDeduction(salary)
                + getPhilHealthDeduction(salary)
                + getWithholdingTax(salary);
    }
}
