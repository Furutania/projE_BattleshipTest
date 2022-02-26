package com.example.proje_battleshiptest;

/**
 * BattleShipGameState - Contains the state of a BattleShipGame. Sent by the game
 * when a play wants to enquire about the state of the game.
 *
 * @author Austen Furutani
 * @author Keoni Han
 * @author Steven Lee
 * @author Tyler Santos
 * @version Spring 2022 - 2/22/22
 */
public class BattleShipGameState {
    private int[] playerID;
    private GameBoard playersBoard;
    private int playersTurn;
    private int timer;
    // 0 = setup | 1 = game phase | 2 = end phase
    private int phase;
    private int remainingShips;
    private BattleshipObj[][] playersFleet = new BattleshipObj[playerID.length][6];


    // basic constructor
    public BattleShipGameState(int[] playerID, GameBoard playersBoard, int playersTurn, int timer,
                               int phase, int remainingShips) {
        this.playerID = playerID;
        this.playersBoard = playersBoard;
        this.playersTurn = playersTurn;
        this.timer = timer;
        this.phase = phase;
        this.remainingShips = remainingShips;
    }

    // deep copy constructor
    public BattleShipGameState(BattleShipGameState copy) {
        this.playerID = copy.playerID;
        this.playersBoard = new GameBoard(copy.playersBoard);
        this.playersTurn = copy.playersTurn;
        this.timer = copy.timer;
        this.phase = copy.phase;
        this.remainingShips = copy.remainingShips;
    }

    // if true, then player can fire and will set coordinate as if it were hit. if false,
    // then player can't fire
    public boolean canFire(int row, int col) {
        boolean isHit = this.playersBoard.getCoordHit(row, col);
        if (isHit == true) {
            return false;
        }
        else {
            this.playersBoard.setCoordHit(row, col, true);
            return true;
        }
    }

    //Checks to see if the coordinates the player has picked are in bounds of board and a ship isn't already placed there
    public void placeShip(BattleshipObj ship, Coordinates[] toPlace) {
        int i;
        for (i = 0; i < toPlace.length; i++) {
            if (toPlace[i].getHasShip() == false &&
                    toPlace[i].getX() <= 10 && toPlace[i].getY() <= 10 &&
                    toPlace[i].getX() >= 1 && toPlace[i].getY() >= 1) {
                ship.setLocation(toPlace);
            }
        }
    }

    @Override
    // returns the number of ships remaining for the player if it is their turn or
    // returns that it is not their turn
    public String toString() {
        if (playersTurn == this.playersTurn) {
            return "It is " + "PlayerID: " + playerID + "'s turn." + playerID + "has " + remainingShips + " remaining.";
        }
        return "It is not " + playerID + "'s turn.";
    }




}
