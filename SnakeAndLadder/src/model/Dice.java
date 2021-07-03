package model;

import Constant.Constants;

import java.util.Random;

public class Dice {

    int diceValue;

    /*
    Get dice value when rolling the dice.
     */
    public int roll() {
        return new Random().nextInt(Constants.DICE_LIMIT);
    }
}
