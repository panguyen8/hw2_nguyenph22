package com.example.hw2;

import java.util.Random;

public class FaceModel {
    protected Random rand = new Random();

    //the variables pertaining to the face
    protected int skinColor = 0;
    protected int skinColorRed = rand.nextInt(256);
    protected int skinColorGreen = rand.nextInt(256);
    protected int skinColorBlue = rand.nextInt(256);

    protected int eyeColor = 0;
    protected int eyeColorRed = rand.nextInt(256);
    protected int eyeColorGreen = rand.nextInt(256);
    protected int eyeColorBlue = rand.nextInt(256);

    protected int hairColor = 0;
    protected int hairColorRed = rand.nextInt(256);
    protected int hairColorGreen = rand.nextInt(256);
    protected int hairColorBlue = rand.nextInt(256);

    protected int hairStyle = 2;

    public void randomize() {
        //randomize changes all the vars of the face
        skinColorRed = rand.nextInt(256);
        skinColorGreen = rand.nextInt(256);
        skinColorBlue = rand.nextInt(256);

        eyeColorRed = rand.nextInt(256);
        eyeColorGreen = rand.nextInt(256);
        eyeColorBlue = rand.nextInt(256);

        hairColorRed = rand.nextInt(256);
        hairColorGreen = rand.nextInt(256);
        hairColorBlue = rand.nextInt(256);

        hairStyle = rand.nextInt(3);
    }
}
