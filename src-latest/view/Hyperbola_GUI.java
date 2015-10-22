package view;

import controller.ShapeController;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import model.graphic_objects.GraphicObject;
import model.graphic_objects.Hyperbola;

import net.miginfocom.swing.MigLayout;

public class Hyperbola_GUI extends Content implements ActionListener{
	private JTextField txt_horizontal, txt_vertical;
	private JLabel lbl_horizontal, lbl_vertical;
	private JPanel panel_content;
	private Point_GUI center;
	private JRadioButton rbtn_vertical, rbtn_horizontal;
	private JLabel lbl_orientation;
        private ShapeController sCon;
	
	//vertexA and vertexB are the horizontal axis points
	//covertexA and covertexB are the vertical axis points
	
	public Hyperbola_GUI() {
		super("Hyperbola");
		sCon = ShapeController.getInstance();
		panel_content = new JPanel();
		panel_content.setPreferredSize(new Dimension(350, 350));
		panel_content.setLayout(new MigLayout("", "[][]", "[][][][][]"));
		super.setContent(panel_content);
		
		center = new Point_GUI("Center", false);
		
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
		
		lbl_orientation = new JLabel("Orientation :");
		panel_content.add(lbl_orientation, "cell 0 3");
		
		ButtonGroup bg = new ButtonGroup();
		
		rbtn_vertical = new JRadioButton("Vertical");
		rbtn_vertical.setBounds(45, 70, 120, 25);
		rbtn_vertical.setOpaque(false);
		rbtn_vertical.addActionListener(this);
		rbtn_vertical.setFocusPainted(false);
                rbtn_vertical.setSelected(true);
		panel_content.add(rbtn_vertical, "cell 1 3");
		
		rbtn_horizontal = new JRadioButton("Horizontal");
		rbtn_horizontal.setBounds(45, 70, 120, 25);
		rbtn_horizontal.setOpaque(false);
		rbtn_horizontal.addActionListener(this);
		rbtn_horizontal.setFocusPainted(false);
		panel_content.add(rbtn_horizontal, "cell 2 3");
		
		bg.add(rbtn_vertical);
		bg.add(rbtn_horizontal);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createShape() {
		// TODO Auto-generated method stub
		GraphicObject hyperbola = new Hyperbola();
                hyperbola.addPoint(Double.parseDouble(center.getXValue()), Double.parseDouble(center.getYValue()));
                System.out.println(txt_horizontal.getText() + txt_vertical.getText());
                ((Hyperbola)hyperbola).sethDistance(Double.parseDouble(txt_horizontal.getText()));
                ((Hyperbola)hyperbola).setvDistance(Double.parseDouble(txt_vertical.getText()));
                ((Hyperbola)hyperbola).setHorizontal(rbtn_horizontal.isSelected());
                sCon.setShape(hyperbola);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

}
