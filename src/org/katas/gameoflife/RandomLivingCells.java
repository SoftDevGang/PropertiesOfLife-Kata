package org.katas.gameoflife;

import java.awt.Point;
import java.util.Random;

public class RandomLivingCells implements BoardGenerator {

	private int numberOfLivingCells;

	public RandomLivingCells(int numberOfLivingCells) {
		this.numberOfLivingCells = numberOfLivingCells;
	}

	public static BoardGenerator withLivingCellsOf(int i) {
		return new RandomLivingCells(i);
	}

	@Override
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
