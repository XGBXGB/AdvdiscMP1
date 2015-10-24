package model.graphic_objects;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.QuadCurve2D;
import static java.lang.Math.sqrt;
import java.util.ArrayList;
import model.Point;

public class Hyperbola extends GraphicObject{
    private double hDistance;
    private double vDistance;
    private boolean horizontal;

    
    public Hyperbola(){
        points = new ArrayList();
        hDistance=0;
        vDistance=0;
        horizontal=false;
    }
    
    public boolean isHorizontal() {
        return horizontal;
    }

    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }

    public double gethDistance() {
        return hDistance;
    }
    
    public void sethDistance(double hDistance) {
        this.hDistance = hDistance;
    }

    public double getvDistance() {
        return vDistance;
    }

    public void setvDistance(double vDistance) {
        this.vDistance = vDistance;
    }
    
    @Override
    public void draw(Graphics2D g) {
        System.out.println("DRAWING HYPERBOLA");
        Point center = points.get(0);
        double h = center.getX();
        double k = center.getY();
       
        double boundary;
        int rowHt = 510 / 40;
        int rowWid = 510 / 40;

        Graphics2D g2 = (Graphics2D) g;

        boundary = 20;
        double val1;
        double val2;
        double i;
        i = -20;
        
        while(i<boundary){
            if(horizontal){
                val1= sqrt( Math.pow(hDistance, 2) + Math.pow(hDistance, 2)*( Math.pow(i-k, 2)/Math.pow(vDistance, 2) ) ) + h;
                val2= -sqrt( Math.pow(hDistance, 2) + Math.pow(hDistance, 2)*( Math.pow(i-k, 2)/Math.pow(vDistance, 2) ) ) + h;
                
                g2.draw(new Line2D.Double((20+val1)*rowWid, (20-i)*rowHt, (20+val1)*rowWid, (20-i)*rowHt ));
                g2.draw(new Line2D.Double((20+val2)*rowWid, (20-i)*rowHt, (20+val2)*rowWid, (20-i)*rowHt ));
            }else{
                val1= sqrt( Math.pow(vDistance, 2) + Math.pow(vDistance, 2)*( Math.pow(i-h, 2)/Math.pow(hDistance, 2) ) ) + k;
                val2= -sqrt( Math.pow(vDistance, 2) + Math.pow(vDistance, 2)*( Math.pow(i-h, 2)/Math.pow(hDistance, 2) ) ) + k;
                
                g2.draw(new Line2D.Double((20+i)*rowWid, (20-val1)*rowHt, (20+i)*rowWid, (20-val1)*rowHt ));
                g2.draw(new Line2D.Double((20+i)*rowWid, (20-val2)*rowHt, (20+i)*rowWid, (20-val2)*rowHt ));
            }
            
            i+=0.05;
        }
    }

	@Override
	public GraphicObject clone() {
		 Hyperbola h = new Hyperbola();
		 h.setColor(getColor());
		 h.sethDistance(gethDistance());
		 h.setvDistance(getvDistance());
		 h.setPoints(getPoints());
		 h.setHorizontal(isHorizontal());
		return h;
	}

}
