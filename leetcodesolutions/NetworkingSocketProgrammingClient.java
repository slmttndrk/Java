package leetcodesolutions;

import java.io.*;
import java.net.Socket;

/**
 * Socket Programming
 * Sockets provide the communication mechanism between two computers using TCP. A client program creates a socket on
   its end of the communication and attempts to connect that socket to a server. When the connection is made, the
   server creates a socket object on its end of the communication. The client and the server can now communicate by
   writing to and reading from the socket. The java.net.Socket class represents a socket, and the java.net.ServerSocket
   class provides a mechanism for the server program to listen for clients and establish connections with them.

 * The following steps occur when establishing a TCP connection between two computers using sockets:
 * The server instantiates a ServerSocket object, denoting which port number communication is to occur on.
 * The server invokes the accept() method of the ServerSocket class. This method waits until a client connects to
   the server on the given port.
 * After the server is waiting, a client instantiates a Socket object, specifying the server name and the port number
   to connect to.
 * The constructor of the Socket class attempts to connect the client to the specified server and the port number.
   If communication is established, the client now has a Socket object capable of communicating with the server.
 * On the server side, the accept() method returns a reference to a new socket on the server that is connected to
   the client's socket.

 * After the connections are established, communication can occur using I/O streams. Each socket has both an
   OutputStream and an InputStream. The client's OutputStream is connected to the server's InputStream, and the
   client's InputStream is connected to the server's OutputStream.

 * TCP is a two-way communication protocol, hence data can be sent across both streams at the same time. Following
   are the useful classes providing complete set of methods to implement sockets.

 * Socket Class Methods
 * The java.net.Socket class represents the socket that both the client and the server use to communicate with each
   other. The client obtains a Socket object by instantiating one, whereas the server obtains a Socket object from the
   return value of the accept() method.

 * When the Socket constructor returns, it does not simply instantiate a Socket object, but it actually attempts to
   connect to the specified server and port. Notice that both the client and the server have a Socket object, so
   these methods can be invoked by both the client and the server.

 * InetAddress Class Methods represents an Internet Protocol (IP) address.

 * A client program that connects to a server by using a socket and sends a greeting, and then waits for a response.
 * */

public class NetworkingSocketProgrammingClient {
    public static void main(String[] args) {
        String serverName = args[0];
        int port = Integer.parseInt(args[1]);
        try {
            System.out.println("Connecting to " + serverName + " on port " + port);
            Socket client = new Socket(serverName, port);

            System.out.println("Just connected to " + client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);

            out.writeUTF("Hello from " + client.getLocalSocketAddress());
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);

            System.out.println("Server says " + in.readUTF());
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
