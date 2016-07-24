package org.katas.gameoflife;

import net.java.quickcheck.Generator;
import net.java.quickcheck.generator.PrimitiveGenerators;

public class RandomLivingCells extends BoardGenerator {

    private final Generator<Integer> xCoordinates = PrimitiveGenerators.integers();
    private final Generator<Integer> yCoordinates = PrimitiveGenerators.integers();

    private final int numberOfLivingCells;

    public RandomLivingCells(int numberOfLivingCells) {
        this.numberOfLivingCells = numberOfLivingCells;
    }

    @Override
    public Board next() {
        Board board = new Board();

        for (int i = 0; i < numberOfLivingCells; i++) {
            int x = xCoordinates.next();
            int y = yCoordinates.next();
            // TODO check if filled

            place(board, x, y, "*");
        }

        return board;
    }

}
