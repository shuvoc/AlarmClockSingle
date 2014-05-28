package alarm_clock;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MyLabel extends JLabel{

	public MyLabel(String t,int x,int y,int width,int height) {
		this.setText(t);
		this.setLocation(x, y);
		this.setSize(width,height);
		
		this.setHorizontalAlignment( SwingConstants.CENTER );
		this.setForeground(new Color(0xeff6f7));
		this.setFont(new Font("Tahoma",Font.BOLD, 45)); 
		//this.setBorder(BorderFactory.createLineBorder(Color.WHITE,3));
	}

}
