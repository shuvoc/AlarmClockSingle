package alarm_clock;

 

import java.awt.AlphaComposite; 
import java.awt.Color; 
import java.awt.Cursor;
import java.awt.Font; 
import java.awt.Graphics; 
import java.awt.Graphics2D; 
import java.awt.LinearGradientPaint; 
import java.awt.Paint; 
import java.awt.event.MouseEvent; 
import java.awt.event.MouseListener; 
import java.awt.event.MouseMotionListener; 
import javax.swing.JLabel; 
import javax.swing.SwingConstants; 


public class GlassButton extends JLabel implements MouseListener, MouseMotionListener{ 
     
    int x, y,wdth=500,hght=20; 
    String text; 
    int state = 1; 
    int inactive=0; 
    public GlassButton(String text,int x,int y,int width,MouseListener ml) { 
        
        setForeground(Color.WHITE); 
        setHorizontalAlignment(SwingConstants.CENTER); 
        this.x=x; 
        this.y=y; 
        this.text=text; 
        this.wdth=width; 
        this.setBounds(x,y, this.wdth,hght); 
        this.addMouseListener(this); 
        this.addMouseMotionListener(this); 
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.addMouseListener(ml);
    } 
    void makeActive(){ 
        inactive=0; 
        repaint(); 
    } 
    void makeInactive(){ 
        inactive=1; 
        repaint(); 
    } 
    @Override 
    public void paint(Graphics g){ 
        paintComponent(g); 
    } 
    @Override 
    protected void paintComponent(Graphics g) { 
               
         Graphics2D g2 = (Graphics2D) g; 
    AlphaComposite newComposite =  
        AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f); 
    g2.setComposite(newComposite);                 
         //this.setBounds(x,y, 320,hght); 
        
        Paint oldPaint = g2.getPaint(); 
         
        LinearGradientPaint p; 
             
        p = new LinearGradientPaint(0.0f, 0.0f, 0.0f, 20.0f, 
          new float[] { 0.001f,0.02f ,0.5f, 0.501f, 1.0f }, 
          new Color[] { new Color(0x909090), 
                        new Color(0x808080), 
                        new Color(0x505050), 
                         new Color(0x101010), 
                        new Color(0x000000) }); 
        g2.setPaint(p); 
        g2.fillRect(0, 0, getWidth(),21); 
         
        g2.setPaint(oldPaint); 
       
         
        if(inactive==1){ 
             g.setColor(new Color(200,200,200)); 
             g.setFont(new Font("Helvetica",0, 12)); 
        } 
        else if(state==1) g.setFont(new Font("Helvetica", 0, 12)); 
        else  if(state==2){ 
            g.setColor(Color.LIGHT_GRAY); 
            g.setFont(new Font("Helvetica", 0, 12)); 
        } 
         else  if(state==3){ 
             g.setColor(Color.GRAY); 
             g.setFont(new Font("Helvetica", 0, 12)); 
         } 
        g2.drawString(text,12,14); 
       
    } 

    public void mouseClicked(MouseEvent e) {
        state=2; 
        repaint();
    } 

    public void mousePressed(MouseEvent e) { 
        
        state=3; 
         repaint(); 
    } 

    public void mouseReleased(MouseEvent e) { 
         
        state=2; 
         repaint(); 
    } 

    public void mouseEntered(MouseEvent e) {
         state=2; 
          repaint(); 
    } 

    public void mouseExited(MouseEvent e) {
          state=1; 
           repaint(); 
     
    } 

    public void mouseDragged(MouseEvent e) { 
    } 

    public void mouseMoved(MouseEvent e) {
	} 

	    
	

}
