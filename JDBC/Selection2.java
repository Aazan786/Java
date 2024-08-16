import java.sql.*;
import java.util.*;
import java.sql.PreparedStatement;

public class Selection2 {

    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1/addressbook";
        Connection con = DriverManager.getConnection(url, "root", "root");

        PreparedStatement pst = con.prepareStatement("Select * from info", ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE);

        pst.setMaxRows(6);

        ResultSet rs = pst.executeQuery();
        con.setAutoCommit(false);

        // int rowCount = 0;
        // while (rs.next()) {
        // rowCount++;
        // }
        // System.out.println("Number of Rows: " + rowCount);
        // // Get the number of rows
        // //int rowCount = 0;
        // while (rs.next()) {
        // rowCount++;
        // }
        // System.out.println("Number of Rows: " + rowCount);

        rs.first();
        System.out.println("\n Moving cursor forward\n");
        String name = rs.getString("username");
        System.out.println(name);

        // rs.next();
        // rs.next();

        // rs.previous();
        // System.out.println("\n Moving cursor backward \n");
        // name = rs.getString("username");
        // System.out.println(name);

        // rs.absolute(3);
        // System.out.println("\n Moving cursor on Third Line \n");
        // name = rs.getString("username");
        // System.out.println(name);

        rs.updateString("address", "Ayubia"); // overloaded
        // rs.updateString(2, "Ayubia");
        rs.updateRow();

        System.out.println("\n After updation \n");
        String pwd = rs.getString(2);
        System.out.println("Adress is " + pwd);

        // rs.absolute(9);
        // String name1 = rs.getString("username");
        // System.out.println(name1);

        System.out.println("\n Adding one more row \n");
        rs.moveToInsertRow();
        rs.updateString("username", "fawadkhan");
        rs.updateString("address", "saudia");
        rs.updateString("city", "Piradak");
        rs.updateString("phone", "7676");
        rs.insertRow();
        // rs.absolute(13);

        // // updating rows

        // while (rs.next()) {
        // System.out.println("Updating.....");
        // rs.absolute(1);
        // int ph = rs.getInt("phone");
        // rs.updateInt("phone", 1111);
        // rs.updateRow();
        // break;
        // }

        // // rs.updateRow();
        // // con.commit();
        // System.out.println("Done");

        // rs.absolute(1);
        // rs.deleteRow();
        // // con.commit();

    }

}