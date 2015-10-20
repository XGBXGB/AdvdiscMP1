/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Shape;

import Model.Point;
import Model.Matrix.Matrix;
import Model.Matrix.MatrixFactory;
import Model.Matrix.R3Matrix;
import Model.Matrix.RotateMatrix;
import Model.Matrix.TranslateMatrix;

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
public class Polygon extends Shape {

    public Polygon() {
        points = new ArrayList();
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
            System.out.println("Point " + i + 1 + ": (" + p1.getX() + "," + p1.getY() + ")  Point 2: (" + p2.getX() + "," + p2.getY() + ")");
        }
    }
}
