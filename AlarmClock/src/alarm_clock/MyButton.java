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
		//img = new ImageIcon(getClass().getResource(SourceOfImage));
		//this.setIcon(img);
		this.setText(title);
		this.setLocation(x, y);
		this.addActionListener(al);
		this.setSize(width, height);
		
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.setBackground(new Color(0x0f798c));
		this.setMargin(new Insets(0,0,0,0));
		this.setBorder(BorderFactory.createEmptyBorder());
	}
	
	public MyButton(String SourceOfImage,int x,int y,ActionListener al) {
		img = new ImageIcon(getClass().getResource(SourceOfImage));
		this.setIcon(img);
		this.setLocation(x, y);
		
		//this.setBorder(BorderFactory.createEmptyBorder());
		this.setSize(16, 15);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		this.setBackground(new Color(0x0f798c));
		this.addActionListener(al);
		
	}

}
