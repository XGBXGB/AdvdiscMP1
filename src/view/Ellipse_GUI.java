package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Model.Shape.Circle;
import Model.Shape.Ellipse;
import Model.Shape.Shape;
import controller.ShapeController;
import net.miginfocom.swing.MigLayout;

public class Ellipse_GUI extends Content {
	private JTextField txt_horizontal, txt_vertical;
	private JLabel lbl_horizontal, lbl_vertical;
	private JPanel panel_content;
	private Points center;
	//vertexA and vertexB are the horizontal axis points
	//covertexA and covertexB are the vertical axis points
	
	private ShapeController sCon;
	
	public Ellipse_GUI() {
		super("Ellipse");
		
		sCon = ShapeController.getInstance();
		
		panel_content = new JPanel();
		panel_content.setPreferredSize(new Dimension(350, 350));
		panel_content.setLayout(new MigLayout("", "[][]", "[][]"));
		super.setContent(panel_content);
		
		center = new Points("Center", false);
		
		panel_content.add(center, "cell 0 0 2 1");
		
		lbl_horizontal = new JLabel("Horizontal distance :");
		panel_content.add(lbl_horizontal, "cell 0 1");
		
		txt_horizontal = new JTextField();
		panel_content.add(txt_horizontal, "cell 1 1");
		txt_horizontal.setColumns(10);
		
		lbl_vertical = new JLabel("Vertical distance :");
		panel_content.add(lbl_vertical, "cell 0 2");
		
		txt_vertical = new JTextField();
		panel_content.add(txt_vertical, "cell 1 2");
		txt_vertical.setColumns(10);
	}

	@Override
	public void createShape() {
		// TODO Auto-generated method stub
		Shape e = new Ellipse();
		System.out.println("Ellipse CREATE SHAPE");
		
		e.addPoint(Double.parseDouble(center.getXValue()), Double.parseDouble(center.getYValue()));
		((Ellipse)e).setHorizontalDistance(Double.parseDouble(txt_horizontal.getText()));
		((Ellipse)e).setVerticalDistance(Double.parseDouble(txt_vertical.getText()));
		
		sCon.setShape(e);
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

}
