import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client extends Thread {
    Socket socket;
    DataOutputStream out;
    DataInputStream in;
    int port;

    Client(int port) {
        this.port = port;
    }

    public void run() {
        try {
            socket = new Socket(InetAddress.getByName("localhost"), port);
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String msgIn = "", msgOut;
            while (!msgIn.equals("end")) {
                System.out.print("CLIENT: ");
                msgOut = br.readLine();
                out.writeUTF(msgOut);
                msgIn = in.readUTF();
                System.out.println("SERVER: " + msgIn);
            }
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
