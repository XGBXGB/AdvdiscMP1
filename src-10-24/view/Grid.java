/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;



import javax.swing.JPanel;

/**
 *
 * @author Christian Gabriel
 */
public class Grid extends JPanel {

    float rows, cols, height, width;
    GridCanvas canvas;

    public Grid(int w, int h, int rows, int cols) {
      
        this.rows = rows;
        this.cols = cols;
        height = h;
        width = w;
        
        canvas = new GridCanvas(w,h,rows,cols);
        this.add(canvas);
        this.setVisible(true);
        
    }
    
//    public void drawLine(int x1, int y1, int x2, int y2){
//        canvas.drawLine(x1, y1, x2, y2);
//        //repaint();
//    }
//    
//    public void rotateLine(double x1, double y1, double x2, double y2, float angle){
//        System.out.println("Grid rotate: x2:"+x2+" y2:"+y2);
//        canvas.rotateLine(x1, y1, x2, y2, angle);
//        //repaint();
//    }
//    
//    public void drawQuad(Polygon quad){
//        canvas.drawQuad(quad);
//        //repaint();
//    }
    
}
