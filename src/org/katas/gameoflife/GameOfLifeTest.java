package org.katas.gameoflife;

import static org.junit.Assert.assertEquals;

import java.awt.Point;
import java.util.Set;
import java.util.function.BiConsumer;

import org.junit.Assert;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class GameOfLifeTest {

    @DataPoints("RandomLivingCells")
    public static Iterable<Board> randomLivingCells() {
        return new RandomLivingCells(1).createBoards(100);
    }

    @DataPoints("StillLife")
    public static Iterable<Board> stillLife() {
        return new StillLife().createBoards(100);
    }

    @DataPoints("Oscillator")
    public static Iterable<Board> oscillator() {
        return new Oscillator().createBoards(100);
    }

    @DataPoints("Filled")
    public static Iterable<Board> filled80() {
        return new Filled(80).createBoards(100);
    }

    @Theory
    public void testSingleCell(@FromDataPoints("RandomLivingCells") Board board) {
        verifyBoard(board, 1, this::goesToEmpty);
    }

    @Theory
    public void testStillLife(@FromDataPoints("StillLife") Board board) {
        verifyBoard(board, 1, this::staysTheSame);
    }

    @Theory
    public void testOscillator(@FromDataPoints("Oscillator") Board board) {
        verifyBoard(board, 2, this::staysTheSame);
    }

    @Theory
    public void testStatisticalDeath(@FromDataPoints("Filled") Board board) {
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
