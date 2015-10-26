package com.example.prachi.senseg;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.*;

/**
 * Created by Prachi on 10/16/15.
 */
public class DisplayButton extends ActionBarActivity{

    public static NumberPicker num1;
    public static NumberPicker num2;
    public static SeekBar seek1;
    public static SeekBar seek2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        num1 = new NumberPicker(this);
        num2 = new NumberPicker(this);

        SeekBarChangeListener listener1 = new SeekBarChangeListener();

        seek1 = new SeekBar(this);
        seek2 = new SeekBar(this);

        seek1.setOnSeekBarChangeListener(listener1);
        seek2.setOnSeekBarChangeListener(listener1);

        RelativeLayout rel = new RelativeLayout(this);
        rel.addView(num1);
        rel.addView(seek1);
        rel.addView(num2);
        rel.addView(seek2);
        //TODO:delete activity_display2
        setContentView(rel);
    }

}
