package org.katas.gameoflife;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.util.Random;
import java.util.Set;
import java.util.function.BiConsumer;

import org.junit.Test;

public class GameOfLifeTest {

    private final Random random = new Random();

    @Test
    public void testSingleCell() {
        BoardGenerator generator = new RandomLivingCells(1);
        for (int run = 0; run < 25000; run++) {
            Board board = generator.generate(random);
            verifyBoard(board, 1, this::goesToEmpty);
        }
    }

    @Test
    public void testStillLife() {
        BoardGenerator generator = new StillLife();
        for (int run = 0; run < 100; run++) {
            Board board = generator.generate(random);
            verifyBoard(board, 1, this::staysTheSame);
        }
    }

    @Test
    public void testOscillator() {
        BoardGenerator generator = new Oscillator();
        for (int run = 0; run < 100; run++) {
            Board board = generator.generate(random);
            verifyBoard(board, 2, this::staysTheSame);
        }
    }

    @Test
    public void testStatisticalDeath() {
        BoardGenerator generator = new Filled(80);
        for (int run = 0; run < 500; run++) {
            Board board = generator.generate(random);
            verifyBoard(board, 1, this::massiveDeath);
        }
    }

    private void massiveDeath(Set<Point> cellsBefore, Set<Point> cellsAfter) {
        int countLivingCellsBefore = cellsBefore.size();
        int countLivingCells = cellsAfter.size();
        // System.out.println("countLivingCells=" + countLivingCells + " < countLivingCellsBefore=" + countLivingCellsBefore);
        assertTrue(countLivingCells < (countLivingCellsBefore * 0.1));
    }

    private void verifyBoard(Board board, int period, BiConsumer<Set<Point>, Set<Point>> assertion) {
        Set<Point> livingCellsBefore = board.getLivingCells();

        for (int times = 0; times < period; times++) {
            board.advance();
        }

        Set<Point> livingCells = board.getLivingCells();
        assertion.accept(livingCellsBefore, livingCells);
    }

    private void staysTheSame(Set<Point> cellsBefore, Set<Point> cellsAfter) {
        assertEquals(cellsBefore, cellsAfter);
    }

    private void goesToEmpty(@SuppressWarnings("unused") Set<Point> cellsBefore, Set<Point> cellsAfter) {
        assertEquals(0, cellsAfter.size());
    }

}
