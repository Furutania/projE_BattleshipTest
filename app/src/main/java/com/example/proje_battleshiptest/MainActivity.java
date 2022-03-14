package com.example.proje_battleshiptest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * MainActivity - This class will test the code once a button has been pressed.
 *
 * @author Austen Furutani
 * @author Keoni Han
 * @author Steven Lee
 * @author Tyler Santos
 */
public class MainActivity extends AppCompatActivity {


    /**
     * onCreate - Creates an activity that will run the test.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText multiLine = findViewById(R.id.editTextTextMultiLine);

        View.OnClickListener buttonHandler = new View.OnClickListener() {
            @Override
            public void onClick(View button) {
                //Clears Text
                multiLine.setText("");

                //instance variables
                //coords on the board
                Coordinates[][] coords = new Coordinates[10][10]; //Creating a 10 x 10 grid
                for (int i = 0; i < 10; i++)  {
                    for(int j = 0; j < 10; j++){
                        coords[i][j] = new Coordinates(false, false, i + 1, j + 1);
                    }
                }

                //coords of a ship
                Coordinates[] location = new Coordinates[5];
                for(int i = 0; i < 5; i++){
                    Log.i("test", "" + i);
                    location[i] = new Coordinates(coords[4 + i][5]);//creates a list of coords for a battle ship object to hold
                    location[i].setX(5 + i);
                    location[i].setY(5);
                }

                BattleshipObj battleship = new BattleshipObj(5, location);
                //Calls default constructor to make first instance of game state and makes a deep copy of it
                BattleShipGameState firstInstance = new BattleShipGameState();
                //Creates 2 list of battleship objects and then passes it into the gamestate
                BattleshipObj[] fleet1 = {battleship,battleship,battleship,battleship,battleship,battleship};
                BattleshipObj[] fleet2 = {battleship,battleship,battleship,battleship,battleship,battleship};
                firstInstance.setPlayersFleet(fleet1, fleet2);

                BattleShipGameState firstDeepCopy = new BattleShipGameState(firstInstance);

                //calls methods in the BattleShipGameState on the firstInstance of the gamestate
                //and then prints the action on the screen

                boolean fire = firstInstance.canFire(5, 6);
                boolean placedShip = firstInstance.placeShip(battleship, location);
                String firedAt; //String of where the player fired at
                String placedShipAt; //String of where the player placed a ship at

                if (fire == true) {
                    firedAt = firstInstance.printFire(5, 6, fire);
                }
                else {
                    firedAt = "Error. Player fired at an invalid coordinate.";
                }

                if(placedShip == true) {
                    placedShipAt = firstInstance.printPlaceShip(location, placedShip);
                }
                else {
                    placedShipAt = "Error. Player placed a ship at an invalid coordinate.";
                }

                //Calls each method once

                //Makes second instance of game state and makes a deep copy of it
                BattleShipGameState secondInstance = new BattleShipGameState();
                secondInstance.setPlayersFleet(fleet1, fleet2);
                BattleShipGameState secondDeepCopy = new BattleShipGameState(secondInstance);
                //Calls toString on both gameStates and prints the message for firing
                //and placing a ship
                multiLine.setText("" + firedAt + "\n" + placedShipAt + "\n" +
                        firstDeepCopy.toString() + " \n SECOND:" + secondDeepCopy.toString());
            }
        };

        Button runTest = findViewById(R.id.runTest);
        runTest.setOnClickListener(buttonHandler);

    }
}