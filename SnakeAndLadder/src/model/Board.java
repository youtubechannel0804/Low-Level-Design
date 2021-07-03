package model;

import Validator.LadderCalculator;
import Validator.SnakeCalculator;
import util.LadderGenerator;
import util.SnakeGenerator;

import java.util.Map;

public class Board {

    int cells = 0;

    Map<Integer, Snake> snakes = null;

    Map<Integer, Ladder> ladders = null;

    public Board(int size, int snakeNeeded, int ladderNeeded) {
        this.cells = size * size;
        initBoard(snakeNeeded, ladderNeeded);
    }

    public void initBoard(int snakeNeeded, int ladderNeeded) {
        addSnake(this.cells, snakeNeeded);
        addLadder(this.cells, ladderNeeded);
    }

    public Map<Integer, Snake> getSnakes() {
        return snakes;
    }

    public void setSnakes(Map<Integer, Snake> snakes) {
        this.snakes = snakes;
    }

    public Map<Integer, Ladder> getLadders() {
        return ladders;
    }

    public void setLadders(Map<Integer, Ladder> ladders) {
        this.ladders = ladders;
    }

    public void addSnake(int cellsCount, int snakeNeeded) {
        snakes = SnakeGenerator.generate(cellsCount, snakeNeeded);
    }

    public void addLadder(int cellsCount, int ladderNeeded) {
        ladders = LadderGenerator.generate(cellsCount, ladderNeeded);
    }

    public int movePosition(int currentPosition, int diceValue) {
        int newPosition = currentPosition + diceValue;

        SnakeCalculator snakeValidator = new SnakeCalculator();
        newPosition = snakeValidator.validate(this, newPosition);
        LadderCalculator ladderValidator = new LadderCalculator();
        newPosition = ladderValidator.validate(this, newPosition);

        return newPosition;
    }

    public int getCells() {
        return cells;
    }

    public void setCells(int cells) {
        this.cells = cells;
    }
}
