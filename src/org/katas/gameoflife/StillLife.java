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
		int x = r.nextInt(Integer.MAX_VALUE - 3);
		int y = r.nextInt(Integer.MAX_VALUE - 3);

		place(b, x, y, getRandomStillLife(r));
		// createBeehive(b, x, y);
		return b;
	}

	private String getRandomStillLife(Random r) {
		String block = "**\n**\n";
		String beehive = " ** \n*  *\n ** ";
		String[] stillLifes = { block, beehive };
		String stillLife = stillLifes[r.nextInt(stillLifes.length)];
		return stillLife;
	}

	private void place(Board b, int x, int y, String string) {

		int originalX = x;
		for (Character c : string.toCharArray()) {
			if (c == '*') {
				b.place(new Point(x, y));
				x++;
			} else if (c == '\n') {
				y++;
				x = originalX;
			} else {
				x++;
			}
		}
	}

}
