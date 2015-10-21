package model.shape;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import model.Point;

public class Ellipse extends Shape{
	
private double horizontalDistance;
private double verticalDistance;
	
	public Ellipse(){
		points = new ArrayList<Point>();
		horizontalDistance = 0;
		verticalDistance = 0;
	}
	
	public void setHorizontalDistance(double hd)
	{
		horizontalDistance = hd;
	}
	
	public double getHorizontalDistance()
	{
		return horizontalDistance;
	}
	
	public void setVerticalDistance(double vd)
	{
		verticalDistance = vd;
	}
	
	public double getVerticalDistance()
	{
		return verticalDistance;
	}
	
	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		Point p1, p2;
        int rowHt = 510 / 40;
        int rowWid = 510 / 40;
        
        if(points.size() > 0){
        	   p1 = points.get(0);
            
               Ellipse2D ellipse = new Ellipse2D.Double();
               ellipse.setFrameFromCenter((20+p1.getX())*rowWid,(20-p1.getY())*rowHt, (20+p1.getX()+horizontalDistance)*rowWid, (20-p1.getY()-verticalDistance)*rowHt);
               //ellipse.setFrame(p1.getX(), p1.getY(), horizontalDistance*100, verticalDistance*100);
               g.draw(ellipse);
               
               Ellipse2D center = new Ellipse2D.Double();
               center.setFrameFromCenter((20+p1.getX())*rowWid,(20-p1.getY())*rowHt, 
            		   					(20+p1.getX()+0.5)*rowWid,(20-p1.getY()-0.5)*rowHt);
               g.fill(center);
               //g.drawLine(0, 0, 20*rowWid, 20*rowHt);
        }
	}

}
