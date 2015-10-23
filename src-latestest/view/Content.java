package view;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;

public abstract class Content extends JPanel{
	
	private JPanel panel_content, panel_top, panel_footer;
	private JButton btn_create;
	private JLabel lbl_caption;
	
	public Content(String caption) {
		setLayout(new BorderLayout(0, 0));
		
		panel_top = new JPanel();
		panel_top.setBackground(new Color(0, 128, 128));
		this.add(panel_top, BorderLayout.NORTH);
		panel_top.setLayout(new BorderLayout(0, 0));
		
		lbl_caption = new JLabel(caption);
		lbl_caption.setForeground(new Color(255, 255, 255));
		lbl_caption.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_caption.setPreferredSize(new Dimension(55, 30));
		lbl_caption.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_top.add(lbl_caption);
		
		panel_footer = new JPanel();
		panel_footer.setBackground(new Color(0, 128, 128));
		this.add(panel_footer, BorderLayout.SOUTH);
		
		btn_create = new JButton("Create Shape");
		btn_create.setActionCommand("create");
		panel_footer.add(btn_create);
	}
	
	public void setContent(JPanel content){
		panel_content = content;
		add(panel_content, BorderLayout.CENTER);
		this.repaint();
		this.revalidate();
		
	}
	public void setCaption(String caption){
		this.lbl_caption.setText(caption);
	}
	
	public JButton getButtonCreate(){
		return this.btn_create;
	}
	
	public JPanel getContent(){
		return this.panel_content;
	}
	public String getCaption(){
		return this.lbl_caption.getText();
	}
	
	public abstract void createShape();
	public abstract void clear();
}
