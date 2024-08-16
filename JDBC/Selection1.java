
import java.sql.*;
import java.util.*;

public class Selection1 {

    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1/addressbook";
        Connection con = DriverManager.getConnection(url, "root", "root");

        java.sql.PreparedStatement pst = con.prepareStatement("Select * from info");

        // Scanner inp = new Scanner(System.in);

        // System.out.print("Please enter Name to search: ");
        // String name = inp.nextLine();

        // pst.setString(1, name);

        ResultSet rs = pst.executeQuery();
        rs.next();
        System.out.println("\n Moving cursor forward\n");
        String name = rs.getString("username");
        System.out.println(name);

        rs.next();
        rs.next();

        rs.previous();
        System.out.println("\n Moving cursor backward \n");
        name = rs.getString("username");
        System.out.println(name);

        rs.absolute(4);
        System.out.println("\n Moving cursor on Third Line \n");
        name = rs.getString("username");
        System.out.println(name);

        // rs.updateString("username", "Names");
        // rs.updateString(3, "pucit");
        // // // rs.updateRow();

        // System.out.println("\n After updation \n");
        // String pwd = rs.getString(3);
        // System.out.println("Password is " + pwd);

        // ResultSetMetaData rsmd = rs.getMetaData();

        // int numColumns = rsmd.getColumnCount();
        // System.out.println("Number of Columns:" + numColumns);

        // String cName;
        // for (int i = 1; i <= numColumns; i++) {
        // cName = rsmd.getColumnName(i);
        // System.out.print(cName);
        // System.out.print("\t");
        // }

        // System.out.println("");

        // while (rs.next()) {

        // System.out.print(rs.getString(2));
        // System.out.print("\t\t");

        // System.out.print(rs.getString(3));
        // System.out.print("\t\t");

        // System.out.print(rs.getString(4));
        // System.out.print("\t");

        // System.out.print(rs.getInt(5));
        // System.out.print("\t");

        // System.out.print(rs.getString(6));

        // System.out.println("");
        // }

    }

}