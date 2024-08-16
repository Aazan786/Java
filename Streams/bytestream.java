import java.io.*;

public class bytestream {
    public static void main(String[] argv) {
        try {
            FileInputStream f = new FileInputStream("bytestream.java");
            int a;
            while ((a = f.read()) > -1) {
                System.out.println((char) a);
            }

            f.close();
        }

        catch (IOException e) {
            System.out.println(e.getMessage());

        }
    }
}