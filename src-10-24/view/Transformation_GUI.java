package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import model.Observer;
import controller.GraphicObjectController;
import java.awt.Font;

public class Transformation_GUI extends JPanel implements ActionListener, Observer {

	private JPanel panel_top, panel_bottom, panel_side;
	private JPanel panel_transformation;
	private JPanel panel_matrix;
	private JPanel panel_menu;
	private JButton btn_change_shape;
	private JButton btn_reset;
	private CardLayout cl;
	private JPanel panel_main_content;
	private JPanel panel_scale;
	private JLabel lbl_scale;
	private JLabel lbl_scale_x;
	private JTextField txt_scale_x;
	private JLabel lbl_scale_y;
	private JTextField txt_scale_y;
	private JPanel panel_translate;
	private JLabel lbl_translate;
	private JLabel lbl_translate_x;
	private JTextField txt_translate_x;
	private JLabel lbl_translate_y;
	private JTextField txt_translate_y;
	private JPanel panel_shear;
	private JLabel lbl_shear;
	private JLabel lbl_shear_x;
	private JTextField txt_shear_x;
	private JLabel lbl_shear_y;
	private JTextField txt_shear_y;
	private JPanel panel_rotate;
	private JLabel lbl_rotate;
	private JTextField txt_rotate;
	private JPanel panel_reflect;
	private JLabel lbl_reflect;
	private JRadioButton rBtn_x;
	private JRadioButton rBtn_y;
	private JTextArea matrix_log;
	private GraphicObjectController sc;
	private JScrollPane scrollPane;
	private String result;
	private Main_GUI m;
	private JLabel lbl_rotate_inform;

