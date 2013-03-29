package test;

public class Main {
    public static void main(String args[]) {
        if (args.length == 0) {
            System.out.println("Please insert server or client");
        } else if (args[0].equals("server")) {
            (new SocketServer()).start();
        } else if (args[0].equals("client")) {
            new SocketClient();
        }
    }
}
