/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import javax.swing.JPanel;

/**
 *
 * @author Christian Gabriel
 */
public class GridCanvas extends JPanel {

    double width, height, rows, cols;
    double x1, y1, x2, y2;
    int rowHt;
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
        g2.draw(new Line2D.Double(x1 * rowHt, y1 * rowHt, x2 * rowHt, y2 * rowHt));
        g2.setStroke(new BasicStroke(1));
        line=false;
    }

    public void drawLine(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        line = true;
        repaint();
    }

    public void rotateLine(double x1, double y1, double x2, double y2, float angle) {
        double length = Math.pow(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2), 0.5);
        double x2Change = (x2-x1) * cos(Math.toRadians(angle));
        double y2Change = (y2-y1) * sin(Math.toRadians(angle));
        this.x2 = x2Change;
        this.y2 = y2Change;
        rotateLine = true;
        System.out.println("new coors:\n:"+this.x2+" "+this.y2);
        repaint();
        
    }
    
    //WINONA'S CODE FOR TRANSLATE
    public void translateLine(double x1, double y1, double x2, double y2, double v1, double v2)
    {
    	double newx1, newx2, newy1, newy2;
    	
    	newx1 = x1 + v1;
    	newy1 = y1 + v2;
    	newx2 = x2 + v1;
    	newy2 = y2 + v2;
    	this.x1 = newx1;
    	this.x2 = newx2;
    	this.y1 = newy1;
    	this.y2 = newy2;
    	System.out.println("vector was (" + v1 + "," + v2 + ")");
    	System.out.println("head was (" + x1 + "," + y1 + ")" );
    	System.out.println("head is now (" + newx1 + "," + newy1 + ")" );
    	System.out.println("tail was (" + x2 + "," + y2 + ")" );
    	System.out.println("tail is now (" + newx2 + "," + newy2 + ")" );
    	repaint();
    }
    
    //shrink or contract is negative scaling factor then expand/dilate is positive scaling factor
    public void scaleLine(double x1, double y1, double x2, double y2, double scalingFactor)
    {
    	double newx1, newy1, newx2, newy2;
    	
    	newx1 = scalingFactor * x1;
    	newx2 = scalingFactor * x2;
    	newy1 = scalingFactor * y1;
    	newy2 = scalingFactor * y2;
    	this.x1 = newx1;
    	this.x2 = newx2;
    	this.y1 = newy1;
    	this.y2 = newy2;
    	System.out.println("scaling factor was" + scalingFactor);
    	System.out.println("head was (" + x1 + "," + y1 + ")" );
    	System.out.println("head is now (" + newx1 + "," + newy1 + ")" );
    	System.out.println("tail was (" + x2 + "," + y2 + ")" );
    	System.out.println("tail is now (" + newx2 + "," + newy2 + ")" );
    	repaint();
    }

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
            } else {
                g.drawLine(i * rowWid, 0, i * rowWid, (int)height);
            }
        }
    }

    //is automatically called when the grid is constructed
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGrid(g);
        if (line) {
            System.out.println("PUMASOWK");
            plotLine(g);
        }
        if (rotateLine){
            plotLine(g);
        }
    }

}
