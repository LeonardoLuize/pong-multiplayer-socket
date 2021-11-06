package entities;

import util.Posi��o;
import util.Tela;

public class Bola {

	private Posi��o pos;
	private float angulo;
	// 0 = esquerda e 1 = direita
	private boolean orienta��o;

	public Bola(Posi��o pos, float angulo, boolean orienta��o) {
		this.pos = pos;
		this.angulo = angulo;
		this.orienta��o = orienta��o;
	}

	public Bola() {
	}
	
	public void setPos(int x, int y) {
		pos.setPos(x, y);
	}

	public void setAngulo(float angulo) {
		this.angulo = angulo;
	}

	public Posi��o getPos() {
		return pos;
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
		
		//ele ve se a altura da tela � menor que a posi��o da bola (se maior, a bola ta pra fora da tela)
		if (t.getHeight() < pos.getPosY() || t.getWidth() < pos.getPosX() || pos.getPosX() < 0 || pos.getPosY() < 0) {
				return true;
		}
		return false;
	}
	
	public void colisaoBorda() {
		//o que fazer quando a bola colidir com a borda?
	}

}
