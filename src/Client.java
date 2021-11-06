import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Boolean isGameRunning;
    private Socket server;
    private OutputStream out;
    private BufferedReader input;
    private PrintWriter pw;

    public Client(){
        isGameRunning = true;
    }

    public void connectPlayer(String url, int port) throws IOException, InterruptedException {
        server = new Socket(url, port);

        out = server.getOutputStream();
        input = new BufferedReader(new InputStreamReader(server.getInputStream()));

        pw = new PrintWriter(out, true);
        pw.println("hello server");

        String response = input.readLine();

        System.out.println(response);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner input = new Scanner(System.in);

        System.out.print("Digite a url que deseja conectar: ");
        String url = input.nextLine();

        System.out.print("Digite a porta que deseja conectar: ");
        int port = Integer.parseInt(input.nextLine());

        new Client().connectPlayer(url, port);
    }
}
