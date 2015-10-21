package driver;


import model.shape.Polygon;
import view.Grid;

public class tempDriver {
	public static void main(String[] args) {
      Grid xz = new Grid(500,500,20,20);
//      xz.drawLine(5, 5, 10, 5);        
//      xz.rotateLine(5, 5, 10, 5, 270);
//      xz.drawLine(10, 5, 5, 5);
//      xz.rotateLine(10, 5, 5, 5, 90);
      
      
      Polygon p = new Polygon();
      p.addPoint(1,1);
      p.addPoint(2,1);
      p.addPoint(2,2);
      p.addPoint(1,2);
      p.shear(true, 2);
      //xz.drawQuad(p);
  }
}

