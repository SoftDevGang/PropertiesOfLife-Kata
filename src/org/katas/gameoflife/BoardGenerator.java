package org.katas.gameoflife;

import java.awt.Point;
import java.util.Random;

public class BoardGenerator {

	private int numberOfLivingCells;

	public BoardGenerator(int numberOfLivingCells) {
		this.numberOfLivingCells = numberOfLivingCells;
	}

	public static BoardGenerator withLivingCellsOf(int i) {
		return new BoardGenerator(i);
	}

	public Board createBoard() {
		Random r = new Random();
		Board b = new Board();
		for (int i = 0; i < numberOfLivingCells; i++) {
			int x = r.nextInt();
			int y = r.nextInt();
			b.place(new Point(x, y));
			// check if filled
		}
		return b;
	}

}
