package leetcodesolutions;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * ServerSocket Class Methods
 * The java.net.ServerSocket class is used by server applications to obtain a port and listen for client requests.
 * If the ServerSocket constructor does not throw an exception, it means that your application has successfully
   bound to the specified port and is ready for client requests.
 * When the ServerSocket invokes accept(), the method does not return until a client connects. After a client does
   connect, the ServerSocket creates a new Socket on an unspecified port and returns a reference to this new Socket.
 * A TCP connection now exists between the client and the server, and communication can begin.

 * A server application that uses the Socket class to listen for clients on a port number specified by a
   command-line argument.
 * */

public class NetworkingSocketProgrammingServer extends Thread {
    private ServerSocket serverSocket;

    public NetworkingSocketProgrammingServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(10000);
    }

    @Override
    public void run() {
        while(true) {
            try {
                System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
                Socket server = serverSocket.accept();

                System.out.println("Just connected to " + server.getRemoteSocketAddress());
                DataInputStream in = new DataInputStream(server.getInputStream());

                System.out.println(in.readUTF());
                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                out.writeUTF("Thank you for connecting to " + server.getLocalSocketAddress() + "\nGoodbye!");
                server.close();

            } catch (SocketTimeoutException s) {
                System.out.println("Socket timed out!");
                break;
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public static void main(String[] args) {
        int port = Integer.parseInt(args[0]);
        try {
            Thread t = new NetworkingSocketProgrammingServer(port);
            t.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
