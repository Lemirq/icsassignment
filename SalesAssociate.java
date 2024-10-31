package UnrealComputer;

/**
 * SalesAssociate
 */
// Sales Associate
// A sales Associate is the other type of UCS employee.
// An Associate has an hourly rate of pay. Rates of pay for sales associates at
// UCS range from $16.50 per hour to $19.75 per hour.
// You can pay() an Associate. The amount paid is based on their hourly rate and
// how many hours they worked.
// A toString() method will return the Associates’ name, employee number, and
// job title.

public class SalesAssociate extends Employee {
    private double hourlyRate;

    public SalesAssociate(String firstName, String lastName, int employeeNumber, double hourlyRate) {
        super(firstName, lastName, employeeNumber);
        this.hourlyRate = hourlyRate;
    }

    public void pay(int hoursWorked) {
        System.out.println("Sales Associate " + this.getFirstName() + " " + this.getLastName() + " has been paid $"
                + (this.hourlyRate * hoursWorked));
    }

    @Override
    public String toString() {
        return "Sales Associate " + this.getFirstName() + " " + this.getLastName() + " (" + this.getEmployeeNumber()
                + ")";
    }
}