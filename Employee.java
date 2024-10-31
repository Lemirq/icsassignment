package UnrealComputer;

/**
 * Employee
 */
// We can model a UCS employee with an object. Since all employees will be
// either managers or associates, this will be an employee template.
// UCS Employees have a first name, a last name, and employee number.
// A toString() method will return a String with the employee’s name and
// employee number.
// You can pay() an employee. Managers and associates are paid differently.

public class Employee {
    private String firstName;
    private String lastName;
    private int employeeNumber;

    public Employee(String firstName, String lastName, int employeeNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeNumber = employeeNumber;
    }

    public void pay(int hoursWorked) {
        System.out.println("Employee " + this.firstName + " " + this.lastName + " has been paid, they worked "
                + hoursWorked + " hours");
    }

    @Override
    public String toString() {
        return "Employee " + this.firstName + " " + this.lastName + " (" + this.employeeNumber + ")";
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }
}