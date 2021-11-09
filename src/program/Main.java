package program;

import entities.Bola;
import entities.Player;
import util.Posi��o;
import util.Tamanho;

public class Main {

	public static void main(String[] args) {

		Tamanho t = new Tamanho(20, 100);

		Bola b = new Bola(new Posi��o(200, 200), 0, false, new Tamanho(10, 10));
		Player[] p = new Player[2];
		p[0] = new Player(new Posi��o(10, 100), 0, false, t);
		p[1] = new Player(new Posi��o(0, 200), 0, true, t);
		int pontMax = 1;

		Game game = new Game(b, p, pontMax);

		game.start();

		System.out.printf("O ganhador � o player %d!", game.getGanhador());
	}

}
