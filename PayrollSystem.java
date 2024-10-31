package UnrealComputer;

import java.util.Scanner;
import java.util.ArrayList;

public class PayrollSystem {
    Scanner sc = new Scanner(System.in);
    ArrayList<Employee> employees = new ArrayList<Employee>();

    public static void main(String[] args) {
        PayrollSystem ps = new PayrollSystem();
        ps.setup();
        ps.run();

    }

    void setup() {
        Manager diego = new Manager("Diego", "Martin", 0, 55000);
        SalesAssociate kylie = new SalesAssociate("Kylie", "Walter", 1, 18.50);
        SalesAssociate michael = new SalesAssociate("Michael", "Rose", 2, 16.75);

        employees.add(diego);
        employees.add(kylie);
        employees.add(michael);
    }

    void run() {
        // run a menu
        System.out.println("Welcome to the Unreal Computer Sales Payroll System");
        System.out.println("===============================================");

        while (true) {

            System.out.println("\n1. Add a new employee");
            System.out.println("2. Pay an employee");
            System.out.println("3. Pay ALL employees");
            System.out.println("4. Display employees' information");
            System.out.println("5. Quit\n");

            // validate the number input by user
            int choice = getValidNumber();

            switch (choice) {
                case 1:

                    break;
                case 2:
                    Employee employee = getEmployee();

                    // get hours worked
                    if (employee instanceof Manager) {
                        System.out.println("How many weeks did " + employee.toString() + " work?");
                        int weeks = getValidNumber();
                        employee.pay(weeks);

                    } else if (employee instanceof SalesAssociate) {
                        System.out.println("How many hours did " + employee.toString() + " work?");
                        int hours = getValidNumber();
                        employee.pay(hours);
                    }

                    break;
                case 3:
                    break;

                case 4:

                    break;

                case 5:
                    System.out.println("Goodbye!");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    break;
            }

        }
    }

    int getValidNumber() {
        String input = sc.nextLine();
        int number = 0;
        while (true) {
            try {
                number = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
                input = sc.nextLine();
            }
        }

        return number;
    }

    Employee getEmployee() {
        // prompt user for first name of employee, then print list of employees that
        // match that firstname showing the id with it, then prompt user for id of
        // employee, then return the employee
        System.out.println("Enter the first name of the employee you want to pay...");
        String firstName = sc.nextLine();
        ArrayList<Employee> matchingEmployees = new ArrayList<Employee>();
        for (Employee employee : employees) {
            if (employee.getFirstName().equalsIgnoreCase(firstName)) {
                matchingEmployees.add(employee);
            }
        }

        if (matchingEmployees.size() == 0) {
            System.out.println("No employees with that first name found");
            return null;
        }

        System.out.println("Employees with that first name:");
        for (Employee employee : matchingEmployees) {
            System.out.println(employee.toString());
        }

        System.out.println("\nEnter the ID of the employee you want to pay");
        int id = getValidNumber();

        for (Employee employee : matchingEmployees) {
            if (employee.getEmployeeNumber() == id) {
                return employee;
            }
        }

        System.out.println("No employee with that ID found");
        return null;
    }
}
