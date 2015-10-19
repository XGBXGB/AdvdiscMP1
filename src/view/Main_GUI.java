package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;

import javax.swing.JSplitPane;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;

import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;



public class Main_GUI extends JFrame implements ActionListener {
	
	private JPanel panel_top, panel_center, panel_bottom;
	private JPanel panel_shape_info, panel_choose_shape, panel_grid, panel_east, panel_west;
	private JPanel panel_shape_details;
	private JLabel lbl_header, lbl_footer, lbl_shape;
	private JSplitPane splitPane;
	private JComboBox cmb_shape;
	private HashMap<String, Content> contentList;
	private CardLayout cl_shape;
	private CardLayout cl_main_content;
	public Main_GUI() {
		
		super();
		contentList = new HashMap<String, Content>();
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		panel_top = new JPanel();
		panel_top.setBackground(new Color(32, 178, 170));
		panel_top.setPreferredSize(new Dimension(10, 40));
		getContentPane().add(panel_top, BorderLayout.NORTH);
		panel_top.setLayout(new BorderLayout(0, 0));
		
		lbl_header = new JLabel("Use of Matrices in Computer Graphics");
		lbl_header.setForeground(Color.WHITE);
		lbl_header.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_header.setHorizontalAlignment(SwingConstants.CENTER);
		panel_top.add(lbl_header);
		
		panel_bottom = new JPanel();
		panel_bottom.setBackground(new Color(32, 178, 170));
		panel_bottom.setPreferredSize(new Dimension(10, 30));
		getContentPane().add(panel_bottom, BorderLayout.SOUTH);
		panel_bottom.setLayout(new BorderLayout(0, 0));
		
		lbl_footer = new JLabel("Cote. Erive. Seo. Tan 2015");
		lbl_footer.setForeground(Color.WHITE);
		lbl_footer.setBackground(Color.DARK_GRAY);
		lbl_footer.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_footer.setHorizontalAlignment(SwingConstants.CENTER);
		panel_bottom.add(lbl_footer);
		
		cl_main_content = new CardLayout();
		
		panel_center = new JPanel();
		panel_center.setBackground(new Color(47, 79, 79));
		getContentPane().add(panel_center, BorderLayout.CENTER);
		panel_center.setLayout(cl_main_content);
		
		splitPane = new JSplitPane();
		splitPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		splitPane.setBackground(Color.DARK_GRAY);
		panel_center.add("Main",splitPane);
		
		Transformation_GUI t = new Transformation_GUI(cl_main_content, panel_center);
		panel_center.add("Transformation",t);
		
		panel_shape_info = new JPanel();
		panel_shape_info.setPreferredSize(new Dimension(400, 10));
		splitPane.setLeftComponent(panel_shape_info);
		panel_shape_info.setLayout(new BorderLayout(0, 0));
		
		panel_choose_shape = new JPanel();
		panel_choose_shape.setMinimumSize(new Dimension(10, 60));
		panel_choose_shape.setBackground(SystemColor.inactiveCaptionBorder);
		panel_choose_shape.setBorder(new TitledBorder(null, "Shape Selection", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_shape_info.add(panel_choose_shape, BorderLayout.NORTH);
		panel_choose_shape.setLayout(new BorderLayout(0, 0));
		
		lbl_shape = new JLabel("Choose Shape :");
		lbl_shape.setPreferredSize(new Dimension(100, 14));
		panel_choose_shape.add(lbl_shape, BorderLayout.WEST);
		
		cmb_shape = new JComboBox();
		cmb_shape.addItemListener(new ItemChangeListener());
		cmb_shape.setModel(new DefaultComboBoxModel(new String[] {"Vector", "Line Segment", "Polygon", "Circle", "Ellipse", "Parabola", "Hyperbola"}));
		cmb_shape.setBackground(SystemColor.window);
		panel_choose_shape.add(cmb_shape, BorderLayout.CENTER);
		
		cl_shape = new CardLayout();
		
		panel_shape_details = new JPanel();
		panel_shape_details.setLayout(cl_shape);
		panel_shape_details.setBackground(SystemColor.inactiveCaptionBorder);
		panel_shape_details.setBorder(new TitledBorder(null, "Shape Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_shape_info.add(panel_shape_details, BorderLayout.CENTER);
		
		panel_grid = new Grid(560,510,40,40);
		panel_grid.setBackground(SystemColor.window);
		panel_grid.setBorder(new TitledBorder(null, "Shape Preview", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		splitPane.setRightComponent(panel_grid);
		
		panel_east = new JPanel();
		panel_east.setBackground(new Color(32, 178, 170));
		getContentPane().add(panel_east, BorderLayout.EAST);
		
		panel_west = new JPanel();
		panel_west.setBackground(new Color(32, 178, 170));
		getContentPane().add(panel_west, BorderLayout.WEST);
		
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize((int)(screenSize.width/1.2), (int)(screenSize.height/1.1));
		this.setVisible(true);
		this.setResizable(false);
		this.setTitle("ADVDISC MP1");
		
		cl_main_content.show(panel_center,"Main");
		init();
		this.repaint();
		this.revalidate();
	}

		public void init(){
			
			TwoPoints_GUI t = new TwoPoints_GUI();
			t.setCaption("Vector");
			t.getButtonCreate().addActionListener(this);
			panel_shape_details.add(t, "Vector");
			contentList.put("Vector", t);
			
			t = new TwoPoints_GUI();
			t.setCaption("Line Segment");
			t.getButtonCreate().addActionListener(this);
			panel_shape_details.add(t, "Line Segment");
			contentList.put("Line Segment", t);
			
			Polygon_GUI p = new Polygon_GUI();
			p.getButtonCreate().addActionListener(this);
			panel_shape_details.add(p, "Polygon");
			contentList.put("Polygon", p);
			
			Circle_GUI c = new Circle_GUI();
			c.getButtonCreate().addActionListener(this);
			panel_shape_details.add(c, "Circle");
			contentList.put("Circle", c);
			
			Ellipse_GUI e = new Ellipse_GUI();
			e.getButtonCreate().addActionListener(this);
			panel_shape_details.add(e, "Ellipse");
			contentList.put("Ellipse", e);
			
			Parabola_GUI b = new Parabola_GUI();
			b.getButtonCreate().addActionListener(this);
			panel_shape_details.add(b, "Parabola");
			contentList.put("Parabola", b);
			
			Hyperbola_GUI h = new Hyperbola_GUI();
			h.getButtonCreate().addActionListener(this);
			panel_shape_details.add(h, "Hyperbola");
			contentList.put("Hyperbola", h);
			
			cl_shape.show(panel_shape_details, "Vector");
		}
		
		class ItemChangeListener implements ItemListener {

		    @Override
		    public void itemStateChanged(ItemEvent event) {
		        if (event.getStateChange() == ItemEvent.SELECTED) {
		            if (event.getSource() == cmb_shape) {
		            	cl_shape.show(panel_shape_details, cmb_shape.getSelectedItem().toString());
		            	System.out.println("Item: "+  cmb_shape.getSelectedItem().toString());
		            }
		        }
		    }
		}

		@Override
		public void actionPerformed(ActionEvent a) {
			// TODO Auto-generated method stub
			if(((JButton) a.getSource()).getActionCommand().equals("create")){
				
				
				contentList.get(cmb_shape.getSelectedItem().toString()).createShape();
				cl_main_content.show(panel_center, "Transformation");
				contentList.get(cmb_shape.getSelectedItem().toString()).clear();
				
			}
		}
}

