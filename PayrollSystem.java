package UnrealComputer;

import java.util.Scanner;

public class PayrollSystem {
    Scanner sc = new Scanner(System.in);
    Manager diego = new Manager("Diego", "Martin", 0, 55000);
    SalesAssociate kylie = new SalesAssociate("Kylie", "Walter", 1, 18.50);
    SalesAssociate michael = new SalesAssociate("Michael", "Rose", 2, 16.75);

    public static void main(String[] args) {
        PayrollSystem ps = new PayrollSystem();
        ps.run();

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
                    diego.pay();
                    break;
                case 3:
                    break;

                case 4:
                    System.out.println(diego.toString());
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
        boolean valid = false;
        while (true) {
            try {
                number = Integer.parseInt(input);
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
                input = sc.nextLine();
            }
        }

        sc.close();
        return number;
    }
}
