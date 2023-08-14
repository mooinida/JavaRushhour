package rushhour;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class howtoplay3 extends JFrame{
	private Image guide1 = new ImageIcon(howtoplay3.class.getResource("/img/guide3.png")).getImage();
	public howtoplay3() {
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
		
		setSize(guide1.getWidth(null)+10,guide1.getHeight(null));
		setLocation(1190, 0);
		setVisible(true);		
	}

	public static void main(String[] args) {
		new howtoplay3();

	}

}
