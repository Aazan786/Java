import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamExample {
    public static void main(String[] args) {
        FileInputStream sourceStream = null;
        FileOutputStream targetStream = null;

        try {
            // Open the source file for reading
            sourceStream = new FileInputStream("source.txt");

            // Create a target file for writing
            targetStream = new FileOutputStream("destination.txt", true);

            // Read bytes from source file and write them to target file
            int byteData;
            while ((byteData = sourceStream.read()) != -1) {
                targetStream.write(byteData);
            }

            System.out.println("File copied successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close the streams in the finally block to release resources
            try {
                if (sourceStream != null) {
                    sourceStream.close();
                }
                if (targetStream != null) {
                    targetStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
