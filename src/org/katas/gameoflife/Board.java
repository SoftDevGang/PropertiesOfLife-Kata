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
		HashSet<Point> grid2 = new HashSet<>();
		for (Point point : getPossiblePoints()) {
			int neighborCount = getNeighborCount(point);
			if ((3 == neighborCount) || (2 == neighborCount && isAlive(point))) {
				grid2.add(point);

			}
		}
		grid = grid2;
	}

	private HashSet<Point> getPossiblePoints() {
		HashSet<Point> grid2 = new HashSet<>();
		for (Point point : grid) {
			for (int x = -1; x <= 1; x++) {
				for (int y = -1; y <= 1; y++) {
					grid2.add(new Point(point.x + x, point.y + y));
				}
			}
		}
		return grid2;

	}

	private int getNeighborCount(Point point) {
		int count = 0;
		for (int x = -1; x <= 1; x++) {
			for (int y = -1; y <= 1; y++) {
				if (isAlive(point.x + x, point.y + y) && !(x == 0 && y == 0)) {
					count++;
				}
			}
		}
		return count;
	}

	private boolean isAlive(int x, int y) {
		return isAlive(new Point(x, y));
	}

	private boolean isAlive(Point p) {
		return grid.contains(p);
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
