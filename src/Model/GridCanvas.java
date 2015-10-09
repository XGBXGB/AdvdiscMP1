/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
        double x2Change = x2 * cos(Math.toRadians(angle)) - y2 * sin(Math.toRadians(angle));
        double y2Change = y2 * cos(Math.toRadians(angle)) + x2 * sin(Math.toRadians(angle));
        this.x2 = x2Change;
        this.y2 = y2Change;
        rotateLine = true;
        System.out.println("new coors:\n:"+this.x2+" "+this.y2);
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
            }
            else {
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
            plotLine(g);
        }
        if (rotateLine){
            plotLine(g);
        }
    }

}
