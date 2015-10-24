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
    	  for(int i =0; i< points.size(); i++){
		      points.get(i).setColor(c);
    		  points.get(i).draw(g); 
	      }
	}

	@Override
	public GraphicObject clone() {
		List_of_Points lp = new List_of_Points();
		lp.setColor(getColor());
		lp.setPoints(getPoints());
		return lp;
	}

}
