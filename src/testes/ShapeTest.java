package testes;

import javax.swing.*;
import java.awt.*;

public class ShapeTest extends JFrame {

	private static final long serialVersionUID = 1L;

	private int tS = 400;
	private int tB = 100;
	private int pW = 20;
	private int pH = 100;
	private int p1 = 50;
	private int p2 = tS - p1 - pW;
	private int pY = 150;
	
	//posição da bola - 1
	private int pt1 = (tS / 2) - 1;
	private int tB2 = tB/2;

	public ShapeTest() {
		setSize(tS, tS);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String a[]) {
		new ShapeTest();
	}

	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawOval((tS / 2) - (tB / 2), (tS / 2) - (tB / 2), tB, tB); // x, y, w, h
		g.drawRect(p1, pY, pW, pH);
		g.drawRect(p2, pY, pW, pH);
		
		g.setColor(Color.RED);
		g.drawOval(pt1 + tB2, pt1, 1, 1); // x, y, w, h
		g.drawOval(pt1 - tB2, pt1, 1, 1); // x, y, w, h
		g.drawOval(pt1, pt1 + tB2, 1, 1); // x, y, w, h
		g.drawOval(pt1, pt1 - tB2, 1, 1); // x, y, w, h

	}
}