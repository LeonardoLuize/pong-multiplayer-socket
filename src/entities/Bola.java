package entities;

import util.Posi��o;
import util.Tamanho;
import util.Tela;

public class Bola {

	// 0 = esquerda e 1 = direita
	private boolean orienta��o;
	private Posi��o pos;
	// ainda tenho q ver como q eu uso essa variavel
	private float angulo;
	private Tamanho tamanho;

	public Bola(Posi��o pos, float angulo, boolean orienta��o, Tamanho tamanho) {
		this.pos = pos;
		this.angulo = angulo;
		this.orienta��o = orienta��o;
		this.tamanho = tamanho;
	}

	public Bola() {
		this.pos = new Posi��o();
		this.tamanho = new Tamanho();
	}

	public Tamanho getTamanho() {
		return tamanho;
	}

	public Posi��o getPos() {
		return pos;
	}

	public void setPos(int x, int y) {
		pos.setPos(x, y);
	}

	public void setAngulo(float angulo) {
		this.angulo = angulo;
	}

	public void setTamanho(int t) {
		tamanho.setHeight(t);
		tamanho.setWidth(t);
	}

	public boolean fezGol(Player p) {
		return false;
	}

	public boolean colidiuPlayer(Player p) {
		return false;
	}

	public void colisaoPlayer() {
		orienta��o = !orienta��o;
	}

	public boolean colidiuBorda(Tela t) {

		// ele ve se a altura da tela � menor que a posi��o da bola (se maior, a bola ta
		// pra fora da tela)
		if (t.getHeight() < pos.getPosY() || t.getWidth() < pos.getPosX() || pos.getPosX() < 0 || pos.getPosY() < 0) {
			return true;
		}
		return false;
	}

	public void colisaoBorda() {
		// o que fazer quando a bola colidir com a borda?
	}

}
