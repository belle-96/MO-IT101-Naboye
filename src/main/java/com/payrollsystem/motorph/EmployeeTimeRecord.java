package com.payrollsystem.motorph;

import com.payrollsystem.motorph.Employee;

/**
 * A class representing an Employee's Time Record in the payroll system.
 * It extends the Employee class to add time tracking functionality 
 * for recording employee's time in and time out during their work hours.
 * 
 * @author Naboye
 */
public class EmployeeTimeRecord extends Employee {

    private int timeIn;    // Time the employee clocks in (e.g., in minutes since midnight)
    private int timeOut;   // Time the employee clocks out (e.g., in minutes since midnight)

    /**
     * Gets the employee's time in.
     * 
     * @return the time in as an integer (in minutes since midnight)
     */
    public int getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(int timeIn) {
        this.timeIn = timeIn;
    }

    /**
     * Gets the employee's time out.
     * 
     * @return the time out as an integer (in minutes since midnight)
     */
    public int getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }
}
