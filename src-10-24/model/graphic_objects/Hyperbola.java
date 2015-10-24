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

public class Hyperbola extends GraphicObject {

    private double a;
    private double b;
    private boolean horizontal;

    public Hyperbola() {
        points = new ArrayList();
        a = 0;
        b = 0;
        horizontal = false;
    }

    public void setCenter(double x, double y) {
        points.add(new Point(x, y));
        Point center = points.get(0);

        //points which are 'a' distance from the center 'vertices'
        if (horizontal) {
            points.add(new Point(center.getX() + a, center.getY()));
            points.add(new Point(center.getX() - a, center.getY()));
        } else {
            points.add(new Point(center.getX(), center.getY() + a));
            points.add(new Point(center.getX(), center.getY() - a));
        }
    }

    public boolean isHorizontal() {
        return horizontal;
    }

    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    @Override
    public void rotateShape(float angle, double val, double val2, boolean clockwise) {
        Point center = points.get(0);

        if (Math.abs(angle) == 180 || Math.abs(angle) == 90) {
            MatrixFactory matrixFactory = new MatrixFactory();
            Matrix rotator = matrixFactory.getMatrix("ROTATE");
            Matrix translator = matrixFactory.getMatrix("TRANSLATE");
            Matrix pointHolder = matrixFactory.getMatrix("POINT");
            ((RotateMatrix) rotator).makeRotator(angle, clockwise);
            for (int i = 1; i < points.size(); i++) {
                Point p = points.get(i);
                ((R3Matrix) pointHolder).setPointValues(p.getX(), p.getY());
                ((TranslateMatrix) translator).setTranslateValues(-center.getX(), -center.getY());
                pointHolder.setData(translator.times(pointHolder));
                pointHolder.setData(rotator.times(pointHolder));
                ((TranslateMatrix) translator).setTranslateValues(center.getX(), center.getY());
                pointHolder.setData(translator.times(pointHolder));

                p = ((R3Matrix) pointHolder).getPoint();
                points.set(i, p);
            }
            if (Math.abs(angle) == 90) {
                horizontal = !horizontal;
            }
        }
    }

    @Override
    public void draw(Graphics2D g) {
        System.out.println("DRAWING HYPERBOLA");
        Point center = points.get(0);
        double h = center.getX();
        double k = center.getY();

        double boundary;
        int rowHt = 510 / 40;
        int rowWid = 510 / 40;

        Graphics2D g2 = (Graphics2D) g;

        boundary = 20;
        double val1;
        double val2;
        double i;
        i = -20;
        g2.setColor(c);
        g2.setStroke(new BasicStroke(3));
        while (i < boundary) {
            if (horizontal) {
                val1 = sqrt(Math.pow(a, 2) + Math.pow(a, 2) * (Math.pow(i - k, 2) / Math.pow(b, 2))) + h;
                val2 = -sqrt(Math.pow(a, 2) + Math.pow(a, 2) * (Math.pow(i - k, 2) / Math.pow(b, 2))) + h;

                g2.draw(new Line2D.Double((20 + val1) * rowWid, (20 - i) * rowHt, (20 + val1) * rowWid, (20 - i) * rowHt));
                g2.draw(new Line2D.Double((20 + val2) * rowWid, (20 - i) * rowHt, (20 + val2) * rowWid, (20 - i) * rowHt));
            } else {
                val1 = sqrt(Math.pow(b, 2) + Math.pow(b, 2) * (Math.pow(i - h, 2) / Math.pow(a, 2))) + k;
                val2 = -sqrt(Math.pow(b, 2) + Math.pow(b, 2) * (Math.pow(i - h, 2) / Math.pow(a, 2))) + k;

                g2.draw(new Line2D.Double((20 + i) * rowWid, (20 - val1) * rowHt, (20 + i) * rowWid, (20 - val1) * rowHt));
                g2.draw(new Line2D.Double((20 + i) * rowWid, (20 - val2) * rowHt, (20 + i) * rowWid, (20 - val2) * rowHt));
            }
            i += 0.05;
        }

        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(5));
        for (int z = 0; z < points.size(); z++) {
            g2.draw(new Line2D.Double((20 + points.get(z).getX()) * rowWid, (20 - points.get(z).getY()) * rowHt, (20 + points.get(z).getX()) * rowWid, (20 - points.get(z).getY()) * rowHt));
        }
        g2.setStroke(new BasicStroke(1));
    }

    @Override
    public GraphicObject clone() {
        Hyperbola h = new Hyperbola();
        h.setColor(getColor());
        h.setA(getA());
        h.setB(getB());
        h.setPoints(getPoints());
        h.setHorizontal(isHorizontal());
        return h;
    }

}
