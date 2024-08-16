import java.io.*;

public class copyingfile {
    public static void main(String[] argv) {
        FileInputStream source = null;
        FileOutputStream destination = null;

        try {
            source = new FileInputStream("aazan.txt");
            destination = new FileOutputStream("ali.txt");

            int ch;
            while ((ch = source.read()) > -1) {
                destination.write((byte) ch);
            }
            System.out.println("File copied sucessfully");
        }

        catch (IOException e) {
            System.out.println(e.getMessage());
        }

        finally {
            // Close the streams in the finally block to release resources
            try {

                if (source != null) {
                    source.close();
                }
                if (destination != null) {
                    destination.close();
                }
            } catch (IOException e) {

            }
        }
    }
}
