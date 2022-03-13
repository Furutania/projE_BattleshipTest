package com.example.proje_battleshiptest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


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
                Coordinates[][] coords = new Coordinates[10][10]; //Creating a 10 x 10 grid
                for (int i = 0; i < 10; i++)  {
                    for(int j = 0; j < 10; j++){
                        coords[i][j] = new Coordinates(false, false, i + 1, j + 1);
                    }
                }
////
                Coordinates[] location = new Coordinates[5];
                for(int i = 0; i < 5; i++){
                    Log.i("test", "" + i);
                    location[i] = new Coordinates(coords[4 + i][5]); //creates a list of coords for a battle ship object to hold
                }

                BattleshipObj battleship = new BattleshipObj(5, location);
//                //Calls default constructor to make first instance of game state and makes a deep copy of it
                BattleShipGameState firstInstance = new BattleShipGameState();
                //Creates 2 list of battleship objects and then passes it into the gamestate
                BattleshipObj[] fleet1 = {battleship,battleship,battleship,battleship,battleship,battleship};
                BattleshipObj[] fleet2 = {battleship,battleship,battleship,battleship,battleship,battleship};
                firstInstance.setPlayersFleet(fleet1, fleet2);

                BattleShipGameState firstDeepCopy = new BattleShipGameState(firstInstance);
//
//                //Calls each method once
//
//                //Makes second instance of game state and makes a deep copy of it
                BattleShipGameState secondInstance = new BattleShipGameState();
                secondInstance.setPlayersFleet(fleet1, fleet2);
                BattleShipGameState secondDeepCopy = new BattleShipGameState(secondInstance);
                //Calls toString on both gameStates
                multiLine.setText("" + firstDeepCopy.toString() + " \n SECOND:" + secondDeepCopy.toString());

                //Calls methods on firstInstance
//                firstInstance.canFire(4, 6);
//                firstInstance.placeShip(battleship, location);
            }
        };

        Button runTest = findViewById(R.id.runTest);
        runTest.setOnClickListener(buttonHandler);

    }
}