package com.ben.utils;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ViewGroup;

/**
 * Created by ben on 22/02/18.
 */

public class DisplayUtils {

    public static int getDPFromPixels(Resources r, int px){
        int pix = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, px, r.getDisplayMetrics());
        return pix;
    }

}
