package model.graphic_objects;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import model.Point;
import model.matrix.Matrix;
import model.matrix.MatrixFactory;
import model.matrix.R3Matrix;
import model.matrix.ScaleMatrix;
import model.matrix.TranslateMatrix;

public class Ellipse extends GraphicObject{
	
private Point distances;
private Point scaledDistances;
private Point origin;	

	public Ellipse(){
		points = new ArrayList<Point>();
		origin = null;
		distances = null;
		scaledDistances = null;
	}
	
	public void setDistances(Point p)
	{
		distances = p;
		//scaledDistances = new Point(horizontalDistance, verticalDistance);
	}
	
	public Point getDistances(){
		return distances;
	}
	
	public void setScaledDistances(Point p){
		scaledDistances = p;
	}
	
	public Point getScaledDistances(){
		return scaledDistances;
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
	
	public void setOrigin(Point p)
	{
		origin = p;
	}
	
	public Point getOrigin(){
		return origin;
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
               ellipse.setFrameFromCenter((20+p1.getX())*rowWid,(20-p1.getY())*rowHt, (20+p1.getX()+scaledDistances.getX())*rowWid, (20-p1.getY()-scaledDistances.getY())*rowHt);
               
               g.setStroke(new BasicStroke(3));
               g.setColor(c);
               g.draw(ellipse);
               g.setStroke(new BasicStroke(1));
  	    	 	g.setColor(Color.BLACK);
               
               p1.draw(g);
               //g.drawLine(0, 0, 20*rowWid, 20*rowHt);
        }
	}
	
	@Override
	public void translateShape(double x, double y)
	{
		MatrixFactory matrixFactory = new MatrixFactory();
		Matrix translator = matrixFactory.getMatrix("TRANSLATE");
		Matrix pointHolder = matrixFactory.getMatrix("POINT");
		((TranslateMatrix) translator).setTranslateValues(x, y);

		for (int i = 0; i < points.size(); i++) {
			Point p = points.get(i);
			((R3Matrix) pointHolder).setPointValues(origin.getX(), origin.getY());
			pointHolder.setData(translator.times(pointHolder));
			points.set(i, ((R3Matrix) pointHolder).getPoint());
		}
	}
	
	@Override
	 public void scaleShape(double scalingFactorX, double scalingFactorY)
	 {
		 
		 MatrixFactory matrixFactory = new MatrixFactory();
        Matrix scalor = matrixFactory.getMatrix("SCALE");
        Matrix pointHolder = matrixFactory.getMatrix("POINT");
        ((ScaleMatrix)scalor).setScalingFactor(scalingFactorX, scalingFactorY);
        
        ((R3Matrix) pointHolder).setPointValues(((Ellipse)this).getHorizontalDistance(), ((Ellipse)this).getVerticalDistance());
         pointHolder.setData(scalor.times(pointHolder));
         this.setScaledDistances(((R3Matrix) pointHolder).getPoint());

	 }

	@Override
	public GraphicObject clone() {
		
		Ellipse e = new Ellipse();
		e.setColor(getColor());
		e.setDistances(getDistances());
		e.setHorizontalDistance(getHorizontalDistance());
		e.setVerticalDistance(getVerticalDistance());
		e.setOrigin(getOrigin());
		e.setScaledDistances(getScaledDistances());
		e.setPoints(getPoints());
		return e;
	}

}