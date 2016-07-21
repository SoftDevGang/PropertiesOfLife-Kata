package org.katas.gameoflife;

import java.util.Random;

public class RandomLivingCells extends BoardGenerator {

    private final Random random = new Random();
    private final int numberOfLivingCells;

    public RandomLivingCells(int numberOfLivingCells) {
        this.numberOfLivingCells = numberOfLivingCells;
    }

    @Override
    public Board createBoard() {
        Board board = new Board();

        for (int i = 0; i < numberOfLivingCells; i++) {
            int x = random.nextInt();
            int y = random.nextInt();
            // TODO check if filled

            place(board, x, y, "*");
        }

        return board;
    }

}
