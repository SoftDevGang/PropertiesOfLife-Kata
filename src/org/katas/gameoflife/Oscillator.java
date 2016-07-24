package org.katas.gameoflife;

import net.java.quickcheck.Generator;
import net.java.quickcheck.generator.PrimitiveGenerators;

public class Oscillator extends BoardGenerator {

    private final Generator<Integer> xCoordinates = PrimitiveGenerators.integers(Integer.MIN_VALUE, Integer.MAX_VALUE - 3);
    private final Generator<Integer> yCoordinates = PrimitiveGenerators.integers(Integer.MIN_VALUE, Integer.MAX_VALUE - 3);
    private final Generator<String> randomOscillators = creatrRandomOscillators();

    @Override
    public Board next() {
        Board board = new Board();

        int x = xCoordinates.next();
        int y = yCoordinates.next();
        place(board, x, y, randomOscillators.next());

        return board;
    }

    private Generator<String> creatrRandomOscillators() {
        String blinker = " * \n * \n * \n";
        String[] oscillators = { blinker };

        return PrimitiveGenerators.fixedValues(oscillators);
    }

}
