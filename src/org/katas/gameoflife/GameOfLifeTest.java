package org.katas.gameoflife;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;

import java.awt.Point;
import java.util.Set;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;

public class GameOfLifeTest {

    @Test
    public void testSingleCell() {
        verifyGoesToEmpty(new RandomLivingCells(1));
    }

    @Test
    public void testStillLife() {
        verifyStaysTheSame(new StillLife(), 1);
    }

    @Test
    public void testOscillator() {
        verifyStaysTheSame(new Oscillator(), 2);
    }

    @Test
    public void testStatisticalDeath() {
        verifyMassiveDeath(new Filled(80), 10);
    }

    private void verifyMassiveDeath(Filled generator, int survival) {
        for (int run = 0; run < 500; run++) {
            Board board = generator.createBoard();
            int countLivingCellsBefore = board.getLivingCellsCount();

            board.advance();

            int countLivingCells = board.getLivingCellsCount();
            // System.out.println("count2=" + count2 + " < count1=" + count1);
            Assert.assertTrue(countLivingCells < (countLivingCellsBefore * 1.0 / 100 * survival));
        }
    }

    private void verifyStaysTheSame(BoardGenerator generator, int period) {
        for (int run = 0; run < 100; run++) {
            Board board = generator.createBoard();
            Set<Point> livingCellsBefore = board.getLivingCells();

            for (int times = 0; times < period; times++) {
                board.advance();
            }

            Set<Point> livingCells = board.getLivingCells();
            assertEquals(livingCellsBefore, livingCells);
        }
    }

    private void verifyGoesToEmpty(BoardGenerator generator) {
        for (int run = 0; run < 100; run++) {
            Board board = generator.createBoard();
            assertEquals(1, board.getLivingCellsCount());
            Assume.assumeThat(board.getLivingCellsCount(), is(1));

            board.advance();

            assertEquals(0, board.getLivingCellsCount());
        }
    }

}
