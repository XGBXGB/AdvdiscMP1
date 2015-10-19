package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class Ellipse_GUI extends JPanel {
	private JTextField txt_horizontal, txt_vertical;
	private JButton btn_create;
	private JLabel lbl_horizontal, lbl_vertical;
	private JPanel panel_content, panel_footer;
	private Points center;
	//vertexA and vertexB are the horizontal axis points
	//covertexA and covertexB are the vertical axis points
	
	public Ellipse_GUI() {
		setLayout(new BorderLayout(0, 0));
		setPreferredSize(new Dimension(350, 400));
		
		panel_content = new JPanel();
		panel_content.setPreferredSize(new Dimension(350, 350));
		panel_content.setLayout(new MigLayout("", "[][]", "[][]"));
		add(panel_content);
		
		center = new Points("Center", false);
		
		panel_content.add(center, "cell 0 0 2 1");
		
		lbl_horizontal = new JLabel("horizontal distance :");
		panel_content.add(lbl_horizontal, "cell 0 1");
		
		txt_horizontal = new JTextField();
		panel_content.add(txt_horizontal, "cell 1 1");
		txt_horizontal.setColumns(10);
		
		lbl_vertical = new JLabel("vertical distance :");
		panel_content.add(lbl_vertical, "cell 0 2");
		
		txt_vertical = new JTextField();
		panel_content.add(txt_vertical, "cell 1 2");
		txt_vertical.setColumns(10);
		
		
		panel_footer = new JPanel();
		add(panel_footer, BorderLayout.SOUTH);
		panel_footer.setLayout(new BorderLayout(0, 0));
		
		btn_create = new JButton("Create Shape");
		panel_footer.add(btn_create);
		this.repaint();
		this.revalidate();
		
	}

}
