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

import controller.GraphicObjectController;
import model.Point;
import model.graphic_objects.GraphicObject;
import model.graphic_objects.LineSegment;
import model.graphic_objects.List_of_Points;
import model.graphic_objects.Polygon;
import model.graphic_objects.Vector;
import net.miginfocom.swing.MigLayout;

import java.awt.FlowLayout;

public class Points_GUI extends Content implements ActionListener {

	private JPanel panel_points;
	private JPanel panel_content;
	private JScrollPane scrollPane;
	private JPanel panel_top;
	private JButton btn_addPoints;
	private ArrayList<Point_GUI> pointList;
	private ArrayList<JButton> buttonList;
	private GraphicObjectController sCon;
	private String title;
	public Points_GUI(String title, boolean hasBtn) {
		
		super(title);
		this.title = title;
		sCon = GraphicObjectController.getInstance();
		
		pointList = new ArrayList<Point_GUI>();
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

		Point_GUI p = new Point_GUI("Point", false);
		panel_points.add(p, "newline");
		pointList.add(p);
		//System.out.println("BUTTON: "+ p.getButton().getActionCommand());
		p.getButton().addActionListener(this);
		buttonList.add(p.getButton());
		
		//init();
	}

	public Point_GUI getPoint(int index){
		return (Point_GUI)pointList.get(index);
	}
	public void addInitPoints(int size){

		for(int i = 0; i<size; i++){
			Point_GUI p = new Point_GUI("Point", false);
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
			Point_GUI p = new Point_GUI("Point",true);
			panel_points.add(p,"newline");
			pointList.add(p);
			p.getButton().addActionListener(this);
			buttonList.add(p.getButton());
			this.repaint();
			this.revalidate();
		}
		else if(((JButton) e.getSource()).getActionCommand().equals("delete")){
		
			int index = buttonList.indexOf(e.getSource());
			buttonList.remove(index);
			panel_points.remove(index);
			pointList.remove(index);
			panel_points.setMaximumSize(new Dimension(360,panel_points.getComponentCount() * 37));
		
			this.repaint();
			this.revalidate();
		}
	}

	@Override
	public void createShape() {
		// TODO Auto-generated method stub
		ArrayList<Point> pList = new ArrayList<Point>();
		
		for(int i = 0; i<pointList.size(); i++){
			Point p = new Point(Double.parseDouble(pointList.get(i).getXValue()), 
								Double.parseDouble(pointList.get(i).getYValue()));
			pList.add(p);
		}
		GraphicObject go = null;
		if(title.equals("Vector")){
			go = new Vector();		
		}else if(title.equals("Line Segment")){
			go = new LineSegment();
		}
		else if(title.equals("Polygon")){
			go = new Polygon();
		}else{
			go = new List_of_Points();
		}
		
		System.out.println("POINTS Create Graphic Object");
		go.setPoints(pList.iterator());
		go.setColor(Color.BLACK);
		sCon.setOriginalObject(go);
		sCon.setTransformedObject(go.clone());
		clear();
	}

	@Override
	public void clear() {
		int min;
		for(int i = 0; i<pointList.size(); i++){
			pointList.get(i).clear();
		}
		
		if(title.equals("Polygon") || title.equals("Point(s)")){
			if(title.equals("Polygon")){
				min = 3;
			}else
				min = 1;
			
			System.out.println("HELLO PASOK");
			for(int i = pointList.size()-1; i>= min; i--){
				buttonList.remove(i);
				panel_points.remove(i);
				pointList.remove(i);
				panel_points.setMaximumSize(new Dimension(360,panel_points.getComponentCount() * 37));
			
				this.repaint();
				this.revalidate();
			}
		}
		
	}
}
