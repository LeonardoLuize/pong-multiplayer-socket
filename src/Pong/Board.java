package Pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

/*
    BOARD extende Jpanel (Herança) e implementa o ActionListener
 */
public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private Bola bola;
    public Player player1;
    private Player player2;
    public int pontuacaop1;
    public int pontuacaop2;


    private final int DELAY = 10;
    /*
     *Construtor com players e bola
     * */
    public Board(Player player1, Player player2, Bola bola, int pontuacaop1, int pontuacaop2) {
        initBoard(player1, player2, bola, pontuacaop1, pontuacaop2);
    }

    public void initBoard(Player player1, Player player2, Bola bola, int pontuacaop1, int pontuacaop2) {

        addKeyListener(new TAdapter());
        setBackground(Color.black);
        setFocusable(true);
        //atribui os players e bola do construtor aos da classe board
        this.bola = bola;
        this.player1 = player1;
        this.player2 = player2;
        this.pontuacaop1 = pontuacaop1;
        this.pontuacaop2 = pontuacaop2;


        timer = new Timer(DELAY, this);
        timer.start();
    }

    /*
     * Desenho efetivo dos gráficos
     * */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);

        Toolkit.getDefaultToolkit().sync();
    }

    /*
    * Desenho dos Players e da Bola
    * */

    @Override
    public String toString() {
        return pontuacaop1 + " : " + pontuacaop2;
    }

    public void setPontuacaop1(int pontuacaop1) {
        this.pontuacaop1 += pontuacaop1;
    }

    public void setPontuacaop2(int pontuacaop2) {
        this.pontuacaop2 += pontuacaop2;
    }

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(bola.getImage(), bola.getX(),
                bola.getY(), null);

        g2d.drawRect(player1.getX() + 2,
                player1.getY() + 2,
                player1.getWidth(),player1.getHeight());

        g2d.drawRect(player2.getX() + 2,
                player2.getY() + 2,
                player2.getWidth(),player2.getHeight());

        g2d.drawString(toString(), 400,30);
    }

    /*
    * É invocado caso uma ação ocorre
    * */
    @Override
    public void actionPerformed(ActionEvent e) {

        step_bola();
        step_player();
        step_player2();

    }

    /*
    * Movimentação e re-pintura da bola e dos players
    * aplicados no metodo actionPerformed
    * */
    private void step_bola() {

        bola.move();

        repaint(bola.getX()-1, bola.getY()-1,
                bola.getWidth()+2, bola.getHeight()+2);
    }
    private void step_player(){
        player1.move();

        repaint();
    }
    private void step_player2(){
       player2.move();

       repaint();
    }



    /*
     * Aqui ocorre polimorfismo por extender a classe abstrata KeyAdapter
     */
    private class TAdapter extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent e) {
            player1.keyReleased(e);
            player2.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            player1.keyPressed(e);
            player2.keyPressed(e);
        }
    }
}
