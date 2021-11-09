package util;

public class Posi��o {

	private int posX;
	private int posY;
	
	public Posi��o(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}

	public Posi��o() {
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

	public void setPos(Posi��o p) {
		this.posX = p.getPosX();
		this.posY = p.getPosY();
	}

}
