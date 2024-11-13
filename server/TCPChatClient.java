import java.io.*;
import java.net.*;

public class TCPChatClient {
    public static void main(String[] args) {
        String serverAddress = "localhost"; // Server address
        int port = 12345; // Server port

        try (Socket socket = new Socket(serverAddress, port)) {
            System.out.println("Connected to server: " + serverAddress);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

            // Thread for receiving messages from server
            new Thread(() -> {
                String serverMessage;
                try {
                    while ((serverMessage = input.readLine()) != null) {
                        System.out.println("Server: " + serverMessage);
                    }
                } catch (IOException e) {
                    System.out.println("Connection closed.");
                }
            }).start();

            // Main loop for sending messages to server
            String clientMessage;
            while ((clientMessage = consoleInput.readLine()) != null) {
                output.println(clientMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
