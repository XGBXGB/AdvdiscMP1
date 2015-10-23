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
import model.graphic_objects.Parabola;

import net.miginfocom.swing.MigLayout;

public class Parabola_GUI extends Content implements ActionListener{
	private JTextField txt_magnitude;
	private JLabel lbl_horizontal;
	private JPanel panel_content;
	private Point_GUI center;
	private JRadioButton rbtn_vertical, rbtn_horizontal;
	private JLabel lbl_orientation;
        private ShapeController sCon;
	
	//vertexA and vertexB are the horizontal axis points
	//covertexA and covertexB are the vertical axis points
	
	public Parabola_GUI() {
		super("Parabola");
		sCon = ShapeController.getInstance();
		panel_content = new JPanel();
		panel_content.setPreferredSize(new Dimension(350, 350));
		panel_content.setLayout(new MigLayout("", "[][][]", "[][][]"));
		super.setContent(panel_content);
		
		center = new Point_GUI("Center", false);
		
		panel_content.add(center, "cell 0 0 2 1");
		
		lbl_horizontal = new JLabel("Magnitude :");
		panel_content.add(lbl_horizontal, "cell 0 1");
		
		txt_magnitude = new JTextField();
		panel_content.add(txt_magnitude, "cell 1 1");
		txt_magnitude.setColumns(10);
		
		ButtonGroup bg = new ButtonGroup();
		
		lbl_orientation = new JLabel("Orientation :");
		panel_content.add(lbl_orientation, "cell 0 2");
		
		rbtn_vertical = new JRadioButton("Vertical");
		rbtn_vertical.setBounds(45, 70, 120, 25);
		rbtn_vertical.setOpaque(false);
		rbtn_vertical.addActionListener(this);
		rbtn_vertical.setFocusPainted(false);
                rbtn_vertical.setSelected(true);
		panel_content.add(rbtn_vertical, "cell 1 2");
		
		bg.add(rbtn_vertical);
		
		rbtn_horizontal = new JRadioButton("Horizontal");
		rbtn_horizontal.setBounds(45, 70, 120, 25);
		rbtn_horizontal.setOpaque(false);
		rbtn_horizontal.addActionListener(this);
		rbtn_horizontal.setFocusPainted(false);
		panel_content.add(rbtn_horizontal, "cell 2 2");
		bg.add(rbtn_horizontal);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createShape() {
            GraphicObject parabola = new Parabola();
            parabola.addPoint(Double.parseDouble(center.getXValue()), Double.parseDouble(center.getYValue()));
            ((Parabola)parabola).setMagnitude(Double.parseDouble(txt_magnitude.getText()));
            ((Parabola)parabola).setVertical(rbtn_vertical.isSelected());
            sCon.setShape(parabola);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

}
