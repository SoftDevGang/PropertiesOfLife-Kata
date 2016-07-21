package org.katas.gameoflife;

import java.awt.Point;

import com.pholser.junit.quickcheck.generator.Generator;

public abstract class BoardGenerator extends Generator<Board> {

    protected BoardGenerator() {
        super(Board.class);
    }

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