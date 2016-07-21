package org.katas.gameoflife;

import java.util.Random;

public class Filled extends BoardGenerator {

    private final Random random = new Random();
    private final int percentage;

    public Filled(int percentage) {
        this.percentage = percentage;
    }

    @Override
    public Board createBoard() {
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
