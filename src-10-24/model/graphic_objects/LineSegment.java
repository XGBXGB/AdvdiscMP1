package model.graphic_objects;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import model.Point;
import model.matrix.Matrix;
import model.matrix.MatrixFactory;
import model.matrix.R3Matrix;
import model.matrix.ScaleMatrix;

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
	    	  g.setColor(c);
              g.draw(new Line2D.Float(x, y,x2,y2));
              g.setColor(Color.BLACK);
              g.setStroke(new BasicStroke(1));
              
	     }	
	}
	
	@Override
	 public void scaleShape(double scalingFactorX, double scalingFactorY)
	 {
		 MatrixFactory matrixFactory = new MatrixFactory();
        Matrix scalor = matrixFactory.getMatrix("SCALE");
        Matrix pointHolder = matrixFactory.getMatrix("POINT");
        ((ScaleMatrix)scalor).setScalingFactor(scalingFactorX, scalingFactorX);
	   	 
	     for (int i = 0; i < points.size(); i++) {
				Point p = points.get(i);
				((R3Matrix) pointHolder).setPointValues(p.getX(), p.getY());
				pointHolder.setData(scalor.times(pointHolder));
				points.set(i, ((R3Matrix) pointHolder).getPoint());
			}
	 }

	@Override
	public GraphicObject clone() {
		LineSegment l = new LineSegment();
		l.setColor(getColor());
		l.setPoints(getPoints());
		return l;
	}

}
