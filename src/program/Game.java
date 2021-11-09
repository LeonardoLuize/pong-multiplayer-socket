package program;

import entities.Bola;
import entities.Player;
import util.Tela;

public class Game {

	private Bola bola;
	private Player[] players;
	private int maxPontos;
	private int ganhador;
	private Tela screen;

	public Game(Bola bola, Player[] players, int maxPontos) {
		this.bola = bola;
		this.players = players;
		this.maxPontos = maxPontos;
		setup();
	}

	private void setup() {
		screen = new Tela(400, 400);
		bola.setPos(screen.getScreenHeight() / 2, screen.getScreenHeight() / 2);
		screen.setBallSize(bola.getTamanho().getWidth());
		screen.setPlayersSize(players[0].getTamanho(), players[1].getTamanho());
		players[1].setPosX(screen.getScreenWidth() - players[0].getPosX() - players[1].getWidth());
	}

	public int getGanhador() {
		return ganhador;
	}

	public void setGanhador(boolean lado) {
		if (lado) {
			ganhador = 1;
		} else {
			ganhador = 0;
		}
	}

	public void start() {
		// aqui é onde tudo vai rodar
		while (true) {
			
			if(bola.getPos().getPosX() > screen.getScreenWidth()) {
				bola.setPos(screen.getScreenHeight() / 2, bola.getPos().getPosY());
			}
			bola.setPos(bola.getPos().getPosX()+1, bola.getPos().getPosY());
			screen.drawScreen(players[0].getPos(), players[1].getPos(), bola.getPos());
			// players[0].addScore();

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// condição para o jogo acabar: quando um player conseguir x pontos
			for (Player p : players) {
				if (p.getScore() >= maxPontos) {
					setGanhador(p.getLado());
					return;
				}
			}

		}
	}

}
