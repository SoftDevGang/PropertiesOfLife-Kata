package org.katas.gameoflife;

import static org.junit.Assert.assertEquals;

import java.awt.Point;
import java.util.Set;
import java.util.function.BiConsumer;

import org.junit.Assert;
import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

@RunWith(JUnitQuickcheck.class)
public class GameOfLifeTest {

    @Property
    public void testSingleCell(@From(RandomLivingCells.class) Board board) {
        verifyBoard(board, 1, this::goesToEmpty);
    }

    @Property
    public void testStillLife(@From(StillLife.class) Board board) {
        verifyBoard(board, 1, this::staysTheSame);
    }

    @Property
    public void testOscillator(@From(Oscillator.class) Board board) {
        verifyBoard(board, 2, this::staysTheSame);
    }

    @Property
    public void testStatisticalDeath(@From(Filled.class) Board board) {
        verifyBoard(board, 1, this::massiveDeath);
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
