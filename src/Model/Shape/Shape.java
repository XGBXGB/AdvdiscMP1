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
import model.matrix.Matrix;
import model.matrix.MatrixFactory;
import model.matrix.R3Matrix;
import model.matrix.RotateMatrix;
import model.matrix.TranslateMatrix;

/**
 *
 * @author Christian Gabriel
 */
public abstract class Shape {
    protected ArrayList<Point> points;
    
    public void addPoint(double x, double y) {
        points.add(new Point(x,y));
    }
    
    public Iterator<Point> getPoints() {
        return points.iterator();
    }

    public void setPoints(Iterator<Point> points) {
        this.points.clear();
        while (points.hasNext()) {
            this.points.add(points.next());
        }
    }
    
    public abstract void draw(Graphics g);
    
    public void rotateShape(float angle, double centerX, double centerY, boolean clockwise) {
        Point center = new Point(centerX, centerY);
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
