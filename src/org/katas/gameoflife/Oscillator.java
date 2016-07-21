package org.katas.gameoflife;

import java.util.Random;

public class Oscillator extends BoardGenerator {

    private final Random random = new Random();

    @Override
    public Board createBoard() {
        Board board = new Board();

        int x = random.nextInt(Integer.MAX_VALUE - 3);
        int y = random.nextInt(Integer.MAX_VALUE - 3);
        place(board, x, y, getRandomOscillator());

        return board;
    }

    private String getRandomOscillator() {
        String blinker = " * \n * \n * \n";
        String[] oscillators = { blinker };

        return oscillators[random.nextInt(oscillators.length)];
    }

}
