package alarm_clock;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.*;

public class ClockBody extends JPanel{
	
	private Image backImg ;
	private MyButton btn_close;
	private MyButton btn_minimize;
	private MyButton btn_set_alarm;
	private MyButton btn_stop_alarm;
	private MyLabel  lbl_hour;
	private MyLabel  lbl_min;
	private MyLabel  lbl_sec;
	private MyTextField tf_hour;
	private MyTextField tf_min;
	private MyTextField tf_sec;
	private Calendar cal;
	private Alarm alarm;
	private boolean isSetAlarm;

	public ClockBody() {
		this.setLayout(null);
		this.setPreferredSize(new Dimension(450,100));
		this.setBackground(new Color(0x767e7f));
		ImageIcon ii = new ImageIcon(getClass().getResource("/Image/back_clock.png"));
		backImg = ii.getImage();
		btn_close     = new MyButton("/Image/close.png",434,0,btn_close_al);
		btn_minimize  = new MyButton("/Image/minimize.png",418,0,btn_minimize_al);
		btn_set_alarm = new MyButton("Set Alarm Time",100,10,btn_set_alarm_al,120,20);
		btn_stop_alarm = new MyButton("Stop Alarm",260,10,btn_stop_alarm_al,120,20);
		lbl_hour = new MyLabel("00",67,85,60,60);
		lbl_min  = new MyLabel("00",197,85,60,60);
		lbl_sec  = new MyLabel("00",325,85,60,60);
		tf_hour  = new MyTextField(10,10,20,20);
		tf_min   = new MyTextField(42,10,20,20);
		tf_sec   = new MyTextField(74,10,20,20);
		
		
		
		this.add(btn_close);
		this.add(btn_minimize);
		this.add(btn_set_alarm);
		this.add(btn_stop_alarm);
		this.add(lbl_hour);
		this.add(lbl_min);
		this.add(lbl_sec);
		this.add(tf_hour);
		this.add(tf_min);
		this.add(tf_sec);
		
		btn_stop_alarm.setVisible(false);
		
		
		
		cal = Calendar.getInstance();
		if((cal.get(cal.HOUR)/10) != 0)lbl_hour.setText(""+cal.get(cal.HOUR));
		else lbl_hour.setText("0"+cal.get(cal.HOUR));
		
		if((cal.get(cal.MINUTE)/10) != 0)lbl_min.setText(""+cal.get(cal.MINUTE));
		else lbl_min.setText("0"+cal.get(cal.MINUTE));
		
		if((cal.get(cal.SECOND)/10) != 0)lbl_sec.setText(""+cal.get(cal.SECOND));
		else lbl_sec.setText("0"+cal.get(cal.SECOND));
		
		
        Timer t = new Timer(1000, taskPerformer);
        t.start();
	}
	
	
	ActionListener taskPerformer = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
        	
        	cal = Calendar.getInstance();
        	if(isSetAlarm){
        		alarm.playAlarm(cal);
        		if(alarm.isPlaying)btn_stop_alarm.setVisible(true);
        	}
        	
        	if((cal.get(cal.HOUR)/10) != 0)lbl_hour.setText(""+cal.get(cal.HOUR));
    		else lbl_hour.setText("0"+cal.get(cal.HOUR));
    		
    		if((cal.get(cal.MINUTE)/10) != 0)lbl_min.setText(""+cal.get(cal.MINUTE));
    		else lbl_min.setText("0"+cal.get(cal.MINUTE));
    		
    		if((cal.get(cal.SECOND)/10) != 0)lbl_sec.setText(""+cal.get(cal.SECOND));
    		else lbl_sec.setText("0"+cal.get(cal.SECOND));
        }
    };
    
    
    ActionListener btn_set_alarm_al = new ActionListener() 
	{
	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	
	    	try{
	    		alarm = new Alarm(Integer.parseInt(tf_hour.getText()),Integer.parseInt(tf_min.getText()),Integer.parseInt(tf_sec.getText()));
	    		isSetAlarm = true;
	    	}
	    	catch(Exception a){
	    		a.printStackTrace();
	    	}
	    }        
	};
	
	ActionListener btn_stop_alarm_al = new ActionListener() 
	{
	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	
	    	try{
	    		alarm.stopAlarm();
	    		btn_stop_alarm.setVisible(false);
	    		isSetAlarm = false;
	    	}
	    	catch(Exception a){
	    		a.printStackTrace();
	    	}
	    }        
	};
	
	ActionListener btn_close_al = new ActionListener() 
	{
	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	System.exit(0);
	    	
	    }        
	};
	
	ActionListener btn_minimize_al = new ActionListener() 
	{
	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	
	    	((JFrame)getTopLevelAncestor()).setState(JFrame.ICONIFIED);
	    }        
	};
	
	public void paint(Graphics g){
		super.paint(g);
		g.drawImage(backImg, 6,50, backImg.getWidth(null),backImg.getHeight(null),this);
	}

}
