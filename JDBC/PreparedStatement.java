import java.sql.*;
import java.util.*;

class AddressBook {
    Connection con;

    public AddressBook() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1/addressbook";
            con = DriverManager.getConnection(url, "root", "root");
            System.out.println("Connected to the database.");

        } catch (SQLException e) {
            System.out.println("Failed to connect to the database: " + e.getMessage());
        }
    }

    public void addPerson() throws Exception {
        String username, address, city;
        int phone;
        try {

            Scanner in = new Scanner(System.in);

            System.out.print("Please enter your Name: ");
            String Name = in.nextLine();

            System.out.print("Please enter your address: ");
            String Address = in.nextLine();

            System.out.print("Please enter your city: ");
            String City = in.nextLine();

            System.out.print("Please enter Phone number: ");
            int phoneno = in.nextInt();

            String query = "Insert into info(username, address, city, phone) Values(?, ?, ?, ?)";
            java.sql.PreparedStatement p = con.prepareStatement(query);
            p.setString(1, Name);
            p.setString(2, Address);
            p.setString(3, City);
            p.setInt(4, phoneno);

            int rowsInserted = p.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Record inserted successfully.");
            } else {
                System.out.println("Failed to insert record.");
            }
        } catch (SQLException e) {
            System.out.println("Error inserting record: " + e.getMessage());
        }
    }

    void searchPerson() throws Exception {
        try {
            Scanner in = new Scanner(System.in);

            System.out.print("Please enter Name to search: ");
            String Name = in.nextLine();
            System.out.println("\t");
            java.sql.PreparedStatement p = con.prepareStatement("Select * from info where username=? ");
            p.setString(1, Name);

            ResultSet rs = p.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();

            int columns = rsmd.getColumnCount();
            System.out.println("Number of Columns:" + columns);

            String ColumnName = rsmd.getColumnName(1);
            System.out.println("Name of Columns:" + ColumnName);

            String ColumnType = rsmd.getColumnClassName(1);
            System.out.println("Type of Columns:" + ColumnType);

            // Retrieve the metadata information
            DatabaseMetaData metadata = con.getMetaData();
            System.out.println("Database Product Name: " +
                    metadata.getDatabaseProductName());
            System.out.println("Database Product Version: " +
                    metadata.getDatabaseProductVersion());
            System.out.println("Driver Name: " + metadata.getDriverName());
            System.out.println("Driver Version: " + metadata.getDriverVersion());

            if (rs.next()) {
                System.out.println("Student Record:");
                System.out.println("Username: " + rs.getString(1));
                System.out.println("Address: " + rs.getString(2));
                System.out.println("City: " + rs.getString(3));
                System.out.println("Phone No: " + rs.getString(4));
                System.out.println("\t");
            } else {
                System.out.println("Student record not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error finding record: " + e.getMessage());
        }
    }

    void deletePerson() throws Exception {
        try {
            Scanner in = new Scanner(System.in);

            System.out.print("Please enter Name you want to delete: ");
            String Name = in.nextLine();

            String query = "DELETE  from info where username = ?";
            java.sql.PreparedStatement p = con.prepareStatement(query);
            p.setString(1, Name);

            int rs = p.executeUpdate(query);
            if (rs > 0) {
                System.out.println("Student record deleted:");
            } else {
                System.out.println("Student record not found.");
            }
        } catch (SQLException e) {
            System.out.println("Error finding record: " + e.getMessage());
        }
    }

    public void Display() throws Exception {

        Scanner in = new Scanner(System.in);
        System.out.print("Please enter your particuLAR city: ");
        String City = in.nextLine();

        String query = "Select COUNT(username) from info where city=?";
        java.sql.PreparedStatement p = con.prepareStatement(query);
        p.setString(1, City);
        // = p.executeQuery();
        ResultSet rs = p.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getInt(1));
        }

    }

}

public class PreparedStatement {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        AddressBook adressbook = new AddressBook();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Insert Student Record");
            System.out.println("2. Search Student");
            System.out.println("3. Delete Student records");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    adressbook.addPerson();
                    break;
                case 2:
                    adressbook.searchPerson();
                    break;
                case 3:
                    adressbook.deletePerson();
                    break;
                case 4:
                    adressbook.Display();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
