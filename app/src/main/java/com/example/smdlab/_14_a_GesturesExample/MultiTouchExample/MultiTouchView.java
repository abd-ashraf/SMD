package com.example.smdlab._14_a_GesturesExample.MultiTouchExample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class MultiTouchView extends View {
    public static final int SIZE = 70;
    public SparseArray<PointF> myActivePointer;
    public Paint paint, myPaint;
    public int[] color = {Color.GRAY, Color.GREEN, Color.RED, Color.MAGENTA, Color.DKGRAY};


    public MultiTouchView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        myPointers();
    }

    public void myPointers() {
        myActivePointer = new SparseArray<PointF>();
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
//        myPaint.setColor(Color.BLUE);
//        myPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setTextSize(30);
    }

//    for single touch we do getAction
//    for double touch we dont do getAction, we do getActionMask
//    this function will detect event
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int pointIndex = event.getActionIndex();
        int pointId = event.getPointerId(pointIndex);
        int actionMasked = event.getActionMasked();

        switch (actionMasked) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_POINTER_DOWN:
                PointF f = new PointF();
                f.x = event.getX(pointIndex);
                f.y = event.getY(pointIndex);
                myActivePointer.put(pointId, f);
                break;
            case MotionEvent.ACTION_MOVE:
                for (int size=event.getPointerCount(), i=0; i < size; i++) {
                    PointF point = myActivePointer.get(event.getPointerId(i));
                    if (point != null) {
                        point.x = event.getX();
                        point.y = event.getY();
                    }
                }
                break;
            case MotionEvent.ACTION_CANCEL:
                myActivePointer.remove(pointId);
                break;
            default:
                return false;
        }
        invalidate();
        return true;
    }

//    this function will draw
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int size=myActivePointer.size(), i=0; i < size; i++) {
            PointF point = myActivePointer.valueAt(i);
            if (point != null) {
                paint.setColor(color[i]);
            }
            canvas.drawCircle(point.x, point.y, SIZE, paint);
        }
    }
}
