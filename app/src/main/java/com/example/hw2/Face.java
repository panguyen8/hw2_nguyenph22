package com.example.hw2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;


public class Face extends SurfaceView {

    FaceModel fModel = new FaceModel();

    //The different colors of the face
    Paint skinPaint = new Paint();
    Paint blackPaint = new Paint();
    Paint whitePaint = new Paint();
    Paint eyePaint = new Paint();
    Paint hairPaint = new Paint();


    public Face(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);

        //sets two standard colors
        blackPaint.setColor(Color.BLACK);
        whitePaint.setColor(Color.WHITE);

    }


    public void drawEyes(Canvas canvas, int x, int y) {
        //draws the eyes
        eyePaint.setARGB(255, fModel.eyeColorRed, fModel.eyeColorGreen, fModel.eyeColorBlue);
        canvas.drawCircle(x, y, 50, whitePaint);
        canvas.drawCircle(x, y, 30, eyePaint);
        canvas.drawCircle(x, y, 20, blackPaint);
    }

    public void drawHair(Canvas canvas, int left, int right) {
        hairPaint.setARGB(255, fModel.hairColorRed, fModel.hairColorGreen, fModel.hairColorBlue);
        if (fModel.hairStyle == 0) {
            //draws a bowlcut hair style
            canvas.drawOval(left, 200, right, 280, hairPaint);
        } else if (fModel.hairStyle == 1) {
            //draws buzzcut
            canvas.drawRect(left, 200, right, 280, hairPaint);
        } else if (fModel.hairStyle == 2) {
            //draws mohawk
            canvas.drawRect(left + 60, 150, right - 60, 250, hairPaint);
        }
    }

    public void onDraw(Canvas canvas) {


        //draws the face
        skinPaint.setARGB(255, fModel.skinColorRed, fModel.skinColorGreen, fModel.skinColorBlue);
        canvas.drawCircle(600, 400, 200, skinPaint);

        //draws the eyes
        drawEyes(canvas, 520, 370);
        drawEyes(canvas, 680, 370);

        //draws the mouth
        canvas.drawRect(520, 470, 680, 530, whitePaint);

        //draws the hair
        drawHair(canvas, 500, 700);
    }

    public FaceModel getFaceModel() {
        return fModel;
    }
}
