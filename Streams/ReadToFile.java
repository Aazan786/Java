import java.io.*;

public class ReadToFile {

    private static void doRead() {

        try {

            String fileName = "aazan.txt";
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            /*
             * int c = 0;
             * while ( (c=in.read()) != -1)
             * {
             * System.out.print((char)c);
             * }
             */

            String s;
            while ((s = in.readLine()) != null) {
                System.out.println(s);
            }
            in.close();

        } catch (IOException e) {

            System.out.println("IOException:");
            e.printStackTrace();

        }

    }

    public static void main(String[] args) {
        doRead();
    }

}