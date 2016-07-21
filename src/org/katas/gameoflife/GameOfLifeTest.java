package org.katas.gameoflife;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;

import java.awt.Point;
import java.util.Set;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class GameOfLifeTest {

    @DataPoints("SingleRandomLivingCell")
    public static Iterable<Board> randomLivingCells() {
        return new RandomLivingCells(1).createBoards(100);
    }

    @DataPoints("StillLife")
    public static Iterable<Board> stillLife() {
        return new StillLife().createBoards(100);
    }

    @DataPoints("OscillatorPhase2")
    public static Iterable<Board> oscillator() {
        return new Oscillator().createBoards(100);
    }

    @DataPoints("Filled80%")
    public static Iterable<Board> filled80() {
        return new Filled(80).createBoards(100);
    }

    @Theory
    public void testSingleCell(@FromDataPoints("SingleRandomLivingCell") Board board) {
        verifyGoesToEmpty(board);
    }

    @Theory
    public void testStillLife(@FromDataPoints("StillLife") Board board) {
        verifyStaysTheSame(board, 1);
    }

    @Theory
    public void testOscillator(@FromDataPoints("OscillatorPhase2") Board board) {
        verifyStaysTheSame(board, 2);
    }

    @Theory
    public void testStatisticalDeath(@FromDataPoints("Filled80%") Board board) {
        verifyMassiveDeath(board, 10);
    }

    private void verifyMassiveDeath(Board board, int survival) {
        int countLivingCellsBefore = board.getLivingCellsCount();

        board.advance();

        int countLivingCells = board.getLivingCellsCount();
        // System.out.println("count2=" + count2 + " < count1=" + count1);
        Assert.assertTrue(countLivingCells < (countLivingCellsBefore * 1.0 / 100 * survival));
    }

    private void verifyStaysTheSame(Board board, int period) {
        Set<Point> livingCellsBefore = board.getLivingCells();

        for (int times = 0; times < period; times++) {
            board.advance();
        }

        Set<Point> livingCells = board.getLivingCells();
        assertEquals(livingCellsBefore, livingCells);
    }

    private void verifyGoesToEmpty(Board board) {
        assertEquals(1, board.getLivingCellsCount());
        Assume.assumeThat(board.getLivingCellsCount(), is(1));

        board.advance();

        assertEquals(0, board.getLivingCellsCount());
    }

}
