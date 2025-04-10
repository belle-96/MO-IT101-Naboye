package com.payrollsystem.motorph;

/**
 * A class representing an Employee in the payroll system. 
 * It contains various attributes such as personal information, salary details, and allowances.
 * This class is used to store and manage employee data for payroll calculation.
 * 
 * @author Naboye
 */
public class Employee {

    private String empNo;             // Employee ID number
    private String lastName;          // Employee's last name
    private String firstName;         // Employee's first name
    private String birthday;          // Employee's birthdate
    private String address;           // Employee's address
    private String phoneNo;           // Employee's phone number
    private String sssNo;             // Employee's SSS number
    private String philHealthNo;      // Employee's PhilHealth number
    private String tinNo;             // Employee's TIN number
    private String pagibigNo;         // Employee's Pagibig number
    private String status;            // Employment status (e.g., Regular, Probationary)
    private String position;          // Employee's job position
    private String supervisor;        // Employee's immediate supervisor
    private double basicSalary;       // Employee's basic salary
    private double riceSubsidy;       // Rice subsidy allowance
    private double phoneAllowance;    // Phone allowance
    private double clothingAllowance; // Clothing allowance
    private double semiMonthlyRate;  // Semi-monthly rate for salary calculation
    private double hourlyRate;        // Hourly rate for salary calculation

    // Getters and setters for each field

    /**
     * Gets the employee number.
     * 
     * @return the employee number
     */
    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    /**
     * Gets the employee's last name.
     * 
     * @return the employee's last name
     */
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the employee's first name.
     * 
     * @return the employee's first name
     */
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the employee's birthday.
     * 
     * @return the employee's birthday
     */
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * Gets the employee's address.
     * 
     * @return the employee's address
     */
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the employee's phone number.
     * 
     * @return the employee's phone number
     */
    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    /**
     * Gets the employee's SSS number.
     * 
     * @return the employee's SSS number
     */
    public String getSssNo() {
        return sssNo;
    }

    public void setSssNo(String sssNo) {
        this.sssNo = sssNo;
    }

    /**
     * Gets the employee's PhilHealth number.
     * 
     * @return the employee's PhilHealth number
     */
    public String getPhilHealthNo() {
        return philHealthNo;
    }

    public void setPhilHealthNo(String philHealthNo) {
        this.philHealthNo = philHealthNo;
    }

    /**
     * Gets the employee's TIN number.
     * 
     * @return the employee's TIN number
     */
    public String getTinNo() {
        return tinNo;
    }

    public void setTinNo(String tinNo) {
        this.tinNo = tinNo;
    }

    /**
     * Gets the employee's Pagibig number.
     * 
     * @return the employee's Pagibig number
     */
    public String getPagibigNo() {
        return pagibigNo;
    }

    public void setPagibigNo(String pagibigNo) {
        this.pagibigNo = pagibigNo;
    }

    /**
     * Gets the employee's status (e.g., Regular, Probationary).
     * 
     * @return the employee's status
     */
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the employee's job position.
     * 
     * @return the employee's position
     */
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * Gets the employee's immediate supervisor.
     * 
     * @return the employee's supervisor
     */
    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    /**
     * Gets the employee's basic salary.
     * 
     * @return the employee's basic salary
     */
    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    /**
     * Gets the rice subsidy allowance for the employee.
     * 
     * @return the rice subsidy amount
     */
    public double getRiceSubsidy() {
        return riceSubsidy;
    }

    public void setRiceSubsidy(double riceSubsidy) {
        this.riceSubsidy = riceSubsidy;
    }

    /**
     * Gets the phone allowance for the employee.
     * 
     * @return the phone allowance
     */
    public double getPhoneAllowance() {
        return phoneAllowance;
    }

    public void setPhoneAllowance(double phoneAllowance) {
        this.phoneAllowance = phoneAllowance;
    }

    /**
     * Gets the clothing allowance for the employee.
     * 
     * @return the clothing allowance
     */
    public double getClothingAllowance() {
        return clothingAllowance;
    }

    public void setClothingAllowance(double clothingAllowance) {
        this.clothingAllowance = clothingAllowance;
    }

    /**
     * Gets the semi-monthly rate for the employee.
     * 
     * @return the semi-monthly salary rate
     */
    public double getSemiMonthlyRate() {
        return semiMonthlyRate;
    }

    public void setSemiMonthlyRate(double semiMonthlyRate) {
        this.semiMonthlyRate = semiMonthlyRate;
    }

    /**
     * Gets the hourly rate for the employee.
     * 
     * @return the hourly salary rate
     */
    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

}
