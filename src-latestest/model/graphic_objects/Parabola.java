/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.graphic_objects;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.QuadCurve2D;
import static java.lang.Math.sqrt;
import java.util.ArrayList;
import model.Point;
import model.matrix.Matrix;
import model.matrix.MatrixFactory;
import model.matrix.R3Matrix;
import model.matrix.RotateMatrix;
import model.matrix.TranslateMatrix;

/**
 *
 * @author Christian Gabriel
 */
public class Parabola extends GraphicObject {
    private Point center;
    private boolean vertical;
    private double magnitude;

    public Parabola() {
        vertical = false;
        magnitude = 0;
        points = new ArrayList<Point>();
        originalPoints = new ArrayList();
        center=null;
    }

    public boolean isVertical() {
        return vertical;
    }

    public void setVertical(boolean vertical) {
        this.vertical = vertical;
        revertToOriginal();
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
        revertToOriginal();
    }
    
    @Override
    public void addPoint(double x, double y) {
        points.add(new Point(x,y));
        center = points.get(0);
        double h = center.getX(); //center X
        double k = center.getY(); // center Y
        double boundary;

        boundary = 20;

        double val1, val2, i;

        i = -20;
        while (i < boundary) {
            if (vertical) {
                val1 = sqrt((i - k) / magnitude) + h;
                val2 = -sqrt((i - k) / magnitude) + h;
                originalPoints.add(new Point(val1, i));
                originalPoints.add(new Point(val2, i));
                points.add(new Point(val1, i));
                points.add(new Point(val2, i));
            } else {
                val1 = sqrt((i - h) / magnitude) + k;
                val2 = -sqrt((i - h) / magnitude) + k;
                originalPoints.add(new Point(i, val1));
                originalPoints.add(new Point(i, val2));
                points.add(new Point(i, val1));
                points.add(new Point(i, val2));
            }
            i += 0.1;
        }
    }

    @Override
    public void draw(Graphics2D g) {
        int rowHt = 510 / 40;
        int rowWid = 510 / 40;
        g.setStroke(new BasicStroke(3));
        for (int i = 0; i < points.size(); i++) {
            Point p = points.get(i);
            g.draw(new Line2D.Double((20 + p.getX()) * rowWid, (20 - p.getY()) * rowHt, (20 + p.getX()) * rowWid, (20 - p.getY()) * rowHt));
        }
        g.setStroke(new BasicStroke(1));
    }

    @Override
    public void rotateShape(float angle, double val, double val2, boolean clockwise) {
        revertToOriginal();
        MatrixFactory matrixFactory = new MatrixFactory();
        Matrix rotator = matrixFactory.getMatrix("ROTATE");
        Matrix translator = matrixFactory.getMatrix("TRANSLATE");
        Matrix pointHolder = matrixFactory.getMatrix("POINT");
        ((RotateMatrix) rotator).makeRotator(angle, clockwise);
        for (int i = 0; i < points.size(); i++) {
            Point p = points.get(i);

            ((R3Matrix) pointHolder).setPointValues(p.getX(), p.getY());
            ((TranslateMatrix) translator).setTranslateValues(-center.getX(), -center.getY());
            pointHolder.setData(translator.times(pointHolder));

            pointHolder.setData(rotator.times(pointHolder));

            ((TranslateMatrix) translator).setTranslateValues(center.getX(), center.getY());
            pointHolder.setData(translator.times(pointHolder));
            points.set(i, ((R3Matrix) pointHolder).getPoint());

        }
        extendParabola();
    }

    public void extendParabola() {
        Point val1 = points.get(points.size() - 1), val2 = points.get(points.size() - 2);
        Point val12 = points.get(points.size() - 3);
        Point val22 = points.get(points.size() - 4);
        
        if (val1.getX() > -20 && val1.getX() < 20 && val1.getY() > -20 && val1.getY() < 20) {
            Point p1 = val1;
            Point p2 = val2;
            double distance1x = val1.getX() - val12.getX();
            double distance1y = val1.getY() - val12.getY();
            double distance2x = val2.getX() - val22.getX();
            double distance2y = val2.getY() - val22.getY();
            
            while(p1.getX() > -20 && p1.getX() < 20 && p1.getY() > -20 && p1.getY() < 20){
                Point p1extend = new Point(p1.getX()+distance1x, p1.getY()+distance1y);
                points.add(p1extend);
                p1 = p1extend;
            }
            
            while(p2.getX() > -20 && p2.getX() < 20 && p2.getY() > -20 && p2.getY() < 20){
                Point p2extend = new Point(p2.getX()+distance2x, p2.getY()+distance2y);
                points.add(p2extend);
                p2 = p2extend;
            }

        }

    }

}
