package Pong;


import java.awt.event.KeyEvent;


public class Player{

    private int dy;
    private int x;
    private int y;
    private int w = 50;
    private int h = 200;
    private boolean principal;

    public Player(int x, int y, boolean principal) {
        this.x = x;
        this.y = y;
        this.principal = principal;
        loadPlayer();
    }

    public void loadPlayer() {


    }

    public void move() {
        if (principal) {
            if (y >= 0 && y < 550) {
                y += dy;
            }
            if (y < 0) {
                y = 1;
            }
            if (y >= 550) {
                y = 548;
            }
        }
    }

    public int getX() {

        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {

        return w;
    }

    public int getHeight() {

        return h;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP) {
            dy = -2;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 2;
        }
    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
}
