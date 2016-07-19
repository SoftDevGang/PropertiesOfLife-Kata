package org.katas.gameoflife;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

public class Board {

	private HashSet<Point> grid = new HashSet<>();

	public void place(Point point) {
		grid.add(point);
	}

	public void advance() {
		grid = new HashSet<>();
	}

	public int getLivingCellsCount() {
		return grid.size();
	}

	@Override
	public String toString() {
		return grid.toString();
	}

	public Set<Point> getLivingCells() {
		return grid;
	}

}
