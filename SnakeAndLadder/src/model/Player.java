package model;

public class Player {

    int id;

    int cellNumber = 0;

    public Player(int id) {
        this.id = id;
    }

    public int getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(int cellNumber) {
        this.cellNumber = cellNumber;
    }

    public int getId() {
        return id;
    }
}
