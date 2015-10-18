/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.shape;

import model.Point;
import model.Point;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Christian Gabriel
 */
public abstract class Shape {
    public abstract Iterator<Point> getPoints();
    public abstract void setPoints(Iterator<Point> points);
    public abstract void draw(Graphics g);
    public abstract void rotateShape(float angle, double centerX, double centerY, boolean clockwise);
    public abstract void translateShape(double x, double y);
}
