package org.katas.gameoflife;

import java.util.Random;

public class StillLife extends BoardGenerator {

    @Override
    public Board generate(Random random) {
        Board board = new Board();

        int x = random.nextInt(Integer.MAX_VALUE - 3);
        int y = random.nextInt(Integer.MAX_VALUE - 3);
        place(board, x, y, getRandomStillLife(random));

        return board;
    }

    private String getRandomStillLife(Random random) {
        String block = "**\n**\n";
        String beehive = " ** \n*  *\n ** ";
        String[] stillLifes = { block, beehive };

        return stillLifes[random.nextInt(stillLifes.length)];
    }

}
