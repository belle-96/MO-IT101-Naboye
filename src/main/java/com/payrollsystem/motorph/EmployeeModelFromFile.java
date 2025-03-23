package com.payrollsystem.motorph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeModelFromFile extends EmployeeModel {

    public EmployeeModelFromFile() {
        File file = new File("./src/FilesToBeRead/EmployeeData.txt");
        getDataFromFile(file);
    }

    @Override
    public Employee[] getEmployeeModelList() {
        return employees;
    }

    private void getDataFromFile(File textFile) {
        List<Employee> employeeList = new ArrayList<>();

        try {
            Scanner scannerToGetFile = new Scanner(textFile);

            while (scannerToGetFile.hasNextLine()) {
                String data = scannerToGetFile.nextLine().trim();

                if (!data.isEmpty()) { // Skip empty lines
                    Scanner scannerForParsing = new Scanner(data);
                    Employee employee = parseDataFromScanner(scannerForParsing);
                    if (employee != null) {
                        employeeList.add(employee);
                        System.out.println("Loaded Employee ID: [" + employee.getEmpNo().trim() + "]"); // Debugging
                    }
                }
            }
            scannerToGetFile.close();

            // Convert List to Array
            employees = employeeList.toArray(new Employee[0]);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(EmployeeModelFromFile.class.getName()).log(Level.SEVERE, "File not found: " + textFile.getPath(), ex);
        }
    }

    private Employee parseDataFromScanner(Scanner scanner) {
        scanner.useDelimiter("[|]");

        try {
            Employee employee = new Employee();
            employee.setEmpNo(scanner.next().trim()); // Trim to avoid spacing issues
            employee.setLastName(scanner.next().trim());
            employee.setFirstName(scanner.next().trim());
            employee.setBirthday(scanner.next().trim());
            employee.setAddress(scanner.next().trim());
            employee.setPhoneNo(scanner.next().trim());
            employee.setSssNo(scanner.next().trim());
            employee.setPhilHealthNo(scanner.next().trim());
            employee.setTinNo(scanner.next().trim());
            employee.setPagibigNo(scanner.next().trim());
            employee.setStatus(scanner.next().trim());
            employee.setPosition(scanner.next().trim());
            employee.setSupervisor(scanner.next().trim());
            employee.setBasicSalary(Double.parseDouble(scanner.next().trim()));
            employee.setRiceSubsidy(Double.parseDouble(scanner.next().trim()));
            employee.setPhoneAllowance(Double.parseDouble(scanner.next().trim()));
            employee.setClothingAllowance(Double.parseDouble(scanner.next().trim()));
            employee.setSemiMonthlyRate(Double.parseDouble(scanner.next().trim()));
            employee.setHourlyRate(Double.parseDouble(scanner.next().trim()));

            return employee;

        } catch (Exception e) {
            Logger.getLogger(EmployeeModelFromFile.class.getName()).log(Level.WARNING, "Error parsing employee data", e);
            return null; // Skip this employee if data is incorrect
        } finally {
            scanner.close();
        }
    }

    public Employee findEmployeeById(String empId) {
        for (Employee employee : employees) {
            if (employee.getEmpNo().trim().equals(empId.trim())) { // Ensures no space issues
                return employee;
            }
        }
        return null; // Employee not found
    }
}
