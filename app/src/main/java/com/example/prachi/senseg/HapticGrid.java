package com.example.prachi.senseg;
import android.content.Context;
import android.widget.GridLayout;

import com.senseg.haptics.Grain;

/**
 * Created by prachibodas on 1/2/16.
 */
public class HapticGrid {

    Context context;
    String[] grains;
    float[] frequencies;
    int[][] pattern;

    public TextViewTouch[] views;
    //public Grain grain; //grain currently playing on the tablet

    GridLayout layout;

    int rows;
    int cols;

    public HapticGrid(Context c, String[] g, float[] f, int[][] p, int width, int height)
    {

        context = c;
        grains = g;
        frequencies = f;
        pattern = p;

        //grains and frequencies are parallel arrays containing grains w respective frequencies
        //pattern is a map of which grain goes where, corresponding to the indices on the other arrays

        //initialize new GridLayout to hold TextViewTouches
        layout = new GridLayout(context);

        views = new TextViewTouch[pattern.length*pattern[0].length];
        // add each new textview

        rows = pattern.length;
        cols = pattern[0].length;

        layout.setRowCount(rows);
        layout.setColumnCount(cols);

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                //decide which grain and freq to pass into textview
                String grain = grains[pattern[i][j]];
                float freq = frequencies[pattern[i][j]];
                //pass these in to textviewtouch, as well as width and height

                //create each textviewtouch in layout
                TextViewTouch newView = new TextViewTouch(context, grain, freq, width, height); //TODO: edit params
                layout.addView(newView);
                //add each to views array
                views[getIndex(i,j)] = newView;
            }
        }

    }

    public GridLayout getLayout()
    {
        return layout;
    }

    public int getIndex (int row, int col)
    //returns index in views array from rows and cols
    {
        return row*rows + col;
    }

}
