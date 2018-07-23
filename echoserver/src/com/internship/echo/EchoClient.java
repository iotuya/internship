package com.internship.echo;

import java.io.*;
import java.net.Socket;

public class EchoClient {

    private static final String URL = "localhost";
    private static final int PORT = 23418;

    public static void main(String[] args) {
        try {

            Socket socket = new Socket(URL, PORT);
            DataInputStream inputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            DataOutputStream outputStream = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));

            outputStream.writeUTF("Wazaaa");
            outputStream.flush();

            String echoResponse = inputStream.readUTF();
            System.out.println("Server sent back: " + echoResponse);
        } catch (IOException e) {
            System.out.println("Error connecting to echo server: " + e.getMessage());
        }
    }
}
