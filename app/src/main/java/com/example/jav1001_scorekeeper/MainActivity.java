package com.example.jav1001_scorekeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int currentPointA = 0;
    int currentPointB = 0;
    int currentPoint = 2;
    boolean isTeamASelected = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView scoreA = findViewById(R.id.textView3);
        TextView scoreB = findViewById(R.id.textView4);
        TextView errorMessage = findViewById(R.id.errorView);

        Button b1 = (Button) findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isTeamASelected){
                    errorMessage.setVisibility(errorMessage.INVISIBLE);
                    currentPointA += currentPoint;
                    scoreA.setText(""+currentPointA);
                } else  {
                    errorMessage.setVisibility(errorMessage.INVISIBLE);
                    currentPointB += currentPoint;
                    scoreB.setText(""+currentPointB);
                }
            }
        });

        Button b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isTeamASelected){
                    if (currentPointA > 0) {
                        errorMessage.setVisibility(errorMessage.INVISIBLE);
                        currentPointA -= currentPoint;
                        scoreA.setText("" + currentPointA);
                    }
                    else {
                        errorMessage.setVisibility(errorMessage.VISIBLE);
                        errorMessage.setText("Score cannot be in negative");
                    }
                } else if (currentPointB > 0) {
                    errorMessage.setVisibility(errorMessage.VISIBLE);
                    currentPointB -= currentPoint;
                    scoreB.setText("" + currentPointB);
                }
                else {
                    errorMessage.setVisibility(errorMessage.VISIBLE);
                        errorMessage.setText("Score cannot be in negative");
                }
            }
        });

        RadioGroup rGroup = (RadioGroup) findViewById(R.id.radioGroup);
        rGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.radioButton) {
                    currentPoint = 2;
                } else if (i == R.id.radioButton2) {
                    currentPoint = 4;
                } else if (i == R.id.radioButton3) {
                    currentPoint = 6;
                } else if (i == R.id.radioButton4) {
                    currentPoint = 8;
                }
            }
        });

        Switch teamSwitch = findViewById(R.id.switch1);
        teamSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                isTeamASelected = !b;
            }
        });
    }
}