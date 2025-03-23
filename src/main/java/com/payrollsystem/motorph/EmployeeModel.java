/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.payrollsystem.motorph;

import com.payrollsystem.motorph.Employee;

/**
 *
 * @author Naboye
 */
public abstract class EmployeeModel {

    //Declaring an Employee object array
    protected Employee[] employees;

    protected abstract Employee[] getEmployeeModelList();

}