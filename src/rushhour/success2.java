package rushhour;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class success2 extends JFrame{
	private Image success=new ImageIcon(success1.class.getResource("/img/finish2.png")).getImage();
	public success2() {
		setTitle("Goal!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Timer t=new Timer();
		

		
		TimerTask task=new TimerTask() {
			
			@Override
			public void run() {
				
				setVisible(false);
				dispose();
				
			}
		};
		t.schedule(task, 4000);
		
		
		
		
		setResizable(false);
        setLayout(null);
        setSize(1200, 900);
        setVisible(true);
        
	}
	public void  paint(Graphics g) {
		g.drawImage(success,0,0,null);
	}
	public static void main(String[] args) {
		
		
	}

}
