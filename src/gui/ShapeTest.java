package gui;
import javax.swing.*;
import java.awt.*;

public class ShapeTest extends JFrame{
	
	private static final long serialVersionUID = 1L;

	private int tS = 400;
	private int tB = 10;
	private int pW = 20;
	private int pH = 100;
	private int p1 = 50;
	private int p2 = tS-p1-pW;
	private int pY = 150;
	
	public ShapeTest(){
          setSize(tS,tS);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          setLocationRelativeTo(null);
          setVisible(true);
     }

     public static void main(String a[]){
         new ShapeTest();
     }

     public void paint(Graphics g){		//canto superior direito
          g.drawOval((tS/2) - (tB/2), (tS/2) - (tB/2), tB, tB); //x, y, w, h
          g.drawRect(p1, pY, pW, pH); // 
          g.drawRect(p2, pY, pW, pH);	//
     }
}