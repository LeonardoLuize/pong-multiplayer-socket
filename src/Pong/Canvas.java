package Pong;

import javax.swing.JFrame;


public class Canvas extends JFrame {

    private Board board;
    /*
    * Construtor com players e bola
    * */
    public Canvas(Player player1, Player player2, Bola bola) {
        board = new Board(player1, player2, bola);
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