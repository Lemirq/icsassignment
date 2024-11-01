package UnrealComputer;

/**
 * Manager
 */
// A Manager is one type of UCS employee.
// A Manager has a yearly salary - this is the total amount that a manager gets
// paid for an entire year (i.e. 52 weeks) of work.
// You can pay() a Manager. The amount paid is based on how many weeks the
// manager has worked and is a portion of their yearly salary.
// A toString() method will return the Manager’s name, employee number, and job
// title.

public class Manager extends Employee {
    private double yearlySalary;
    private String firstName;
    private String lastName;
    private int employeeNumber;
    private double moneyEarned;

    public Manager(String firstName, String lastName, int employeeNumber, double yearlySalary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeNumber = employeeNumber;
        this.yearlySalary = yearlySalary;
    }

    public void pay(int weeksWorked, boolean isHourly) {
        // there are 8,765.82 hours in a year
        if (!isHourly) {
            double earned = PayrollSystem.roundToTwo(this.yearlySalary / 52 * weeksWorked);
            System.out
                    .println("Manager " + this.getFirstName() + " " + this.getLastName() + " has been paid $" + earned);
            moneyEarned += earned;
        }
    }

    @Override
    public String toString() {
        return "Manager " + this.getFirstName() + " " + this.getLastName() + " (" + this.getEmployeeNumber()
                + ")";
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

    public double getEarnings() {
        return moneyEarned;
    }
}