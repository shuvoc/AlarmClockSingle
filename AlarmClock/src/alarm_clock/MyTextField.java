package alarm_clock;

import javax.swing.JTextField;

public class MyTextField extends JTextField{

	public MyTextField(int x,int y,int w,int h) {
		this.setLocation(x, y);
		this.setSize(w, h);
		this.setText("00");	}

}
