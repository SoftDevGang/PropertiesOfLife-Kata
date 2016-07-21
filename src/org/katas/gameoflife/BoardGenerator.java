package org.katas.gameoflife;

import java.awt.Point;
import java.util.Iterator;

public abstract class BoardGenerator {

    public abstract Board createBoard();

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

    public Iterable<Board> createBoards(int number) {
        return new Iterable<Board>() {
            @Override
            public Iterator<Board> iterator() {
                return new CreateBoards(number);
            }
        };
    }

    private class CreateBoards implements Iterator<Board> {
        private final int maxBoards;
        private int count = 0;

        public CreateBoards(int number) {
            this.maxBoards = number;
        }

        @Override
        public boolean hasNext() {
            return count < maxBoards;
        }

        @Override
        public Board next() {
            count++;
            return createBoard();
        }
    }

}