package util;

public class Tamanho {

	private int w;
	private int h;
	
	public Tamanho(int w, int h) {
		this.w = w;
		this.h = h;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public void setTamanho(Tamanho t) {
		this.w = t.getW();
		this.h = t.getH();
	}
	
	@Override
	public String toString() {
		return "Tamanho [w=" + w + ", h=" + h + "]";
	}
	
}
