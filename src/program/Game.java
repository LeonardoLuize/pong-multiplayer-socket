package program;

import entities.Bola;
import entities.Player;

public class Game {

	private Bola bola;
	private Player[] players;
	private int maxPontos;
	private int ganhador;
	
	public Game(Bola bola, Player[] players, int maxPontos) {
		this.bola = bola;
		this.players = players;
		this.maxPontos = maxPontos;
		setup();
	}
	
	private void setup() {
		this.bola.setPos(0, 0);
	}
	
	public int getGanhador() {
		return ganhador;
	}
	
	public void setGanhador(boolean lado) {
		if(lado) {
			ganhador = 1;
		}else {
			ganhador = 0;
		}
	}
	
	public void start() {
		
		//aqui é onde tudo vai rodar do jogo
		while(true) {
			
			
			//condição para o jogo acabar: quando um player conseguir x pontos
			for(Player p: players) {
				if(p.getScore()>=maxPontos) {
					setGanhador(p.getLado());
					return;
				}
			}
			
		}
	}
	
}
