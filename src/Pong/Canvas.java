package Pong;

import Pong.Player;
import java.awt.EventQueue;
import javax.swing.JFrame;


public class Canvas extends JFrame {

    private Board board;

    public Canvas(Player player1, Player player2, Bola bola) {
        board = new Board(player1, player2, bola);
        initUI();
    }

    public Board getBoard() {
        return board;
    }

    private void initUI() {
        add(board);

        setSize(1200,800);

        setTitle("POOng");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
     /*
    public void initGame(){
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                Canvas ex = new Canvas();
                ex.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(()-> {
                Canvas ex = new Canvas();
                ex.setVisible(true);

        });
    }
         */
}