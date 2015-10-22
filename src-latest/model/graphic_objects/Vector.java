package model.graphic_objects;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import model.Point;

public class Vector extends GraphicObject {

	public Vector(){
		points = new ArrayList<Point>();
	}
	
	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		  int rowHt = 510 / 40;
	      int rowWid = 510 / 40;
	      double x, y, x2,y2;
	      double dx, dy;
	      int j;
	      if(points.size() > 0){
	    	 
	    	 
	    	  x = (20+points.get(0).getX())*rowWid;
	    	  y = (20-points.get(0).getY())*rowHt;
	    	  
	    	  x2 = (20+points.get(1).getX())*rowWid;
	    	  y2 = (20-points.get(1).getY())*rowHt;
	    	  
	    	  g.setStroke(new BasicStroke(3));
              g.draw(new Line2D.Double(x, y,x2,y2));
              g.setStroke(new BasicStroke(1));
              
              dx = x2-x;
              dy = y2-y;
              
	    	  for(int i = (int)points.get(points.size()-1).getX(); i <20; i++){
		    	  
	    		  j = (int)points.get(points.size()-1).getY();
	    		  System.out.println("X: " + x + " Y: "+ y);
	    		  System.out.println("X2: " + x2 + " Y2: "+ y2);
	    		  System.out.println("dx: " + dx);
	    		  System.out.println("dy: " + dy);
	    		  
		    	  x2 = (20+i+dx)*rowWid;
		    	  y2 = (20-j+dy)*rowHt;
		    	  
		    	  g.setStroke(new BasicStroke(3));
		    	  g.setColor(Color.CYAN);
	              g.draw(new Line2D.Double(x, y,x2,y2));
	              g.setColor(Color.BLACK);
	              g.setStroke(new BasicStroke(1));
	              
	              x = (20+x2+dx)*rowWid;
		    	  y = (20-y2+dy)*rowHt;  
		    	  j++; 
	    	  }
	    	  
	    	  for(int i =0; i< points.size(); i++){
			        points.get(i).draw(g);
			     }
	     }	
	}

}