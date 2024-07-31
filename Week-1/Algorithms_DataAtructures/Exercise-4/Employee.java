package employeeManagementSystem;

import java.util.Scanner;

public class Employee {
    private int eId;
    private String name;
    private String pos;
    private double salary;

    private static Employee[] employeeList = new Employee[100];
    private static int employeeCount = 0;

    public Employee(int eId, String name, String pos, double salary) {
        this.eId = eId;
        this.name = name;
        this.pos = pos;
        this.salary = salary;
    }

    public static void addNewEmployee(int eId, String name, String pos, double salary) {
        if (employeeCount < employeeList.length) {
            employeeList[employeeCount++] = new Employee(eId, name, pos, salary);
            System.out.println("Employee ID " + eId + " has been successfully added.");
        } else {
            System.out.println("Cannot add more employees, list is full.");
        }
        showAllEmployees();
    }

    public static void removeEmployee(int eId) {
        for (int i = 0; i < employeeCount; i++) {
            if (employeeList[i].eId == eId) {
                for (int j = i; j < employeeCount - 1; j++) {
                    employeeList[j] = employeeList[j + 1];
                }
                employeeList[--employeeCount] = null;
                System.out.println("Employee ID " + eId + " has been removed.");
                showAllEmployees();
                return;
            }
        }
        System.out.println("No employee found with ID " + eId + ".");
    }

    public static void findEmployee(int eId) {
        for (Employee employee : employeeList) {
            if (employee != null && employee.eId == eId) {
                System.out.println("Employee details: " + employee);
                return;
            }
        }
        System.out.println("No employee found with ID " + eId + ".");
    }

    public static void showAllEmployees() {
        System.out.println("------------------------------------------------------");
        System.out.printf("| %-10s | %-20s | %-15s | %-10s |\n", "Employee ID", "Name", "Position", "Salary");
        System.out.println("------------------------------------------------------");
        for (Employee employee : employeeList) {
            if (employee != null) {
                System.out.printf("| %-10d | %-20s | %-15s | %-10.2f |\n", employee.eId, employee.name, employee.pos, employee.salary);
            }
        }
        System.out.println("------------------------------------------------------");
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + eId +
                ", name='" + name + '\'' +
                ", position='" + pos + '\'' +
                ", salary=" + salary +
                '}';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("----- Employee Management System -----");
            System.out.println("1. Add New Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. Search for Employee");
            System.out.println("4. Display All Employees");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int empId = scanner.nextInt();
                    System.out.print("Enter Employee Name: ");
                    String empName = scanner.next();
                    System.out.print("Enter Employee Position: ");
                    String empPosition = scanner.next();
                    System.out.print("Enter Employee Salary: ");
                    double empSalary = scanner.nextDouble();
                    addNewEmployee(empId, empName, empPosition, empSalary);
                    break;
                case 2:
                    System.out.print("Enter Employee ID: ");
                    int removeId = scanner.nextInt();
                    removeEmployee(removeId);
                    break;
                case 3:
                    System.out.print("Enter Employee ID: ");
                    int searchId = scanner.nextInt();
                    findEmployee(searchId);
                    break;
                case 4:
                    showAllEmployees();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}