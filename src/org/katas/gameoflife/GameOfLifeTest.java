package org.katas.gameoflife;

import java.awt.Point;
import java.util.Set;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;

public class GameOfLifeTest {

	@Test
	public void test() {
		verifyGoesToEmpty(RandomLivingCells.withLivingCellsOf(1));
		// 2 -> empty
	}

	@Test
	public void testStillLife() {
		verifyStaysTheSame(new StillLife(1));
	}

	private void verifyStaysTheSame(BoardGenerator generator) {
		for (int i = 0; i < 100; i++) {
			Board b = generator.createBoard();
			Set<Point> points1 = b.getLivingCells();
			b.advance();
			Set<Point> points2 = b.getLivingCells();
			Assert.assertEquals(points1, points2);
		}
	}

	private void verifyGoesToEmpty(BoardGenerator generator) {
		for (int i = 0; i < 100; i++) {
			Board b = generator.createBoard();
			Assert.assertEquals(1, b.getLivingCellsCount());
			Assume.assumeThat(b.getLivingCellsCount(), Is.is(1));
			System.out.println(b);
			b.advance();
			Assert.assertEquals(0, b.getLivingCellsCount());
		}
	}

}
