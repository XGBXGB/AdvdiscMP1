/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import static java.lang.Math.cos;
import static java.lang.Math.sin;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

import controller.ShapeController;
import model.Observer;
import model.shape.Polygon;
import model.shape.Shape;

/**
 *
 * @author Christian Gabriel*/
public class GridCanvas extends Canvas implements Observer {

	private ShapeController sCon;
	private int width, height;
	private int rows,cols;
	private Shape shape = null;
    double x1, y1, x2, y2;
    float rowHt, rowWid;
    Polygon quad = null;
    boolean line = false;
    boolean rotateLine = false;

    public GridCanvas(int width, int height, int rows, int cols) {
    	sCon = ShapeController.getInstance();
    	sCon.registerObserver(this);
        this.setSize(width, height);
        this.width  = width;
        this.height = height;
    	this.rows = rows;
        this.cols = cols;
        rowHt = height / rows;
        rowWid = width / cols;
        
    }

    public void paint(Graphics g) {
        int i;
        Graphics2D g2 = (Graphics2D) g;
        if(shape!=null)
        	shape.draw(g2);
        drawGrid(g2);
    }

    public void drawGrid(Graphics2D g) {
        int i;
        width = getSize().width;
        height = getSize().height;
        Graphics2D g2 = (Graphics2D) g;
        // draw the rows
        for (i = 0; i < rows; i++)
        {
        	if(i == rows/2){
                 g2.setStroke(new BasicStroke(3));
                 g2.draw(new Line2D.Float(0, i * rowHt, (int)width, i * rowHt));
                 g2.setStroke(new BasicStroke(1));
        	}else{
        		 g2.draw(new Line2D.Float(0, i * rowHt, width, i * rowHt));
        	}
        }
        // draw the columns
        int rowWid = (width / (cols));
        for (i = 0; i < cols; i++)
        {
        	if(i == cols/2){
                 g2.setStroke(new BasicStroke(3));
                 g2.draw(new Line2D.Float(i * rowWid, 0, i * rowWid, height));
                 g2.setStroke(new BasicStroke(1));
        	}else{
        		 g2.draw(new Line2D.Float(i * rowWid, 0, i * rowWid, height));
        	}
        }
    }
  
	@Override
	public void update() {
		// TODO Auto-generated method stub
		shape = sCon.getShape();
		
		repaint();
	}

 

}
