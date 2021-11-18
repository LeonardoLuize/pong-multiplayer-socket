package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;


// BOARD extende Jpanel (Heranca) e implementa o ActionListener
public class Board extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private Timer timer;
	private Bola bola;
	private Player player1;
	private Player player2;
	private final int DELAY = 10;

	// Construtor com players e bola
	public Board(Player player1, Player player2, Bola bola) {
		addKeyListener(new TAdapter());
		setBackground(Color.black);
		setFocusable(true);
		
		// atribui os players e bola do construtor aos da classe board
		this.bola = bola;
		this.player1 = player1;
		this.player2 = player2;
		timer = new Timer(DELAY, this);
		timer.start();
	}

	//Desenho efetivo dos graficos
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		doDrawing(g);
		Toolkit.getDefaultToolkit().sync();
	}

	private void doDrawing(Graphics g) {
		
		// Desenho dos Players e da Bola
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(bola.getImage(), bola.getX(), bola.getY(), null);
		g2d.drawRect(player1.getX() + 2, player1.getY() + 2, player1.getWidth(), player1.getHeight());
		g2d.drawRect(player2.getX() + 2, player2.getY() + 2, player2.getWidth(), player2.getHeight());
		g2d.drawString(toString(), 400, 30);
	}

	// E invocado caso uma acao ocorra
	@Override
	public void actionPerformed(ActionEvent e) {
		step_bola();
		step_player();
		step_player2();
	}

	/*
	 * Movimentacao e re-pintura da bola e dos players aplicados no metodo
	 * actionPerformed
	 */
	private void step_bola() {
		bola.mover();
		repaint(bola.getX() - 1, bola.getY() - 1, bola.getWidth() + 2, bola.getHeight() + 2);
	}

	private void step_player() {
		player1.mover();
		repaint();
	}

	private void step_player2() {
		player2.mover();
		repaint();
	}

	// Aqui ocorre polimorfismo por extender a classe abstrata KeyAdapter
	private class TAdapter extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent e) {
			player1.keyReleased(e);
			player2.keyReleased(e);
		}

		@Override
		public void keyPressed(KeyEvent e) {
			player1.keyPressed(e);
			player2.keyPressed(e);
		}
	}

	@Override
	public String toString() {
		return player1.getPontuacao() + " : " + player2.getPontuacao();
	}
	
}
