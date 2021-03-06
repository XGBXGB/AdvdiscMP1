package view;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import model.Point;

public class Point_GUI extends JPanel
{
	private JLabel lbl_point_name;
	private JTextField txt_x, txt_y;
	private JLabel lbl_comma, lbl_open_paren, lbl_close_paren;
	private JButton btn;
	
	private final JTextField textField = new JTextField();
	public Point_GUI(String point_name, boolean stat) {
		textField.setColumns(10);
		
		setMaximumSize(new Dimension(400, 37));
		setPreferredSize(new Dimension(300, 37));
		
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		
		lbl_point_name = new JLabel(point_name);
		lbl_point_name.setPreferredSize(new Dimension(40, 25));
		this.add(lbl_point_name);
		
		lbl_open_paren = new JLabel("(");
		this.add(lbl_open_paren);
		
		txt_x = new JTextField("X");
		txt_x.setDocument(new JTextFieldFilter(JTextFieldFilter.FLOAT));
		((JTextFieldFilter)txt_x.getDocument()).setNegativeAccepted(true);
		txt_x.setHorizontalAlignment(SwingConstants.CENTER);
		txt_x.setPreferredSize(new Dimension(50, 24));
		this.add(txt_x);
		
		lbl_comma = new JLabel(",");
		this.add(lbl_comma);
		
		txt_y = new JTextField("Y");
		txt_y.setDocument(new JTextFieldFilter(JTextFieldFilter.FLOAT));
		((JTextFieldFilter)txt_y.getDocument()).setNegativeAccepted(true);
		txt_y.setHorizontalAlignment(SwingConstants.CENTER);
		txt_y.setPreferredSize(new Dimension(50, 24));
		this.add(txt_y);
		
		lbl_close_paren = new JLabel(")");
		this.add(lbl_close_paren);
		
		btn = new JButton("X");
		btn.setActionCommand("delete");
		btn.setVisible(stat);
		this.add(btn);
	}
	
	public void setButton(JButton btn){
		this.remove(this.btn);
		this.btn = btn;
		this.add(btn);
		this.repaint();
	}
	
	public void setCaption(String title){
		this.lbl_point_name.setText(title);
	}
	public void setXValue(String x){
		this.txt_x.setText(x);
	}
	public void setYValue(String y){
		this.txt_y.setText(y);
	}

	public String getXValue(){
		return this.txt_x.getText();
	}
	public String getYValue(){
		return this.txt_y.getText();
	}
	
	public JButton getButton(){
		return this.btn;
	}
	
	public void clear(){
		this.txt_x.setText("");
		this.txt_y.setText("");
	}
	
}
