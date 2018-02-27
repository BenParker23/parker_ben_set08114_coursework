package com.ben.display;

import android.content.res.Resources;
import android.util.TypedValue;

/**
 * Created by ben on 22/02/18.
 */

public class DisplayUtils {

    public static int getDPFromPixels(Resources r, int px){
        int pix = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, px, r.getDisplayMetrics());
        return pix;
    }
}