	public Transformation_GUI(Transformation_Builder tb) {

		super();
		sc = GraphicObjectController.getInstance();
		sc.registerObserver(this);

		this.m = tb.getMain_GUI();

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
		panel_transformation.setBorder(new TitledBorder(null, "Transformations", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_transformation.setBackground(new Color(102, 205, 170));
		panel_side.add(panel_transformation, BorderLayout.CENTER);
		panel_transformation.setLayout(new GridLayout(0, 1, 0, 0));

		panel_scale = new JPanel();
		panel_scale.setOpaque(false);
		panel_scale.setVisible(tb.scale);
		panel_transformation.add(panel_scale);
		GridBagLayout gbl_panel_scale = new GridBagLayout();
		gbl_panel_scale.columnWidths = new int[]{100, 0, 150, 0, 150, 0};
		gbl_panel_scale.rowHeights = new int[]{14, 0};
		gbl_panel_scale.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_scale.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_scale.setLayout(gbl_panel_scale);

		lbl_scale = new JLabel("Scale");
		GridBagConstraints gbc_lbl_scale = new GridBagConstraints();
		gbc_lbl_scale.anchor = GridBagConstraints.WEST;
		gbc_lbl_scale.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_scale.gridx = 0;
		gbc_lbl_scale.gridy = 0;
		panel_scale.add(lbl_scale, gbc_lbl_scale);

		lbl_scale_x = new JLabel("X :");
		lbl_scale_x.setVisible(tb.scaleY); 
		GridBagConstraints gbc_lbl_scale_x = new GridBagConstraints();
		gbc_lbl_scale_x.anchor = GridBagConstraints.EAST;
		gbc_lbl_scale_x.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_scale_x.gridx = 1;
		gbc_lbl_scale_x.gridy = 0;
		panel_scale.add(lbl_scale_x, gbc_lbl_scale_x);

		txt_scale_x = new JTextField();
		txt_scale_x.setDocument(new JTextFieldFilter(JTextFieldFilter.FLOAT));
		((JTextFieldFilter)txt_scale_x.getDocument()).setNegativeAccepted(true);
		GridBagConstraints gbc_txt_scale_x = new GridBagConstraints();
		gbc_txt_scale_x.insets = new Insets(0, 0, 0, 5);
		gbc_txt_scale_x.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_scale_x.gridx = 2;
		gbc_txt_scale_x.gridy = 0;
		panel_scale.add(txt_scale_x, gbc_txt_scale_x);
		txt_scale_x.setColumns(10);
		txt_scale_x.setText("1");

		lbl_scale_y = new JLabel("Y :");
		lbl_scale_y.setVisible(tb.scaleY); 
		GridBagConstraints gbc_lbl_scale_y = new GridBagConstraints();
		gbc_lbl_scale_y.anchor = GridBagConstraints.EAST;
		gbc_lbl_scale_y.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_scale_y.gridx = 3;
		gbc_lbl_scale_y.gridy = 0;
		panel_scale.add(lbl_scale_y, gbc_lbl_scale_y);

		txt_scale_y = new JTextField();
		txt_scale_y.setVisible(tb.scaleY);
		txt_scale_y.setDocument(new JTextFieldFilter(JTextFieldFilter.FLOAT));
		((JTextFieldFilter)txt_scale_y.getDocument()).setNegativeAccepted(true);
		GridBagConstraints gbc_txt_scale_y = new GridBagConstraints();
		gbc_txt_scale_y.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_scale_y.gridx = 4;
		gbc_txt_scale_y.gridy = 0;
		panel_scale.add(txt_scale_y, gbc_txt_scale_y);
		txt_scale_y.setColumns(10);
		txt_scale_y.setText("1");

		panel_translate = new JPanel();
		panel_translate.setOpaque(false);
		panel_translate.setVisible(tb.translate);
		panel_transformation.add(panel_translate);
		GridBagLayout gbl_panel_translate = new GridBagLayout();
		gbl_panel_translate.columnWidths = new int[]{100, 0, 150, 0, 150, 0};
		gbl_panel_translate.rowHeights = new int[]{14, 0};
		gbl_panel_translate.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_translate.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_translate.setLayout(gbl_panel_translate);

		lbl_translate = new JLabel("Translate ");
		GridBagConstraints gbc_lbl_translate = new GridBagConstraints();
		gbc_lbl_translate.anchor = GridBagConstraints.WEST;
		gbc_lbl_translate.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_translate.gridx = 0;
		gbc_lbl_translate.gridy = 0;
		panel_translate.add(lbl_translate, gbc_lbl_translate);

		lbl_translate_x = new JLabel("X :");
		GridBagConstraints gbc_lbl_translate_x = new GridBagConstraints();
		gbc_lbl_translate_x.anchor = GridBagConstraints.EAST;
		gbc_lbl_translate_x.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_translate_x.gridx = 1;
		gbc_lbl_translate_x.gridy = 0;
		panel_translate.add(lbl_translate_x, gbc_lbl_translate_x);

		txt_translate_x = new JTextField();
		txt_translate_x.setColumns(10);
		txt_translate_x.setDocument(new JTextFieldFilter(JTextFieldFilter.FLOAT));
		((JTextFieldFilter)txt_translate_x.getDocument()).setNegativeAccepted(true);
		GridBagConstraints gbc_txt_translate_x = new GridBagConstraints();
		gbc_txt_translate_x.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_translate_x.insets = new Insets(0, 0, 0, 5);
		gbc_txt_translate_x.gridx = 2;
		gbc_txt_translate_x.gridy = 0;
		panel_translate.add(txt_translate_x, gbc_txt_translate_x);

		lbl_translate_y = new JLabel("Y :");
		GridBagConstraints gbc_lbl_translate_y = new GridBagConstraints();
		gbc_lbl_translate_y.anchor = GridBagConstraints.EAST;
		gbc_lbl_translate_y.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_translate_y.gridx = 3;
		gbc_lbl_translate_y.gridy = 0;
		panel_translate.add(lbl_translate_y, gbc_lbl_translate_y);

		txt_translate_y = new JTextField();
		txt_translate_y.setColumns(10);
		txt_translate_y.setDocument(new JTextFieldFilter(JTextFieldFilter.FLOAT));
		((JTextFieldFilter)txt_translate_y.getDocument()).setNegativeAccepted(true);
		GridBagConstraints gbc_txt_translate_y = new GridBagConstraints();
		gbc_txt_translate_y.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_translate_y.gridx = 4;
		gbc_txt_translate_y.gridy = 0;
		panel_translate.add(txt_translate_y, gbc_txt_translate_y);

		panel_shear = new JPanel();
		panel_shear.setOpaque(false);
		panel_shear.setVisible(tb.shear);
		panel_transformation.add(panel_shear);
		GridBagLayout gbl_panel_shear = new GridBagLayout();
		gbl_panel_shear.columnWidths = new int[]{100, 0, 150, 0, 150, 0};
		gbl_panel_shear.rowHeights = new int[]{14, 0};
		gbl_panel_shear.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_shear.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_shear.setLayout(gbl_panel_shear);

		lbl_shear = new JLabel("Shear ");
		GridBagConstraints gbc_lbl_shear = new GridBagConstraints();
		gbc_lbl_shear.anchor = GridBagConstraints.WEST;
		gbc_lbl_shear.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_shear.gridx = 0;
		gbc_lbl_shear.gridy = 0;
		panel_shear.add(lbl_shear, gbc_lbl_shear);

		lbl_shear_x = new JLabel("X :");
		GridBagConstraints gbc_lbl_shear_x = new GridBagConstraints();
		gbc_lbl_shear_x.anchor = GridBagConstraints.EAST;
		gbc_lbl_shear_x.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_shear_x.gridx = 1;
		gbc_lbl_shear_x.gridy = 0;
		panel_shear.add(lbl_shear_x, gbc_lbl_shear_x);

		txt_shear_x = new JTextField();
		txt_shear_x.setColumns(10);
		txt_shear_x.setDocument(new JTextFieldFilter(JTextFieldFilter.FLOAT));
		((JTextFieldFilter)txt_shear_x.getDocument()).setNegativeAccepted(true);
		GridBagConstraints gbc_txt_shear_x = new GridBagConstraints();
		gbc_txt_shear_x.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_shear_x.insets = new Insets(0, 0, 0, 5);
		gbc_txt_shear_x.gridx = 2;
		gbc_txt_shear_x.gridy = 0;
		panel_shear.add(txt_shear_x, gbc_txt_shear_x);

		lbl_shear_y = new JLabel("Y :");
		GridBagConstraints gbc_lbl_shear_y = new GridBagConstraints();
		gbc_lbl_shear_y.anchor = GridBagConstraints.EAST;
		gbc_lbl_shear_y.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_shear_y.gridx = 3;
		gbc_lbl_shear_y.gridy = 0;
		panel_shear.add(lbl_shear_y, gbc_lbl_shear_y);

		txt_shear_y = new JTextField();
		txt_shear_y.setColumns(10);
		txt_shear_y.setDocument(new JTextFieldFilter(JTextFieldFilter.FLOAT));
		((JTextFieldFilter)txt_shear_y.getDocument()).setNegativeAccepted(true);
		GridBagConstraints gbc_txt_shear_y = new GridBagConstraints();
		gbc_txt_shear_y.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_shear_y.gridx = 4;
		gbc_txt_shear_y.gridy = 0;
		panel_shear.add(txt_shear_y, gbc_txt_shear_y);

		panel_rotate = new JPanel();
		panel_rotate.setOpaque(false);
		panel_rotate.setVisible(tb.rotate);
		panel_transformation.add(panel_rotate);
		GridBagLayout gbl_panel_rotate = new GridBagLayout();
		gbl_panel_rotate.columnWidths = new int[]{85, 8, 150, 0, 150, 0};
		gbl_panel_rotate.rowHeights = new int[]{35, 0};
		gbl_panel_rotate.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_rotate.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_rotate.setLayout(gbl_panel_rotate);

		lbl_rotate = new JLabel("Rotate (angle in degrees)");
		GridBagConstraints gbc_lbl_rotate = new GridBagConstraints();
		gbc_lbl_rotate.anchor = GridBagConstraints.WEST;
		gbc_lbl_rotate.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_rotate.gridx = 0;
		gbc_lbl_rotate.gridy = 0;
		panel_rotate.add(lbl_rotate, gbc_lbl_rotate);

		txt_rotate = new JTextField();
		txt_rotate.setColumns(10);
		txt_rotate.setDocument(new JTextFieldFilter(JTextFieldFilter.FLOAT));
		((JTextFieldFilter)txt_rotate.getDocument()).setNegativeAccepted(true);
		GridBagConstraints gbc_txt_rotate = new GridBagConstraints();
		gbc_txt_rotate.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_rotate.insets = new Insets(0, 0, 0, 5);
		gbc_txt_rotate.gridx = 2;
		gbc_txt_rotate.gridy = 0;
		panel_rotate.add(txt_rotate, gbc_txt_rotate);
		txt_rotate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!txt_rotate.getText().equals("")) {
					sc.rotateShape(Float.parseFloat(txt_rotate.getText()), 0, 0, true);
				}
			}
		});

		lbl_rotate_inform = new JLabel("*rotate only by 90, -90, 180, or -180");
		lbl_rotate_inform.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lbl_rotate_inform.setVisible(tb.rotateLimit);
		GridBagConstraints gbc_lbl_rotate_inform = new GridBagConstraints();
		gbc_lbl_rotate_inform.gridwidth = 4;
		gbc_lbl_rotate_inform.gridx = 3;
		gbc_lbl_rotate_inform.gridy = 0;
		panel_rotate.add(lbl_rotate_inform, gbc_lbl_rotate_inform);

		panel_reflect = new JPanel();
		panel_reflect.setOpaque(false);
		panel_reflect.setVisible(tb.reflect);
		panel_transformation.add(panel_reflect);
		GridBagLayout gbl_panel_reflect = new GridBagLayout();
		gbl_panel_reflect.columnWidths = new int[]{100, 0, 150, 0, 150, 0};
		gbl_panel_reflect.rowHeights = new int[]{14, 0};
		gbl_panel_reflect.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_reflect.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_reflect.setLayout(gbl_panel_reflect);

		lbl_reflect = new JLabel("Reflect ");
		GridBagConstraints gbc_lbl_reflect = new GridBagConstraints();
		gbc_lbl_reflect.anchor = GridBagConstraints.WEST;
		gbc_lbl_reflect.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_reflect.gridx = 0;
		gbc_lbl_reflect.gridy = 0;
		panel_reflect.add(lbl_reflect, gbc_lbl_reflect);

		rBtn_x = new JRadioButton("X-axis");
		rBtn_x.setOpaque(false);
		GridBagConstraints gbc_rBtn_x = new GridBagConstraints();
		gbc_rBtn_x.insets = new Insets(0, 0, 0, 5);
		gbc_rBtn_x.gridx = 2;
		gbc_rBtn_x.gridy = 0;
		panel_reflect.add(rBtn_x, gbc_rBtn_x);

		rBtn_y = new JRadioButton("Y-axis");
		rBtn_y.setOpaque(false);
		GridBagConstraints gbc_rBtn_y = new GridBagConstraints();
		gbc_rBtn_y.gridx = 4;
		gbc_rBtn_y.gridy = 0;
		panel_reflect.add(rBtn_y, gbc_rBtn_y);

		ButtonGroup bg = new ButtonGroup();
		bg.add(rBtn_x);
		bg.add(rBtn_y);

		panel_matrix = new JPanel();
		panel_matrix.setBorder(new TitledBorder(null, "Matrix Results", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_matrix.setBackground(new Color(32, 178, 170));
		panel_matrix.setPreferredSize(new Dimension(250, 310));
		panel_side.add(panel_matrix, BorderLayout.SOUTH);
		panel_matrix.setLayout(new BorderLayout(0, 0));

		matrix_log = new JTextArea(100,100);
		matrix_log.setEditable(false);
		scrollPane = new JScrollPane(matrix_log);

		scrollPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		scrollPane.getViewport().setBackground(null);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel_matrix.add(scrollPane, BorderLayout.CENTER);

		panel_menu = new JPanel();
		panel_menu.setBackground(new Color(135, 206, 250));
		panel_menu.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_menu.setPreferredSize(new Dimension(10, 50));
		panel_side.add(panel_menu, BorderLayout.NORTH);
		panel_menu.setLayout(new GridLayout(0, 2, 0, 0));

		btn_change_shape = new JButton("Change Shape");
		btn_change_shape.setBackground(new Color(255, 255, 255));
		btn_change_shape.setPreferredSize(new Dimension(103, 25));
		btn_change_shape.addActionListener(this);
		panel_menu.add(btn_change_shape);

		btn_reset = new JButton("Reset");
		btn_reset.setBackground(new Color(255, 255, 255));
		btn_reset.setPreferredSize(new Dimension(61, 25));
		btn_reset.addActionListener(this);
		panel_menu.add(btn_reset);

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

		this.setSize((int) (screenSize.width / 1.2), (int) (screenSize.height / 1.1));

		/********************************* SCALE *******************************/

		txt_scale_x.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!txt_scale_x.getText().equals("") && !txt_scale_y.getText().equals("")
						&& !txt_scale_x.getText().equals("0") && !txt_scale_x.getText().equals("0")) {
					sc.scaleShape(Double.valueOf(txt_scale_x.getText()), Double.valueOf(txt_scale_y.getText()));
				} else if ((txt_scale_x.getText().equals("") || txt_scale_x.getText().equals("0")) && (!txt_scale_y.getText().equals("")
						&& !txt_scale_y.getText().equals("0"))) {
					sc.scaleShape(1, Double.valueOf(txt_scale_y.getText()));
				} else if ((!txt_scale_x.getText().equals("") && !txt_scale_x.getText().equals("0")) && (txt_scale_y.getText().equals("")
						|| txt_scale_x.getText().equals("0"))) {
					sc.scaleShape(Double.valueOf(txt_scale_x.getText()), 1);
				} else {
					sc.scaleShape(1, 1);
				}
			}
		});

		txt_scale_y.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!txt_scale_x.getText().equals("") && !txt_scale_y.getText().equals("")
						&& !txt_scale_x.getText().equals("0") && !txt_scale_x.getText().equals("0")) {
					sc.scaleShape(Double.valueOf(txt_scale_x.getText()), Double.valueOf(txt_scale_y.getText()));
				} else if ((txt_scale_x.getText().equals("") || txt_scale_x.getText().equals("0")) && (!txt_scale_y.getText().equals("")
						&& !txt_scale_y.getText().equals("0"))) {
					sc.scaleShape(1, Double.valueOf(txt_scale_y.getText()));
				} else if ((!txt_scale_x.getText().equals("") && !txt_scale_x.getText().equals("0")) && (txt_scale_y.getText().equals("")
						|| txt_scale_x.getText().equals("0"))) {
					sc.scaleShape(Double.valueOf(txt_scale_x.getText()), 1);
				} else {
					sc.scaleShape(1, 1);
				}
			}
		});

		/********************************* TRANSLATE *******************************/

		txt_translate_x.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!txt_translate_x.getText().equals("") && !txt_translate_y.getText().equals("")) {
					sc.translateShape(Double.valueOf(txt_translate_x.getText()), Double.valueOf(txt_translate_y.getText()));
				} else if (txt_translate_x.getText().equals("") && !txt_translate_y.getText().equals("")) {
					sc.translateShape(0, Double.valueOf(txt_translate_y.getText()));
				} else if (!txt_translate_x.getText().equals("") && txt_translate_y.getText().equals("")) {
					sc.translateShape(Double.valueOf(txt_translate_x.getText()), 0);
				} else {
					sc.translateShape(0, 0);
				}
			}
		});

		txt_translate_y.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!txt_translate_x.getText().equals("") && !txt_translate_y.getText().equals("")) {
					sc.translateShape(Double.valueOf(txt_translate_x.getText()), Double.valueOf(txt_translate_y.getText()));
				} else if (txt_translate_x.getText().equals("") && !txt_translate_y.getText().equals("")) {
					sc.translateShape(0, Double.valueOf(txt_translate_y.getText()));
				} else if (!txt_translate_x.getText().equals("") && txt_translate_y.getText().equals("")) {
					sc.translateShape(Double.valueOf(txt_translate_x.getText()), 0);
				} else {
					sc.translateShape(0, 0);
				}

			}
		});

		/************************************** ROTATE *******************************/

		/*********************************** SHEAR *******************************/
		txt_shear_x.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!txt_shear_x.getText().equals("") && !txt_shear_y.getText().equals("")) {
					sc.revertToOriginal();
					sc.shearShape(false, Double.valueOf(txt_shear_y.getText()));
					sc.shearShape(true, Double.valueOf(txt_shear_x.getText()));
				} else if (txt_shear_x.getText().equals("") && !txt_shear_y.getText().equals("")) {
					sc.revertToOriginal();
					sc.shearShape(false, Double.valueOf(txt_shear_y.getText()));
				} else if (!txt_shear_x.getText().equals("") && txt_shear_y.getText().equals("")) {
					sc.revertToOriginal();
					sc.shearShape(true, Double.valueOf(txt_shear_x.getText()));
				} else {
					sc.revertToOriginal();
				}
			}
		});

		txt_shear_y.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!txt_shear_x.getText().equals("") && !txt_shear_y.getText().equals("")) {
					sc.revertToOriginal();
					sc.shearShape(true, Double.valueOf(txt_shear_x.getText()));
					sc.shearShape(false, Double.valueOf(txt_shear_y.getText()));
				} else if (txt_shear_x.getText().equals("") && !txt_shear_y.getText().equals("")) {
					sc.revertToOriginal();
					sc.shearShape(false, Double.valueOf(txt_shear_y.getText()));
				} else if (!txt_shear_x.getText().equals("") && txt_shear_y.getText().equals("")) {
					sc.revertToOriginal();
					sc.shearShape(true, Double.valueOf(txt_shear_x.getText()));
				} else {
					sc.revertToOriginal();
				}

			}
		});

		/******************************************* REFLECT *******************************/
		rBtn_x.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				sc.reflect(true);
			}
		});

		rBtn_y.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sc.reflect(false);
			}
		});
		this.setVisible(true);
	}

	public void clearMatrixLog(){
		this.matrix_log.setText("");
		this.repaint();
		this.revalidate();
	}

	public void clear(){
		update();
		this.rBtn_x.setSelected(false);
		this.rBtn_y.setSelected(false);
		this.txt_rotate.setText("");
		this.txt_scale_x.setText("");
		this.txt_scale_y.setText("");
		this.txt_shear_x.setText("");
		this.txt_shear_y.setText("");
		this.txt_translate_x.setText("");
		this.txt_translate_y.setText("");
	}


	@Override
	public void actionPerformed(ActionEvent a) {
		// TODO Auto-generated method stub

		if (a.getSource() == btn_change_shape) {
			m.setReturn();
			clear();
		}
		else if (a.getSource() == btn_reset) {
			clear();
			sc.revertToOriginal();  
		}
	}

	@Override
	public void update() {
		if(matrix_log != null){
			this.matrix_log.setText(sc.getMatrixLog());
		}

	}

	public static class Transformation_Builder{
		private boolean rotate;
		private boolean scaleY;
		private boolean scale;
		private boolean shear;
		private boolean translate;
		private boolean reflect;
		private boolean rotateLimit;
		private Main_GUI m;

		public Transformation_Builder(Main_GUI m){
			rotate = false;
			rotateLimit = false;
			scale = false;
			scaleY = false;
			shear = false;
			translate = false;
			reflect = false;
			this.m = m;
		}

		public Main_GUI getMain_GUI(){
			return m;
		}

		public Transformation_Builder rotate(boolean rotate) {
			this.rotate = rotate;
			return this;
		}

		public Transformation_Builder scaleY(boolean scale) {
			this.scaleY = scale;
			return this;
		}
		
		public Transformation_Builder scale(boolean scale) {
			this.scale = scale;
			return this;
		}

		public Transformation_Builder shear(boolean shear) {
			this.shear = shear;
			return this;
		}

		public Transformation_Builder rotateLimit(boolean rotateLimit){
			this.rotateLimit = rotateLimit;
			return this;
		}
		public Transformation_Builder translate(boolean translate) {
			this.translate = translate;
			return this;
		}
		public Transformation_Builder reflect(boolean reflect) {
			this.reflect = reflect;
			return this;
		}
		public Transformation_GUI build() {
			return new Transformation_GUI(this);
		}
	}



}
