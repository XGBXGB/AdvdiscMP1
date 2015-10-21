package model.shape;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import model.Point;

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
               
               
               Ellipse2D center = new Ellipse2D.Double();
               center.setFrameFromCenter((20+p1.getX())*rowWid,(20-p1.getY())*rowHt, 
            		   					(20+p1.getX()+0.5)*rowWid,(20-p1.getY()-0.5)*rowHt);
               g.fill(center);
               //g.drawLine(0, 0, 20*rowWid, 20*rowHt);
        }
	}

}
