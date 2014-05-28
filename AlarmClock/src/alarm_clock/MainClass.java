package alarm_clock;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

public class MainClass extends JFrame{
	
	
	static Point mouseDownScreenCoords;
    static Point mouseDownCompCoords;
    
	public MainClass() {
		
		mouseDownScreenCoords = null;
        mouseDownCompCoords = null;
        this.add(new ClockBody());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(450,200);
	    setUndecorated(true);
	    //this.setOpacity(0.9F);
	    
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        
	}
	
	public static void main(String args[]){
		final MainClass mc = new MainClass();
		mc.addMouseListener(new MouseListener(){
            public void mouseReleased(MouseEvent e) {
                mouseDownScreenCoords = null;
                mouseDownCompCoords = null;
            }
            public void mousePressed(MouseEvent e) {
                mouseDownScreenCoords = e.getLocationOnScreen();
                mouseDownCompCoords = e.getPoint();
            }
            public void mouseExited(MouseEvent e) {
            }
            public void mouseEntered(MouseEvent e) {
            }
            public void mouseClicked(MouseEvent e) {
            }
        });
		
		
		mc.addMouseMotionListener(new MouseMotionListener(){
            public void mouseMoved(MouseEvent e) {
            }
            public void mouseDragged(MouseEvent e) {
                Point currCoords = e.getLocationOnScreen();
                mc.setLocation(mouseDownScreenCoords.x + (currCoords.x - mouseDownScreenCoords.x) - mouseDownCompCoords.x,
                              mouseDownScreenCoords.y + (currCoords.y - mouseDownScreenCoords.y) - mouseDownCompCoords.y);
            }
        });
	}

}
