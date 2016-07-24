package org.katas.gameoflife;

import net.java.quickcheck.Generator;
import net.java.quickcheck.generator.PrimitiveGenerators;

public class Filled extends BoardGenerator {

    private static final int MAX_X = 100;
    private static final int MAX_Y = 100;

    private final Generator<Integer> percentages = PrimitiveGenerators.integers(0, 99);

    private final int percentage;

    public Filled(int percentage) {
        this.percentage = percentage;
    }

    @Override
    public Board next() {
        Board board = new Board();

        for (int x = 0; x < MAX_X; x++) {
            for (int y = 0; y < MAX_Y; y++) {
                if (percentages.next() <= percentage) {
                    place(board, x, y, "*");
                }
            }
        }

        return board;
    }

}
