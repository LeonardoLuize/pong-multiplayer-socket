package Pong;

import javax.swing.JFrame;


public class Canvas extends JFrame {

    public Board board;

    /*
    * Construtor com players e bola
    *
    */
    public Canvas(Player player1, Player player2, Bola bola, int pontuacaop1, int pontuacaop2) {
        board = new Board(player1, player2, bola, pontuacaop1, pontuacaop2);
        initUI();
    }



    private void initUI() {
        add(board);

        setSize(1200,800);

        setTitle("POOng");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}