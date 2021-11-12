package util;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import entities.Bola;
import entities.Player;

public class Tela extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1L;

	private int screenWidth;
	private int screenHeight;
	// a barra em cima da tela tem por volta de 22 pixels
	private int barraTela = 22;
	private Player player1;
	private Player player2;
	private Bola bola;
	private int[] movPlayer = new int[2];

	public void drawScreen(Posição posPlayerL, Posição posPlayerR, Posição bola) {

		player1.setPos(posPlayerL);
		player2.setPos(posPlayerR);
		this.bola.setPos(bola.getPosX(), bola.getPosY());

		setSize(screenWidth, screenHeight);
		setFocusable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void paint(Graphics g) {

		repaint();

		// ISSO faz a tela flickar!!
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.BLACK);

		g.drawOval(bola.getPos().getPosX(), bola.getPos().getPosY(), bola.getTamanho().getWidth(),
				bola.getTamanho().getHeight());
		g.drawRect(player1.getPosX(), player1.getPosY(), player1.getWidth(), player1.getHeight()); // player da esquerda
		g.drawRect(player2.getPosX(), player2.getPosY(), player2.getWidth(), player2.getHeight()); // player da direita
	}

	public Tela(int screenWidth, int screenHeight) {
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
		player1 = new Player();
		player2 = new Player();
		this.bola = new Bola();
	}

	public void setPlayersSize(Tamanho p1, Tamanho p2) {
		this.player1.setSize(p1);
		this.player2.setSize(p2);
	}

	public void setBallSize(int t) {
		bola.setTamanho(t);
	}

	public int getScreenWidth() {
		return screenWidth;
	}

	// por algum motivo a tela vai 8 pixels pra baixo
	public int getScreenHeight() {
		return screenHeight - 8;
	}

	public int getBarraTela() {
		return barraTela;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {//87 & 83 teclado | 38 & 40 | cima baixo
		if(e.getKeyCode() == 87) {
			movPlayer[0] = -1;
		}
		if(e.getKeyCode() == 83) {
			movPlayer[0] = 1;
					
		}
		if(e.getKeyCode() == 38) {
			movPlayer[1] = -1;
		}
		if(e.getKeyCode() == 40) {
			movPlayer[1] = 1;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == 87 || e.getKeyCode() == 83) {
			movPlayer[0] = 0;
		}
		if(e.getKeyCode() == 38 || e.getKeyCode() == 40) {
			movPlayer[1] = 0;
		}
	}
	
	public int getMovPlayer(int p) {
		return movPlayer[p];
	}
	
}
