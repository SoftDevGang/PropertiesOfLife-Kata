package org.katas.gameoflife;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

public class Filled extends BoardGenerator {

    private final int percentage;

    public Filled() {
        this(80);
    }

    public Filled(int percentage) {
        this.percentage = percentage;
    }

    @Override
    public Board generate(SourceOfRandomness random, GenerationStatus status) {
        Board board = new Board();

        for (int x = 0; x < 100; x++) {
            for (int y = 0; y < 100; y++) {
                if (random.nextInt(100) <= percentage) {
                    place(board, x, y, "*");
                }
            }
        }
        return board;
    }

}
