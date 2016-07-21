package org.katas.gameoflife;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

public class StillLife extends BoardGenerator {

    @Override
    public Board generate(SourceOfRandomness random, GenerationStatus status) {
        Board board = new Board();

        int x = random.nextInt(Integer.MAX_VALUE - 3);
        int y = random.nextInt(Integer.MAX_VALUE - 3);
        place(board, x, y, getRandomStillLife(random));

        return board;
    }

    private String getRandomStillLife(SourceOfRandomness random) {
        String block = "**\n**\n";
        String beehive = " ** \n*  *\n ** ";
        String[] stillLifes = { block, beehive };

        return stillLifes[random.nextInt(stillLifes.length)];
    }

}
