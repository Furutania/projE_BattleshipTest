package com.example.proje_battleshiptest;

import android.util.Log;

/**
 * BattleshipObj
 * Creates a battleship object, storing its location, its size, and if its been sunk
 *
 * @author Austen Furutani
 * @author Keoni Han
 * @author Steven Lee
 * @author Tyler Santos
 * @version Spring 2022 - 2/22/22
 */
//hi
public class BattleshipObj {
    private int size;
    private boolean sunk;
    private Coordinates[] location;

    public BattleshipObj(int size, Coordinates[] location){
        this.size = size;
        this.sunk = false;
        this.location = new Coordinates[size];
        Log.i("in battleship", "BEFORE LOOP");
        int i;
        for(i = 0; i < location.length; i++){
            Log.i("in battleship", "" + i);
            this.location[i] = new Coordinates(location[i]);
        }
    }

    public BattleshipObj(BattleshipObj orig){
        this.size = orig.size;
        this.sunk = orig.sunk;

        int i;
        Log.i("in BSOBJ", "BattleshipObj: ");
        this.location = new Coordinates[orig.location.length];
        for(i = 0; i < orig.location.length; i++){
            Log.i("in BSOBJ", "BattleshipObj: " + i);
            this.location[i] = new Coordinates(orig.location[i]);
        }
    }

    public boolean checkIfSunk(BattleshipObj ship){
        int i;
        for(i = 0; i < location.length; i++){
            if(ship.location[i].getHit() == false){
                return false;
            }
        }
        //ship sunk
        setSunk(true);
        return true;
    }



    public int getSize() {
        return size;
    }
    public boolean getSunk() {
        return sunk;
    }
    public Coordinates[] getLocation() {
        return location;
    }

    public void setSize(int size){
        this.size = size;
    }
    public void setSunk(boolean sunk){
        this.sunk = sunk;
    }
    public void setLocation(Coordinates[] location) {
        this.location = location;
    }
}
