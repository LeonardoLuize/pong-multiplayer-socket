package Pong;

import java.awt.EventQueue;
import javax.swing.JFrame;


public class Canvas extends JFrame {

    public Canvas() {
        initUI();
    }

    private void initUI() {

        add(new Board());

        setSize(1200,800);

        setTitle("POOng");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void initGame(){
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                Canvas ex = new Canvas();
                ex.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(()-> {
                Canvas ex = new Canvas();
                ex.setVisible(true);

        });
    }
}