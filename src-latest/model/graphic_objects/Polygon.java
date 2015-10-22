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
        float x,y,x2,y2;
        
        int[] xList = new int[points.size()];
        int[] yList = new int[points.size()];
        
        for (int i = 0; i < points.size()-1; i++) {
         
        	 x = (float)(20+points.get(i).getX())*rowHt;
	    	 y = (float)(20-points.get(i).getY())*rowHt;
	    	  
	    	 x2 = (float)(20+points.get(i+1).getX())*rowHt;
	    	 y2 = (float)(20-points.get(i+1).getY())*rowHt;
	    	  
	    	 g.setStroke(new BasicStroke(3));
	    	 g.setColor(Color.CYAN);
             g.draw(new Line2D.Float(x, y,x2,y2));
             g.setColor(Color.BLACK);
             g.setStroke(new BasicStroke(1));
             
           points.get(i).draw(g);
        }
        
        System.out.println("DRAW");
        //connect the first point and the last point
   	 	x = (float)(20+points.get(0).getX())*rowHt;
   	 	y = (float)(20-points.get(0).getY())*rowHt;
   	  
   	 	x2 = (float)(20+points.get(points.size()-1).getX())*rowHt;
   	 	y2 = (float)(20-points.get(points.size()-1).getY())*rowHt;
   	 	points.get(points.size()-1).draw(g); //print the point of the last point
   	 	g.setStroke(new BasicStroke(3));
   	 	g.setColor(Color.CYAN);
        g.draw(new Line2D.Float(x, y,x2,y2));
        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(1));
        
    }
}
