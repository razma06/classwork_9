import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    ServerSocket serverSocket;
    Socket socket;
    DataInputStream in;
    DataOutputStream out;
    int port;

    Server(int port) {
        this.port = port;
    }

    protected void StartServerSocket() {
        try {
            serverSocket = new ServerSocket(port);
            socket = serverSocket.accept();
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
