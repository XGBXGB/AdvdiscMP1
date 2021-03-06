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

	public Ellipse(){
		points = new ArrayList<Point>();
		distances = null;
	}
	
	public void setDistances(Point p)
	{
		distances = p;
	}
	
	public Point getDistances(){
		return distances;
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
			((R3Matrix) pointHolder).setPointValues(p.getX(), p.getY());
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

         ((R3Matrix) pointHolder).setPointValues(getHorizontalDistance(), getVerticalDistance());
	     pointHolder.setData(scalor.times(pointHolder));
	     this.setDistances(((R3Matrix) pointHolder).getPoint());
	   	 
	     for (int i = 0; i < points.size(); i++) {
				Point p = points.get(i);
				((R3Matrix) pointHolder).setPointValues(p.getX(), p.getY());
				pointHolder.setData(scalor.times(pointHolder));
				points.set(i, ((R3Matrix) pointHolder).getPoint());
			}
	 }

	public String printMatrix(){
		String result = "";
		double vd, hd;
		
		result = String.format(" Center: %5s", " ");
		result += String.format("[%-1s %.3f %.3f %1s]\n"," ",points.get(0).getX(),points.get(0).getY(), " ");
		
		vd = points.get(0).getY() + getVerticalDistance();
		result += String.format(" Vertical Distance: %10s", " ");
		result += String.format("[%-1s %.3f %.3f %1s] %3s"," ",points.get(0).getX(),vd, " ", " ");
		vd = points.get(0).getY() - getVerticalDistance();
		result += String.format("[%-1s %.3f %.3f %1s]\n"," ",points.get(0).getX(),vd, " ");
		
		hd = points.get(0).getX() + getHorizontalDistance();
		result += String.format(" Horizontal Distance: %5s", " ");
		result += String.format("[%-1s %.3f %.3f %1s] %3s"," ",hd,points.get(0).getY(), " ", " ");
		hd = points.get(0).getX() - getHorizontalDistance();
		result += String.format("[%-1s %.3f %.3f %1s]\n"," ",hd,points.get(0).getY(), " ");
		return result;
	}
	
	@Override
	public GraphicObject clone() {
		
		Ellipse e = new Ellipse();
		e.setColor(getColor());
		e.setDistances(getDistances());
		e.setHorizontalDistance(getHorizontalDistance());
		e.setVerticalDistance(getVerticalDistance());
		e.setPoints(getPoints());
		return e;
	}

}
