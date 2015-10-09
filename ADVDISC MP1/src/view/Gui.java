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
import java.awt.Toolkit;

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


public class Gui extends JFrame{
	
	public Gui() {
		super();
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel_top = new JPanel();
		panel_top.setBackground(new Color(47, 79, 79));
		getContentPane().add(panel_top, BorderLayout.NORTH);
		
		JPanel panel_bottom = new JPanel();
		panel_bottom.setBackground(new Color(47, 79, 79));
		getContentPane().add(panel_bottom, BorderLayout.SOUTH);
		
		JPanel panel_side = new JPanel();
		panel_side.setPreferredSize(new Dimension(500, 10));
		panel_side.setBackground(new Color(60, 179, 113));
		getContentPane().add(panel_side, BorderLayout.WEST);
		panel_side.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_shape = new JPanel();
		panel_shape.setBorder(new TitledBorder(null, "Shape Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_shape.setBackground(new Color(176, 224, 230));
		panel_shape.setPreferredSize(new Dimension(10, 80));
		panel_side.add(panel_shape, BorderLayout.NORTH);
		panel_shape.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_choose_shape = new JPanel();
		panel_choose_shape.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_choose_shape.setPreferredSize(new Dimension(200, 10));
		panel_shape.add(panel_choose_shape, BorderLayout.WEST);
		
		JPanel panel_shape_info = new JPanel();
		panel_shape_info.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_shape.add(panel_shape_info, BorderLayout.CENTER);
		
		JPanel panel_transformation = new JPanel();
		panel_transformation.setBorder(new TitledBorder(null, "Transformation", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_transformation.setBackground(new Color(102, 205, 170));
		panel_side.add(panel_transformation, BorderLayout.CENTER);
		panel_transformation.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_rotate = new JPanel();
		panel_transformation.add(panel_rotate);
		panel_rotate.setLayout(new BorderLayout(0, 0));
		
		JLabel lbl_rotate = new JLabel("Rotate");
		lbl_rotate.setPreferredSize(new Dimension(75, 14));
		lbl_rotate.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_rotate.add(lbl_rotate, BorderLayout.WEST);
		
		JLabel lbl_rotate_val = new JLabel("0");
		lbl_rotate_val.setPreferredSize(new Dimension(5, 15));
		lbl_rotate_val.setMinimumSize(new Dimension(5, 14));
		lbl_rotate_val.setMaximumSize(new Dimension(5, 14));
		lbl_rotate_val.setHorizontalTextPosition(SwingConstants.LEFT);
		lbl_rotate_val.setHorizontalAlignment(SwingConstants.CENTER);
		panel_rotate.add(lbl_rotate_val, BorderLayout.CENTER);
		
		JSlider slider_rotate = new JSlider();
		slider_rotate.setPreferredSize(new Dimension(400, 26));
		slider_rotate.setPaintLabels(true);
		panel_rotate.add(slider_rotate, BorderLayout.EAST);
		
		JPanel panel_scale = new JPanel();
		panel_transformation.add(panel_scale);
		panel_scale.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_scale_x = new JPanel();
		panel_scale.add(panel_scale_x, BorderLayout.NORTH);
		panel_scale_x.setLayout(new BorderLayout(0, 0));
		
		JLabel lbl_scale_x = new JLabel("Scale X ");
		lbl_scale_x.setMaximumSize(new Dimension(40, 14));
		lbl_scale_x.setPreferredSize(new Dimension(75, 15));
		lbl_scale_x.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_scale_x.add(lbl_scale_x, BorderLayout.WEST);
		
		JLabel lbl_scale_x_val = new JLabel("0");
		lbl_scale_x_val.setMaximumSize(new Dimension(5, 14));
		lbl_scale_x_val.setMinimumSize(new Dimension(5, 14));
		lbl_scale_x_val.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_scale_x_val.setHorizontalTextPosition(SwingConstants.LEFT);
		lbl_scale_x_val.setPreferredSize(new Dimension(5, 15));
		panel_scale_x.add(lbl_scale_x_val, BorderLayout.CENTER);
		
		JSlider slider_scale_x = new JSlider();
		slider_scale_x.setPaintLabels(true);
		slider_scale_x.setPreferredSize(new Dimension(400, 26));
		panel_scale_x.add(slider_scale_x, BorderLayout.EAST);
		
		JPanel panel_scale_y = new JPanel();
		panel_scale.add(panel_scale_y, BorderLayout.CENTER);
		panel_scale_y.setLayout(new BorderLayout(0, 0));
		
		JLabel lbl_scale_y = new JLabel("Scale Y");
		lbl_scale_y.setPreferredSize(new Dimension(75, 15));
		lbl_scale_y.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_scale_y.add(lbl_scale_y, BorderLayout.WEST);
		
		JLabel lbl_scale_y_val = new JLabel("0");
		lbl_scale_y_val.setPreferredSize(new Dimension(5, 15));
		lbl_scale_y_val.setMinimumSize(new Dimension(5, 14));
		lbl_scale_y_val.setMaximumSize(new Dimension(5, 14));
		lbl_scale_y_val.setHorizontalTextPosition(SwingConstants.LEFT);
		lbl_scale_y_val.setHorizontalAlignment(SwingConstants.CENTER);
		panel_scale_y.add(lbl_scale_y_val, BorderLayout.CENTER);
		
		JSlider slider_scale_y = new JSlider();
		slider_scale_y.setPreferredSize(new Dimension(400, 26));
		panel_scale_y.add(slider_scale_y, BorderLayout.EAST);
		
		JPanel panel_shear = new JPanel();
		panel_transformation.add(panel_shear);
		panel_shear.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_shear_x = new JPanel();
		panel_shear.add(panel_shear_x, BorderLayout.NORTH);
		panel_shear_x.setLayout(new BorderLayout(0, 0));
		
		JLabel lbl_shear_x = new JLabel("Shear X ");
		panel_shear_x.add(lbl_shear_x, BorderLayout.WEST);
		lbl_shear_x.setPreferredSize(new Dimension(75, 15));
		lbl_shear_x.setMaximumSize(new Dimension(40, 14));
		lbl_shear_x.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lbl_shear_x_val = new JLabel("0");
		panel_shear_x.add(lbl_shear_x_val, BorderLayout.CENTER);
		lbl_shear_x_val.setPreferredSize(new Dimension(5, 15));
		lbl_shear_x_val.setMinimumSize(new Dimension(5, 14));
		lbl_shear_x_val.setMaximumSize(new Dimension(5, 14));
		lbl_shear_x_val.setHorizontalTextPosition(SwingConstants.LEFT);
		lbl_shear_x_val.setHorizontalAlignment(SwingConstants.CENTER);
		
		JSlider slider_shear_x = new JSlider();
		panel_shear_x.add(slider_shear_x, BorderLayout.EAST);
		slider_shear_x.setPreferredSize(new Dimension(400, 26));
		
		JPanel panel_shear_y = new JPanel();
		panel_shear.add(panel_shear_y, BorderLayout.CENTER);
		panel_shear_y.setLayout(new BorderLayout(0, 0));
		
		JLabel lbl_shear_y = new JLabel("Shear Y");
		lbl_shear_y.setPreferredSize(new Dimension(75, 15));
		lbl_shear_y.setMaximumSize(new Dimension(40, 14));
		lbl_shear_y.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_shear_y.add(lbl_shear_y, BorderLayout.WEST);
		
		JLabel lbl_shear_y_val = new JLabel("0");
		lbl_shear_y_val.setPreferredSize(new Dimension(5, 15));
		lbl_shear_y_val.setMinimumSize(new Dimension(5, 14));
		lbl_shear_y_val.setMaximumSize(new Dimension(5, 14));
		lbl_shear_y_val.setHorizontalTextPosition(SwingConstants.LEFT);
		lbl_shear_y_val.setHorizontalAlignment(SwingConstants.CENTER);
		panel_shear_y.add(lbl_shear_y_val, BorderLayout.CENTER);
		
		JSlider slider_shear_y = new JSlider();
		slider_shear_y.setPreferredSize(new Dimension(400, 26));
		panel_shear_y.add(slider_shear_y, BorderLayout.EAST);
		
		JPanel panel_translate = new JPanel();
		panel_transformation.add(panel_translate);
		panel_translate.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_translate_x = new JPanel();
		panel_translate.add(panel_translate_x, BorderLayout.NORTH);
		panel_translate_x.setLayout(new BorderLayout(0, 0));
		
		JLabel lbl_translate_x = new JLabel("Translate X");
		lbl_translate_x.setPreferredSize(new Dimension(75, 15));
		lbl_translate_x.setMaximumSize(new Dimension(40, 14));
		lbl_translate_x.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_translate_x.add(lbl_translate_x, BorderLayout.WEST);
		
		JLabel label_translate_x_val = new JLabel("0");
		label_translate_x_val.setPreferredSize(new Dimension(5, 15));
		label_translate_x_val.setMinimumSize(new Dimension(5, 14));
		label_translate_x_val.setMaximumSize(new Dimension(5, 14));
		label_translate_x_val.setHorizontalTextPosition(SwingConstants.LEFT);
		label_translate_x_val.setHorizontalAlignment(SwingConstants.CENTER);
		panel_translate_x.add(label_translate_x_val, BorderLayout.CENTER);
		
		JSlider slider_translate_x = new JSlider();
		slider_translate_x.setPreferredSize(new Dimension(400, 26));
		panel_translate_x.add(slider_translate_x, BorderLayout.EAST);
		
		JPanel panel_translate_y = new JPanel();
		panel_translate.add(panel_translate_y, BorderLayout.CENTER);
		panel_translate_y.setLayout(new BorderLayout(0, 0));
		
		JLabel lbl_translate_y = new JLabel("Translate Y");
		lbl_translate_y.setPreferredSize(new Dimension(75, 15));
		lbl_translate_y.setMaximumSize(new Dimension(40, 14));
		lbl_translate_y.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_translate_y.add(lbl_translate_y, BorderLayout.WEST);
		
		JLabel lbl_translate_y_val = new JLabel("0");
		lbl_translate_y_val.setPreferredSize(new Dimension(5, 15));
		lbl_translate_y_val.setMinimumSize(new Dimension(5, 14));
		lbl_translate_y_val.setMaximumSize(new Dimension(5, 14));
		lbl_translate_y_val.setHorizontalTextPosition(SwingConstants.LEFT);
		lbl_translate_y_val.setHorizontalAlignment(SwingConstants.CENTER);
		panel_translate_y.add(lbl_translate_y_val, BorderLayout.CENTER);
		
		JSlider slider_translate_y = new JSlider();
		slider_translate_y.setPreferredSize(new Dimension(400, 26));
		panel_translate_y.add(slider_translate_y, BorderLayout.EAST);
		
		JPanel panel_matrix = new JPanel();
		panel_matrix.setBorder(new TitledBorder(null, "Matrix Result", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_matrix.setBackground(new Color(32, 178, 170));
		panel_matrix.setPreferredSize(new Dimension(250, 240));
		panel_side.add(panel_matrix, BorderLayout.SOUTH);
		panel_matrix.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		panel_matrix.add(splitPane);
		
		JPanel panel_before_matrix = new JPanel();
		panel_before_matrix.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Before", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_before_matrix.setPreferredSize(new Dimension(220, 10));
		splitPane.setLeftComponent(panel_before_matrix);
		
		JPanel panel_after_matrix = new JPanel();
		splitPane.setRightComponent(panel_after_matrix);
		panel_after_matrix.setPreferredSize(new Dimension(200, 10));
		panel_after_matrix.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "After", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JPanel panel_center = new JPanel();
		panel_center.setBackground(new Color(255, 255, 255));
		panel_center.setBorder(new TitledBorder(null, "Grid", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel_center, BorderLayout.CENTER);
		
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
	}

}
