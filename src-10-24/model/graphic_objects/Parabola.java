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

    public Parabola() {
        vertical = false;
        magnitude = 0;
        points = new ArrayList();
    }

    public boolean isVertical() {
        return vertical;
    }

    public void setVertical(boolean vertical) {
        this.vertical = vertical;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    public Point getCenter() {
        return points.get(0);
    }

    public void setCenter(Point c) {
        Point focus;
        if (vertical) {
            focus = new Point(c.getX(), c.getY() + (1 / magnitude) / 4);
        } else {
            focus = new Point(c.getX() + (1 / magnitude) / 4, c.getY());
        }
        points.add(c);
        points.add(focus);
    }

    @Override
    public void draw(Graphics2D g) {
        int rowHt = 510 / 40;
        int rowWid = 510 / 40;
        
        double h = points.get(0).getX();
        double k = points.get(0).getY();
        double boundary = 20;
        double val1, val2, i;

        g.setColor(c);
        g.setStroke(new BasicStroke(3));

        i = -20;
        if(vertical)
            magnitude = (points.get(1).getY()-points.get(0).getY())*4*Math.pow(magnitude, 2);
        else
            magnitude = (points.get(1).getX()-points.get(0).getX())*4*Math.pow(magnitude, 2);
        while (i < boundary) {
            if (vertical) {
                System.out.println("FUCKINGTUDE: "+magnitude);
                val1 = sqrt((i - k) / magnitude) + h;
                val2 = -sqrt((i - k) / magnitude) + h;
                g.draw(new Line2D.Double((20 + val1) * rowWid, (20 - i) * rowHt, (20 + val1) * rowWid, (20 - i) * rowHt));
                g.draw(new Line2D.Double((20 + val2) * rowWid, (20 - i) * rowHt, (20 + val2) * rowWid, (20 - i) * rowHt));

            } else {
                val1 = sqrt((i - h) / magnitude) + k;
                val2 = -sqrt((i - h) / magnitude) + k;
                g.draw(new Line2D.Double((20 + i) * rowWid, (20 - val1) * rowHt, (20 + i) * rowWid, (20 - val1) * rowHt));
                g.draw(new Line2D.Double((20 + i) * rowWid, (20 - val2) * rowHt, (20 + i) * rowWid, (20 - val2) * rowHt));

            }
            if ((i + 0.1 < boundary)) {
            }
            i += 0.1;
        }

        //extendParabola(pVal1, pVal2, extender1, extender2, g);
        g.setStroke(new BasicStroke(1));
        g.setColor(Color.BLACK);
    }
    

    @Override
    public void rotateShape(float angle, double val, double val2, boolean clockwise) {
        Point center = points.get(0);
        Point focus = points.get(1);
        if (Math.abs(angle) == 180 || Math.abs(angle) == 90) {
            MatrixFactory matrixFactory = new MatrixFactory();
            Matrix rotator = matrixFactory.getMatrix("ROTATE");
            Matrix translator = matrixFactory.getMatrix("TRANSLATE");
            Matrix pointHolder = matrixFactory.getMatrix("POINT");
            ((RotateMatrix) rotator).makeRotator(angle, clockwise);
            ((R3Matrix) pointHolder).setPointValues(focus.getX(), focus.getY());
            ((TranslateMatrix) translator).setTranslateValues(-center.getX(), -center.getY());
            pointHolder.setData(translator.times(pointHolder));
            pointHolder.setData(rotator.times(pointHolder));
            ((TranslateMatrix) translator).setTranslateValues(center.getX(), center.getY());
            pointHolder.setData(translator.times(pointHolder));
            
            focus = ((R3Matrix) pointHolder).getPoint();
            points.set(1, focus);
            if(angle==90 || angle==-90){
                if(vertical){
                    if(angle==-90){
                        magnitude = -magnitude;
                    }
                    vertical = !vertical;
                }else{
                    if(angle==90){
                        magnitude = -magnitude;
                    }
                    vertical = !vertical;
                }
            }
            if(Math.abs(angle) == 180){
                magnitude = -magnitude;
            }
        }
    }

//    public void extendParabola(Point val1, Point val2, Point val12, Point val22, Graphics2D g) {
//        System.out.println("POINTSSSSSSSSS");
//        System.out.println("val1 x:" + val1.getX() + " y:" + val1.getY());
//        System.out.println("extender1 x:" + val12.getX() + " y:" + val12.getY());
//        System.out.println("val2 x:" + val2.getX() + " y:" + val2.getY());
//        System.out.println("extender2 x:" + val22.getX() + " y:" + val22.getY());
//
//        int rowHt = 510 / 40;
//        int rowWid = 510 / 40;
//
//        if (val1.getX() > -20 && val1.getX() < 20 && val1.getY() > -20 && val1.getY() < 20) {
//            Point p1 = val1;
//            Point p2 = val2;
//            double distance1x = val1.getX() - val12.getX();
//            double distance1y = val1.getY() - val12.getY();
//            double distance2x = val2.getX() - val22.getX();
//            double distance2y = val2.getY() - val22.getY();
//
//            while (p1.getX() > -20 && p1.getX() < 20 && p1.getY() > -20 && p1.getY() < 20) {
//                g.draw(new Line2D.Double((p1.getX() + distance1x + 20) * rowWid, (20 - p1.getY() - distance1y) * rowHt, (p1.getX() + distance1x + 20) * rowWid, (20 - p1.getY() - distance1y) * rowHt));
//                Point p1extend = new Point(p1.getX() + distance1x, p1.getY() + distance1y);
//                //points.add(p1extend);
//                p1 = p1extend;
//                System.out.println("WHILE EX1 X:" + p1.getX() + " Y:" + p1.getY());
//                System.out.println("DX: " + distance1x + " D2X:" + distance2x);
//            }
//
//            while (p2.getX() > -20 && p2.getX() < 20 && p2.getY() > -20 && p2.getY() < 20) {
//                g.draw(new Line2D.Double((p2.getX() + distance2x + 20) * rowWid, (20 - p2.getY() - distance2y) * rowHt, (p2.getX() + distance2x + 20) * rowWid, (20 - p2.getY() - distance2y) * rowHt));
//                Point p2extend = new Point(p2.getX() + distance2x, p2.getY() + distance2y);
//                p2 = p2extend;
//            }
//        }
//    }

    @Override
    public GraphicObject clone() {
        Parabola p = new Parabola();
        p.setColor(getColor());
        p.setMagnitude(getMagnitude());
        p.setVertical(isVertical());
        p.setCenter(getCenter());
        return p;
    }

}
