package com.example.prachi.senseg;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;
import android.view.MotionEvent;
import com.senseg.haptics.Grain;

import static com.example.prachi.senseg.DisplayButton.*;


/**
 * Created by Prachi on 10/16/15.
 */
public class TextViewTouch extends TextView {
    public float intensity;
    public boolean pressed = false;
    public String grainName;
    public Grain grain;

    //public static TextViewTouchListener listener = new TextViewTouchListener();

    public TextViewTouch(Context context, String grainstring, float freq, int width, int height){
        super(context);

        this.setWidth(width);
        this.setHeight(height);

        intensity = freq;
        grainName = grainstring;
        grain = new Grain(grainName);

        setBackgroundResource(R.drawable.blue);

        //this.setOnTouchListener(listener);

    }


    public boolean onTouchEvent(MotionEvent event)
    {
        //create clip to drag around
        String[] mimeTypes = new String[1];
        mimeTypes[0] = ClipDescription.MIMETYPE_TEXT_PLAIN;

        ClipData newclip = new ClipData("DRAGGING", mimeTypes, new ClipData.Item("DRAGGING"));

        View.DragShadowBuilder blankShadow = new View.DragShadowBuilder();

        startDrag(newclip, blankShadow, null, 0);

        return true;
    }

    public boolean onDragEvent(DragEvent event)
    {
        if (event.getAction() == DragEvent.ACTION_DRAG_STARTED)
        {
            //sent to all views to register them for listening
        }else if (event.getAction() == DragEvent.ACTION_DRAG_ENDED)
        {
            unpress();
        }else if (event.getAction() == DragEvent.ACTION_DRAG_ENTERED)
        {
            press();
        }else if (event.getAction() == DragEvent.ACTION_DRAG_EXITED)
        {
            unpress();
        }
        return true;
    }

    public void press()
    {
        pressed = true;
        grain.play(intensity);
        setBackgroundResource(0);
        Log.d("str", ""+ intensity);
    }

    public void unpress()
    {
        pressed = false;
        grain = null; //hopefully the effect will stop at this point
        setBackgroundResource(R.drawable.blue);
        grain = new Grain(grainName);
    }
}
