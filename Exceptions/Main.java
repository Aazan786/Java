
import java.util.Scanner;

class duplicateCustomerException extends Exception {
    public duplicateCustomerException(String id) {
        super("Duplicate customer with ID: " + id);
    }

    public String toString() {
        return "duplicateCustomerException: " + getMessage();
    }

}

class invalidAgeException extends Exception {
    public invalidAgeException(int age) {
        super("Invalid age: " + age);
    }

    public String toString() {
        return "invalidAgeException: " + getMessage();
    }
}

class lowBalanceException extends Exception {
    public lowBalanceException(double balance) {
        super("Low balance: " + balance);
    }

    public String toString() {
        return "lowBalanceException: " + getMessage();
    }
}

class invalidCustomerIDException extends Exception {
    public invalidCustomerIDException(String id) {
        super("Invalid customer ID: " + id);
    }

    public String toString() {
        return "invalidCustomerIDException: " + getMessage();
    }
}

class Customer {
    String name;
    String id;
    int age;
    double balance;

    public Customer(String name, String id, int age, double balance) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.balance = balance;
    }

    public String getname() {
        return name;
    }

    public String getid() {
        return id;
    }

    public int getage() {
        return age;
    }

    public double getbalance() {
        return balance;
    }

}

class Bank {
    Customer[] customers;
    int totalcustomer;

    public Bank() {
        customers = new Customer[5];
        totalcustomer = 0;
    }

    public void addCustomer(String name, String id, int age, double balance)
            throws duplicateCustomerException, invalidAgeException, lowBalanceException {
        // Check if customer already exists
        for (int i = 0; i < totalcustomer; i++) {
            if (customers[i].getid().equals(id)) {
                throw new duplicateCustomerException(id);
            }
        }

        // Validate age and balance
        if (age < 18 || age > 65) {
            throw new invalidAgeException(age);
        }
        if (balance <= 0) {
            throw new lowBalanceException(balance);
        }

        // Add new customer
        customers[totalcustomer] = new Customer(name, id, age, balance);
        totalcustomer++;
    }

    public Customer searchCustomer(String id) throws invalidCustomerIDException {
        // Find customer by ID
        for (int i = 0; i < totalcustomer; i++) {
            if (customers[i].getid().equals(id)) {
                return customers[i];
            }
        }

        // If customer is not found, raise an exception
        throw new invalidCustomerIDException(id);
    }

    public void displayCustomers() {
        // Display all customers in the bank
        for (int i = 0; i < totalcustomer; i++) {
            Customer customer = customers[i];
            System.out.println("Name of Customer: " + customer.getname());
            System.out.println("ID of Customer: " + customer.getid());
            System.out.println("Age of Customer: " + customer.getage());
            System.out.println("Balance in Bank: " + customer.getbalance() + "\n");
        }
    }

}

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // Add some customers to the bank
        try {
            bank.addCustomer("Azan", "80", 25, 10000.0);
            bank.addCustomer("Ali", "81", 27, 15000.0);
            bank.addCustomer("Ahmed", "82", 30, 20000.0);
        } catch (duplicateCustomerException e) {
            System.out.println(e);
        } catch (invalidAgeException e) {
            System.out.println(e);
        } catch (lowBalanceException e) {
            System.out.println(e);
        }

        // Search for a customer by ID
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ID of customer: ");
        String id = scanner.nextLine();

        try {
            Customer customer = bank.searchCustomer(id);
            System.out.println("name: " + customer.getname());
            System.out.println("id: " + customer.getid());
            System.out.println("age: " + customer.getage());
            System.out.println("balance: " + customer.getbalance());
        } catch (invalidCustomerIDException e) {
            System.out.println("Customer ID does not exist: " + e);
        }

        // Display all customers in the bank
        System.out.println("\nAll customers:");
        // bank.displayCustomers();
    }
}
