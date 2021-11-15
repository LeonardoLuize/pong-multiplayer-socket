package Pong;


import java.awt.event.KeyEvent;


public class Player{

    private int dy;
    private int x;
    private int y;
    private int w = 50;
    private int h = 200;
    private boolean principal;

    /*
     Construtor com x, y (Posição) e uma variável booleana
     para o metodo move() funcionar
     */
    public Player(int x, int y, boolean principal) {
        this.x = x;
        this.y = y;
        this.principal = principal;

    }


    /*
     * método com mudança de posição.
     */
    public void move() {
        if (principal) {
            if (y >= 0 && y < 550) {y += dy;} //incrementa dy a y no escopo da tela
            if (y < 0) {y = 1;} // limite superior da tela
            if (y >= 550) {y = 548;} //limite inferior da tela
        }
    }

    public int getX() {

        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {this.x = x;}

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {

        return w;
    }

    public int getHeight() {

        return h;
    }


    /*
    * Ao apertar a tecla, muda o valor de dy.
    * dy incrementa o valor de y no move()
    * */
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP) {
            dy = -2;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 2;
        }
    }
    /*
     * Ao soltar a tecla, dy = 0.
     * Fazendo com que y não mude no move()
     */
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
