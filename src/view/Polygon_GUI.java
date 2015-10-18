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

public class Polygon_GUI extends JPanel implements ActionListener {
	
	private JPanel panel_points, panel_footer, panel_content;
	private JButton btn_create;
	private JScrollPane scrollPane;
	private JPanel panel_top;
	private JButton btn_addPoints;
	private ArrayList<Points> pointList;
	private ArrayList<JButton> buttonList;
	
	public Polygon_GUI() {
		setPreferredSize(new Dimension(500, 500));
		setLayout(new BorderLayout(0, 0));
		pointList = new ArrayList<Points>();
		buttonList = new ArrayList<JButton>();
		
		panel_content = new JPanel();
		add(panel_content);
		
		panel_points = new JPanel();
		panel_points.setPreferredSize(new Dimension(330, 500));
		panel_points.setBackground(Color.WHITE);
		panel_points.setBounds(51, 478, 457, 200);
		panel_points.setLayout(new MigLayout("", "[]", "[][]"));
	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(350, 350));
		panel_content.add(scrollPane);
		scrollPane.setBorder(null);
		scrollPane.setViewportView(panel_points);
		
		panel_footer = new JPanel();
		panel_footer.setMinimumSize(new Dimension(10, 15));
		add(panel_footer, BorderLayout.SOUTH);
		panel_footer.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btn_create = new JButton("Create Shape");
		btn_create.setMinimumSize(new Dimension(99, 25));
		panel_footer.add(btn_create);
		
		panel_top = new JPanel();
		add(panel_top, BorderLayout.NORTH);
		
		btn_addPoints = new JButton("Add Point");
		btn_addPoints.addActionListener(this);
		panel_top.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_top.add(btn_addPoints);
		
		init();
	}

	public void init(){
		
		for(int i = 0; i<3; i++){
			Points p = new Points("Point", false);
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
		          System.out.println("asdasdadasd");
		if(e.getSource() == btn_addPoints){
			Points p = new Points("Point",true);
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
}
