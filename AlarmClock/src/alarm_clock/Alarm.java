package alarm_clock;

import java.applet.Applet;
import java.applet.AudioClip;
import java.util.Calendar;

public class Alarm {
	
	Calendar c;
	AudioClip alarm_sound;
	boolean isPlaying;
	
	public Alarm(int v1,int v2,int v3) {
		
		c = Calendar.getInstance();
		
		c.set(c.HOUR   , v1);
		c.set(c.MINUTE , v2);
		c.set(c.SECOND , v3);
		alarm_sound = Applet.newAudioClip(this.getClass().getResource("/Sound/alarm.wav"));
		isPlaying = false;
	}
	
	public void playAlarm(Calendar cal){
		if(cal.get(cal.HOUR) == c.get(c.HOUR) && cal.get(cal.MINUTE) == c.get(c.MINUTE) && cal.get(cal.SECOND) == c.get(c.SECOND))
		{
			alarm_sound.loop();
			isPlaying = true;
		}
	}
	
	public void stopAlarm(){
		alarm_sound.stop();
	}

}
