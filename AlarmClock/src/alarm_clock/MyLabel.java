package alarm_clock;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MyLabel extends JLabel{

	
	public MyLabel(String t,int x,int y,int width,int height) {
		this.setText(t);
		this.setLocation(x, y);
		this.setSize(width,height);
		
		this.setHorizontalAlignment( SwingConstants.CENTER );
		this.setForeground(Color.WHITE);
		
		
		/*
		 * Font settings of JLabel
		 */
		InputStream is = this.getClass().getResourceAsStream("/Font/digital-7 (mono).ttf");
		
		try {
			Font font = Font.createFont(Font.TRUETYPE_FONT, is);
			this.setFont(font.deriveFont(Font.BOLD,55)); 
		} 
		catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
		
		/*
		 * Font Settings End
		 */
		//this.setBorder(BorderFactory.createLineBorder(Color.WHITE,1));
	}
	
	

}
