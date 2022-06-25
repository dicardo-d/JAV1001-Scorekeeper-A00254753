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


        Button b1 = (Button) findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isTeamASelected){
                    currentPointA += currentPoint;
                    scoreA.setText(""+currentPointA);
                } else  {
                    currentPointB += currentPoint;
                    scoreB.setText(""+currentPointB);
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