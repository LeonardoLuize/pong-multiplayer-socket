package util;

public class Posicao {

	private int x;
	private int y;
	
	public Posicao(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Posicao() {
		this.x = 0;
		this.y = 0;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setPos(int x, int y) {
		this.y = y;
		this.x = x;
	}
	
	public void setPos(Posicao p) {
		this.y = p.getY();
		this.x = p.getX();
	}

	@Override
	public String toString() {
		return "Posição [x=" + x + ", y=" + y + "]";
	}
	
}
