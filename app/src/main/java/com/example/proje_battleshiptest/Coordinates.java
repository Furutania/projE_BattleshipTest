package com.example.proje_battleshiptest;

/**
 * coordinates - A representation of the coordinates on a Battleship board.
 *
 * @author Austen Furutani
 * @author Keoni Han
 * @author Steven Lee
 * @author Tyler Santos
 * @version Spring 2022 - 2/22/22
 */
public class Coordinates {
    private boolean hit;
    private boolean hasShip;
    private int x;
    private int y;


    /**
     * creates a coordinate object setting its instance variables
     * @param hit
     * @param hasShip
     */
    public Coordinates(boolean hit, boolean hasShip, int x, int y){
        this.hit = hit;
        this.hasShip = hasShip;
        this.x = x;
        this.y = y;
    }

    /**
     * default constructor for coordinate sets hit and hasShip to false
     */
    public Coordinates(){ //default constructor
        this.hit = false;
        this.hasShip = false;
    }

    /**
     * Copy contructor, creates a copy of the passed in coordinate object
     * @param orig
     */
    public Coordinates(Coordinates orig){
        this.hit = orig.hit;
        this.hasShip = orig.hasShip;
        this.x = orig.x;
        this.y = orig.y;
    }

    /**
     * Changes the boolean of hit to the passed in value, then returns
     * if the coordinate hit has a ship on it
     * @param hit
     * @return
     */
    public boolean setHit(boolean hit){
        this.hit = hit;
        return this.hasShip;
    }



    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * returns a boolean, if the coordinate has already been hit.
     * @return bool of hit
     */



    public boolean getHit() {
        return this.hit;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public boolean getHasShip(){
        return this.hasShip;
    }



}
