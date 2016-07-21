package org.katas.gameoflife;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

public class RandomLivingCells extends BoardGenerator {

    private final int numberOfLivingCells;

    public RandomLivingCells() {
        this(1);
    }

    public RandomLivingCells(int numberOfLivingCells) {
        this.numberOfLivingCells = numberOfLivingCells;
    }

    @Override
    public Board generate(SourceOfRandomness random, GenerationStatus status) {
        Board board = new Board();

        for (int i = 0; i < numberOfLivingCells; i++) {
            int x = random.nextInt();
            int y = random.nextInt();
            // TODO check if filled

            place(board, x, y, "*");
        }

        return board;
    }

}
