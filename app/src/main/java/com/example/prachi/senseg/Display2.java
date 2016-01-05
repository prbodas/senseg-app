package com.example.prachi.senseg;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MotionEvent;
import android.content.Context;
import android.widget.*;
import android.util.Log;

import com.senseg.haptics.Grain;

/**
 * Created by Prachi on 10/11/15.
 */
public class Display2 extends ActionBarActivity {

    /*notes on the xml file
    * 1920x1200 pixel display TODO*/

    //TODO: set up board with stripes and gradient, play with stripe width
    //TODO: change gradient based on x direction and x movement

    public static String grain1 = Grain.GRAIN_AREA_SMOOTH;
    public static float intensity1 = 1.0f; //pink
    public static String grain2 = Grain.GRAIN_AREA_SMOOTH;
    public static float intensity2 = 0.2f; //blue
    //TODO: make private and add getter and setter methods

    public static final int ROWS = 8;
    public static final int COLS = 8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO: display2 xml may end up being completely useless
        GridLayout rel = new GridLayout(this);
        rel.setColumnCount(COLS);
        rel.setRowCount(ROWS);

        int q = 0;
        //adding fourth through eighth rows
        for (int i = 0; i < ROWS; i++)
        {
            if (q == 0){q = 1;}else{q = 0;}
            //adding fourth row
            for (int j = 0; j < COLS; j++)
            {
                //rel.addView(new TextViewTouch(this,q,i,j));
                //Log.d("added", i + " " + j);
                if (q == 0){q = 1;}else{q = 0;}
            }
        }


        //rel.addView(new TextViewTouch(this,1));
        setContentView(rel);
        //TODO:make the textviewtouches

    }


}