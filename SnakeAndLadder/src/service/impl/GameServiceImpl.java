package service.impl;

import Validator.ValidMoveValidator;
import Validator.WinValidator;
import excepition.InvalidMoveException;
import model.*;
import service.GameService;

public class GameServiceImpl implements GameService {

    public void play(Game game) {

        Dice dice = new Dice();

        while (game.getStatus() != Status.COMPLETED) {
            Board board = game.getBoard();
            int diceValue = dice.roll();

            Player currentPlayer = game.getPlayers().poll();

            int newPosition = currentPlayer.getCellNumber() + diceValue;

            if (!validateMove(currentPlayer, board, newPosition))
                continue;

            newPosition = getNewPosition(diceValue, currentPlayer, board);

            isWinner(game, board, newPosition);

            currentPlayer.setCellNumber(newPosition);
            game.setCurrentPlayer(currentPlayer);
            game.getPlayers().offer(currentPlayer);
        }

        System.out.println(game.getCurrentPlayer().getId());
    }

    private void isWinner(Game game, Board board, int newPosition) {
        if (WinValidator.validate(board, newPosition))
            game.setStatus(Status.COMPLETED);
    }

    private int getNewPosition(int diceValue, Player currentPlayer,
        Board board) {
        int newPosition;
        newPosition = board
            .movePosition(currentPlayer.getCellNumber(),
                diceValue);
        return newPosition;
    }

    private boolean validateMove(Player currentPlayer, Board board,
        int newPosition) {
        ValidMoveValidator validMoveValidator = new ValidMoveValidator();
        boolean isValid = true;
        try {
            isValid = validMoveValidator.validate(board, newPosition);
            if (!isValid)
                throw new InvalidMoveException(currentPlayer, newPosition);
        } catch (InvalidMoveException ex) {
            System.out.println(ex.getMessage());
        }
        return isValid;
    }
}
