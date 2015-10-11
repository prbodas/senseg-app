package com.example.prachi.senseg;
import com.senseg.haptics.Grain;
import com.senseg.haptics.HapticSettings;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MotionEvent;

public class Display1 extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display1);

    }

    public boolean onTouchEvent(MotionEvent event){
        switch(event.getAction()){
            case MotionEvent.ACTION_MOVE:
                Grain grain = new Grain(Grain.GRAIN_AREA_BUMPY);
                grain.play(1.0f);
                break;
            default:
                return false;
        }
        return true;
    }

}
