package com.example.proje_battleshiptest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button runTest = findViewById(R.id.runTest);
        EditText multiLine = findViewById(R.id.editTextTextMultiLine);

        View.OnClickListener buttonHandler = new View.OnClickListener() {
            @Override
            public void onClick(View button) {
                //Clears Text
                multiLine.setText("");

                //Calls default constructor to make first instance of game state and makes a deep copy of it
                BattleShipGameState firstInstance = new BattleShipGameState();
                BattleShipGameState firstDeepCopy = new BattleShipGameState(firstInstance);

                //Calls each method once

                //Makes second instance of game state and makes a deep copy of it
                BattleShipGameState secondInstance = new BattleShipGameState();
                BattleShipGameState secondDeepCopy = new BattleShipGameState(secondInstance);
                //Calls toString on both gameStates
                firstDeepCopy.toString();
                secondDeepCopy.toString();

            }
        };

    }
}