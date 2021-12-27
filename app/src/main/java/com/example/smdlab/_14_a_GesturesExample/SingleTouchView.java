package com.example.smdlab._14_a_GesturesExample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class SingleTouchView extends View {
    public Paint paint = new Paint();
    public Path path = new Path();
//    to know which gesture we are using
    GestureDetector gestureDetector;
//    we will need context of page
    Context context;

    public SingleTouchView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
//        gestureDetector initialise, whenever we will double tap listeener will be active
        gestureDetector = new GestureDetector(context, new MyGestureListener());
//        pass the context to this view
        this.context = context;

    }

//    make inner class
    private class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
    @Override
    public boolean onDoubleTap(MotionEvent e) {
        float x = e.getX();
        float y = e.getY();
//        when we double tap path should be reset
        path.reset();
        return true;
    }
}

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawPath(path, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float eventX = event.getX();
        float eventY = event.getY();
//        action is which? up, down, etc
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(eventX, eventY);
                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(eventX, eventY);
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                return false;
        }
        gestureDetector.onTouchEvent(event);
        invalidate();
        return true;
    }
}
