package com.payrollsystem.motorph;

import java.util.Scanner;

/**
 * Main class for the MotorPH Payroll System.
 * Handles user interface, menu navigation, and interaction with employee models and salary calculations.
 */
public class Motorph {

    private static int platform = 1; // 1 = Text File, 2 = Class File
    private static EmployeeModel employeeModel;
    private static final Scanner input = new Scanner(System.in); // Single shared Scanner instance

    /**
     * Program entry point. Initializes the employee model and displays the main menu.
     */
    public static void main(String[] args) {
        getDefaultEmployeeModel();
        displayMainMenu();
    }

    /**
     * Displays the main menu options and prompts the user to select an action.
     */
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

        System.out.print("Please choose the screen you would like to view: ");
        String option = input.nextLine();
        processOption(option);
    }

    /**
     * Processes the user's main menu selection.
     *
     * @param option the menu option selected by the user
     */
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

    /**
     * Prompts the user to choose the data source platform (Text File or Class File).
     * Updates the employee model based on the selected platform.
     */
    private static void choosePlatform() {
        System.out.println("**********************************************************");
        System.out.println("    You have chosen option #1");
        System.out.println("    Which platform would you like the data to be read from?");
        System.out.println("    Option 1: Text File");
        System.out.println("    Option 2: Class File");
        System.out.println("**********************************************************");

        String optionPlatform = input.nextLine();

        if ("1".equals(optionPlatform)) {
            platform = 1;
        } else if ("2".equals(optionPlatform)) {
            platform = 2;
        } else {
            System.out.println("Invalid choice. Defaulting to Text File.");
            platform = 1;
        }

        getDefaultEmployeeModel(); // Re-initialize based on platform selection

        System.out.println("**********************************************************");
        System.out.println("    Would you like to go back to the main menu?");
        System.out.println("    Option 1: Yes");
        System.out.println("    Option 2: No");
        System.out.println("**********************************************************");

        String optionToMainMenu = input.nextLine();
        if ("1".equals(optionToMainMenu)) {
            displayMainMenu();
        }
    }

    /**
     * Initializes the employee model depending on the current platform.
     */
    private static void getDefaultEmployeeModel() {
        if (platform == 1) {
            employeeModel = new EmployeeModelFromFile();
        } else {
            employeeModel = new EmployeeModelFromClass();
        }
    }

    /**
     * Displays the list of employees retrieved from the employee model.
     */
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

    /**
     * Calculates and displays the net salary of all employees using fixed salary calculations.
     */
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

    /**
     * Calculates and displays salary for all employees based on input hours worked.
     */
    private static void salaryOnHoursWorked() {
        Employee[] employeeList = employeeModel.getEmployeeModelList();
        SalaryCalculator salaryCalculator = new SalaryOnHoursWorked();

        System.out.println("***********************************************");
        System.out.println("        You have chosen option #4");
        System.out.println("     Salaries based on hours worked");
        System.out.println("***********************************************");

        System.out.print("Enter hours worked (e.g., 160): ");
        while (!input.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a number.");
            input.next(); // Clear the invalid input
        }
        double hoursWorked = input.nextDouble();
        input.nextLine(); // Clear newline

        for (Employee employee : employeeList) {
            double salary = salaryCalculator.calculateSalary(employee, hoursWorked);
            System.out.println("Last Name: " + employee.getLastName()
                    + ", First Name: " + employee.getFirstName()
                    + ", Salary Based on Hours Worked: " + salary);
        }
    }

    /**
     * Displays salary details of a specific employee based on their ID.
     * If the ID is not found, an appropriate message is displayed.
     */
    private static void viewEmployeeSalaryById() {
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
