/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.shape;

import model.Point;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Iterator;
import model.matrix.Matrix;
import model.matrix.MatrixFactory;
import model.matrix.R3Matrix;
import model.matrix.RotateMatrix;
import model.matrix.TranslateMatrix;

/**
 *
 * @author Christian Gabriel
 */
public class Polygon extends Shape {

    private ArrayList<Point> points;

    public Polygon() {
        points = new ArrayList();
    }

    public void addPoint(Point p) {
        points.add(p);
    }

    @Override
    public Iterator<Point> getPoints() {
        return points.iterator();
    }

    @Override
    public void setPoints(Iterator<Point> points) {
        this.points.clear();
        while (points.hasNext()) {
            this.points.add(points.next());
        }
    }

    @Override
    public void draw(Graphics g) {
        Point p1, p2;
        int rowHt = 500 / 20;
        for (int i = 0; i < 4; i++) {
            p1 = points.get(i);
            if (i + 1 == 4) {
                p2 = points.get(0);
            } else {
                p2 = points.get(i + 1);
            }
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(2));
            g2.setColor(Color.red);
            g2.draw(new Line2D.Double((p1.getX() + 10) * rowHt, (10 - p1.getY()) * rowHt, (p2.getX() + 10) * rowHt, (10 - p2.getY()) * rowHt));
            g2.setStroke(new BasicStroke(1));
            System.out.println("Point " + i + 1 + ": (" + p1.getX() + "," + p1.getY() + "  Point 2: (" + p2.getX() + "," + p2.getY() + ")");
        }
    }

    @Override
    public void rotateShape(float angle, Point center, boolean clockwise) {
        MatrixFactory matrixFactory = new MatrixFactory();
        Matrix rotator = matrixFactory.getMatrix("ROTATE");
        Matrix translator = matrixFactory.getMatrix("TRANSLATE");
        Matrix pointHolder = matrixFactory.getMatrix("POINT");
        ((RotateMatrix) rotator).makeRotator(angle, clockwise);

        for (int i = 0; i < points.size(); i++) {
            Point p = points.get(i);

            //Convert point to matrix
            ((R3Matrix) pointHolder).setPointValues(p.getX(), p.getY());//insert point values to matrix

            //translate point near origin
            ((TranslateMatrix) translator).setTranslateValues(-center.getX(), -center.getY());
            pointHolder.setData(translator.times(pointHolder));

            pointHolder.setData(rotator.times(pointHolder));//multiplies the 3x1 matrix to the rotator matrix

            //because we rotated based on (0,0), we bring it back to its original position by translating
            ((TranslateMatrix) translator).setTranslateValues(center.getX(), center.getY());
            pointHolder.setData(translator.times(pointHolder));

            points.set(i, ((R3Matrix) pointHolder).getPoint());
        }
    }
    
    public void translateShape(double x, double y){
        MatrixFactory matrixFactory = new MatrixFactory();
        Matrix translator = matrixFactory.getMatrix("TRANSLATE");
        Matrix pointHolder = matrixFactory.getMatrix("POINT");
        ((TranslateMatrix)translator).setTranslateValues(x, y);
        
        for(int i=0; i<points.size(); i++){
            Point p = points.get(i);
            ((R3Matrix)pointHolder).setPointValues(p.getX(), p.getY());
            pointHolder.setData(translator.times(pointHolder));
            points.set(i, ((R3Matrix) pointHolder).getPoint());
        }
    }

}
