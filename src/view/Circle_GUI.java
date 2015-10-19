package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class Circle_GUI extends Content{
	private JTextField txt_radius;
	private JLabel lbl_radius;
	private JPanel panel_content;
	private Points center;

	public Circle_GUI() {
		
		super("Circle");
		panel_content = new JPanel();
		panel_content.setPreferredSize(new Dimension(350, 350));
		panel_content.setLayout(new MigLayout("", "[][]", "[][]"));
		setContent(panel_content);
		
		center = new Points("Center", false);
		panel_content.add(center, "cell 0 0 2 1");

		lbl_radius = new JLabel("Radius :");
		panel_content.add(lbl_radius, "cell 0 1");

		txt_radius = new JTextField();
		panel_content.add(txt_radius, "cell 1 1");
		txt_radius.setColumns(10);
	}

	@Override
	public void createShape() {
		// TODO Auto-generated method stub
		System.out.println("CIRCLEE CREATE SHAPE");
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	
}
