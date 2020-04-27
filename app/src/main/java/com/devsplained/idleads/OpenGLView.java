package com.devsplained.idleads;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

public class OpenGLView extends GLSurfaceView {

    private float previousX;
    private float previousY;

    public OpenGLView(Context context) {
        super(context);
        init();
    }

    public OpenGLView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        float x = e.getX();
        float y = e.getY();

        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                float dx = x - previousX;
                float dy = y - previousY;
                Log.println(Log.INFO, "TAG", "Touch: "+dx+"x"+dy);
                requestRender();
                break;
            default:
                break;
        }

        previousX = x;
        previousY = y;
        return super.onTouchEvent(e);
    }

    private void init() {
        setEGLContextClientVersion(2);
        setPreserveEGLContextOnPause(true);
        setRenderer(new OpenGLRenderer());
    }
}
