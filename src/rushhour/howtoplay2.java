package rushhour;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class howtoplay2 extends JFrame{
	private Image guide1 = new ImageIcon(howtoplay2.class.getResource("/img/GUIDE2.png")).getImage();
	public howtoplay2() {
		setTitle("How to play");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c=getContentPane();
		JLabel guide = new JLabel(new ImageIcon(guide1)) {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(guide1, 1190,0, null);
                
            }
        };
        guide.setBounds(100,100,guide1.getWidth(null),guide1.getHeight(null));
		c.add(guide);
		
		setSize(300,600);
		setLocation(1190, 0);
		
	}

	public static void main(String[] args) {
		

	}

}
