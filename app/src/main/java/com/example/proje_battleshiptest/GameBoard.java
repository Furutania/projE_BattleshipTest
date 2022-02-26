package com.example.proje_battleshiptest;
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
public class GameBoard extends com.example.proje_battleshiptest.Coordinates {
    private com.example.proje_battleshiptest.Coordinates currentBoard[][] = new com.example.proje_battleshiptest.Coordinates[10][10];

    /**
     * Default constructor for the board
     * initerates through the 2d array assigning each one
     * coordinate object with two false values one for hit(if the coordinate has been fired at)
     * and one for hasShip(Identifying if the coordinate houses a ship)
     */
    public GameBoard(){
        int i,j;
        for (i = 1; i <= 10; i++){
            for(j = 1; i <= 10; j++){
                this.currentBoard[i][j] = new com.example.proje_battleshiptest.Coordinates(false, false, i, j);
            }
        }
    }


    /**
     * Copy constructor for the Board object
     * iterates through the list assigning each coordinate with
     * a copy of the originals coordinate values
     * @param orig
     */
    public GameBoard(GameBoard orig){ //copy constructor
        int i,j;
        for (i = 1; i <= 10; i++){
            for(j = 1; i <= 10; j++){
                this.currentBoard[i][j] = new com.example.proje_battleshiptest.Coordinates(orig.currentBoard[i][j]);
            }
        }
    }

    /**
     * Sets the coordinate of row, col to be hit or not hit
     * @param row
     * @param col
     * @param hit
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
     * @param row
     * @param col
     * @return bool, if the coordinate has been hit
     */
 public boolean getCoordHit(int row, int col){
        return this.currentBoard[row][col].getHit();
 }

}
