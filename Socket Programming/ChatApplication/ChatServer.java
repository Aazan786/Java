import java.net.*;
import java.util.Scanner;
import java.io.*;

public class ChatServer {
    public static void main(String[] argv) {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(1234);
            System.out.println("Waiting for client Connection");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Connection Established");

                InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

                String msgFromClient;
                while ((msgFromClient = bufferedReader.readLine()) != null) {
                    System.out.println("Client: " + msgFromClient);

                    Scanner scanner = new Scanner(System.in);

                    String msgToSend = scanner.nextLine();
                    bufferedWriter.write(msgToSend);
                    bufferedWriter.newLine();
                    bufferedWriter.flush();

                    if (msgFromClient.equalsIgnoreCase("Bye")) {
                        break;
                    }
                }

                socket.close();
                inputStreamReader.close();
                outputStreamWriter.close();
                bufferedReader.close();
                bufferedWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
