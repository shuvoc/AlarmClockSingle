package alarm_clock;


import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Caret;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

public class MyTextField extends JTextField{

	public MyTextField(int x,int y,int w,int h) {
		this.setLocation(x, y);
		this.setSize(w, h);
		this.setText("00");	
		
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.setBorder(BorderFactory.createEmptyBorder());
		this.setBackground(new Color(0x030022));
		this.setForeground(Color.WHITE);
		this.setCaretColor(Color.WHITE);
		this.setCaretPosition(CENTER);
		
		/*
		 * Font settings of JLabel
		 */
		InputStream is = this.getClass().getResourceAsStream("/Font/digital-7.ttf");
		
		try {
			Font font = Font.createFont(Font.TRUETYPE_FONT, is);
			this.setFont(font.deriveFont(Font.BOLD,20)); 
		} 
		catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
		
		/*
		 * Font Settings End
		 */
	}
	
	@Override
    protected Document createDefaultModel() {
        return new LimitDocument();
    }

    private class LimitDocument extends PlainDocument {

        @Override
        public void insertString( int offset, String  str, AttributeSet attr ) throws BadLocationException {
            if (str == null) return;
            if ((getLength() + str.length()) <= 2 ) {
                super.insertString(offset, str, attr);
            }
            
        }       

    }
	
	
}
