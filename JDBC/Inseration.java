import java.sql.*;
import java.util.*;

public class Inseration {
    public static void main(String[] argv) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1/azanoffice";
        Connection con = DriverManager.getConnection(url, "root", "root");
        Statement st = con.createStatement();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please Enter your name");
        String name = scanner.nextLine();

        System.out.println("Please Enter your rollno");
        String rollno = scanner.nextLine();

        System.out.println("Please Enter your CGPA");
        Float cgpa = Float.parseFloat(scanner.nextLine());

        String query = "insert into class(Name, Rollno, CGPA) values ('" + name + "', '" + rollno + "', " + cgpa + ")";

        int result = st.executeUpdate(query);
        System.out.println(result);
        if (result > 0) {
            System.out.println("Record inserted successfully.");
        }

        else {
            System.out.println("Record could not inserted.");
        }

        scanner.close();

    }
}
