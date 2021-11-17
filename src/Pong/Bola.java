package pong;

import java.awt.Image;

import javax.swing.ImageIcon;

import util.Posicao;
import util.Tamanho;

public class Bola extends Entidade {

	private Image image;
	private String arquivo;
	private boolean direcao = false;

	/*
	 * Construtor da Bola. a imagem da bola sera aleatoria, variando com os rostos
	 * dos desenvolvedores.
	 */
	public Bola(int positionX, int positionY, int gerador) {

		direcaoX = 0;
		direcaoY = 1;
		pos = new Posicao(positionX, positionY);

		switch (gerador) {
		case 1:
			arquivo = "src/pong/Daniel.png";
			break;
		case 2:
			arquivo = "src/pong/Leo.png";
			break;
		case 3:
			arquivo = "src/pong/Bola.png";
			break;
		case 4:
			arquivo = "src/pong/professor_poo.png";
			break;
		}
		ImageIcon ii = new ImageIcon(arquivo);
		image = ii.getImage();

		tamanho = new Tamanho(image.getWidth(null), image.getHeight(null));

	}

	public void setDx(int dx) {
		this.direcaoX = dx;
	}

	public void setDy(int dy) {
		this.direcaoY = dy;
	}

	public void setDirecao(boolean direcao) {
		this.direcao = direcao;
	}

	public boolean getDirecao() {
		return direcao;
	}

	/*
	 * Metodo move() da bola. Aqui deve conter os paramentros de colisao com a
	 * parede superior e inferior. Os paramentros de colisao com os players e o
	 * servidor devem ser implementados na classe Server e Client
	 */

	public boolean aBolaColidiuComPlayer(Player p1, Player p2) {
		// Colisao com o Player1
		if (pos.getY() > p1.getY() && (pos.getY() < p1.getY() + p1.getHeight())) {
			return true;
		}

		// Colisao com o Player2
		if (pos.getY() > p2.getY() && (pos.getY() < p2.getY() + p2.getHeight())) {
			return true;
		}

		return false;
	}

	public void elaColidiuSim(Player p1, Player p2) {

		if (pos.getX() == 90 && ((pos.getY() > p1.getY()) && (pos.getY() < p1.getY() + 65))) {
			setDy(-1);
			setDirecao(true);
		}
		if (pos.getX() == 90 && ((pos.getY() > p1.getY() + 65) && (pos.getY() < p1.getY() + 130))) {
			setDirecao(true);
			setDy(0);
		}
		if (pos.getX() == 90 && (pos.getY() > p1.getY() + 130 && (pos.getY() < p1.getY() + 200))) {
			setDy(1);
			setDirecao(true);
		}

		// Colisao com o Player2
		if (pos.getX() == 1000 && ((pos.getY() > p2.getY()) && (pos.getY() < p2.getY() + 65))) {
			setDy(-1);
			setDirecao(false);
		}
		if (pos.getX() == 1000 && ((pos.getY() > p2.getY() + 65) && (pos.getY() < p2.getY() + 130))) {
			setDirecao(false);
			setDy(0);
		}
		if (pos.getX() == 1000 && ((pos.getY() > p2.getY() + 130) && (pos.getY() < p2.getY() + 200))) {
			setDy(1);
			setDirecao(false);
		}
	}

	public void mover() {
		pos.setX(pos.getX() + direcaoX * velocidade);
		pos.setY(pos.getY() + direcaoY * velocidade);

		if (direcao) {
			direcaoX = 1;
		} else {
			direcaoX = -1;
		}

		if (pos.getY() == 0) {
			direcaoY = 1;
		} else if (pos.getY() == 650) {
			direcaoY = -1;
		}
	}

	public boolean goleou(int x) {
		if (x == 80) {
			if (getX() < 80) {
				return true;
			}
		}
		if (x == 1100) {
			if (getX() > 1100) {
				return true;
			}
		}
		return false;
	}

	public void resetPos() {
		setX(400);
		setY(300);
	}

	public Image getImage() {
		return image;
	}
}
