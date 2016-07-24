package org.katas.gameoflife;

import net.java.quickcheck.Generator;
import net.java.quickcheck.generator.PrimitiveGenerators;

public class StillLife extends BoardGenerator {

    private final Generator<Integer> xCoordinates = PrimitiveGenerators.integers(Integer.MIN_VALUE, Integer.MAX_VALUE - 3);
    private final Generator<Integer> yCoordinates = PrimitiveGenerators.integers(Integer.MIN_VALUE, Integer.MAX_VALUE - 3);
    private final Generator<String> randomStillLifes = createRandomStillLifes();

    @Override
    public Board next() {
        Board board = new Board();

        int x = xCoordinates.next();
        int y = yCoordinates.next();
        place(board, x, y, randomStillLifes.next());

        return board;
    }

    private Generator<String> createRandomStillLifes() {
        String block = "**\n**\n";
        String beehive = " ** \n*  *\n ** ";
        String[] stillLifes = { block, beehive };

        return PrimitiveGenerators.fixedValues(stillLifes);
    }

}
