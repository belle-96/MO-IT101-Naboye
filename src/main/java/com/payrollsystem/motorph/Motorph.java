package com.payrollsystem.motorph;

import java.util.Scanner;

public class Motorph {

    private static int platform = 1;
    private static EmployeeModel employeeModel;

    public static void main(String[] args) {
        getDefaultEmployeeModel();
        displayMainMenu();
    }

    private static void displayMainMenu() {
        System.out.println("***********************************************");
        System.out.println("        Motor PH Main Menu      ");
        System.out.println("***********************************************");
        System.out.println("1: Data to read from");
        System.out.println("2: List of Employee Records");
        System.out.println("3: Calculate Net Salary");
        System.out.println("4: Calculate Salary based on Hours Worked");
        System.out.println("5: View Employee Salary by ID");
        System.out.println("6: Exit");
        System.out.println("************************************************");

        Scanner input = new Scanner(System.in);
        System.out.print("Please choose the screen you would like to view: ");
        String option = input.nextLine();
        processOption(option);
    }

    private static void processOption(String option) {
        switch (option) {
            case "1":
                choosePlatform();
                break;
            case "2":
                processListOfEmployees();
                break;
            case "3":
                calculateNetSalary();
                break;
            case "4":
                salaryOnHoursWorked();
                break;
            case "5":
                viewEmployeeSalaryById();
                break;
            case "6":
                System.out.println("Exiting program. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                displayMainMenu();
        }
    }

    private static void choosePlatform() {
        System.out.println("**********************************************************");
        System.out.println("    You have chosen option #1");
        System.out.println("    Which platform would you like the data to be read from?");
        System.out.println("    Option 1: Text File");
        System.out.println("    Option 2: Class File");
        System.out.println("**********************************************************");

        Scanner inputPlatform = new Scanner(System.in);
        String optionPlatform = inputPlatform.nextLine();

        if ("1".equals(optionPlatform)) {
            platform = 1;
        } else if ("2".equals(optionPlatform)) {
            platform = 2;
        } else {
            System.out.println("Invalid choice. Defaulting to Text File.");
            platform = 1;
        }

        System.out.println("**********************************************************");
        System.out.println("    Would you like to go back to the main menu?");
        System.out.println("    Option 1: Yes");
        System.out.println("    Option 2: No");
        System.out.println("**********************************************************");

        String optionToMainMenu = inputPlatform.nextLine();
        if ("1".equals(optionToMainMenu)) {
            displayMainMenu();
        }
    }

    private static void getDefaultEmployeeModel() {
        if (platform == 1) {
            employeeModel = new EmployeeModelFromFile();
        } else {
            employeeModel = new EmployeeModelFromClass();
        }
    }

    private static void processListOfEmployees() {
        Employee[] employeeList = employeeModel.getEmployeeModelList();
        System.out.println("***********************************************");
        System.out.println("        You have chosen option #2");
        System.out.println("             List of employees");
        System.out.println("***********************************************");

        for (Employee employee : employeeList) {
            System.out.println("Last Name: " + employee.getLastName()
                    + ", First Name: " + employee.getFirstName()
                    + ", Position: " + employee.getPosition());
        }
    }

    private static void calculateNetSalary() {
        Employee[] employeeList = employeeModel.getEmployeeModelList();
        SalaryCalculator salaryCalculator = new SalaryFixedCalculator();

        System.out.println("***********************************************");
        System.out.println("        You have chosen option #3");
        System.out.println("          Employee Net Salaries");
        System.out.println("***********************************************");

        for (Employee employee : employeeList) {
            double gross = salaryCalculator.calculateGrossSalary(employee);
            double deductions = salaryCalculator.calculateDeductions(employee);
            double netSalary = salaryCalculator.calculateSalary(employee);

            System.out.println("Last Name: " + employee.getLastName()
                    + ", First Name: " + employee.getFirstName()
                    + ", Gross Salary: " + gross
                    + ", Deductions: " + deductions
                    + ", Net Salary: " + netSalary);
        }
    }

    private static void salaryOnHoursWorked() {
        Employee[] employeeList = employeeModel.getEmployeeModelList();
        SalaryCalculator salaryCalculator = new SalaryOnHoursWorked();

        System.out.println("***********************************************");
        System.out.println("        You have chosen option #4");
        System.out.println("     Salaries based on hours worked");
        System.out.println("***********************************************");

        Scanner input = new Scanner(System.in);
        System.out.print("Enter hours worked (e.g., 160): ");
        double hoursWorked = input.nextDouble();

        for (Employee employee : employeeList) {
            double salary = salaryCalculator.calculateSalary(employee, hoursWorked);
            System.out.println("Last Name: " + employee.getLastName()
                    + ", First Name: " + employee.getFirstName()
                    + ", Salary Based on Hours Worked: " + salary);
        }
    }

    private static void viewEmployeeSalaryById() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Employee ID: ");
        String empId = input.nextLine();

        Employee[] employeeList = employeeModel.getEmployeeModelList();
        SalaryCalculator salaryCalculator = new SalaryFixedCalculator();
        boolean found = false;

        for (Employee employee : employeeList) {
            if (employee.getEmpNo().equals(empId)) {
                double gross = salaryCalculator.calculateGrossSalary(employee);
                double deductions = salaryCalculator.calculateDeductions(employee);
                double netSalary = salaryCalculator.calculateSalary(employee);

                System.out.println("\n***********************************************");
                System.out.println("        Employee Salary Details      ");
                System.out.println("***********************************************");
                System.out.println("Employee ID: " + employee.getEmpNo());
                System.out.println("Name: " + employee.getFirstName() + " " + employee.getLastName());
                System.out.println("Position: " + employee.getPosition());
                System.out.println("Gross Pay: " + gross);
                System.out.println("Deductions: " + deductions);
                System.out.println("Net Salary: " + netSalary);
                System.out.println("***********************************************");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Employee ID not found. Please try again.");
        }

        displayMainMenu();
    }
}
