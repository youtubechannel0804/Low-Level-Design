package Validator;

import model.Board;

public class WinValidator {

    public static boolean validate(Board board, int position) {
        return board.getCells() == position;
    }
}
