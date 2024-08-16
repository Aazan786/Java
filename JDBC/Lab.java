// import java.sql.*;
// import java.util.*;

// class Student {
//     String rollNo;
//     String studentName;
//     String address;
//     int phoneNo;
//     double CGPA;

//     public Student(String rollNo, String studentName, String address, int phoneNo, double CGPA) {
//         this.rollNo = rollNo;
//         this.studentName = studentName;
//         this.address = address;
//         this.phoneNo = phoneNo;
//         this.CGPA = CGPA;
//     }

//     public String getRollNo() {
//         return rollNo;
//     }

//     public void setRollNo(String rollNo) {
//         this.rollNo = rollNo;
//     }

//     public String getStudentName() {
//         return studentName;
//     }

//     public void setStudentName(String studentName) {
//         this.studentName = studentName;
//     }

//     public String getAddress() {
//         return address;
//     }

//     public void setAddress(String address) {
//         this.address = address;
//     }

//     public int getPhoneNo() {
//         return phoneNo;
//     }

//     public void setPhoneNo(int phoneNo) {
//         this.phoneNo = phoneNo;
//     }

//     public double getCGPA() {
//         return CGPA;
//     }

//     public void setCGPA(double CGPA) {
//         this.CGPA = CGPA;
//     }
// }

// class ProgramCoordinator {
//     Connection con;
//     static Statement st;

//     public ProgramCoordinator() throws Exception {
//         try {
//             Class.forName("com.mysql.jdbc.Driver");
//             String url = "jdbc:mysql://127.0.0.1/university";
//             con = DriverManager.getConnection(url, "root", "root");
//             st = con.createStatement();

//             System.out.println("Connected to the database.");

//         } catch (SQLException e) {
//             System.out.println("Failed to connect to the database: " + e.getMessage());
//         }
//     }

//     public void insertRecord() {
//         try {

//             Scanner in = new Scanner(System.in);

//             System.out.print("Please enter Name: ");
//             String name = in.nextLine();

//             System.out.print("Please enter Roll No: ");
//             String roll = in.nextLine();

//             System.out.print("Please enter Address: ");
//             String address = in.nextLine();

//             System.out.print("Please enter Phone number: ");
//             int phone = in.nextInt();

//             System.out.print("Please enter CGPA: ");
//             double cgpa = in.nextDouble();

//             String query = "insert into profile(studentName,rollNo,address,phoneno,cgpa) values('" + name + "','" + roll
//                     + "','" + address + "','" + phone + "','" + cgpa + "')";

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

//     void find() throws Exception {
//         try {
//             Scanner in = new Scanner(System.in);

//             System.out.print("Please enter Name to search: ");
//             String name = in.nextLine();

//             String query = "Select * from profile where studentName = '" + name + "' ";

//             ResultSet resultSet = st.executeQuery(query);
//             if (resultSet.next()) {
//                 System.out.println("Student Record:");
//                 System.out.println("Roll No: " + resultSet.getString("rollNo"));
//                 System.out.println("Name: " + resultSet.getString("studentName"));
//                 System.out.println("Address: " + resultSet.getString("address"));
//                 System.out.println("Phone No: " + resultSet.getString("phoneno"));
//                 System.out.println("CGPA: " + resultSet.getDouble("CGPA"));
//             } else {
//                 System.out.println("Student record not found.");
//             }
//         } catch (SQLException e) {
//             System.out.println("Error finding record: " + e.getMessage());
//         }
//     }

//     public void loadRecords() throws Exception {
//         try {
//             Class.forName("com.mysql.jdbc.Driver");
//             String url = "jdbc:mysql://127.0.0.1/university";
//             con = DriverManager.getConnection(url, "root", "root");

//             String query = "Select * from profile";
//             ResultSet rs = st.executeQuery(query);

//             System.out.println("\nLoad Record function is called.");

//             while (rs.next()) {

//                 System.out.print(rs.getString(1));
//                 System.out.print("\t\t");

//                 System.out.print(rs.getString(2));
//                 System.out.print("\t\t");

//                 System.out.print(rs.getString(3));
//                 System.out.print("\t");

//                 System.out.print(rs.getInt(4));
//                 System.out.print("\t");

//                 System.out.print(rs.getString(5));

//                 System.out.println("");
//             }

//         } catch (SQLException e) {
//             System.out.println("Error loading records: " + e.getMessage());
//         }
//     }
// }

// public class Lab {
//     public static void main(String[] args) throws Exception {
//         Scanner scanner = new Scanner(System.in);
//         ProgramCoordinator coordinator = new ProgramCoordinator();

//         while (true) {
//             System.out.println("Menu:");
//             System.out.println("1. Insert Record");
//             System.out.println("2. Find Student");
//             System.out.println("3. Load Records");
//             System.out.println("4. Exit");
//             System.out.print("Enter your choice: ");
//             int choice = scanner.nextInt();
//             scanner.nextLine(); // Consume newline

//             switch (choice) {
//                 case 1:
//                     coordinator.insertRecord();
//                     break;
//                 case 2:

//                     coordinator.find();
//                     break;
//                 case 3:
//                     coordinator.loadRecords();
//                     break;
//                 case 4:
//                     System.out.println("Exiting program...");
//                     System.exit(0);
//                 default:
//                     System.out.println("Invalid choice. Please try again.");
//                     break;
//             }

//             System.out.println("---------------------------");
//         }
//     }
// }
