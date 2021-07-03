package Validator;

import model.Board;

public class SnakeCalculator {

    public int validate(Board board, int position) {

        return board.getSnakes().containsKey(position) ?
            board.getSnakes().get(position).getEnd() : position;
    }
}
