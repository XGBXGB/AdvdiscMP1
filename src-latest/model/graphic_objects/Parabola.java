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

    private boolean vertical;
    private double magnitude;
    private ArrayList<Point> paraPoints;

    public Parabola() {
        vertical = false;
        magnitude = 0;
        points = new ArrayList<Point>();
        paraPoints = new ArrayList<Point>();
    }

    public boolean isVertical() {
        return vertical;
    }

    public void setVertical(boolean vertical) {
        this.vertical = vertical;
        initialize();
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
        initialize();
    }

    public void initialize() {
        paraPoints.clear();
        Point center = points.get(0);
        double h = center.getX(); //center X
        double k = center.getY(); // center Y
        //double a = 0.5; // magnitude!
        double boundary;

        boundary = 20;

        double val1, val2, i;

        i = -20;
        while (i < boundary) {
            if (vertical) {
                val1 = sqrt((i - k) / magnitude) + h;
                val2 = -sqrt((i - k) / magnitude) + h;
                paraPoints.add(new Point(val1, i));
                paraPoints.add(new Point(val2, i));
            } else {
                val1 = sqrt((i - h) / magnitude) + k;
                val2 = -sqrt((i - h) / magnitude) + k;
                paraPoints.add(new Point(i, val1));
                paraPoints.add(new Point(i, val2));
            }
            i += 0.1;
        }
    }

    @Override
    public void draw(Graphics2D g) {
        System.out.println("PARABOLA");
        int rowHt = 510 / 40;
        int rowWid = 510 / 40;
        //double a = 0.5; // magnitude!

        g.setStroke(new BasicStroke(3));
        for (int i = 0; i < paraPoints.size(); i++) {
            Point p = paraPoints.get(i);
            g.draw(new Line2D.Double((20 + p.getX()) * rowWid, (20 - p.getY()) * rowHt, (20 + p.getX()) * rowWid, (20 - p.getY()) * rowHt));
        }
        g.setStroke(new BasicStroke(1));
    }

    public void rotateShape(float angle, boolean clockwise) {
        System.out.println("INA ANG ROTATE");
        initialize();
        Point center = points.get(0);
        MatrixFactory matrixFactory = new MatrixFactory();
        Matrix rotator = matrixFactory.getMatrix("ROTATE");
        Matrix translator = matrixFactory.getMatrix("TRANSLATE");
        Matrix pointHolder = matrixFactory.getMatrix("POINT");
        ((RotateMatrix) rotator).makeRotator(angle, clockwise);
        for (int i = 0; i < paraPoints.size(); i++) {
            Point p = paraPoints.get(i);

            ((R3Matrix) pointHolder).setPointValues(p.getX(), p.getY());
            ((TranslateMatrix) translator).setTranslateValues(-center.getX(), -center.getY());
            pointHolder.setData(translator.times(pointHolder));

            pointHolder.setData(rotator.times(pointHolder));

            ((TranslateMatrix) translator).setTranslateValues(center.getX(), center.getY());
            pointHolder.setData(translator.times(pointHolder));
            paraPoints.set(i, ((R3Matrix) pointHolder).getPoint());

        }
        extendParabola();
    }

    public void extendParabola() {
        Point val1 = paraPoints.get(paraPoints.size() - 1), val2 = paraPoints.get(paraPoints.size() - 2);
        Point val12 = paraPoints.get(paraPoints.size() - 3);
        Point val22 = paraPoints.get(paraPoints.size() - 4);
        
        if (val1.getX() > -20 && val1.getX() < 20 && val1.getY() > -20 && val1.getY() < 20) {
            Point p1 = val1;
            Point p2 = val2;
            double distance1x = val1.getX() - val12.getX();
            double distance1y = val1.getY() - val12.getY();
            double distance2x = val2.getX() - val22.getX();
            double distance2y = val2.getY() - val22.getY();
            
            while(p1.getX() > -20 && p1.getX() < 20 && p1.getY() > -20 && p1.getY() < 20){
                Point p1extend = new Point(p1.getX()+distance1x, p1.getY()+distance1y);
                paraPoints.add(p1extend);
                p1 = p1extend;
            }
            
            while(p2.getX() > -20 && p2.getX() < 20 && p2.getY() > -20 && p2.getY() < 20){
                Point p2extend = new Point(p2.getX()+distance2x, p2.getY()+distance2y);
                paraPoints.add(p2extend);
                p2 = p2extend;
            }

        }

    }

}
