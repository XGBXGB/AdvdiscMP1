package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.BevelBorder;
import javax.swing.BoxLayout;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.border.SoftBevelBorder;
import java.awt.FlowLayout;


public class Transformation_GUI extends JPanel{
	private JPanel panel_top, panel_bottom, panel_side, panel_center;
	private JPanel panel_transformation, panel_rotate, panel_scale, panel_translate, panel_shear;
	private JPanel panel_scale_x, panel_scale_y;
	private JPanel panel_shear_x, panel_shear_y;
	private JPanel panel_translate_x, panel_translate_y;
	private JPanel panel_matrix, panel_before_matrix, panel_after_matrix;

	private JLabel lbl_rotate, lbl_rotate_val;
	private JLabel lbl_scale_x, lbl_scale_x_val, lbl_scale_y, lbl_scale_y_val;
	private JLabel lbl_shear_x, lbl_shear_x_val, lbl_shear_y, lbl_shear_y_val;
	private JLabel lbl_translate_x, lbl_translate_x_val, lbl_translate_y, lbl_translate_y_val;
	
	private JSplitPane splitPane;
	
	private JSlider slider_rotate,  slider_scale_x, slider_scale_y,
					slider_shear_x, slider_shear_y, slider_translate_x, slider_translate_y;
	private JPanel panel_menu;
	private JButton btn_change_shape;
	private JButton btn_reset;
	
