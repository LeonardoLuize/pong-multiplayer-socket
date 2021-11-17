package pong;

import util.Posicao;
import util.Tamanho;

public abstract class Entidade {

	// todas as entidades (coisas que se movem) devem possuir os seguintes atributos
	// e metodos:
	protected Posicao pos;
	protected Tamanho tamanho;
	protected int direcaoX;
	protected int direcaoY;
	protected int velocidade = 5;

	public int getX() {
		return pos.getX();
	}

	public int getY() {
		return pos.getY();
	}

	public void setX(int x) {
		pos.setX(x);
	}

	public void setY(int y) {
		pos.setY(y);
	}

	public int getWidth() {
		return tamanho.getW();
	}

	public int getHeight() {
		return tamanho.getH();
	}

	// todas as entidades precisam se mover de alguma forma, porém a implementação é
	// diferente de uma pra outra, por isso fiz essa classe abstrata
	public abstract void mover();

}
