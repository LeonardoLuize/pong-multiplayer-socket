import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    private ServerSocket server;
    private DataOutputStream dataOut;
    private DataInputStream dataIn;
    private Boolean accepted;

    public Server(){
    }

    public void createServer(int port) throws IOException {
        ServerSocket server = new ServerSocket(port);
        System.out.printf("Servidor iniciado na porta %d", port);

        Socket cliente = server.accept();

        PrintWriter out = new PrintWriter(cliente.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(cliente.getInputStream()));

        String greeting = in.readLine();

        System.out.println(greeting);

        if ("hello server".equals(greeting)) {
            out.println("hello client");
        }
        else {
            out.println("unrecognised greeting");
        }
    }

    public static void main(String[] args) throws IOException {
        Server pongServer = new Server();
        pongServer.createServer(3002);
    }

}
