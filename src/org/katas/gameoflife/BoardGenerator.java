package org.katas.gameoflife;

import java.awt.Point;
import java.util.Random;

public abstract class BoardGenerator {

    public abstract Board generate(Random random);

    protected void place(Board board, int startX, int startY, String pattern) {
        int x = startX;
        int y = startY;

        for (char c : pattern.toCharArray()) {
            if (c == '*') {
                board.place(new Point(x, y));
                x++;
            } else if (c == '\n') {
                y++;
                x = startX;
            } else {
                x++;
            }
        }
    }

}