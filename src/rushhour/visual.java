package rushhour;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class visual extends JFrame{
	public Image background = new ImageIcon(Stage1.class.getResource("/img/map.png")).getImage();
	public Image horse = new ImageIcon(Stage1.class.getResource("/img/run.png")).getImage();
	public Image goal = new ImageIcon(Stage1.class.getResource("/img/짱아.png")).getImage();
	public Image bus1 = new ImageIcon(Stage1.class.getResource("/img/버스.png")).getImage();
	public Image train1 = new ImageIcon(Stage1.class.getResource("/img/짱구기차.png")).getImage();
	public Image airplane1 = new ImageIcon(Stage1.class.getResource("/img/airplane.png")).getImage();
	public Image toy1 = new ImageIcon(Stage1.class.getResource("/img/toy.png")).getImage();
	public Image play1 = new ImageIcon(Stage1.class.getResource("/img/롤러코스터.png")).getImage();
	public Image ladder1 = new ImageIcon(Stage1.class.getResource("/img/사다리.png")).getImage();
	public Image doll1 = new ImageIcon(Stage1.class.getResource("/img/액션가면.png")).getImage();
    
    public int horseX = 0,horseY = 375;
    public int bus1x = 300, bus1y = 75;
    public int train1x = 450, train1y = 375;
    public int airplane1x = 300, airplane1y = 675;
    public int toy1x = 150, toy1y = 225;
    public int play1x=300, play1y=375;
    public int doll1x=750,doll1y=375;
    public int ladder1x=900,ladder1y=225;
    
	
	public visual() {
		
		
		
	}

	public static void main(String[] args) {
	
	}

}
