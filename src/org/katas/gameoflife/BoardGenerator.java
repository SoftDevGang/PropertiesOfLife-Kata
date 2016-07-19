package org.katas.gameoflife;

import java.awt.Point;

public interface BoardGenerator {

	Board createBoard();

	static void place(Board b, int x, int y, String string) {
	
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