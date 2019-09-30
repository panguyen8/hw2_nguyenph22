package com.example.hw2;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;

import static android.content.ContentValues.TAG;

public class FaceController implements View.OnClickListener, RadioGroup.OnCheckedChangeListener,
        SeekBar.OnSeekBarChangeListener, AdapterView.OnItemSelectedListener{
    private Face fView;
    private FaceModel fModel;
    private RadioGroup radioGroup;
    private RadioButton radioButton;

    public FaceController(Face cv) {
        fView = cv;
        fModel = cv.getFaceModel();

    }

    public void onClick(View v) {
        fModel.randomize();
        fView.invalidate();
    }


    public void onItemSelected (AdapterView<?> parent, View view, int position, long id) {
        String hairChoice = (String) parent.getItemAtPosition(position);
        Log.v(TAG, hairChoice);
        if (hairChoice.equals("Bowlcut")) {
            fModel.hairStyle = 0;
        } else if (hairChoice.equals("Buzzcut")) {
            fModel.hairStyle = 1;
        } else if (hairChoice.equals("Mohawk")) {
            fModel.hairStyle = 2;
        }
        fView.invalidate();
    }

    public void onNothingSelected (AdapterView<?> parent) {

    }

    public void onCheckedChanged(RadioGroup group, int checkedId) {
        RadioButton checkedRadioButton = (RadioButton)group.findViewById(checkedId);
        boolean isChecked = checkedRadioButton.isChecked();

        switch (checkedId) {
            case R.id.hairButton:
                if (isChecked) {
                    fModel.hairColor = 1;
                    fModel.eyeColor = 0;
                    fModel.skinColor = 0;
                    Log.v(TAG, "hair!");

                }
                break;
            case R.id.eyesButton:
                if (isChecked) {
                    fModel.hairColor = 0;
                    fModel.eyeColor = 1;
                    fModel.skinColor = 0;
                    Log.v(TAG, "eyes");

                }
                break;
            case R.id.skinButton:
                if (isChecked) {
                    fModel.hairColor = 0;
                    fModel.eyeColor = 0;
                    fModel.skinColor = 1;
                    Log.v(TAG, "skin");
                }
                break;
        }

        fView.invalidate();
    }

    public void onProgressChanged(SeekBar seekbar, int progress, boolean fromUser) {


        switch(seekbar.getId()){
            case R.id.redBar:
                //to turn on hair color sliders
                if (fModel.hairColor == 1) {
                    fView.invalidate();
                } else if (fModel.eyeColor == 1) {
                    fModel.eyeColorRed = progress;
                    fView.invalidate();
                } else if (fModel.skinColor == 1) {
                    fModel.skinColorRed = progress;
                    fView.invalidate();
                }
                break;
            case R.id.greenBar:
                //to turn on eye color sliders
                if (fModel.hairColor == 1) {
                    fModel.hairColorGreen = progress;
                    fView.invalidate();
                } else if (fModel.eyeColor == 1) {
                    fModel.eyeColorGreen = progress;
                    fView.invalidate();
                } else if (fModel.skinColor == 1) {
                    fModel.skinColorGreen = progress;
                    fView.invalidate();
                }
                break;
            case R.id.blueBar:
                //to turn on eye color sliders
                if (fModel.hairColor == 1) {
                    fModel.hairColorBlue = progress;
                    fView.invalidate();
                } else if (fModel.eyeColor == 1) {
                    fModel.eyeColorBlue = progress;
                    fView.invalidate();
                } else if (fModel.skinColor == 1) {
                    fModel.skinColorBlue = progress;
                    fView.invalidate();
                }
                break;
        }


    }

    public void onStartTrackingTouch(SeekBar seekbar) {
        /*
        if (fModel.hairColor == 1) {
            switch(seekbar.getId()) {
                case R.id.redBar:
                    seekbar.setProgress(fModel.hairColorRed);
                case R.id.blueBar:
                    seekbar.setProgress(fModel.hairColorBlue);
                case R.id.greenBar:
                    seekbar.setProgress(fModel.hairColorRed);
                    break;
            }
        } else if (fModel.eyeColor == 1) {
            switch(seekbar.getId()) {
                case R.id.redBar:
                    seekbar.setProgress(fModel.eyeColorRed);
                case R.id.blueBar:
                    seekbar.setProgress(fModel.eyeColorBlue);
                case R.id.greenBar:
                    seekbar.setProgress(fModel.eyeColorRed);
                    break;
            }
        } else if (fModel.skinColor == 1) {
            switch(seekbar.getId()) {
                case R.id.redBar:
                    seekbar.setProgress(fModel.skinColorRed);
                case R.id.blueBar:
                    seekbar.setProgress(fModel.skinColorBlue);
                case R.id.greenBar:
                    seekbar.setProgress(fModel.skinColorRed);
                    break;
            }
        }
        */
         
    }

    public void onStopTrackingTouch(SeekBar seekbar) {

    }
}
