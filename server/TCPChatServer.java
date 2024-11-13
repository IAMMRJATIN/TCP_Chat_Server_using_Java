import java.io.*;
import java.net.*;

public class TCPChatServer {
    public static void main(String[] args) {
        int port = 12345; // Server port
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started. Waiting for client...");

            try (Socket socket = serverSocket.accept()) {
                System.out.println("Client connected: " + socket.getInetAddress());
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

                // Thread for receiving messages from client
                new Thread(() -> {
                    String clientMessage;
                    try {
                        while ((clientMessage = input.readLine()) != null) {
                            System.out.println("Client: " + clientMessage);
                        }
                    } catch (IOException e) {
                        System.out.println("Connection closed.");
                    }
                }).start();

                // Main loop for sending messages to client
                String serverMessage;
                while ((serverMessage = consoleInput.readLine()) != null) {
                    output.println(serverMessage);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}