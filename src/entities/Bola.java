package entities;

import util.Posição;
import util.Tamanho;
import util.Tela;

public class Bola {

	int[] way = new int[2];
	private Posição pos;
	private Tamanho tamanho;
	private int velocidade;

	public Bola(Posição pos, int x, int y, Tamanho tamanho, int velocidade) {
		this.pos = pos;
		way[0] = x;
		way[1] = y;
		this.tamanho = tamanho;
		this.velocidade = velocidade;
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

	public boolean fezGol(Player pl) {
		if (pl.getLado()) {// direita
			if (pos.getPosX() > pl.getPosX() + pl.getWidth()) {
				return true;
			}
		} else {// esquerda
			if (pos.getPosX() < pl.getPosX()) {
				return true;
			}
		}
		return false;
	}

	public boolean colidiuPlayer(Player[] p) {
		Posição[] pontos = pontosDeColisão();
		for (Player player : p) {
			for (Posição pontoCirculo : pontos) {
				if (player.getPosX() < pontoCirculo.getPosX()
						&& player.getPosX() + player.getTamanho().getWidth() / 2 > pontoCirculo.getPosX()
						&& player.getPosY() < pontoCirculo.getPosY()
						&& player.getPosY() + player.getTamanho().getHeight() > pontoCirculo.getPosY()) {
					return true;
				}
			}
		}
		return false;
	}

	public void colisaoPlayer(Player[] p) {
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

		Posição[] p = pontosDeColisão();
		// cima
		if (p[3].getPosY() < t.getBarraTela()) {
			return true;
		}
		// baixo
		if (t.getScreenHeight() < p[2].getPosY()) {
			return true;
		}

		return false;
	}

	public boolean[] checaLadoColisao(Tela t) {
		boolean[] b = new boolean[2];
		Posição[] p = pontosDeColisão();
		// esquerda / direita
		if (t.getScreenWidth() < p[0].getPosX() || p[1].getPosX() < 0) {
			b[0] = true;
		}

		// cima / baixo
		if (t.getScreenHeight() < p[2].getPosY() || p[3].getPosY() < t.getBarraTela()) {
			b[1] = true;
		}
		return b;
	}

	public int[] colisaoBorda(Tela t) {
		// o que fazer quando a bola colidir com a borda?
		boolean[] lado = checaLadoColisao(t);
		return inverteCaminho(way, lado);
	}

	public Posição[] pontosDeColisão() {
		Posição[] pontos = new Posição[4];

		for (int i = 0; i < 4; i++) {
			pontos[i] = new Posição();
		}

		// as coordenadas no centro tem um offset de -1 pra o x e para o y
		int x = pos.getPosX();
		int y = pos.getPosY();

		pontos[0].setPos(x + tamanho.getWidth(), y); // direita
		pontos[1].setPos(x - tamanho.getWidth(), y); // esquerda
		pontos[2].setPos(x, y + tamanho.getHeight()); // baixo
		pontos[3].setPos(x, y - tamanho.getHeight()); // cima

		return pontos;
	}

	public void mover() {
		setPos(pos.getPosX() + way[0] * velocidade, pos.getPosY() + way[1] * velocidade);
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
