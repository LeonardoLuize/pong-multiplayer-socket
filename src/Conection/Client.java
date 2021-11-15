package Conection;

import Pong.*;

import java.io.*;
import java.net.Socket;
import java.util.Random;
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
            /*
             *  Criação dos players e da bola.
             * O Cliente é o Player2 pois principal = true
             */
            Player p1 = new Player(40,300,false);
            Player p2 = new Player(1100, 300,true);
            Bola ball = new Bola(400,300, 3);
            int pontuacaop1 = 0;
            int pontuacaop2 = 0;
            Canvas pongScreen = new Canvas(p1,p2, ball,pontuacaop1, pontuacaop2);
            pongScreen.setVisible(true);




            /*
             * Envio de dados para o servidor
             */
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
                /*
                 * Colisão com o Player1
                 *
                 * */
                if (ball.getX()== 90 && ((ball.getY() > p1.getY()) && (ball.getY() < p1.getY() + 65))){
                    ball.setDy(-1);
                    ball.setDirecao(true);
                }
                if (ball.getX()== 90 && ((ball.getY() > p1.getY() + 65) && (ball.getY() < p1.getY() + 130) )){
                    ball.setDirecao(true);
                    ball.setDy(0);
                }
                if (ball.getX() == 90 && (ball.getY() > p1.getY() + 130 && (ball.getY() < p2.getY() + 200))){
                    ball.setDy(1);
                    ball.setDirecao(true);
                }
                /*
                 * Colisão com o Player2
                 *
                 * */
                if (ball.getX()== 1000 && ((ball.getY() > p2.getY()) && (ball.getY() < p2.getY() + 65))){
                    ball.setDy(-1);
                    ball.setDirecao(false);
                }
                if (ball.getX()== 1000  && ((ball.getY() > p2.getY() + 65) && (ball.getY() < p2.getY() + 130))){
                    ball.setDirecao(false);
                    ball.setDy(0);
                }
                if (ball.getX() == 1000  && ((ball.getY() > p2.getY() + 130) && (ball.getY() < p2.getY() + 200))){
                    ball.setDy(1);
                    ball.setDirecao(false);
                }
                /*
                 * pontuação Player1 e Player2
                 * */
                if (ball.getX() < 80){
                    pongScreen.board.setPontuacaop1(1);
                    ball.setX(400);
                    ball.setY(300);

                }
                if (ball.getX() > 1100){
                    pongScreen.board.setPontuacaop2(1);
                    ball.setX(400);
                    ball.setY(300);
                }

            }while(isGameRunning);

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
