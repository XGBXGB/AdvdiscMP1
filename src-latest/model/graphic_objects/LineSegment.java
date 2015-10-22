package model.graphic_objects;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import model.Point;

public class LineSegment extends GraphicObject {

	public LineSegment(){
		points = new ArrayList<Point>();
	}
	
	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		  int rowHt = 510 / 40;
	      int rowWid = 510 / 40;
	      float x, y, x2,y2;
	      
	      if(points.size() > 0){
	    	  for(int i =0; i< points.size(); i++){
		        points.get(i).draw(g);
		     }
	    	 
	    	  x = (float)(20+points.get(0).getX())*rowHt;
	    	  y = (float)(20-points.get(0).getY())*rowHt;
	    	  
	    	  x2 = (float)(20+points.get(1).getX())*rowHt;
	    	  y2 = (float)(20-points.get(1).getY())*rowHt;
	    	  
	    	  g.setStroke(new BasicStroke(3));
	    	  g.setColor(Color.CYAN);
              g.draw(new Line2D.Float(x, y,x2,y2));
              g.setColor(Color.BLACK);
              g.setStroke(new BasicStroke(1));
              
	     }	
	}

}
