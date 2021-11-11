package entities;

import util.Posição;
import util.Tamanho;
import util.Tela;

public class Bola {

	int[] way = new int[2];
	private Posição pos;
	// ainda tenho q ver como q eu uso essa variavel
	private Tamanho tamanho;

	public Bola(Posição pos, int x, int y, Tamanho tamanho) {
		this.pos = pos;
		way[0] = 1; // x
		way[1] = 1; // y
		this.tamanho = tamanho;
	}

	public Bola() {
		this.pos = new Posição();
		this.tamanho = new Tamanho();
	}

	public Tamanho getTamanho() {
		return tamanho;
	}

	public Posição getPos() {
		return pos;
	}

	public void setPos(int x, int y) {
		pos.setPos(x, y);
	}

	public void setTamanho(int t) {
		tamanho.setHeight(t);
		tamanho.setWidth(t);
	}

	public boolean fezGol(Player p) {
		return false;
	}

	public boolean colidiuPlayer(Player[] p) {
		for (Player player : p) {
			if (player.getPosX() < pos.getPosX() && player.getPosX() + player.getWidth() > pos.getPosX()
					&& player.getPosY() < pos.getPosY() && player.getPosY() + player.getHeight() > pos.getPosY()) {
				return true;
			}
		}
		return false;
	}

	public void colisaoPlayer() {
		if (way[0] == 1) {
			way[0] = -1;
		} else {
			way[0] = 1;
		}
	}

	public boolean colidiuBorda(Tela t) {
		if (t.getHeight() == 0 || t.getWidth() == 0) {
			return false;
		}

		// lado esquerdo / cima
		if (t.getHeight() < pos.getPosY() || t.getWidth() < pos.getPosX() || pos.getPosX() < 0 || pos.getPosY() < 0) {
			return true;
		}
		// lado direito / baixo
		if (t.getHeight() < pos.getPosY() + tamanho.getHeight() * 2
				|| t.getWidth() < pos.getPosX() + tamanho.getWidth() * 2 || pos.getPosX() < 0 || pos.getPosY() < 0) {
			return true;
		}

		return false;
	}

	public boolean[] checaLadoColisao(Tela t) {
		boolean[] b = new boolean[2];
		// caso a bola saia verticalmente da tela:
		// System.out.printf("tH: %d, pY: %d\ntW: %d, pX: %d\n\n", t.getHeight(),
		// pos.getPosY(), t.getWidth(), pos.getPosX());

		if (t.getWidth() <= pos.getPosX() + tamanho.getWidth() * 2 || 0 >= pos.getPosX()) {
			b[0] = true;
		}

		if (t.getHeight() <= pos.getPosY() + tamanho.getHeight() * 2 || 0 >= pos.getPosY()) {
			b[1] = true;
		}
		return b;
	}

	public int[] colisaoBorda(Tela t) {
		// o que fazer quando a bola colidir com a borda?
		boolean[] lado = checaLadoColisao(t);
		return inverteCaminho(way, lado);
	}

	public void mover() {
		setPos(pos.getPosX() + way[0], pos.getPosY() + way[1]);
	}

	public int[] inverteCaminho(int[] c, boolean[] b) {
		// nesse caso os vetores 0 representam a horizontal, e os 1, vertical
		if (b[0]) {
			if (c[0] == 1) {
				c[0] = -1;
			} else {
				c[0] = 1;
			}
		}
		if (b[1]) {
			if (c[1] == 1) {
				c[1] = -1;
			} else {
				c[1] = 1;
			}
		}

		return c;
	}

}
