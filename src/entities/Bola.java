package entities;

import util.Posição;
import util.Tela;

public class Bola {

	private Posição pos;
	private float angulo;
	// 0 = esquerda e 1 = direita
	private boolean orientação;

	public Bola(Posição pos, float angulo, boolean orientação) {
		this.pos = pos;
		this.angulo = angulo;
		this.orientação = orientação;
	}

	public Bola() {
	}
	
	public void setPos(int x, int y) {
		pos.setPos(x, y);
	}

	public void setAngulo(float angulo) {
		this.angulo = angulo;
	}

	public Posição getPos() {
		return pos;
	}

	public boolean fezGol(Player p) {
		return false;
	}
	
	public boolean colidiuPlayer(Player p) {
		return false;
	}

	public void colisaoPlayer() {
		orientação = !orientação;
	}
	
	public boolean colidiuBorda(Tela t) {
		
		//ele ve se a altura da tela é menor que a posição da bola (se maior, a bola ta pra fora da tela)
		if (t.getHeight() < pos.getPosY() || t.getWidth() < pos.getPosX() || pos.getPosX() < 0 || pos.getPosY() < 0) {
				return true;
		}
		return false;
	}
	
	public void colisaoBorda() {
		//o que fazer quando a bola colidir com a borda?
	}

}
