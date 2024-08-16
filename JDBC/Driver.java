// import java.sql.*;
// import java.util.*;

// class AddressBook {
//     Connection con;
//     static Statement st;

//     public AddressBook() throws Exception {
//         try {
//             Class.forName("com.mysql.jdbc.Driver");
//             String url = "jdbc:mysql://127.0.0.1/addressbook";
//             con = DriverManager.getConnection(url, "root", "root");
//             st = con.createStatement();

//             System.out.println("Connected to the database.");

//         } catch (SQLException e) {
//             System.out.println("Failed to connect to the database: " + e.getMessage());
//         }
//     }

//     public void addPerson() {
//         String username, address, city;
//         int phone;
//         try {

//             Scanner in = new Scanner(System.in);

//             System.out.print("Please enter your Name: ");
//             String Name = in.nextLine();

//             System.out.print("Please enter your address: ");
//             String Address = in.nextLine();

//             System.out.print("Please enter your city: ");
//             String City = in.nextLine();

//             System.out.print("Please enter Phone number: ");
//             int phoneno = in.nextInt();

//             String query = "insert into info(username,address,city,phone) values('" + Name + "','" + Address
//                     + "','" + City + "'," + phoneno + ")";

//             int rowsInserted = st.executeUpdate(query);

//             if (rowsInserted > 0) {
//                 System.out.println("Record inserted successfully.");
//             } else {
//                 System.out.println("Failed to insert record.");
//             }
//         } catch (SQLException e) {
//             System.out.println("Error inserting record: " + e.getMessage());
//         }
//     }

//     void searchPerson() throws Exception {
//         try {
//             Scanner in = new Scanner(System.in);

//             System.out.print("Please enter Name to search: ");
//             String Name = in.nextLine();

//             String query = "Select * from info where username = '" + Name + "' ";

//             ResultSet rs = st.executeQuery(query);
//             if (rs.next()) {
//                 System.out.println("Student Record:");
//                 System.out.println("Username: " + rs.getString("username"));
//                 System.out.println("Address: " + rs.getString("address"));
//                 System.out.println("City: " + rs.getString("city"));
//                 System.out.println("Phone No: " + rs.getString("phone"));
//             } else {
//                 System.out.println("Student record not found.");
//             }
//         } catch (SQLException e) {
//             System.out.println("Error finding record: " + e.getMessage());
//         }
//     }

//     void deletePerson() throws Exception {
//         try {
//             Scanner in = new Scanner(System.in);

//             System.out.print("Please enter Name you want to delete: ");
//             String Name = in.nextLine();

//             String query = "DELETE * from info where username = '" + Name + "' ";

//             int rs = st.executeUpdate(query);
//             if (rs > 0) {
//                 System.out.println("Following Student record deleted:");
//                 System.out.println("Username: " + rs.getString("username"));
//                 System.out.println("Address: " + rs.getString("address"));
//                 System.out.println("City: " + rs.getString("city"));
//                 System.out.println("Phone No: " + rs.getString("phone"));
//             } else {
//                 System.out.println("Student record not found.");
//             }
//         } catch (SQLException e) {
//             System.out.println("Error finding record: " + e.getMessage());
//         }
//     }

// }

// public class Driver {
//     public static void main(String[] args) throws Exception {
//         Scanner scanner = new Scanner(System.in);
//         AddressBook adressbook = new AddressBook();

//         while (true) {
//             System.out.println("Menu:");
//             System.out.println("1. Insert Student Record");
//             System.out.println("2. Search Student");
//             System.out.println("3. Delete Student records");
//             System.out.println("4. Exit");
//             System.out.print("Enter your choice: ");
//             int choice = scanner.nextInt();
//             scanner.nextLine();

//             switch (choice) {
//                 case 1:
//                     adressbook.addPerson();
//                     break;
//                 case 2:
//                     adressbook.searchPerson();
//                     break;
//                 case 3:
//                     adressbook.deletePerson();
//                     break;
//                 case 4:
//                     System.out.println("Exiting program...");
//                     System.exit(0);
//                 default:
//                     System.out.println("Invalid choice. Please try again.");
//                     break;
//             }
//         }
//     }
// }
