package Conection;

import Pong.Board;
import Pong.Bola;
import Pong.Canvas;
import Pong.Player;

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

    public void connectPlayer(String url, int port) throws InterruptedException {

        try{
            server = new Socket(url, port);

            out = server.getOutputStream();
            input = new BufferedReader(new InputStreamReader(server.getInputStream()));

            pw = new PrintWriter(out, true);
            pw.println("hello server");

            String response = input.readLine();
            System.out.println(response);

            Canvas pongScreen = new Canvas();
            pongScreen.setVisible(true);
            Bola ball = new Bola();

            pongScreen.initGame();
            ball.loadImage();

            String type = input.readLine();
            if(type.equals("player")){
                String position = input.readLine();
                System.out.println(position);

            }

//            do{
//
//
//            }while(isGameRunning);
        }catch(IOException e){
            e.printStackTrace();
        }


    }

    public static void main(String[] args) throws InterruptedException {

        Scanner input = new Scanner(System.in);

        System.out.print("Digite a url que deseja conectar: ");
        String url = input.nextLine();

        System.out.print("Digite a porta que deseja conectar: ");
        int port = Integer.parseInt(input.nextLine());

        new Client().connectPlayer(url, port);
    }
}
