package com.example.mojaaplikacija;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;


public class Crtac extends View {
    private final Path path;
    private Linija linija;
    private final Paint paint;
    private final List<Linija> linije;

    public Crtac(Context context) {
        super(context);
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(15);
        paint.setStyle(Paint.Style.STROKE);
        path = new Path();
        linija = new Linija();
        linije = new ArrayList<>();
    }


    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path, paint);
        for (Linija linija : linije) {
            String  a = String.valueOf(linije.size());
            Log.v("TAG", String.valueOf(linije.size()));
            canvas.drawLine(linija.startX, linija.startY, linija.endX, linija.endY, paint);

        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                linija = new Linija(); // Create a new instance of Linija
                path.moveTo(x, y);
                linija.setX(x);
                linija.setY(y);
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(x, y);
                invalidate();
                //do path drawing;
                break;
            case MotionEvent.ACTION_UP:
                linija.setXend(event.getX());
                linija.setYend(event.getY());

                if (linije.size() > 0) {
                    Linija prevLine = linije.get(linije.size() - 1);
                    float angle = calculateAngle(prevLine.getEndX(), prevLine.getEndY(), linija.getXstart(), linija.getYstart());
                    Log.v("Angle", String.valueOf(angle));
                    linija.setAngle(angle);
                }

                linije.add(linija);
                path.reset();
                break;
        }
        invalidate();
        return true;
    }

    private float calculateAngle(float x1, float y1, float x2, float y2) {
        float deltaX = x2 - x1;
        float deltaY = y2 - y1;
        return (float) Math.toDegrees(Math.atan2(deltaY, deltaX));
    }



}
