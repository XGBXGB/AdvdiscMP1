package view;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.SwingConstants;

public class Content extends JPanel{
	
	private JPanel panel_content, panel_top;
	private JLabel lbl_caption;
	
	public Content(String caption, JPanel content) {
		setLayout(new BorderLayout(0, 0));
		
		panel_content = content;
		add(panel_content, BorderLayout.CENTER);
		panel_content.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panel_top = new JPanel();
		add(panel_top, BorderLayout.NORTH);
		panel_top.setLayout(new BorderLayout(0, 0));
		
		lbl_caption = new JLabel(caption);
		lbl_caption.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_caption.setPreferredSize(new Dimension(55, 30));
		lbl_caption.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_top.add(lbl_caption);
	}
	
	public void setContent(JPanel content){
		this.panel_content = content;
	}
	public void setCaption(String caption){
		this.lbl_caption.setText(caption);
	}
	
	public JPanel getContent(){
		return this.panel_content;
	}
	public String getCaption(){
		return this.lbl_caption.getText();
	}

}
