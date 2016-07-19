package org.katas.gameoflife;

import org.junit.Assert;
import org.junit.Test;

public class GameOfLifeTest {

	@Test
	public void test() {
		// 1 -> empty
		verifyGoesToEmpty(BoardGenerator.withLivingCellsOf(1));
		// 2 -> empty
	}

	private void verifyGoesToEmpty(BoardGenerator generator) {
		for (int i = 0; i < 100; i++) {
			Board b = generator.createBoard();
			// verify 1 exist
			b.advance();
			Assert.assertEquals(0, b.getLivingCellsCount());
		}
	}

}
