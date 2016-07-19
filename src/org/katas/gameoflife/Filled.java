package org.katas.gameoflife;

import java.util.Random;

public class Filled implements BoardGenerator {

	private int percentage;

	public Filled(int percentage) {
		this.percentage = percentage;
	}

	@Override
	public Board createBoard() {
		Random r = new Random();
		Board b = new Board();

		for (int x = 0; x < 100; x++) {
			for (int y = 0; y < 100; y++) {
				if (r.nextInt(100) <= percentage) {
					BoardGenerator.place(b, x, y, "*");
				}
			}
		}
		return b;
	}

}
