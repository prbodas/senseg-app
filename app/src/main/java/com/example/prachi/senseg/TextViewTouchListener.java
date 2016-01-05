package com.example.prachi.senseg;

import android.view.View;
import android.view.DragEvent;
import android.util.Log;
import android.view.MotionEvent;
import android.graphics.Rect;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Prachi on 10/25/15.
 */
//public class TextViewTouchListener implements View.OnTouchListener{

   /* public static int xcoord = -1;
    public static int ycoord = -1;
    public boolean firstpress = true;
    public boolean dragging = false;
    //public Class sourceClass = Display1;

    public boolean onTouch(View v, MotionEvent event) {
        Log.d("str","Inmethod");
        TextViewTouch t = (TextViewTouch)v;

        if (t.xcoord != xcoord || t.ycoord != ycoord)
        {
            this.changePosition(t);
        }

        iteratePositions(t,event.getX(), event.getY());

        return true;
    }


    // MotionEvent object holds X-Y values
    /*if(event.getAction() == MotionEvent.ACTION_DOWN)
    {
        Log.d("str",  "You click at x = " + event.getX() + " and y = " + event.getY());
    }*/
        //return true;*/


    /*public void iteratePositions(TextViewTouch t, float x, float y)
    // t xcoord is equal to x coord, same for ycoord
    {
        //int x = (xcoord*TextViewTouch.WIDTH + (int)newX)/TextViewTouch.WIDTH;
        //int y = (ycoord*TextViewTouch.HEIGHT + (int)newY)/TextViewTouch.HEIGHT;
        //if (x < 0 || y < 0){Log.d("str", "x=" + x + " y= " + y);}
        //TextViewTouch.views[TextViewTouchListener.toIndex(xcoord, ycoord)].unpress();
        //this.changePosition(TextViewTouch.views[TextViewTouchListener.toIndex(x, y)]);

        for (int i = -1; i <= 1; i++)
        {
            for (int j = -1; j <= 1; j++)
            {
                int upperX = (i+1)*TextViewTouch.HEIGHT;
                int lowerX = i*TextViewTouch.HEIGHT;
                int upperY = (j+1)*TextViewTouch.WIDTH;
                int lowerY = j*TextViewTouch.WIDTH;

                if (x < upperX
                        && x >= lowerX
                        && y < upperY
                        && y >= lowerY
                        && coordsInBounds(t.xcoord + j, t.ycoord + i)
                        && (i == 0 && j == 0))
                {
                    return;
                }

                if (x < upperX
                        && x >= lowerX
                        && y < upperY
                        && y >= lowerY
                        && coordsInBounds(t.xcoord + j, t.ycoord + i))
                {
                    Log.d("str",  "You click at x = " + x + " and y = " + x);
                    Log.d("str", "i = " + i + " and j = " + j);
                    Log.d("str", "xcoord = " + t.xcoord +" and ycoord = " + t.ycoord);
                    Log.d("str", "index = " +TextViewTouchListener.toIndex(t.xcoord + i, t.ycoord + j));
                    this.changePosition(TextViewTouch.views[TextViewTouchListener.toIndex(t.xcoord + j, t.ycoord + i)]);
                    //iteratePositions();
                }
            }
        }
    }

    public static int toIndex (int x, int y)
    {
        return x*DisplayButton.COLS + y;
    }

    public void changePosition(TextViewTouch t)
    //presses t and changes xcoord ycoord to t
    {

        if (!firstpress){TextViewTouch.views[TextViewTouchListener.toIndex(xcoord,ycoord)].unpress();}
        firstpress = false;
        xcoord = t.xcoord;
        ycoord = t.ycoord;
        t.press();
    }

    public static boolean coordsInBounds (int x, int y)
    {
        return (0 <= x && 0 <= y && x < DisplayButton.COLS && y < DisplayButton.ROWS);
    }*/

//}
