/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

import model.shape.Polygon;

/**
 *
 * @author Christian Gabriel*/
public class GridCanvas extends JPanel {

    double width, height, rows, cols;
    double x1, y1, x2, y2;
    int rowHt;
    Polygon quad = null;
    boolean line = false;
    boolean rotateLine = false;

    public GridCanvas(int width, int height, int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        rowHt = height / (rows);
        this.setPreferredSize(new Dimension(width, height));
    }

    public void plotLine(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));
        g2.setColor(Color.red);
        g2.draw(new Line2D.Double(x1 * rowHt, y1 * rowHt, x2 * rowHt, y2 * rowHt));
        g2.setStroke(new BasicStroke(1));
        line=false;
    }
    
    public void drawQuad(Polygon q) {
        quad = q;
        repaint();
    }
    
    

    public void drawLine(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        line = true;
        repaint();
    }

    //Given a center point (x1,y1), this method rotates point(x2,y2) (angle)degrees around the center point, clockwise.
    public void rotateLine(double x1, double y1, double x2, double y2, float angle) {
        //double length = Math.pow(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2), 0.5);
        double newX1, newX2, newY1, newY2;
        double centerX = (x2-x1)/2+x1;
        double centerY = (y2-y1)/2+y1;
        
        double x2Change = (x2-centerX) * cos(Math.toRadians(angle)) - (y2-centerY) * sin(Math.toRadians(angle));
        double y2Change = (y2-centerY) * cos(Math.toRadians(angle)) + (x2-centerX) * sin(Math.toRadians(angle));
        newX2 = x2Change+centerX;
        newY2 = y2Change+centerY;
        
        double x1Change = (x1-centerX) * cos(Math.toRadians(angle)) - (y1-centerY) * sin(Math.toRadians(angle));
        double y1Change = (y1-centerY) * cos(Math.toRadians(angle)) + (x1-centerX) * sin(Math.toRadians(angle));
        newX1 = x1Change+centerX;
        newY1 = y1Change+centerY;
        
        this.y1 = newY1;
        this.y2 = newY2;
        this.x1 = newX1;
        this.x2 = newX2;
        
        rotateLine = true;
        System.out.println("new coors:\nx:"+this.x2+" y:"+this.y2);
        
//        double x2Change = (x2-x1) * cos(Math.toRadians(angle)) - (y2-y1) * sin(Math.toRadians(angle));
//        double y2Change = (y2-y1) * cos(Math.toRadians(angle)) + (x2-x1) * sin(Math.toRadians(angle));
//        this.x2 = x2Change+x1;
//        this.y2 = y2Change+y2;
//        rotateLine = true;
//        System.out.println("new coors:\nx:"+this.x2+" y:"+this.y2);
        repaint();
    }
    
    
    public void rotatePoint(double x1, double y1, double x2, double y2, float angle) {
        //double length = Math.pow(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2), 0.5);
        
        double x2Change = (x2-x1) * cos(Math.toRadians(angle)) - (y2-y1) * sin(Math.toRadians(angle));
        double y2Change = (y2-y1) * cos(Math.toRadians(angle)) + (x2-x1) * sin(Math.toRadians(angle));
        this.x2 = x2Change+x1;
        this.y2 = y2Change+y2;
        rotateLine = true;
        System.out.println("new coors:\nx:"+this.x2+" y:"+this.y2);
        repaint();
        
        /*
        
        
        
        
        */
    }
    
    /*
    //Given a Shape s, this method changes all of its points based on a given center point and angle
    public void rotatePoint(Point center, Shape s, float angle) {
        for(i=0;i<s.numOfPoints;i++){
            Point temp = s.getPoint(i);
            s.getPoint(i).setX = (temp.getX-center.getX) * cos(Math.toRadians(angle)) - (temp.getY-center.getY) * sin(Math.toRadians(angle));
            s.getPoint(i).setY = (temp.getY-center.getY) * cos(Math.toRadians(angle)) + (temp.getX-center.getX) * sin(Math.toRadians(angle));
        }
    }
    
    */

    public void drawGrid(Graphics g) {
        int i;
        width = getSize().width;
        height = getSize().height;

        // draw the rows
        for (i = 0; i < rows; i++) {
            if (i == 10) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setStroke(new BasicStroke(3));
                g2.draw(new Line2D.Float(0, i * rowHt, (int)width, i * rowHt));
                g2.setStroke(new BasicStroke(1));
            } else {
                g.drawLine(0, i * rowHt, (int)width, i * rowHt);
            }
        }
        // draw the columns
        int rowWid =(int) width /(int) cols;
        for (i = 0; i < cols; i++) {
            if (i == 10) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setStroke(new BasicStroke(3));
                g2.draw(new Line2D.Double(i * rowWid, 0, i * rowWid, height));
                g2.setStroke(new BasicStroke(1));
            }
            else {
                g.drawLine(i * rowWid, 0, i * rowWid, (int)height);
            }
        }
    }
    /*
    for(Point p: s.getPoints()){
            p.setX = (p.getX-center.getX) * cos(Math.toRadians(angle)) - (p.getY-center.getY) * sin(Math.toRadians(angle));
            p.setY = (p.getY-center.getY) * cos(Math.toRadians(angle)) + (p.getX-center.getX) * sin(Math.toRadians(angle));
        }
    */

    //is automatically called when the grid is constructed
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGrid(g);
        if (line) {
            plotLine(g);
        }
        if (rotateLine){
            plotLine(g);
        }
        if(quad!=null){
            System.out.println("PASOK QUAD");
            quad.draw(g);
        }
    }

}
