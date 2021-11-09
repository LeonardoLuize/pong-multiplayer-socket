package util;

public class Posição {

	private int posX;
	private int posY;
	
	public Posição(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}

	public Posição() {
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public void setPos(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}

	public void setPos(Posição p) {
		this.posX = p.getPosX();
		this.posY = p.getPosY();
	}

}
