package view;

import java.awt.Dimension;



import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Point;
import model.graphic_objects.Ellipse;
import model.graphic_objects.GraphicObject;
import net.miginfocom.swing.MigLayout;
import controller.GraphicObjectController;

public class Ellipse_GUI extends Content {
	private JTextField txt_horizontal, txt_vertical;
	private JLabel lbl_horizontal, lbl_vertical;
	private JPanel panel_content;
	private Point_GUI center;
	//vertexA and vertexB are the horizontal axis points
	//covertexA and covertexB are the vertical axis points
	
	private GraphicObjectController sCon;
	
	public Ellipse_GUI() {
		super("Ellipse");
		
		sCon = GraphicObjectController.getInstance();
		
		panel_content = new JPanel();
		panel_content.setPreferredSize(new Dimension(350, 350));
		panel_content.setLayout(new MigLayout("", "[][]", "[][]"));
		super.setContent(panel_content);
		
		center = new Point_GUI("Center", false);
		
		panel_content.add(center, "cell 0 0 2 1");
		
		lbl_horizontal = new JLabel("Horizontal distance :");
		panel_content.add(lbl_horizontal, "cell 0 1");
		
		txt_horizontal = new JTextField();
		txt_horizontal.setDocument(new JTextFieldFilter(JTextFieldFilter.FLOAT));
		((JTextFieldFilter)txt_horizontal.getDocument()).setNegativeAccepted(true);
		panel_content.add(txt_horizontal, "cell 1 1");
		txt_horizontal.setColumns(10);
		
		lbl_vertical = new JLabel("Vertical distance :");
		panel_content.add(lbl_vertical, "cell 0 2");
		
		txt_vertical = new JTextField();
		txt_vertical.setDocument(new JTextFieldFilter(JTextFieldFilter.FLOAT));
		((JTextFieldFilter)txt_vertical.getDocument()).setNegativeAccepted(true);
		panel_content.add(txt_vertical, "cell 1 2");
		txt_vertical.setColumns(10);
	}

	@Override
	public void createShape() {
		// TODO Auto-generated method stub
		GraphicObject e = new Ellipse();
		System.out.println("Ellipse CREATE SHAPE");
		
		e.addPoint(Double.parseDouble(center.getXValue()), Double.parseDouble(center.getYValue()));
		Point d = new Point(Double.parseDouble(txt_horizontal.getText()), Double.parseDouble(txt_vertical.getText()));
		Point o = new Point(Double.parseDouble(center.getXValue()), Double.parseDouble(center.getYValue()));
		((Ellipse)e).setDistances(d);
		sCon.setOriginalObject(e);
		sCon.setTransformedObject((Ellipse)e.clone());
		clear();
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		 this.txt_horizontal.setText(""); 
		 this.txt_vertical.setText("");
		 this.center.clear();
	}

}
