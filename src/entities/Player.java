package entities;

import util.Posi��o;

public class Player {

	private Posi��o pos;
	private int score;
	private boolean lado;
	//tamanho da barrinha ("goleiro") do player
	private int tamanho;
	
	public Player(Posi��o pos, int score, boolean lado, int tamanho) {
		this.pos = pos;
		this.score = score;
		this.lado = lado;
		this.tamanho = tamanho;
	}

	//o player s� se move para cima e para baixo, movimento para cima
	//vai ser realizado com valores negativos, e para baixo, positivos
	//(coordenadas 0,0 s�o canto superior esquerdo da tela)
	public void addPosY(int y) {
		pos.setPosY(pos.getPosY() + y);
	}
	
	public void addScore() {
		score += 1;
	}
	
	public int getGol() {
		return pos.getPosX();
	}
	
	public int getScore() {
		return score;
	}
	
	public boolean getLado() {
		return lado;
	}
	
}
