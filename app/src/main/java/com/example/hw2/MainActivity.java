package com.example.hw2;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Face faceView =  (Face) findViewById(R.id.surfaceView);
        FaceController faceController = new FaceController(faceView);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroupVars);
        radioGroup.setOnCheckedChangeListener(faceController);

        SeekBar redBar = (SeekBar) findViewById(R.id.redBar);
        redBar.setOnSeekBarChangeListener(faceController);
        SeekBar greenBar = (SeekBar) findViewById(R.id.greenBar);
        greenBar.setOnSeekBarChangeListener(faceController);
        SeekBar blueBar = (SeekBar) findViewById(R.id.blueBar);
        blueBar.setOnSeekBarChangeListener(faceController);



        Button randomButton = (Button) findViewById(R.id.randomize);
        randomButton.setOnClickListener(faceController);

        Spinner hairSpinner = (Spinner) findViewById(R.id.spinner);
        hairSpinner.setOnItemSelectedListener(faceController);
        String[] items = new String[] {
                "Bowlcut", "Buzzcut", "Mohawk"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        hairSpinner.setAdapter(adapter);


    }
}
