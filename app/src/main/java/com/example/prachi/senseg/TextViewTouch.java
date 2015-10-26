package com.example.prachi.senseg;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;
import android.view.MotionEvent;
import com.senseg.haptics.Grain;

import static com.example.prachi.senseg.Display2.*;


/**
 * Created by Prachi on 10/16/15.
 */
public class TextViewTouch extends TextView {
    public float intensity;
    public boolean pressed = false;
    public Grain grain;
    public int grain_number;
    public int xcoord;
    public int ycoord;

    //contains all the views ever created
    public static TextViewTouch[] views = new TextViewTouch[ROWS*COLS];
    public static int viewsindex = 0;
    public static TextViewTouchListener listener = new TextViewTouchListener();
    public static final int WIDTH = 200;
    public static final int HEIGHT = 200;

    public TextViewTouch(Context context, int grainNum, int x, int y){
        super(context);
        if (grainNum == 0)
        {
            grain = new Grain(grain1);
            intensity = intensity1;
            setBackgroundResource(R.drawable.pink);
        }else{
            grain = new Grain(grain2);
            intensity = intensity2;
            setBackgroundResource(R.drawable.blue);
        }
        //Log.d("str","In constructor");

        this.setWidth(WIDTH);
        this.setHeight(HEIGHT);

        views[viewsindex] = this;
        viewsindex++;
        grain_number = grainNum;
        xcoord = x;
        ycoord = y;

        //this.setOnDragListener(listener);
        this.setOnTouchListener(listener);
        //Log.d("str", "C done");
    }


    /*public boolean onTouchEvent(MotionEvent event)
    {
        if (!pressed)
        {
            press();
        }else if (pressed)
        {
            unpress();
        }

        //check if any others are pressed, and unpress those
        for (int i = 0; i<views.length; i++)
        {
            if (views[i].pressed)
            {
                views[i].unpress();
            }
        }
        press();

        return true;
    } */

    public void press()
    {
        pressed = true;
        grain.play(intensity);
        setBackgroundResource(0);
    }

    public void unpress()
    {
        Log.d("coords",xcoord +" "+ycoord);
        pressed = false;
        grain = null; //hopefully the effect will stop at this point
        if (grain_number == 0)
        {
            grain = new Grain(grain1);
            setBackgroundResource(R.drawable.pink);
        }else
        {
            grain = new Grain(grain2);
            setBackgroundResource(R.drawable.blue);
        }
    }
}
