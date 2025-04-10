package com.payrollsystem.motorph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class extends the EmployeeModel and is responsible for
 * loading employee data from a text file.
 * The file should contain employee records separated by '|'.
 */
public class EmployeeModelFromFile extends EmployeeModel {

    /**
     * Constructor that loads employee data from a default file path.
     */
    public EmployeeModelFromFile() {
        File file = new File("./src/FilesToBeRead/EmployeeData.txt");
        getDataFromFile(file);
    }

    /**
     * Returns the list of employees read from the file.
     *
     * @return an array of Employee objects.
     */
    @Override
    public Employee[] getEmployeeModelList() {
        return employees;
    }

    /**
     * Reads data from the specified text file and stores valid employee entries
     * into the employees array.
     *
     * @param textFile The text file containing employee data.
     */
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

    /**
     * Parses a line of data using a Scanner with '|' as a delimiter and maps
     * it to an Employee object.
     *
     * @param scanner A Scanner object used to parse a single employee record.
     * @return An Employee object if parsing is successful, otherwise null.
     */
    private Employee parseDataFromScanner(Scanner scanner) {
        scanner.useDelimiter("[|]");

        try {
            Employee employee = new Employee();
            employee.setEmpNo(scanner.next().trim());
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

    /**
     * Finds an employee by their ID.
     *
     * @param empId The employee ID to search for.
     * @return The Employee object if found, otherwise null.
     */
    public Employee findEmployeeById(String empId) {
        for (Employee employee : employees) {
            if (employee.getEmpNo().trim().equals(empId.trim())) {
                return employee;
            }
        }
        return null;
    }
}
