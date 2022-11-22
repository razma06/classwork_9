import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChatServer extends Server implements Runnable {
    ChatServer(int port) {
        super(port);
    }

    protected void StartChat() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String msgIn = "", msgOut;
            while (!msgIn.equals("end")) {
                msgIn = in.readUTF();
                System.out.println("CLIENT: " + msgIn);
                System.out.print("Server: ");
                msgOut = br.readLine();
                out.writeUTF(msgOut);
                out.flush();
            }
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        this.StartServerSocket();
        this.StartChat();
    }
}
