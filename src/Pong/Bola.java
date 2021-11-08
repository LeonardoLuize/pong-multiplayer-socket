package Pong;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Bola {

    private int dx = 1;
    private int dy = 1;
    private int x;
    private int y;
    private int w;
    private int h;
    private Image image;

    public Bola(int positionX, int positionY) {

        this.x = positionX;
        this.y = positionY;


        loadImage();
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void loadImage() {

        ImageIcon ii = new ImageIcon("src/Pong/professor_poo.png");
        image = ii.getImage();

        w = image.getWidth(null);
        h = image.getHeight(null);
    }

    //revisar
    public void move() {

        x += dx;
        y += dy;
    }

    public int getX() {

        return x;
    }

    public int getY() {

        return y;
    }

    public int getWidth() {

        return w;
    }

    public int getHeight() {

        return h;
    }

    public Image getImage() {

        return image;
    }
}
