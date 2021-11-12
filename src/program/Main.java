package program;

import entities.Bola;
import entities.Player;
import util.Posição;
import util.Tamanho;

public class Main {

	public static void main(String[] args) {

		Tamanho t = new Tamanho(20, 100);

		Bola b = new Bola(new Posição(200, 200), 1, -1, new Tamanho(10, 10), 3);
		Player[] p = new Player[2];
		p[0] = new Player(new Posição(10, 200), 0, false, t, 5);
		p[1] = new Player(new Posição(10, 200), 0, true, t, 5);
		int pontMax = 5;

		Game game = new Game(b, p, pontMax);

		game.start();

		System.out.printf("O ganhador é o player %d!", game.getGanhador());
	}

}
