/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Shape;

import Model.Point;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Christian Gabriel
 */
public class Quadrilateral extends Shape {

    private ArrayList<Point> points;

    public Quadrilateral(Point p1, Point p2, Point p3, Point p4) {
        points = new ArrayList();
        points.add(p1);
        points.add(p2);
        points.add(p3);
        points.add(p4);
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
        int rowHt = 500/20;
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
            g2.draw(new Line2D.Double((p1.getX()+10) * rowHt, (10-p1.getY()) * rowHt, (p2.getX()+10) * rowHt, (10-p2.getY()) * rowHt));
            g2.setStroke(new BasicStroke(1));
            System.out.println("Point "+i+1+": ("+p1.getX()+","+p1.getY()+"  Point 2: ("+p2.getX()+","+p2.getY()+")");
        }
    }

}