	public Transformation_GUI() {
		
		super();
		this.setBackground(new Color(255, 255, 255));
		this.setLayout(new BorderLayout(0, 0));
		
		panel_top = new JPanel();
		panel_top.setBackground(new Color(47, 79, 79));
		this.add(panel_top, BorderLayout.NORTH);
		
		panel_bottom = new JPanel();
		panel_bottom.setBackground(new Color(47, 79, 79));
		this.add(panel_bottom, BorderLayout.SOUTH);
		
		panel_side = new JPanel();
		panel_side.setPreferredSize(new Dimension(500, 10));
		panel_side.setBackground(new Color(60, 179, 113));
		this.add(panel_side, BorderLayout.WEST);
		panel_side.setLayout(new BorderLayout(0, 0));
		
		panel_transformation = new JPanel();
		panel_transformation.setBorder(new TitledBorder(null, "Transformation", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_transformation.setBackground(new Color(102, 205, 170));
		panel_side.add(panel_transformation, BorderLayout.CENTER);
		panel_transformation.setLayout(new GridLayout(0, 1, 0, 0));
		
		panel_rotate = new JPanel();
		panel_rotate.setBackground(new Color(102, 205, 170));
		panel_transformation.add(panel_rotate);
		panel_rotate.setLayout(new BorderLayout(0, 0));
		
		lbl_rotate = new JLabel("Rotate");
		lbl_rotate.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_rotate.setPreferredSize(new Dimension(75, 14));
		lbl_rotate.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_rotate.add(lbl_rotate, BorderLayout.WEST);
		
		lbl_rotate_val = new JLabel("0");
		lbl_rotate_val.setPreferredSize(new Dimension(10, 14));
		lbl_rotate_val.setHorizontalTextPosition(SwingConstants.LEFT);
		lbl_rotate_val.setHorizontalAlignment(SwingConstants.CENTER);
		panel_rotate.add(lbl_rotate_val, BorderLayout.CENTER);
		
		slider_rotate = new JSlider();
		slider_rotate.setBackground(new Color(102, 205, 170));
		slider_rotate.setPreferredSize(new Dimension(360, 26));
		slider_rotate.setPaintLabels(true);
		panel_rotate.add(slider_rotate, BorderLayout.EAST);
		
		panel_scale = new JPanel();
		panel_transformation.add(panel_scale);
		panel_scale.setLayout(new BorderLayout(0, 0));
		
		panel_scale_x = new JPanel();
		panel_scale_x.setBackground(new Color(102, 205, 170));
		panel_scale.add(panel_scale_x, BorderLayout.NORTH);
		panel_scale_x.setLayout(new BorderLayout(0, 0));
		
		lbl_scale_x = new JLabel("Scale X ");
		lbl_scale_x.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_scale_x.setMaximumSize(new Dimension(40, 14));
		lbl_scale_x.setPreferredSize(new Dimension(75, 15));
		lbl_scale_x.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_scale_x.add(lbl_scale_x, BorderLayout.WEST);
		
		lbl_scale_x_val = new JLabel("0");
		lbl_scale_x_val.setPreferredSize(new Dimension(10, 14));
		lbl_scale_x_val.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_scale_x_val.setHorizontalTextPosition(SwingConstants.LEFT);
		panel_scale_x.add(lbl_scale_x_val, BorderLayout.CENTER);
		
		slider_scale_x = new JSlider();
		slider_scale_x.setBackground(new Color(102, 205, 170));
		slider_scale_x.setPaintLabels(true);
		slider_scale_x.setPreferredSize(new Dimension(360, 26));
		panel_scale_x.add(slider_scale_x, BorderLayout.EAST);
		
		panel_scale_y = new JPanel();
		panel_scale_y.setBackground(new Color(102, 205, 170));
		panel_scale.add(panel_scale_y, BorderLayout.CENTER);
		panel_scale_y.setLayout(new BorderLayout(0, 0));
		
		lbl_scale_y = new JLabel("Scale Y");
		lbl_scale_y.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_scale_y.setPreferredSize(new Dimension(75, 15));
		lbl_scale_y.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_scale_y.add(lbl_scale_y, BorderLayout.WEST);
		
		lbl_scale_y_val = new JLabel("0");
		lbl_scale_y_val.setPreferredSize(new Dimension(10, 14));
		lbl_scale_y_val.setHorizontalTextPosition(SwingConstants.LEFT);
		lbl_scale_y_val.setHorizontalAlignment(SwingConstants.CENTER);
		panel_scale_y.add(lbl_scale_y_val, BorderLayout.CENTER);
		
		slider_scale_y = new JSlider();
		slider_scale_y.setBackground(new Color(102, 205, 170));
		slider_scale_y.setPreferredSize(new Dimension(360, 26));
		panel_scale_y.add(slider_scale_y, BorderLayout.EAST);
		
		panel_shear = new JPanel();
		panel_transformation.add(panel_shear);
		panel_shear.setLayout(new BorderLayout(0, 0));
		
		panel_shear_x = new JPanel();
		panel_shear_x.setBackground(new Color(102, 205, 170));
		panel_shear.add(panel_shear_x, BorderLayout.NORTH);
		panel_shear_x.setLayout(new BorderLayout(0, 0));
		
		lbl_shear_x = new JLabel("Shear X ");
		lbl_shear_x.setHorizontalAlignment(SwingConstants.LEFT);
		panel_shear_x.add(lbl_shear_x, BorderLayout.WEST);
		lbl_shear_x.setPreferredSize(new Dimension(75, 15));
		lbl_shear_x.setMaximumSize(new Dimension(40, 14));
		lbl_shear_x.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		lbl_shear_x_val = new JLabel("0");
		lbl_shear_x_val.setPreferredSize(new Dimension(10, 14));
		panel_shear_x.add(lbl_shear_x_val, BorderLayout.CENTER);
		lbl_shear_x_val.setHorizontalTextPosition(SwingConstants.LEFT);
		lbl_shear_x_val.setHorizontalAlignment(SwingConstants.CENTER);
		
		slider_shear_x = new JSlider();
		slider_shear_x.setBackground(new Color(102, 205, 170));
		panel_shear_x.add(slider_shear_x, BorderLayout.EAST);
		slider_shear_x.setPreferredSize(new Dimension(360, 26));
		
		panel_shear_y = new JPanel();
		panel_shear_y.setBackground(new Color(102, 205, 170));
		panel_shear.add(panel_shear_y, BorderLayout.CENTER);
		panel_shear_y.setLayout(new BorderLayout(0, 0));
		
		lbl_shear_y = new JLabel("Shear Y");
		lbl_shear_y.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_shear_y.setPreferredSize(new Dimension(75, 15));
		lbl_shear_y.setMaximumSize(new Dimension(40, 14));
		lbl_shear_y.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_shear_y.add(lbl_shear_y, BorderLayout.WEST);
		
		lbl_shear_y_val = new JLabel("0");
		lbl_shear_y_val.setPreferredSize(new Dimension(10, 14));
		lbl_shear_y_val.setHorizontalTextPosition(SwingConstants.LEFT);
		lbl_shear_y_val.setHorizontalAlignment(SwingConstants.CENTER);
		panel_shear_y.add(lbl_shear_y_val, BorderLayout.CENTER);
		
		slider_shear_y = new JSlider();
		slider_shear_y.setBackground(new Color(102, 205, 170));
		slider_shear_y.setPreferredSize(new Dimension(360, 26));
		panel_shear_y.add(slider_shear_y, BorderLayout.EAST);
		
		panel_translate = new JPanel();
		panel_transformation.add(panel_translate);
		panel_translate.setLayout(new BorderLayout(0, 0));
		
		panel_translate_x = new JPanel();
		panel_translate_x.setBackground(new Color(102, 205, 170));
		panel_translate.add(panel_translate_x, BorderLayout.NORTH);
		panel_translate_x.setLayout(new BorderLayout(0, 0));
		
		lbl_translate_x = new JLabel("Translate X");
		lbl_translate_x.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_translate_x.setPreferredSize(new Dimension(75, 15));
		lbl_translate_x.setMaximumSize(new Dimension(40, 14));
		lbl_translate_x.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_translate_x.add(lbl_translate_x, BorderLayout.WEST);
		
		lbl_translate_x_val = new JLabel("0");
		lbl_translate_x_val.setPreferredSize(new Dimension(10, 14));
		lbl_translate_x_val.setHorizontalTextPosition(SwingConstants.LEFT);
		lbl_translate_x_val.setHorizontalAlignment(SwingConstants.CENTER);
		panel_translate_x.add(lbl_translate_x_val, BorderLayout.CENTER);
		
		slider_translate_x = new JSlider();
		slider_translate_x.setBackground(new Color(102, 205, 170));
		slider_translate_x.setPreferredSize(new Dimension(360, 26));
		panel_translate_x.add(slider_translate_x, BorderLayout.EAST);
		
		panel_translate_y = new JPanel();
		panel_translate_y.setBackground(new Color(102, 205, 170));
		panel_translate.add(panel_translate_y, BorderLayout.CENTER);
		panel_translate_y.setLayout(new BorderLayout(0, 0));
		
		lbl_translate_y = new JLabel("Translate Y");
		lbl_translate_y.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_translate_y.setPreferredSize(new Dimension(75, 15));
		lbl_translate_y.setMaximumSize(new Dimension(40, 14));
		lbl_translate_y.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_translate_y.add(lbl_translate_y, BorderLayout.WEST);
		
		lbl_translate_y_val = new JLabel("0");
		lbl_translate_y_val.setPreferredSize(new Dimension(10, 14));
		lbl_translate_y_val.setHorizontalTextPosition(SwingConstants.LEFT);
		lbl_translate_y_val.setHorizontalAlignment(SwingConstants.CENTER);
		panel_translate_y.add(lbl_translate_y_val, BorderLayout.CENTER);
		
		slider_translate_y = new JSlider();
		slider_translate_y.setBackground(new Color(102, 205, 170));
		slider_translate_y.setPreferredSize(new Dimension(360, 26));
		panel_translate_y.add(slider_translate_y, BorderLayout.EAST);
		
		panel_matrix = new JPanel();
		panel_matrix.setBorder(new TitledBorder(null, "Matrix Result", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_matrix.setBackground(new Color(32, 178, 170));
		panel_matrix.setPreferredSize(new Dimension(250, 350));
		panel_side.add(panel_matrix, BorderLayout.SOUTH);
		panel_matrix.setLayout(new BorderLayout(0, 0));
		
		splitPane = new JSplitPane();
		splitPane.setPreferredSize(new Dimension(179, 50));
		panel_matrix.add(splitPane);
		
		panel_before_matrix = new JPanel();
		panel_before_matrix.setBackground(new Color(255, 255, 255));
		panel_before_matrix.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Before", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_before_matrix.setPreferredSize(new Dimension(220, 10));
		splitPane.setLeftComponent(panel_before_matrix);
		
		panel_after_matrix = new JPanel();
		panel_after_matrix.setBackground(new Color(255, 255, 255));
		splitPane.setRightComponent(panel_after_matrix);
		panel_after_matrix.setPreferredSize(new Dimension(200, 10));
		panel_after_matrix.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "After", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		panel_menu = new JPanel();
		panel_menu.setBackground(new Color(135, 206, 250));
		panel_menu.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_menu.setPreferredSize(new Dimension(10, 50));
		panel_side.add(panel_menu, BorderLayout.NORTH);
		panel_menu.setLayout(new GridLayout(0, 2, 0, 0));
		
		btn_change_shape = new JButton("Change Shape");
		btn_change_shape.setBackground(new Color(255, 255, 255));
		btn_change_shape.setPreferredSize(new Dimension(103, 25));
		panel_menu.add(btn_change_shape);
		
		btn_reset = new JButton("Reset");
		btn_reset.setBackground(new Color(255, 255, 255));
		btn_reset.setPreferredSize(new Dimension(61, 25));
		panel_menu.add(btn_reset);
		
		panel_center = new JPanel();
		panel_center.setBackground(new Color(255, 255, 255));
		panel_center.setBorder(new TitledBorder(null, "Grid", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.add(panel_center, BorderLayout.CENTER);
		
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
//		this.setResizable(false);
//		this.setTitle("ADVDISC MP1");
	}

}
