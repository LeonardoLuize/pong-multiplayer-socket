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

		direcaoX = -1;
		direcaoY = 0;
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

	public Posicao[] pontosDeColisão() {
		Posicao[] pontos = new Posicao[4];

		for (int i = 0; i < 4; i++) {
			pontos[i] = new Posicao();
		}

		int x = getX();
		int y = getY();

		pontos[0].setPos(x + tamanho.getW(), y + tamanho.getH() / 2); // direita
		pontos[1].setPos(x, y + tamanho.getH() / 2); 				  // esquerda
		pontos[2].setPos(x + tamanho.getW() / 2, y + tamanho.getH()); // baixo
		pontos[3].setPos(x + tamanho.getW() / 2, y); 				  // cima

		return pontos;
	}

	public boolean aBolaColidiuComPlayer(Player p1, Player p2) {
		// Colisao com o Player1

		Posicao[] pontos = pontosDeColisão();

		if (pontos[1].getY() > p1.getY() && (pontos[1].getY() < p1.getY() + p1.getHeight())) {
			return true;
		}

		// Colisao com o Player2
		if (pontos[0].getY() > p2.getY() && (pontos[0].getY() < p2.getY() + p2.getHeight())) {
			return true;
		}

		return false;
	}

	public void elaColidiuSim(Player p1, Player p2) {

		Posicao[] pontos = pontosDeColisão();

		if (pontos[1].getX() <= p1.getX() + p1.getWidth()
				&& ((pontos[1].getY() > p1.getY()) && (pontos[1].getY() < p1.getY() + 65))) {
			setDy(-1);
			setDirecao(true);
		}
		if (pontos[1].getX() <= p1.getX() + p1.getWidth()
				&& ((pontos[1].getY() > p1.getY() + 65) && (pontos[1].getY() < p1.getY() + 130))) {
			setDirecao(true);
			setDy(0);
		}
		if (pontos[1].getX() <= p1.getX() + p1.getWidth()
				&& ((pontos[1].getY() > p1.getY() + 130) && (pontos[1].getY() < p1.getY() + 200))) {
			setDy(1);
			setDirecao(true);
		}

		// Colisao com o Player2
		if (pontos[0].getX() >= p2.getX() && ((pontos[0].getY() > p2.getY()) && (pontos[0].getY() < p2.getY() + 65))) {
			setDy(-1);
			setDirecao(false);
		}
		if (pontos[0].getX() >= p2.getX()
				&& ((pontos[0].getY() > p2.getY() + 65) && (pontos[0].getY() < p2.getY() + 130))) {
			setDirecao(false);
			setDy(0);
		}
		if (pontos[0].getX() >= p2.getX()
				&& ((pontos[0].getY() > p2.getY() + 130) && (pontos[0].getY() < p2.getY() + 200))) {
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

		if (pos.getY() <= 0) {
			direcaoY = 1;
		} else if (pos.getY() >= 650) {
			direcaoY = -1;
		}
	}

	public boolean goleou(Player p) {
		if (p.getX() < 500) {
			// player1 - esse 50 é meio q pra calibrar um pouco até aonde a bola ve que é
			// player e onde que é gol
			if (p.getX() + p.getWidth() - 50 >= pos.getX()) {
				return true;
			}
		} else {
			// player2
			if (p.getX() <= pos.getX()) {
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
