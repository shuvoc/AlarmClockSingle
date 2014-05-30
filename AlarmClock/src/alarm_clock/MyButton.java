package alarm_clock;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class MyButton extends JButton{
	
	private ImageIcon img;

	public MyButton(String title,int x,int y,ActionListener al,int width,int height) {
		
		this.setText(title);
		this.setLocation(x, y);
		this.addActionListener(al);
		this.setSize(width, height);
		
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.setBackground(new Color(0xFFFFFF));
		this.setMargin(new Insets(1,1,1,1));
		//this.setBorder(BorderFactory.createEmptyBorder());
	}
	
	public MyButton(String SourceOfImage,int x,int y,ActionListener al) {
		try {
			img = new ImageIcon(getClass().getResource(SourceOfImage));
			this.setIcon(img);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		this.setLocation(x, y);
		
		//this.setBorder(BorderFactory.createEmptyBorder());
		this.setSize(31, 20);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		this.setBackground(new Color(0xFFFFFF));
		this.addActionListener(al);
		
	}

}
