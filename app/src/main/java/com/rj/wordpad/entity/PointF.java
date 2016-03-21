package com.rj.wordpad.entity;

/**
 * Created by Administrator on 2016/3/11.
 */
public class
        PointF {
    float x;
    float y;

    public PointF() {
    }

    public PointF(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "PointF{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
