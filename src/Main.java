public class Main {
    public static void main(String[] args) {
        Client client = new Client(8081);
        client.start();

        InfoServer infoServer = new InfoServer(8081);
        Thread thread = new Thread(infoServer);
        thread.start();

//        ChatServer chatServer = new ChatServer(8080);
//        Thread thread = new Thread(chatServer);
//        thread.start();
    }
}