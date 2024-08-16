import java.net.*;
import java.io.*;

public class ClientTime {
    public static void main(String[] argv) {
        for (int i = 0; i <= 5; i++) {
            try {
                Socket c = new Socket("127.0.0.1", 1200);
                if (c != null) {
                    BufferedReader bis = new BufferedReader(new InputStreamReader(c.getInputStream()));
                    System.out.println(bis.readLine());
                    c.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        }

    }
}
