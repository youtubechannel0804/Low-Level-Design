package Validator;

import model.Board;

public class ValidMoveValidator {

    public boolean validate(Board board, int position) {
        return board.getCells() >= position;
    }
}
