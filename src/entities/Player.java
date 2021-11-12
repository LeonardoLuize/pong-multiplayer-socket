package entities;

import util.Posição;
import util.Tamanho;

public class Player {

	private Posição pos;
	private int score;
	private boolean lado;
	private Tamanho tamanho;
	private int velocidade;

	public Player(Posição pos, int score, boolean lado, Tamanho tamanho, int velocidade) {
		this.pos = pos;
		this.score = score;
		this.lado = lado;
		this.tamanho = tamanho;
		this.velocidade = velocidade;
	}

	public Player() {
		pos = new Posição();
		tamanho = new Tamanho();
	}

	public int getScore() {
		return score;
	}

	public boolean getLado() {
		return lado;
	}

	public Tamanho getTamanho() {
		return tamanho;
	}

	//-1 nos 2 getters pq tem o offset do retangulo
	
	public int getPosX() {
		return pos.getPosX() - 1;
	}

	public int getPosY() {
		return pos.getPosY() - 1;
	}

	public Posição getPos() {
		return pos;
	}

	public int getWidth() {
		return tamanho.getWidth();
	}

	public int getHeight() {
		return tamanho.getHeight();
	}

	public void setPosY(int y) {
		pos.setPosY(y);
	}

	public void setPosX(int x) {
		pos.setPosX(x);
	}

	public void setPos(int x, int y) {
		pos.setPos(x, y);
	}

	public void setPos(Posição p) {
		pos.setPos(p);
	}

	public void addScore() {
		score += 1;
	}

	public void setLado(boolean l) {
		lado = l;
	}

	public void setSize(Tamanho t) {
		tamanho = t;
	}

	public void mover(int i, int telaY, int telaYmin) {
		if(pos.getPosY()+tamanho.getHeight() + i*velocidade < telaY && pos.getPosY() + i * velocidade > telaYmin + 8) {
			setPosY(pos.getPosY() + i * velocidade);
		}
	}
	
}
