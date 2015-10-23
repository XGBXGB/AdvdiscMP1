/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import model.graphic_objects.GraphicObject;

/**
 *
 * @author Christian Gabriel
 */
public class Point extends GraphicObject{
    double x;
    double y;
    double w;
    
    public Point(double x, double y){
        this.x = x;
        this.y = y;
        this.w = 1;
    }

    public double getW() {
        return w;
    }

    public void setW(double w) {
        this.w = w;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

	@Override
	public void draw(Graphics2D g) {

        int rowHt = 510 / 40;
        int rowWid = 510 / 40;
        
		// TODO Auto-generated method stub
		 Ellipse2D center = new Ellipse2D.Double();
         center.setFrameFromCenter((20+x)*rowWid,(20-y)*rowHt, 
      		   					(20+x+0.3)*rowWid,(20-y-0.3)*rowHt);
         g.setColor(Color.BLUE);
         g.fill(center);
         g.setColor(Color.BLACK);
	}
    
    
}
