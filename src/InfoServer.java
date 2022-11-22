import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InfoServer extends Server implements Runnable {
    InfoServer(int port) {
        super(port);
    }

    @Override
    public void run() {
        this.StartServerSocket();
        this.SendInfo();
    }

    public void SendInfo() {
        try {
            String option = "";
            while (!option.equals("end")) {
                BufferedReader br = new BufferedReader(new FileReader("info.txt"));
                option = in.readUTF().toLowerCase();
                String line;
                while (true) {
                    line = br.readLine();
                    if (line == null) {
                        out.writeUTF("There was no such command");
                        br.close();
                        break;
                    }
                    if (line.toLowerCase().equals(option)) {
                        out.writeUTF(br.readLine());
                        break;
                    }
                }
            }
            socket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
