package com.payrollsystem.motorph;

import com.payrollsystem.motorph.Employee;

/**
 * An abstract class that serves as a template for models that retrieve employee data.
 * This class defines the structure for how employee data will be fetched, 
 * either from a file, database, or hardcoded sources.
 * Subclasses of this class must implement the method for retrieving the employee data.
 */
public abstract class EmployeeModel {

    /**
     * The array that will hold the employee data.
     * This array is populated by the subclass implementation.
     */
    protected Employee[] employees;

    /**
     * Abstract method for retrieving the list of employees.
     * The implementation of this method will vary depending on the data source.
     * For example, it could retrieve employee data from a file, database, or be hardcoded.
     * 
     * @return An array of Employee objects containing the list of employees.
     */
    protected abstract Employee[] getEmployeeModelList();
}
