import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.QuadCurve2D;

import static java.lang.Math.sqrt;
public class DrawingComponent extends Component {
    int cols=20,rows = 20;
        int rowHt = 600/rows;
        int rowWid = 600/cols;
        int width = 600;
        int height = 600;
        
    public void paint(Graphics g)
    {
        double h = -2;
        double k = -3;
        double a = 0.5;
        
        drawGrid(g);
        g.setColor(Color.blue);
        g.drawLine(0, 0, 300, 300);
        for(double y=k;y<=40;y+=0.02)
        {
//            System.out.println(y);
            double x = sqrt((y-k)/a)+h;
            double x2 = -sqrt((y-k)/a)+h;
//            
            double intX =  x;
            double intX2 =  x2;
//            
            Graphics2D g2 = (Graphics2D) g;
            //g2.setStroke(new BasicStroke(5));
            //g2.draw(new Line2D.Double(rowWid*(h+10), (12-k)*rowHt,rowWid*(h+10), (12-k)*rowHt));
                g2.setStroke(new BasicStroke(5));
                g2.draw(new Line2D.Double(rowWid*(intX+10),(10-y)*rowHt,rowWid*(intX+10),(10-y)*rowHt));
                g2.draw(new Line2D.Double(rowWid*(intX2+10),(10-y)*rowHt,rowWid*(intX2+10),(10-y)*rowHt));
                g2.setStroke(new BasicStroke(1));
            

                
                // create new QuadCurve2D.Float
                QuadCurve2D q = new QuadCurve2D.Float();
                // draw QuadCurve2D.Float with set coordinates
                
                double z = sqrt((40-k)/a)+h;
                double zz = -sqrt((40-k)/a)+h;
//q.setCurve((zz+10)*rowWid, 0, rowWid*(h+10), (12-k)*rowHt, (10+z)*rowWid, 0);                
//q.setCurve(rowWid*(h+10), (10-k)*rowHt, (x+10)*rowWid, (1+10)*rowHt, (x+10)*rowWid, -30*rowHt);
                g2.draw(q);
                
                
                System.out.println(10+z+" "+10+zz);
                
        }
    }
    
    public void drawGrid(Graphics g) {
        int i;

        // draw the rows
        for (i = 0; i < 20; i++) {
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
}
