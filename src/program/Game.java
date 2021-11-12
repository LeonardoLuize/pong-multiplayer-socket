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
		screen.setBallSize(bola.getTamanho().getWidth());
		screen.setPlayersSize(players[0].getTamanho(), players[1].getTamanho());
		screen.addKeyListener(screen);
		players[1].setPosX(screen.getScreenWidth() - players[0].getPosX() - players[1].getWidth());
		
	}

	public int getGanhador() {
		return ganhador;
	}

	public void setGanhador(boolean lado) {
		if (lado) {
			ganhador = 1;
		} else {
			ganhador = 2;
		}
	}

	public void start() {
		
		// aqui � onde tudo vai rodar
		while (true) {
			
			if(bola.colidiuBorda(screen)) {
				bola.colisaoBorda(screen);
			}
			
			if(bola.colidiuPlayer(players)) {
				bola.colisaoPlayer(players);
			}
			
			if(bola.fezGol(players[0])) {
				players[0].addScore();
				bola.setPos(screen.getScreenWidth()/2, screen.getScreenHeight()/2);
			}
			
			if(bola.fezGol(players[1])) {
				players[1].addScore();
				bola.setPos(screen.getScreenWidth()/2, screen.getScreenHeight()/2);
			}
			
			players[0].mover(screen.getMovPlayer(0), screen.getScreenHeight(), screen.getBarraTela());
			players[1].mover(screen.getMovPlayer(1), screen.getScreenHeight(), screen.getBarraTela());
			bola.mover();
			
			screen.drawScreen(players[0].getPos(), players[1].getPos(), bola.getPos());

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			// condi��o para o jogo acabar: quando um player conseguir x pontos
			for (Player p : players) {
				if (p.getScore() >= maxPontos) {
					setGanhador(p.getLado());
					return;
				}
			}

		}
	}

}
