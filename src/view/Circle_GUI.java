package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class Circle_GUI extends JPanel{
	private JTextField txt_radius;
	private JButton btn_create;
	private JLabel lbl_radius;
	private JPanel panel_content, panel_footer;
	private Points center;
	
	public Circle_GUI() {
		setLayout(new BorderLayout(0, 0));
		setPreferredSize(new Dimension(350, 400));
		
		panel_content = new JPanel();
		panel_content.setPreferredSize(new Dimension(350, 350));
		panel_content.setLayout(new MigLayout("", "[][]", "[][]"));
		add(panel_content);
		
		center = new Points("Center", false);
		panel_content.add(center, "cell 0 0 2 1");
		
		lbl_radius = new JLabel("Radius :");
		panel_content.add(lbl_radius, "cell 0 1");
		
		txt_radius = new JTextField();
		panel_content.add(txt_radius, "cell 1 1");
		txt_radius.setColumns(10);
		
		panel_footer = new JPanel();
		add(panel_footer, BorderLayout.SOUTH);
		panel_footer.setLayout(new BorderLayout(0, 0));
		
		btn_create = new JButton("Create Shape");
		panel_footer.add(btn_create);
		this.repaint();
		this.revalidate();
		
	}

}
