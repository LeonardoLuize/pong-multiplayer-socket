package connection;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

import pong.*;

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

            String randomNumber = input.readLine();
            /*
             *  Criacao dos players e da bola.
             *  Cliente -> Player2, pois principal = true
             */

            Player p1 = new Player(40, 300,false);
            Player p2 = new Player(1100, 300,true);
            Bola ball = new Bola(400, 300, Integer.parseInt(randomNumber));
            Canvas pongScreen = new Canvas(p1,p2, ball);
            pongScreen.setVisible(true);

            // Envio de dados para o servidor
            do {

                out = server.getOutputStream();
                input = new BufferedReader(new InputStreamReader(server.getInputStream()));

                pw = new PrintWriter(out, true);

                pw.println("player;" + p2.getY());

                String response = input.readLine();

                if(response != null ){
                    String[] data = response.split(";");

                    if(data[0].equals("player")){
                        p1.setY(Integer.parseInt(data[1]));
                    }
                    if(data[0].equals("bola")){
                        ball.setX(Integer.parseInt(data[1]));
                        ball.setY(Integer.parseInt(data[2]));
                    }
                }
                
                if(ball.aBolaColidiuComPlayer(p1, p2)) {
					ball.elaColidiuSim(p1, p2);
				}
                
                // pontuacao Player1 e Player2
                if (ball.goleou(80)){
                    p1.pontuou();
                    ball.resetPos();
                }
                
                if (ball.goleou(1100)){
                    p2.pontuou();
                    ball.resetPos();
                }

            }while(isGameRunning);

        }catch(IOException e){
            e.printStackTrace();
        }


    }

    public static void main(String[] args) throws InterruptedException {
    	/*
        Scanner input = new Scanner(System.in);

        System.out.print("Digite a url que deseja conectar: ");
        String url = input.nextLine();

        System.out.print("Digite a porta que deseja conectar: ");
        int port = Integer.parseInt(input.nextLine());
    	*/
        new Client().connectPlayer(null, 21);
        
        //input.close();
    }
}
