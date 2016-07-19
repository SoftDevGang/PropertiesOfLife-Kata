package org.katas.gameoflife;

import java.awt.Point;
import java.util.Random;

public class StillLife implements BoardGenerator {

	private int numberOfStillLifes;

	public StillLife(int numberOfStillLifes) {
		this.numberOfStillLifes = numberOfStillLifes;
	}

	@Override
	public Board createBoard() {

		Board b = new Board();
		Random r = new Random();
		int x = r.nextInt(Integer.MAX_VALUE - 1);
		int y = r.nextInt(Integer.MAX_VALUE - 1);
		b.place(new Point(x + 0, y + 0));
		b.place(new Point(x + 1, y + 0));
		b.place(new Point(x + 0, y + 1));
		b.place(new Point(x + 1, y + 1));
		return b;
	}

}
