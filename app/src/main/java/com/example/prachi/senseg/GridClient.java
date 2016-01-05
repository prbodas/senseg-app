package com.example.prachi.senseg;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.GridLayout;

import com.senseg.haptics.Grain;

/**
 * Created by prachibodas on 1/4/16.
 */
public class GridClient extends ActionBarActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] grains = new String[2];
        grains[0] = Grain.GRAIN_AREA_BUMPY;
        grains[1] = Grain.GRAIN_AREA_EVEN;

        float[] intensities = new float[2];
        intensities[0] = 1.0f;
        intensities[1] = 0.5f;

        int[][] pattern = new int[10][10];

        boolean zeroGrain = false;
        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < 10; j++)
            {
                if (zeroGrain)
                {
                    pattern[i][j] = 0;
                }else{
                    pattern[i][j] = 1;
                }
                zeroGrain = !zeroGrain;
            }
        }


        HapticGrid grid = new HapticGrid(this, grains, intensities, pattern, 150, 150);

        setContentView(grid.getLayout());
    }

}
