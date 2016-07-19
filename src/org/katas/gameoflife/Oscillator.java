package org.katas.gameoflife;

import java.util.Random;

public class Oscillator implements BoardGenerator {

	@Override
	public Board createBoard() {
		Board b = new Board();
		Random r = new Random();
		int x = r.nextInt(Integer.MAX_VALUE - 3);
		int y = r.nextInt(Integer.MAX_VALUE - 3);

		BoardGenerator.place(b, x, y, getRandomStillLife(r));
		return b;
	}

	private String getRandomStillLife(Random r) {
		String blinker = " * \n * \n * \n";
		String[] stillLifes = { blinker };
		String stillLife = stillLifes[r.nextInt(stillLifes.length)];
		return stillLife;
	}

}
