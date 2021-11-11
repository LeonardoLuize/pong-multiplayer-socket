package Pong;


import java.awt.event.KeyEvent;


public class Enemy {

    private int dy;
    private int x;
    private int y;
    private int w = 50;

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return w;
    }

    public void getWidth(int w) {
        this.w = w;
    }

    public int getHeight() {
        return h;
    }

    public void getHeight(int h) {
        this.h = h;
    }

    private int h = 200;


    public Enemy(int positionX, int positionY) {

        this.x = positionX;
        this.y = positionY;

        loadPlayer();
    }

    public void loadPlayer() {


    }

    public void move(int dx, int dy){
        this.x += dx;
        this.y += dy;
    }

}
