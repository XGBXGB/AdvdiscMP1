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
import java.lang.reflect.Array;
import java.util.ArrayList;

import model.Point;

/**
 *
 * @author Christian Gabriel
 */
public class Polygon extends GraphicObject {

    public Polygon() {
        points = new ArrayList<Point>();
    }

    @Override
    public void draw(Graphics2D g) {
        Point p1, p2;
        int rowHt = 510 / 40;
        int rowWid = 510 / 40;
        
        int[] xList = new int[points.size()];
        int[] yList = new int[points.size()];
        
        for (int i = 0; i < points.size() ; i++) {
           xList[i] = (int) (20+points.get(i).getX())*rowWid ;
           yList[i] = (int) (20-points.get(i).getY())*rowHt;
           points.get(i).draw(g);
        }
        
        g.setStroke(new BasicStroke(3));
        g.setColor(Color.CYAN);
        
        g.drawPolygon(xList, yList, xList.length);
        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(1));
        
    }
}
