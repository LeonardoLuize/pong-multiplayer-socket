package program;

import entities.Bola;
import entities.Player;

public class Main {

	public static void main(String[] args) {
		
		Bola b = new Bola();
		Player[] p = new Player[2];
		p[0] = new Player(null, 0, false, 0);
		p[1] = new Player(null, 0, false, 0);
		int pontMax = 10;
		
		Game game = new Game(b, p, pontMax);

		game.start();
		
		System.out.printf("O ganhador é o player %d!", game.getGanhador());
	}

}
