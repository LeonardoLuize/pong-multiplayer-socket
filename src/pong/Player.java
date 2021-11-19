package pong;

import java.awt.event.KeyEvent;

import util.Posicao;
import util.Tamanho;

public class Player extends Entidade {

	private boolean principal;
	private int pontuacao;

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	// Construtor com posicao e uma variavel booleana para o metodo move() funcionar
	public Player(int x, int y, boolean principal) {
		pos = new Posicao(x, y);
		tamanho = new Tamanho(50, 200);
		this.principal = principal;
		pontuacao = 0;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void pontuou() {
		this.pontuacao += 1;
	}

	// metodo com mudanca de posicao.
	public void mover() {
		int y = pos.getY();
		if (principal) {
			// soma a dire��o com a posi��o atual (dentro da tela)
			if (y >= 0 && y < 550) {
				pos.setY(y + direcaoY * velocidade);
			}

			// limite superior da tela
			if (y < 0) {
				pos.setY(1);
			}

			// limite inferior da tela
			if (y >= 550) {
				pos.setY(548);
			}
		}
	}

	// Ao apertar a tecla, muda o valor de dy. dy incrementa o valor de y no move()
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_UP) {
			direcaoY = -2;
		}

		if (key == KeyEvent.VK_DOWN) {
			direcaoY = 2;
		}
	}

	// Ao soltar a tecla, dy = 0. Fazendo com que y nao mude no move()
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_UP) {
			direcaoY = 0;
		}

		if (key == KeyEvent.VK_DOWN) {
			direcaoY = 0;
		}
	}

}
