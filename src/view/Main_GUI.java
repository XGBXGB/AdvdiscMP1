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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;


public class Main_GUI extends JFrame {
	
	private JPanel panel_top, panel_center, panel_bottom;
	private JPanel panel_shape_info, panel_choose_shape, panel_grid, panel_east, panel_west;
	private JPanel panel_shape_details;
	private JLabel lbl_header, lbl_footer, lbl_shape;
	private JSplitPane splitPane;
	private JComboBox cmb_shape;
	private CardLayout cardLayout;
	
	public Main_GUI() {
		
		super();
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		panel_top = new JPanel();
		panel_top.setBackground(Color.DARK_GRAY);
		panel_top.setPreferredSize(new Dimension(10, 55));
		getContentPane().add(panel_top, BorderLayout.NORTH);
		panel_top.setLayout(new BorderLayout(0, 0));
		
		lbl_header = new JLabel("Use of Matrices in Computer Graphics");
		lbl_header.setForeground(Color.WHITE);
		lbl_header.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl_header.setHorizontalAlignment(SwingConstants.CENTER);
		panel_top.add(lbl_header);
		
		panel_bottom = new JPanel();
		panel_bottom.setBackground(Color.DARK_GRAY);
		panel_bottom.setPreferredSize(new Dimension(10, 45));
		getContentPane().add(panel_bottom, BorderLayout.SOUTH);
		panel_bottom.setLayout(new BorderLayout(0, 0));
		
		lbl_footer = new JLabel("Cote. Erive. Seo. Tan 2015");
		lbl_footer.setForeground(Color.WHITE);
		lbl_footer.setBackground(Color.DARK_GRAY);
		lbl_footer.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_footer.setHorizontalAlignment(SwingConstants.CENTER);
		panel_bottom.add(lbl_footer);
		
		panel_center = new JPanel();
		getContentPane().add(panel_center, BorderLayout.CENTER);
		panel_center.setLayout(new BorderLayout(0, 0));
		
		splitPane = new JSplitPane();
		splitPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		splitPane.setBackground(Color.DARK_GRAY);
		panel_center.add(splitPane, BorderLayout.CENTER);
		
		panel_shape_info = new JPanel();
		panel_shape_info.setPreferredSize(new Dimension(400, 10));
		splitPane.setLeftComponent(panel_shape_info);
		panel_shape_info.setLayout(new BorderLayout(0, 0));
		
		panel_choose_shape = new JPanel();
		panel_choose_shape.setBackground(SystemColor.inactiveCaptionBorder);
		panel_choose_shape.setBorder(new TitledBorder(null, "Shape Selection", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_shape_info.add(panel_choose_shape, BorderLayout.NORTH);
		panel_choose_shape.setLayout(new BorderLayout(0, 0));
		
		lbl_shape = new JLabel("Choose Shape :");
		lbl_shape.setPreferredSize(new Dimension(100, 14));
		panel_choose_shape.add(lbl_shape, BorderLayout.WEST);
		
		cmb_shape = new JComboBox();
		cmb_shape.addItemListener(new ItemChangeListener());
		cmb_shape.setModel(new DefaultComboBoxModel(new String[] {"Line Segments", "Vectors", "Polygon", "Circle", "Ellipse", "Parabola", "Hyperbola"}));
		cmb_shape.setBackground(SystemColor.window);
		panel_choose_shape.add(cmb_shape, BorderLayout.CENTER);
		
		cardLayout = new CardLayout();
		
		panel_shape_details = new JPanel();
		panel_shape_details.setLayout(cardLayout);
		panel_shape_details.setBackground(SystemColor.inactiveCaptionBorder);
		panel_shape_details.setBorder(new TitledBorder(null, "Shape Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_shape_info.add(panel_shape_details, BorderLayout.CENTER);
		
		panel_grid = new JPanel();
		panel_grid.setBackground(SystemColor.window);
		panel_grid.setBorder(new TitledBorder(null, "Shape Preview", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		splitPane.setRightComponent(panel_grid);
		
		panel_east = new JPanel();
		panel_east.setBackground(Color.DARK_GRAY);
		getContentPane().add(panel_east, BorderLayout.EAST);
		
		panel_west = new JPanel();
		panel_west.setBackground(Color.DARK_GRAY);
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
		
		init();
		this.repaint();
		this.revalidate();
	}

		public void init(){
			
			Content c = new Content("Polygon", new Polygon_GUI());
			panel_shape_details.add(c, "Polygon");
			
			c = new Content("Circle", new Circle_GUI());
			panel_shape_details.add(c, "Circle");
			cardLayout.show(panel_shape_details, null);
		}
		
		class ItemChangeListener implements ItemListener {

		    @Override
		    public void itemStateChanged(ItemEvent event) {
		        if (event.getStateChange() == ItemEvent.SELECTED) {
		            if (event.getSource() == cmb_shape) {
		            	cardLayout.show(panel_shape_details, cmb_shape.getSelectedItem().toString());
		            	System.out.println("Item: "+  cmb_shape.getSelectedItem().toString());
		            }
		        }
		    }
		}
}

