package org.katas.gameoflife;

import java.util.Random;

public class Filled extends BoardGenerator {

    private static final int MAX_X = 100;
    private static final int MAX_Y = 100;

    private final int percentage;

    public Filled(int percentage) {
        this.percentage = percentage;
    }

    @Override
    public Board generate(Random random) {
        Board board = new Board();

        for (int x = 0; x < MAX_X; x++) {
            for (int y = 0; y < MAX_Y; y++) {
                if (random.nextInt(100) <= percentage) {
                    place(board, x, y, "*");
                }
            }
        }

        return board;
    }

}
