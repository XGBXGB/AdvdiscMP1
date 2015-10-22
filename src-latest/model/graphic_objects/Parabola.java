/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.graphic_objects;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.QuadCurve2D;
import static java.lang.Math.sqrt;
import java.util.ArrayList;
import model.Point;

/**
 *
 * @author Christian Gabriel
 */
public class Parabola extends GraphicObject{
    private boolean vertical;
    private double magnitude;

    public Parabola(){
        vertical = false;
        magnitude = 0;
        points = new ArrayList<Point>();
    }
    
    public boolean isVertical() {
        return vertical;
    }

    public void setVertical(boolean vertical) {
        this.vertical = vertical;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    @Override
    public void draw(Graphics2D g) {
        System.out.println("PARABOLA");
        Point center = points.get(0);
        int rowHt = 510 / 40;
        int rowWid = 510 / 40;
        double h = center.getX(); //center X
        double k = center.getY(); // center Y
        //double a = 0.5; // magnitude!
        double boundary;

        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));

        if (magnitude < 0) {
            boundary = -40;
        } else {
            boundary = 40;
        }

        double val1,val2,i;
        if(vertical)
            i = k;
        else
            i = h;
        
        if(magnitude>0){
            while(i<boundary){
                if(vertical){
                    val1 = sqrt((i - k) / magnitude) + h;
                    val2 = -sqrt((i - k) / magnitude) + h;
                    g2.draw(new Line2D.Double((val1+20)*rowWid,(20-i)*rowHt, (val1+20)*rowWid,(20-i)*rowHt));
                    g2.draw(new Line2D.Double((val2+20)*rowWid,(20-i)*rowHt, (val2+20)*rowWid,(20-i)*rowHt));
                }
                else{
                    val1 = sqrt((i - h) / magnitude) + k;
                    val2 = -sqrt((i - h) / magnitude) + k;
                    g2.draw(new Line2D.Double((20+i)*rowWid, (20-val2)*rowHt, (20+i)*rowWid, (20-val2)*rowHt));
                    g2.draw(new Line2D.Double((20+i)*rowWid, (20-val1)*rowHt, (20+i)*rowWid, (20-val1)*rowHt));
                }
                i+=0.1;
            }
        }
        
        if(magnitude<0){
            while(i>boundary){
                if(vertical){
                    val1 = sqrt((i - k) / magnitude) + h;
                    val2 = -sqrt((i - k) / magnitude) + h;
                    g2.draw(new Line2D.Double((val1+20)*rowWid,(20-i)*rowHt, (val1+20)*rowWid,(20-i)*rowHt));
                    g2.draw(new Line2D.Double((val2+20)*rowWid,(20-i)*rowHt, (val2+20)*rowWid,(20-i)*rowHt));
                }
                else{
                    val1 = sqrt((i - h) / magnitude) + k;
                    val2 = -sqrt((i - h) / magnitude) + k;
                    g2.draw(new Line2D.Double((20+i)*rowWid, (20-val2)*rowHt, (20+i)*rowWid, (20-val2)*rowHt));
                    g2.draw(new Line2D.Double((20+i)*rowWid, (20-val1)*rowHt, (20+i)*rowWid, (20-val1)*rowHt));
                }
                i-=0.1;
            }
        }
        g2.setStroke(new BasicStroke(1));
    }
    
    
}
