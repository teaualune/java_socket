package test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer extends java.lang.Thread {
    private boolean outServer = false;
    private ServerSocket server;
    private final int serverPort = 8666;

    public SocketServer() {
        try {
            server = new ServerSocket(serverPort);
        } catch (IOException e) {
            System.out.println("Socket error!");
            System.out.println(e.toString());
        }
    }

    public void run() {
        Socket socket;
        BufferedInputStream in;
        while (!outServer) {
            socket = null;
            try {
                synchronized(server) {
                    socket = server.accept();
                }
                System.out.println("InetAddress = " + socket.getInetAddress());
                socket.setSoTimeout(15000);
                in = new BufferedInputStream(socket.getInputStream());
                byte[] b = new byte[1024];
                String data = "";
                int length;
                while ((length = in.read(b)) > 0) {
                    data = new String(b, 0, length);
                    System.out.println(data);
                }
            } catch (IOException e) {
                System.out.println("Socket error!");
                System.out.println(e.toString());
                outServer = true;
            }
        }
    }

    public static void main(String args[]) {
        (new SocketServer()).start();
    }
}
