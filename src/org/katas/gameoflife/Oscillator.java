package org.katas.gameoflife;

import java.util.Random;

public class Oscillator extends BoardGenerator {

    @Override
    public Board generate(Random random) {
        Board board = new Board();

        int x = random.nextInt(Integer.MAX_VALUE - 3);
        int y = random.nextInt(Integer.MAX_VALUE - 3);
        place(board, x, y, getRandomOscillator(random));

        return board;
    }

    private String getRandomOscillator(Random random) {
        String blinker = " * \n * \n * \n";
        String[] oscillators = { blinker };

        return oscillators[random.nextInt(oscillators.length)];
    }

}
