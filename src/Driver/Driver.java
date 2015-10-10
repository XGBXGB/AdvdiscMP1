/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

import java.util.ArrayList;
import Model.Grid;
import Model.Matrix;
import Model.Point;
import Model.Shape.Quadrilateral;

/**
 *
 * @author Christian Gabriel
 */
public class Driver {
    public static void main(String[] args) {
        Grid xz = new Grid("Title",500,500,20,20);
//        xz.drawLine(5, 5, 10, 5);
//        xz.rotateLine(5, 5, 10, 5, 270);
//        xz.drawLine(10, 5, 5, 5);
//        xz.rotateLine(10, 5, 5, 5, 90);
        
        
        Quadrilateral q = new Quadrilateral(new Point(2,2),new Point(7,2), new Point(7,4), new Point(2,4));
        xz.drawQuad(q);
        Matrix m = new Matrix(3,3);
        q = (Quadrilateral) m.rotateShape(q, 90, new Point(3,3),false);
        xz.drawQuad(q);
    }
    
    
}
