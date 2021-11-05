import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public Server(){
    }

    public void createServer(int port) throws IOException {
        ServerSocket server = new ServerSocket(port);
        System.out.printf("Servidor iniciado na porta %d", port);

        Socket cliente = server.accept();
        //System.out.println("ip: " + cliente.getInetAddress().getHostAddress());

        PrintWriter out = new PrintWriter(cliente.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
        String greeting = in.readLine();
        if ("hello server".equals(greeting)) {
            out.println("hello client");
        }
        else {
            out.println("unrecognised greeting");
        }

//        Scanner entrada = new Scanner(cliente.getInputStream());
//        while(entrada.hasNextLine()){
//            System.out.println(entrada.nextLine());
//        }
//
//        System.out.println("...");
    }

    public void connectPlayer() throws IOException {
        ServerSocket server = new ServerSocket(3001);
        if (!server.isBound()){
            server.bind(new InetSocketAddress("192.168.1.11", 0));
            System.out.println("1");
        }
    }

}
