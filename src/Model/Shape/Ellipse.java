package model.shape;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import model.Point;

public class Ellipse extends Shape{
	
private Point distances;
	
	public Ellipse(){
		points = new ArrayList<Point>();
		distances = null;
	}
	
	public void setDistances(double horizontalDistance, double verticalDistance)
	{
		distances = new Point(horizontalDistance, verticalDistance);
	}
	
	public void setHorizontalDistance(double hd)
	{
		distances.setX(hd);
	}
	
	public double getHorizontalDistance()
	{
		return distances.getX();
	}
	
	public void setVerticalDistance(double vd)
	{
		distances.setY(vd);
	}
	
	public double getVerticalDistance()
	{
		return distances.getY();
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
               ellipse.setFrameFromCenter((20+p1.getX())*rowWid,(20-p1.getY())*rowHt, (20+p1.getX()+distances.getX())*rowWid, (20-p1.getY()-distances.getY())*rowHt);
               g.draw(ellipse);
               
               Ellipse2D center = new Ellipse2D.Double();
               center.setFrameFromCenter((20+p1.getX())*rowWid,(20-p1.getY())*rowHt, 
            		   					(20+p1.getX()+0.5)*rowWid,(20-p1.getY()-0.5)*rowHt);
               g.fill(center);
               //g.drawLine(0, 0, 20*rowWid, 20*rowHt);
        }
	}

}
