package excepition;

import model.Player;

public class InvalidMoveException extends Exception {
    String message;

    public InvalidMoveException(Player player, int positon) {
        message =
            "Player " + player.getId() + " made an invalid move at position " +
                positon;
    }

    public String getMessage() {
        return message;
    }
}
