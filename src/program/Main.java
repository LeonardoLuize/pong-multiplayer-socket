package program;

import entities.Bola;
import entities.Player;
import util.Posição;

public class Main {

	public static void main(String[] args) {
		
		Bola b = new Bola(new Posição(0, 0), 0, false);
		Player[] p = new Player[2];
		p[0] = new Player(new Posição(0, 0), 0, false, 0);
		p[1] = new Player(new Posição(0, 0), 0, true, 0);
		int pontMax = 10;
		
		Game game = new Game(b, p, pontMax);

		game.start();
		
		System.out.printf("O ganhador é o player %d!", game.getGanhador());
	}

}
