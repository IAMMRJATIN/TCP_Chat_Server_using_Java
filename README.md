# TCP_Chat_Server_using_Java
This project demonstrates a simple TCP-based chat server and client in Java, enabling two-way communication between a server and a single client. The server listens on a specified port for a client connection, allowing both server and client to send and receive messages in real time.

# Features
- Two-way Communication: Supports both sending and receiving messages between server and client.
- Multi-threading: The server and client each spawn a dedicated thread to handle incoming messages, allowing simultaneous sending and receiving of messages.
- Console I/O: Both server and client use console input and output to interact, providing a simple, text-based chat interface.
- Automatic Disconnection Handling: If the connection is closed, the program catches the exception and informs the user.

# How it Works

* Server:
Starts on a specified port (default: 12345) and waits for client connections.
Accepts a client connection and spawns a thread to continuously listen for messages from the client.
Reads console input to send messages to the connected client.

* Client:
Connects to the server using the specified server address and port.
Spawns a thread to listen for incoming messages from the server while allowing the user to send messages concurrently.

#Usage

Run the Server: Start TCPChatServer.java in the console, which will wait for a client connection.
Run the Client: Start TCPChatClient.java in the console. This will connect to the server and allow two-way communication.

# Requirements
Java JDK 8 or above

# Running the Application
1. Open two separate terminal windows.
2. In the first terminal, run the TCPChatServer program to start the server.
3. In the second terminal, run the TCPChatClient program to connect as a client.
