package Conection;

import Pong.*;

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

            Player p1 = new Player(40,300);
            Player p2 = new Player(1100, 300);
            Bola ball = new Bola(400,300);
            Canvas pongScreen = new Canvas(p1,p2, ball);
            pongScreen.setVisible(true);



            do {
                out = server.getOutputStream();
                input = new BufferedReader(new InputStreamReader(server.getInputStream()));

                pw = new PrintWriter(out, true);
                //pw.println("hello server");

                String response = input.readLine();
               //System.out.println(response);

                if(response != null ){
                    String[] data = response.split(";");

                    if(data[0].equals("player")){
                        p1.setY(Integer.parseInt(data[1]));
                    }else if(data[0].equals("bola")){
                        ball.setX(Integer.parseInt(data[1]));
                        ball.setY(Integer.parseInt(data[2]));
                    }
                }

            }while(isGameRunning);


//            do{
//                String type = input.readLine();
//
//                if (type != null) {
//                    String[] data = type.split(";");
//
//                    if(data[0].equals("player")){
//                        System.out.println(data[1]);
//
//                    }
//                }
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
