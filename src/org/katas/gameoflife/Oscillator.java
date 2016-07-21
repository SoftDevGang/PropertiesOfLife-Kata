package org.katas.gameoflife;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

public class Oscillator extends BoardGenerator {

    @Override
    public Board generate(SourceOfRandomness random, GenerationStatus status) {
        Board board = new Board();

        int x = random.nextInt(Integer.MAX_VALUE - 3);
        int y = random.nextInt(Integer.MAX_VALUE - 3);
        place(board, x, y, getRandomOscillator(random));

        return board;
    }

    private String getRandomOscillator(SourceOfRandomness random) {
        String blinker = " * \n * \n * \n";
        String[] oscillators = { blinker };

        return oscillators[random.nextInt(oscillators.length)];
    }

}
