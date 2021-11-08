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

public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private Bola bola;
    private Player player1;
    private Enemy player2;

    public Player getPlayer1() {
        return player1;
    }

    public Bola getBola() {
        return bola;
    }

    private final int DELAY = 10;

    public Board() {
        initBoard();
    }

    public void initBoard() {

        addKeyListener(new TAdapter());
        setBackground(Color.black);
        setFocusable(true);

        bola = new Bola(600, 400);
        player1 = new Player();
        player2 = new Enemy(1090, 300);

        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);

        Toolkit.getDefaultToolkit().sync();
    }

    public Enemy getPlayer2() {
        return player2;
    }

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(bola.getImage(), bola.getX(),
                bola.getY(), this);

        g2d.drawRect(player1.getX() + 2,
                player1.getY() + 2,
                player1.getWidth(),player1.getHeight());

        g2d.drawRect(player2.getX() + 2,
                player2.getY() + 2,
                player2.getWidth(),player2.getHeight());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        step_bola();
        step_player();
        step_player2();
    }

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

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            player1.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            player1.keyPressed(e);
        }
    }
}
