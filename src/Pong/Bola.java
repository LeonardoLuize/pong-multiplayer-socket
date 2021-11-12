package Pong;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Bola {

    private int dx = 1;
    private int dy = 1;
    private int x;
    private int y;
    private int w;
    private int h;
    private Image image;

    /*
     * Construtor da Bola.
     * a imagem da bola será aleatória, variando com os rostos dos desenvolvedores.
     */
    public Bola(int positionX, int positionY) {

        this.x = positionX;
        this.y = positionY;


        ImageIcon ii = new ImageIcon("src/Pong/professor_poo.png");
        image = ii.getImage();

        w = image.getWidth(null);
        h = image.getHeight(null);

    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }


    /*
     *  Método move() da bola.
     *  Aqui deve conter os paramentros de colisão com a parede superior e inferior.
     *  os paramentros de colisão com os players e o servidor devem ser implementados na classe Server e Client
     */
    //revisar
    public void move() {

        //implementar colisão
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
