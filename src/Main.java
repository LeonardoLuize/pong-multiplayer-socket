import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Server pongServer = new Server();
        pongServer.createServer(3002);

        pongServer.connectPlayer();
    }
}
