package com.internship.echo;

        import java.io.*;
        import java.net.ServerSocket;
        import java.net.Socket;

public class EchoServer {

    private static final int SERVER_PORT = 23418;

    public static void main(String[] args) {
        spawnSingleClientServer();
    }

    private static void spawnSingleClientServer() {
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            acceptClient(serverSocket);
        } catch (IOException e) {
            System.out.println("Error spawning server: " + e.getMessage());
        }
    }

    private static void acceptClient(ServerSocket serverSocket) throws IOException {

        Socket socket = serverSocket.accept();

        DataInputStream inputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        DataOutputStream outputStream = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));

        String received = inputStream.readUTF();

        System.out.println("Received: " + received);

        outputStream.writeUTF(received);
        outputStream.flush();
    }
}
