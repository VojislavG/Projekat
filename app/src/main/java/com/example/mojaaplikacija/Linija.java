package com.example.mojaaplikacija;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Linija {
    public float startX;
    public float startY;
    public float endX;
    public float endY;
    public int color;
    public float angle;
    public float newEndX;
    public float newEndY;


    public Linija(){}

    public Linija(float startX, float startY, float endX, float endY, int color, float angle) {
        this.color = Color.RED;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.angle = angle;
    }

    public Linija(float startX, float startY, float endX, float endY, int color) {
        this.color = Color.RED;
        this.startY = startY;
        this.startX = startX;
        this.endX = endX;
        this.endY = endY;


    }

    public float getXstart() {
        return startX;
    }

    public void setX(float x) {
        this.startX = x;
    }

    public float getYstart() {
        return startY;
    }

    public void setY(float y) {
        this.startY = y;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public float getEndX() {
        return endX;
    }

    public void setXend(float x) {
        this.endX = x;
    }

    public float getEndY() {
        return endY;
    }

    public void setYend(float y) {
        this.endY = y;
    }
    public float getNewEndX(){
        return newEndX;
    }

    public float getNewEndY(){
        return newEndY;
    }


    public void drawLine(Canvas canvas, float startX, float startY, float endX, float endY) {
        Paint paint = new Paint();
        paint.setColor(color);
        paint.setStrokeWidth(3.0f);
        float length = (float) Math.sqrt(Math.pow((Math.abs(startX) - Math.abs(endX)), 2) + Math.pow((Math.abs(endY) - Math.abs(startY)), 2));
        float newEndX = startX + length * (float) Math.cos(Math.toRadians(angle));
        float newEndY = startY + length * (float) Math.sin(Math.toRadians(angle));

        canvas.drawLine(startX, startY, newEndX, newEndY, paint);


    }
    public void drawLine(Canvas canvas, float startX, float startY, float endX, float endY, float angle) {
        Paint paint = new Paint();
        paint.setColor(color);
        paint.setStrokeWidth(3.0f);

        float length = (float) Math.sqrt(Math.pow((Math.abs(startX) - Math.abs(endX)), 2) + Math.pow((Math.abs(endY) - Math.abs(startY)), 2));
        float newEndX = startX + length * (float) Math.cos(Math.toRadians(angle));
        float newEndY = startY + length * (float) Math.sin(Math.toRadians(angle));

        canvas.drawLine(startX, startY, newEndX, newEndY, paint);
    }


}