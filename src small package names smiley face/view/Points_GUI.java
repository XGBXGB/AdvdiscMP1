package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;

public class Points_GUI extends Content implements ActionListener {

	private JPanel panel_points;
	private JPanel panel_content;
	private JScrollPane scrollPane;
	private JPanel panel_top;
	private JButton btn_addPoints;
	private ArrayList<Point> pointList;
	private ArrayList<JButton> buttonList;

	public Points_GUI(String title, boolean hasBtn) {
		
		super(title);
		
		pointList = new ArrayList<Point>();
		buttonList = new ArrayList<JButton>();
		
		panel_content = new JPanel();
		super.setContent(panel_content);
		panel_content.setLayout(new BorderLayout(0, 0));
	
		panel_points = new JPanel();
		panel_points.setPreferredSize(new Dimension(330, 500));
		panel_points.setBounds(51, 478, 457, 200);
		panel_points.setLayout(new MigLayout("", "[]", "[][]"));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(350, 300));
		panel_content.add(scrollPane);
		scrollPane.setBorder(null);
		scrollPane.setViewportView(panel_points);

		panel_top = new JPanel();
		panel_content.add(panel_top, BorderLayout.NORTH);

		btn_addPoints = new JButton("Add Point");
		btn_addPoints.setVisible(hasBtn);
		btn_addPoints.addActionListener(this);
		panel_top.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_top.add(btn_addPoints);

		Point p = new Point("Point", false);
		panel_points.add(p, "newline");
		pointList.add(p);
		//System.out.println("BUTTON: "+ p.getButton().getActionCommand());
		p.getButton().addActionListener(this);
		buttonList.add(p.getButton());
		
		//init();
	}

	public void addInitPoints(int size){

		for(int i = 0; i<size; i++){
			Point p = new Point("Point", false);
			panel_points.add(p, "newline");
			pointList.add(p);
			//System.out.println("BUTTON: "+ p.getButton().getActionCommand());
			p.getButton().addActionListener(this);
			buttonList.add(p.getButton());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btn_addPoints){
			Point p = new Point("Point",true);
			panel_points.add(p,"newline");
			pointList.add(p);
			//woooooooooh
			p.getButton().addActionListener(this);
			buttonList.add(p.getButton());
			//wooooooooooh
			this.repaint();
			this.revalidate();
			System.out.println("ADD POINT");
		}
		else if(((JButton) e.getSource()).getActionCommand().equals("delete")){
			System.out.println("Delete POINT");
			int index = buttonList.indexOf(e.getSource());
			buttonList.remove(index);
			panel_points.remove(index);
			pointList.remove(index);
			panel_points.setMaximumSize(new Dimension(360,panel_points.getComponentCount() * 37));
			System.out.println("Delete POINT");
			this.repaint();
			this.revalidate();
		}
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
