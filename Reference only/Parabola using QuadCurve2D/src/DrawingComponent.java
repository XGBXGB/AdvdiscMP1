
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.QuadCurve2D;

import static java.lang.Math.sqrt;

public class DrawingComponent extends Component {

    int cols = 20, rows = 20;
    int rowHt = 600 / rows;
    int rowWid = 600 / cols;
    int width = 600;
    int height = 600;

    public void paint(Graphics g) {
        double h = -2; //center X
        double k = -3; // center Y
        double a = -0.1; // magnitude!
        double boundary;
        boolean vertical = true; //vertical horizontal

        drawGrid(g);
        g.setColor(Color.blue);
        Graphics2D g2 = (Graphics2D) g;
        QuadCurve2D q = new QuadCurve2D.Float();

        if (a < 0) {
            boundary = -10;
        } else {
            boundary = 10;
        }

        double val1;
        double val2;
        if(vertical){//if vertical, finds the x values with respect to y
            val1 = sqrt((boundary - k) / a) + h;
            val2 = -sqrt((boundary - k) / a) + h;
        }
        else{//else finds y values with respect to x
            val1 = sqrt((boundary - h) / a) + k;
            val2 = -sqrt((boundary - h) / a) + k;
        }


        double i = 0;//pulls the curve until it contains the vertex point
        do {
            if (vertical) {
                q.setCurve((val2 + 10) * rowWid, (10 - boundary) * rowHt, rowWid * (h + 10), ((10 - k) + i) * rowHt, (10 + val1) * rowWid, (10 - boundary) * rowHt);
            } else {
                q.setCurve((10 + boundary) * rowHt, (10 - val2) * rowWid, rowWid * (h + 10 - i), (10 - k) * rowHt, (10 + boundary) * rowHt, (10 - val1) * rowWid);
            }
            
            if (a < 0) {
                i -= 0.05;
            } else {
                i += 0.05;
            }
            
        }while (!q.contains((10 + h) * rowWid, (10 - k) * rowHt));
        g2.draw(q);
    }

    public void drawGrid(Graphics g) {
        int i;

        // draw the rows
        for (i = 0; i < 20; i++) {
            if (i == 10) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setStroke(new BasicStroke(3));
                g2.draw(new Line2D.Float(0, i * rowHt, (int) width, i * rowHt));
                g2.setStroke(new BasicStroke(1));
            } else {
                g.drawLine(0, i * rowHt, (int) width, i * rowHt);
            }
        }
        // draw the columns
        for (i = 0; i < cols; i++) {
            if (i == 10) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setStroke(new BasicStroke(3));
                g2.draw(new Line2D.Double(i * rowWid, 0, i * rowWid, height));
                g2.setStroke(new BasicStroke(1));
            } else {
                g.drawLine(i * rowWid, 0, i * rowWid, (int) height);
            }
        }
    }
}
