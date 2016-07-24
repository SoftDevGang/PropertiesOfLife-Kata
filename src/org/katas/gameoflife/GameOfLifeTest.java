package org.katas.gameoflife;

import static org.junit.Assert.assertEquals;

import java.awt.Point;
import java.util.Set;
import java.util.function.BiConsumer;

import org.junit.Assert;
import org.junit.Test;

import net.java.quickcheck.QuickCheck;
import net.java.quickcheck.characteristic.AbstractCharacteristic;

public class GameOfLifeTest {

    @Test
    public void testSingleCell() {
        QuickCheck.forAll(25000, new RandomLivingCells(1), new AbstractCharacteristic<Board>() {
            @Override
            protected void doSpecify(Board board) {
                verifyBoard(board, 1, GameOfLifeTest.this::goesToEmpty);
            }
        });
    }

    @Test
    public void testStillLife() {
        QuickCheck.forAll(new StillLife(), new AbstractCharacteristic<Board>() {
            @Override
            protected void doSpecify(Board board) {
                verifyBoard(board, 1, GameOfLifeTest.this::staysTheSame);
            }
        });
    }

    @Test
    public void testOscillator() {
        QuickCheck.forAll(new Oscillator(), new AbstractCharacteristic<Board>() {
            @Override
            protected void doSpecify(Board board) {
                verifyBoard(board, 2, GameOfLifeTest.this::staysTheSame);
            }
        });
    }

    @Test
    public void testStatisticalDeath() {
        QuickCheck.forAll(new Filled(80), new AbstractCharacteristic<Board>() {
            @Override
            protected void doSpecify(Board board) {
                verifyBoard(board, 1, GameOfLifeTest.this::massiveDeath);
            }
        });
    }

    private void massiveDeath(Set<Point> cellsBefore, Set<Point> cellsAfter) {
        int countLivingCellsBefore = cellsBefore.size();
        int countLivingCells = cellsAfter.size();
        // System.out.println("countLivingCells=" + countLivingCells + " < countLivingCellsBefore=" + countLivingCellsBefore);
        Assert.assertTrue(countLivingCells < (countLivingCellsBefore * 0.1));
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
