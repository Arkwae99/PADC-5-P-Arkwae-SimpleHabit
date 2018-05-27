package com.padcmyanmar.simplehabit.viewpod;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import butterknife.ButterKnife;

/**
 * Created by WaiPhyoAg on 5/25/18.
 */

public class Viewpod_Me extends RelativeLayout {

    public Viewpod_Me(Context context) {
        super(context);
    }

    public Viewpod_Me(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Viewpod_Me(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this,this);
    }
}
