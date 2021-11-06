import java.io.*;
import java.net.Socket;

public class Client {
    public Client(){

    }

    public void connectPlayer() throws IOException, InterruptedException {
        Socket server = new Socket("localhost", 3002);

        OutputStream out = server.getOutputStream();
        BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));

        PrintWriter pw = new PrintWriter(out, true);
        pw.println("hello server");

        String response = in.readLine();

        System.out.println(response);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        new Client().connectPlayer();
    }
}
