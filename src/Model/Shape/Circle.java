package Model.Shape;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import Model.Point;

public class Circle extends Shape{

	private double radius;
	
	public Circle(){
		points = new ArrayList<Point>();
		radius = 0;
	}
	
	public void setRadius(double radius){
		this.radius = radius;
	}
	public double getRadius(){
		return this.radius;
	}
	
	
	
	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		Point p1, p2;
        int rowHt = 510 / 40;
        int rowWid = 510 / 40;
        
        if(points.size() > 0){
        	   p1 = points.get(0);
            
               Ellipse2D circle = new Ellipse2D.Double();
               circle.setFrameFromCenter((20+p1.getX())*rowWid,(20-p1.getY())*rowHt, (20+p1.getX()+radius)*rowWid, (20-p1.getY()-radius)*rowHt);
               g.draw(circle);
               //g.drawLine(0, 0, 20*rowWid, 20*rowHt);
        }
	}

}
