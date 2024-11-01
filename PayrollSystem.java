package UnrealComputer;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class PayrollSystem {
    Scanner sc = new Scanner(System.in);
    ArrayList<Employee> employees = new ArrayList<Employee>();

    public static void main(String[] args) {
        PayrollSystem ps = new PayrollSystem();
        ps.setup();
        ps.run();

    }

    void setup() {
        Manager diego = new Manager("Diego", "Martin", makeNewEmployeeID(), 55000);
        SalesAssociate kylie = new SalesAssociate("Kylie", "Walter", makeNewEmployeeID(), 18.50);
        SalesAssociate michael = new SalesAssociate("Michael", "Rose", makeNewEmployeeID(), 16.75);

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
                    System.out.println("Enter the first name of the new employee");
                    String firstName = sc.nextLine();
                    System.out.println("Enter the last name of the new employee");
                    String lastName = sc.nextLine();
                    System.out.println("Enter the position of the new employee (1. Sales Associate, 2. Manager)");
                    int position = getValidNumber();

                    if (position == 1) {
                        System.out.println("Enter the hourly rate of the new employee");
                        double hourlyRate = sc.nextDouble();
                        employees.add(new SalesAssociate(firstName, lastName, makeNewEmployeeID(), hourlyRate));
                    } else if (position == 2) {
                        System.out.println("Enter the salary of the new employee");
                        double salary = sc.nextDouble();
                        employees.add(new Manager(firstName, lastName, makeNewEmployeeID(), salary));
                    }

                    break;
                case 2:
                    Employee employee = getEmployee();

                    // get hours worked
                    if (employee instanceof Manager) {
                        System.out.println("How many weeks did " + employee.toString() + " work?");
                        int weeks = getValidNumber();
                        employee.pay(weeks, false);

                    } else if (employee instanceof SalesAssociate) {
                        System.out.println("How many hours did " + employee.toString() + " work?");
                        int hours = getValidNumber();
                        employee.pay(hours, true);
                    }

                    break;
                case 3:
                    // pay all employees
                    for (Employee emp : employees) {
                        if (emp instanceof Manager) {
                            System.out.println(emp.getFirstName() + " is a Manager. Enter how many weeks they worked:");
                            int weeksWorked = getValidNumber();
                            emp.pay(weeksWorked, false);
                        } else if (emp instanceof SalesAssociate) {

                            System.out.println(
                                    emp.getFirstName() + " is a Sales Associate. Enter how many hours they worked:");
                            int hoursWorked = getValidNumber();
                            emp.pay(hoursWorked, true);
                        }
                    }
                    break;

                case 4:
                    searchEmployees();

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

    ArrayList<Employee> searchEmployees() {
        // prompt user for first name
        // print list of employees with that first name

        System.out.println("Enter the first name of the employee:");
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
            System.out.println(employee.toString() + " They earn $" + roundToTwo(employee.getEarnings()));
        }

        return matchingEmployees;
    }

    Employee getEmployee() {
        // prompt user for first name of employee, then print list of employees that
        // match that firstname showing the id with it, then prompt user for id of
        // employee, then return the employee
        ArrayList<Employee> matchingEmployees = searchEmployees();

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

    public static double roundToTwo(double num) {
        return Math.round(num * 100) / 100;
    }

    int makeNewEmployeeID() {
        // with random class, check if any other employee has that id, if not return it
        Random rand = new Random();
        int id = rand.nextInt(00000000, 99999999);
        for (Employee employee : employees) {
            if (employee.getEmployeeNumber() == id) {
                return makeNewEmployeeID();
            }
        }

        return id;
    }

}
