package view;

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

import net.miginfocom.swing.MigLayout;
import java.awt.Color;

public class TwoPoints_GUI extends Content{
	private JTextField txt_horizontal;
	private JLabel lbl_horizontal;
	private JPanel panel_content;
	private Points p1, p2;
	private JRadioButton rbtn_vertical, rbtn_horizontal;
	private JLabel lbl_orientation;
	
	//vertexA and vertexB are the horizontal axis points
	//covertexA and covertexB are the vertical axis points
	
	public TwoPoints_GUI() {
		super("Two Points");
		
		panel_content = new JPanel();
		panel_content.setPreferredSize(new Dimension(350, 350));
		panel_content.setLayout(new MigLayout("", "[]", "[][]"));
		setContent(panel_content);
		
		p1 = new Points("P1", false);
		panel_content.add(p1, "cell 0 1");
		p2 = new Points("P2", false);
		panel_content.add(p2, "cell 0 2");		
	}

	@Override
	public void createShape() {
		// TODO Auto-generated method stub
		System.out.println("HELLO IDOL");
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	

}
