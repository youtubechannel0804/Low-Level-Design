package Validator;

import model.Board;

public class LadderCalculator {

    public int validate(Board board, int position) {

        return board.getLadders().containsKey(position) ?
            board.getLadders().get(position).getEnd() : position;
    }
}
