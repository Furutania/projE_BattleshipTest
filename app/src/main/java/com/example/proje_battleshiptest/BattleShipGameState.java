package com.example.proje_battleshiptest;

import android.util.Log;

import androidx.appcompat.widget.AppCompatRadioButton$InspectionCompanion;

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
    private BattleshipObj[][] playersFleet;


    public BattleShipGameState(){
        this.playerID = new int[]{0,1};
        Log.i("BSG", "Made playerID");
        this.playersBoard = new GameBoard();
        Log.i("BSG", "Made gameBoard");
        int num = (int) Math.random() * 1;
        this.playersTurn = num;
        Log.i("BSG", "Made player turn");
        this.timer = 30;
        Log.i("BSG", "Made timer");
        this.remainingShips = 6;
        this.playersFleet = new BattleshipObj[playerID.length][6];
        Log.i("BSG", "fleet");
    }


    // basic constructor
    public BattleShipGameState(int[] playerID, GameBoard playersBoard, int playersTurn, int timer,
                               int phase, int remainingShips, BattleshipObj[][] playersFleet) {
        this.playerID = playerID;
        this.playersBoard = playersBoard;
        this.playersTurn = playersTurn;
        this.timer = timer;
        this.phase = phase;
        this.remainingShips = remainingShips;
        this.playersFleet = playersFleet;
    }

    // deep copy constructor
    public BattleShipGameState(BattleShipGameState copy) {
        this.playerID = new int[2];
        for(int k = 0; k < 2; k++){
            this.playerID[k] = copy.playerID[k];
        }
        this.playersBoard = new GameBoard(copy.playersBoard);
        this.playersTurn = copy.playersTurn;
        this.timer = copy.timer;
        this.phase = copy.phase;
        this.remainingShips = copy.remainingShips;
        this.playersFleet = new BattleshipObj[playerID.length][6];

        int i;
        int j;
        Log.i("Test", "before Players fleet for loop");
        for (i = 0;  i < playerID.length; i++) {
            for (j = 0;j < 6; j++) {
                Log.i("Test", i + " " + j);
                this.playersFleet[i][j] = new BattleshipObj(copy.playersFleet[i][j]);
            }
        }
        Log.i("Test", "after Players fleet for loop");

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
            this.printFire(row, col, true);
            return true;
        }
    }

    //Checks to see if the coordinates the player has picked are in bounds of board and a ship isn't already placed there
    public boolean placeShip(BattleshipObj ship, Coordinates[] toPlace) {
        int i;
        for (i = 0; i < toPlace.length; i++) {
            if (toPlace[i].getX() <= 10 && toPlace[i].getY() <= 10 &&
                    toPlace[i].getX() >= 1 && toPlace[i].getY() >= 1) {
                ship.setLocation(toPlace);
                this.printPlaceShip(toPlace, true);
                return true;
            }
        }
        return false;
    }

    public String printFire(int row, int col, boolean canFire) {
        char[] letters = "ABCDEFGHIJ".toCharArray();
        if(canFire == true) {
            char rowLetter = letters[row];
            return playerID + " fired at x: " + row + " & y: " + col + ".";
        }
        return "Error";
    }

    public String printPlaceShip(Coordinates[] coords, boolean canPlaceShip) {
        char[] letters = "ABCDEFGHIJ".toCharArray();
        if(canPlaceShip == true) {
            for(int i = 0; i < coords.length; ++i) {
                int row = coords[i].getX();
                int col = coords[i].getY();
                char rowLetter = letters[row];
                return playerID + " placed a ship at x: " + rowLetter + " & y: " + col + ".";
            }
        }
        return "Error";
    }

    public void setPlayersFleet(BattleshipObj[] playerOneShips, BattleshipObj[] playerZeroShips){
        for(int i = 0; i < playerZeroShips.length; i++){
            playersFleet[0][i] = new BattleshipObj(playerZeroShips[i]);
        }
        for(int i = 0; i < playerOneShips.length; i++){
            playersFleet[1][i] = new BattleshipObj(playerOneShips[i]);
        }
    }


    @Override
    // returns the number of ships remaining for the player if it is their turn or
    // returns that it is not their turn
    public String toString() {
        if (playersTurn == this.playersTurn) {
            return "It is Player " + playerID[1] + "'s turn. They have " + remainingShips + " remaining ships.";
        }
        return "It is not " + playerID + "'s turn.";
    }






}
