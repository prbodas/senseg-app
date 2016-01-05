package com.example.prachi.senseg;
import com.senseg.haptics.Grain;
import com.senseg.haptics.HapticSettings;
import android.util.*;
import android.support.v4.view.*;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MotionEvent;
import android.view.*;

//import java.util.Timer;

public class Display1 extends ActionBarActivity {

    float currentX = 0; //represents the x coordinate of the touch
    float currentY = 0; //y coordinate of touch

    public static String grain1type = Grain.GRAIN_AREA_SMOOTH; //grain of "black squares"
    public static float intensity1 = 1.0f;

    public static String grain2type = Grain.GRAIN_AREA_SMOOTH; //grain of "white square"
    public static float intensity2 = 0.2f;

    Grain grain = null; //used to set current grain in code

    //Timer timer; //timer to calculate position based on velocity


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display1);
        //timer = new Timer();
    }

    private static final String DEBUG_TAG = "Velocity";
    private VelocityTracker mVelocityTracker = null;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int index = event.getActionIndex();
        int action = event.getActionMasked();
        int pointerId = event.getPointerId(index);

        //current X and current Y of touch
        currentX = event.getX();
        currentY = event.getY();

        //DEBUG
        Log.d("X position", ""+currentX);
        Log.d("Y position", ""+currentY);

        switch(action) {
            case MotionEvent.ACTION_DOWN:
                if(mVelocityTracker == null) {
                    // Retrieve a new VelocityTracker object to watch the velocity of a motion.
                    mVelocityTracker = VelocityTracker.obtain();
                }
                else {
                    // Reset the velocity tracker back to its initial state.
                    mVelocityTracker.clear();
                }
                // Add a user's movement to the tracker.
                mVelocityTracker.addMovement(event);
                break;
            case MotionEvent.ACTION_MOVE:
                mVelocityTracker.addMovement(event);
                // When you want to determine the velocity, call
                // computeCurrentVelocity(). Then call getXVelocity()
                // and getYVelocity() to retrieve the velocity for each pointer ID.
                mVelocityTracker.computeCurrentVelocity(1000);
                // Log velocity of pixels per second
                // Best practice to use VelocityTrackerCompat where possible.
                float xVelocity = VelocityTrackerCompat.getXVelocity(mVelocityTracker,
                        pointerId);
                float yVelocity = VelocityTrackerCompat.getYVelocity(mVelocityTracker,
                        pointerId);
                Log.d("", "X velocity: " +
                        VelocityTrackerCompat.getXVelocity(mVelocityTracker,
                                pointerId));
                Log.d("", "Y velocity: " +
                        VelocityTrackerCompat.getYVelocity(mVelocityTracker,
                                pointerId));

                if (xVelocity < 0 && yVelocity > 0) //going toward bottom left
                {
                    grain = null;
                    grain = new Grain(grain1type);
                    grain.play(intensity1);
                    Log.d("Direction:", "Bottom left");
                    //TODO: abstract gradient intensity based on position
                }else if (xVelocity > 0 && yVelocity < 0)
                {
                    grain = null;
                    grain = new Grain(grain2type);
                    grain.play(intensity2);
                    Log.d("Direction:", "Top right");
                    //TODO: abstract gradient intensity based on position
                }else{
                    grain = null;
                    grain = new Grain(grain1type);
                    grain.play((intensity1 + intensity2)/2);
                }



                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                // Return a VelocityTracker object back to be re-used by others.
                //mVelocityTracker.recycle();
                mVelocityTracker = null;
                break;
        }
        return true;
    }

}
