package Pong;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Bola {

    private int dx;
    private int dy;
    private int x = 600;
    private int y = 400;
    private int w;
    private int h;
    private Image image;

    public Bola() {

        loadImage();
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
