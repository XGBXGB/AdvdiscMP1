package model.graphic_objects;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import model.Point;

public class List_of_Points extends GraphicObject {

	public List_of_Points(){
		points = new ArrayList<Point>();
	}
	
	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		  int rowHt = 510 / 40;
	      int rowWid = 510 / 40;
	        

    	  for(int i =0; i< points.size(); i++){
	        	 Ellipse2D center = new Ellipse2D.Double();
		         center.setFrameFromCenter((20+points.get(i).getX())*rowWid,(20-points.get(i).getY())*rowHt, 
		      		   					(20+points.get(i).getX()+0.5)*rowWid,(20-points.get(i).getY()-0.5)*rowHt);
		         points.get(i).draw(g);
		         g.fill(center);
	        }
	      
	}

}
