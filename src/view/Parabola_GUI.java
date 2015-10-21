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

public class Parabola_GUI extends Content implements ActionListener{
	private JTextField txt_horizontal;
	private JLabel lbl_horizontal;
	private JPanel panel_content;
	private Points center;
	private JRadioButton rbtn_vertical, rbtn_horizontal;
	private JLabel lbl_orientation;
	
	//vertexA and vertexB are the horizontal axis points
	//covertexA and covertexB are the vertical axis points
	
	public Parabola_GUI() {
		super("Parabola");
		
		panel_content = new JPanel();
		panel_content.setPreferredSize(new Dimension(350, 350));
		panel_content.setLayout(new MigLayout("", "[][][]", "[][][]"));
		super.setContent(panel_content);
		
		center = new Points("Center", false);
		
		panel_content.add(center, "cell 0 0 2 1");
		
		lbl_horizontal = new JLabel("Magnitude :");
		panel_content.add(lbl_horizontal, "cell 0 1");
		
		txt_horizontal = new JTextField();
		panel_content.add(txt_horizontal, "cell 1 1");
		txt_horizontal.setColumns(10);
		
		ButtonGroup bg = new ButtonGroup();
		
		lbl_orientation = new JLabel("Orientation :");
		panel_content.add(lbl_orientation, "cell 0 2");
		
		rbtn_vertical = new JRadioButton("Vertical");
		rbtn_vertical.setBounds(45, 70, 120, 25);
		rbtn_vertical.setOpaque(false);
		rbtn_vertical.addActionListener(this);
		rbtn_vertical.setFocusPainted(false);
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

}
