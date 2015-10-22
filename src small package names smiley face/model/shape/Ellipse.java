package model.shape;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import model.Point;
import model.matrix.Matrix;
import model.matrix.MatrixFactory;
import model.matrix.R3Matrix;
import model.matrix.ScaleMatrix;

public class Ellipse extends Shape{
	
private Point distances;
private Point scaledDistances;
	
	public Ellipse(){
		points = new ArrayList<Point>();
		distances = null;
		scaledDistances = null;
	}
	
	public void setDistances(double horizontalDistance, double verticalDistance)
	{
		distances = new Point(horizontalDistance, verticalDistance);
		scaledDistances = new Point(horizontalDistance, verticalDistance);
	}
	
	public void setScaledDistances(double horizontalDistance, double verticalDistance)
	{
		scaledDistances = new Point(horizontalDistance, verticalDistance);
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
               ellipse.setFrameFromCenter((20+p1.getX())*rowWid,(20-p1.getY())*rowHt, (20+p1.getX()+scaledDistances.getX())*rowWid, (20-p1.getY()-scaledDistances.getY())*rowHt);
               g.draw(ellipse);
               
               Ellipse2D center = new Ellipse2D.Double();
               center.setFrameFromCenter((20+p1.getX())*rowWid,(20-p1.getY())*rowHt, 
            		   					(20+p1.getX()+0.5)*rowWid,(20-p1.getY()-0.5)*rowHt);
               g.fill(center);
               //g.drawLine(0, 0, 20*rowWid, 20*rowHt);
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
         this.setScaledDistances(((R3Matrix) pointHolder).getPoint().getX(), ((R3Matrix) pointHolder).getPoint().getY());

	 }

}
