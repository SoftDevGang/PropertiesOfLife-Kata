package org.katas.gameoflife;

import java.util.Random;

public class StillLife extends BoardGenerator {

    private final Random random = new Random();

    @Override
    public Board createBoard() {
        Board board = new Board();

        int x = random.nextInt(Integer.MAX_VALUE - 3);
        int y = random.nextInt(Integer.MAX_VALUE - 3);
        place(board, x, y, getRandomStillLife());

        return board;
    }

    private String getRandomStillLife() {
        String block = "**\n**\n";
        String beehive = " ** \n*  *\n ** ";
        String[] stillLifes = { block, beehive };

        return stillLifes[random.nextInt(stillLifes.length)];
    }

}
