package model;

import Validator.ValidMoveValidator;
import Validator.WinValidator;

import java.util.LinkedList;
import java.util.Queue;

public class Game {

    Board board = null;

    Player currentPlayer;

    Status status = Status.START;

    Queue<Player> players;

    public Game(int boardSize, int playerCount) {
        players = new LinkedList();
        status = Status.INPROGRESS;
        init(boardSize, playerCount);
    }



    public void init(int boardSize, int playerCount) {
        this.board = new Board(boardSize, 5, 5);
        createPlayers(playerCount);
    }

    public void createPlayers(int playerCount) {
        for (int i = 0; i < playerCount; i++) {
            Player player = new Player(i);
            players.add(player);
        }

    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Queue<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Queue<Player> players) {
        this.players = players;
    }
}
