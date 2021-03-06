package com.example.proje_battleshiptest;

import android.util.Log;

/**
 * board - Contains a 2d array of coordinates, each coordinate has two booleans
 * hit and hasShip from.
 *
 * @author Austen Furutani
 * @author Keoni Han
 * @author Steven Lee
 * @author Tyler Santos
 * @version Spring 2022 - 2/22/22
 */
public class GameBoard extends Coordinates {
    private Coordinates currentBoard[][]; //a Coordinate array representing the board

    /**
     * GameBoard - Default constructor for the board
     * initerates through the 2d array assigning each one
     * coordinate object with two false values one for hit(if the coordinate has been fired at)
     * and one for hasShip(Identifying if the coordinate houses a ship)
     */
    public GameBoard(){
        int i,j;
        this.currentBoard = new Coordinates[10][10];
        for (i = 0; i < 10; i++)  {
            for(j = 0; j < 10; j++){
                this.currentBoard[i][j] = new Coordinates(false, false, i + 1, j + 1);
            }
        }
    }


    /**
     * GameBoard - Copy constructor for the Board object
     * iterates through the list assigning each coordinate with
     * a copy of the originals coordinate values
     * @param orig - a copy of the original GameBoard
     */
    public GameBoard(GameBoard orig){ //copy constructor
        int i,j;
        this.currentBoard = new Coordinates[10][10];
        for (i = 0; i < 10; i++){
            for(j = 0; j < 10; j++){
                Log.i("COPY", "GameBoard: " + i + " " + j);
                this.currentBoard[i][j] = new Coordinates(orig.currentBoard[i][j]);
            }
        }
        Log.i("DONE", "DONE");
    }

    /**
     * setCoordHit - Sets the coordinate of row, col to be hit or not hit
     * @param row - a given row coord
     * @param col - a given column coord
     * @param hit - whether the ship has been hit or not
     */
 public boolean setCoordHit(int row, int col, boolean hit){
     if(getCoordHit(row, col) == false) {
         this.currentBoard[row][col].setHit(hit);
         return true;
     }
     return false;
 }

    /**
     * Checks if the coordinate values passed in has been hit
     * @param row - a given row coord
     * @param col - a given column coord
     * @return bool, if the coordinate has been hit
     */
 public boolean getCoordHit(int row, int col){
        return this.currentBoard[row][col].getHit();
 }

}
