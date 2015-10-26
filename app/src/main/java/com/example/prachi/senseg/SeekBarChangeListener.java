package com.example.prachi.senseg;

import android.widget.SeekBar;

/**
 * Created by Prachi on 10/16/15.
 */
public class SeekBarChangeListener implements SeekBar.OnSeekBarChangeListener {

    //TODO:Changelistener not really working pls do smt

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (seekBar == DisplayButton.seek1)
        {
            Display2.intensity1 = (float)(progress/100);
            System.out.println("Intensity 1 " + Display2.intensity1 + "\n");
        }else{
            Display2.intensity2 = (float)(progress/100);
            System.out.println("Intensity 2 " + Display2.intensity1 + "\n");
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        //do nothing, required for implementation
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        //do nothing, required for implementation
    }
}
