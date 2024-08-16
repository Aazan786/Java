import java.net.*;
import java.util.*;
import java.io.*;

class ServerTime {
    public static void main(String[] argv) {
        Socket c = null;
        try {
            ServerSocket s = new ServerSocket(1200);
            try {
                while (true) {
                    c = s.accept();
                    System.out.println("Connection Established");

                    PrintStream p = new PrintStream(c.getOutputStream());
                    Date date = new Date();
                    p.write(date.toString().getBytes());
                    c.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
                s = null;
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }

    }

}
