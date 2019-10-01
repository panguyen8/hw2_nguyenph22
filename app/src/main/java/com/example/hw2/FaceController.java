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
    private SeekBar seekBarRed;
    private SeekBar seekBarGreen;
    private SeekBar seekBarBlue;

    //The constructor
    public FaceController(Face cv) {
        fView = cv;
        fModel = cv.getFaceModel();

    }

    //The button method for when it is clicked
    public void onClick(View v) {
        fModel.randomize();
        updateSeekBars();
        fView.invalidate();
    }

    //Spinner bar that changes the hair
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

    //For each button clicked, it will be assigned to its respective choice
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        RadioButton checkedRadioButton = (RadioButton)group.findViewById(checkedId);
        boolean isChecked = checkedRadioButton.isChecked();

        //looks for the checkedId
        switch (checkedId) {
            case R.id.hairButton:
                if (isChecked) {
                    fModel.hairColor = 1;
                    fModel.eyeColor = 0;
                    fModel.skinColor = 0;
                    //updates the seekBar
                    updateSeekBars();
                }
                break;
            case R.id.eyesButton:
                if (isChecked) {
                    fModel.hairColor = 0;
                    fModel.eyeColor = 1;
                    fModel.skinColor = 0;
                    //updates the seekBar
                    updateSeekBars();
                }
                break;
            case R.id.skinButton:
                if (isChecked) {
                    fModel.hairColor = 0;
                    fModel.eyeColor = 0;
                    fModel.skinColor = 1;
                    //updates the seekBar
                    updateSeekBars();
                }
                break;
        }

        fView.invalidate();
    }

    //Method which grabs the seekbars from main activity, allows them to be updated
    public void setSeekBars(SeekBar red, SeekBar green, SeekBar blue) {
        seekBarRed = red;
        seekBarGreen = green;
        seekBarBlue = blue;
    }

    //The Method which updates the seekBar
    private void updateSeekBars() {
        if (fModel.hairColor == 1) {
            seekBarRed.setProgress(fModel.hairColorRed);
            seekBarGreen.setProgress(fModel.hairColorGreen);
            seekBarBlue.setProgress(fModel.hairColorBlue);
            fView.invalidate();
        } else if (fModel.eyeColor == 1) {
            seekBarRed.setProgress(fModel.eyeColorRed);
            seekBarGreen.setProgress(fModel.eyeColorGreen);
            seekBarBlue.setProgress(fModel.eyeColorBlue);
            fView.invalidate();
        } else if (fModel.skinColor == 1) {
            seekBarRed.setProgress(fModel.skinColorRed);
            seekBarGreen.setProgress(fModel.skinColorGreen);
            seekBarBlue.setProgress(fModel.skinColorBlue);
            fView.invalidate();
        }
    }

    //method which allows for the seekbar to change depending on which radio button chosen
    public void onProgressChanged(SeekBar seekbar, int progress, boolean fromUser) {
        switch(seekbar.getId()){
            case R.id.redBar:
                //to turn on hair color sliders
                if (fModel.hairColor == 1) {
                    fModel.hairColorRed = progress;
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

    }

    public void onStopTrackingTouch(SeekBar seekbar) {

    }
}
