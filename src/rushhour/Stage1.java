package rushhour;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;

import javax.print.attribute.standard.MultipleDocumentHandling;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;


public class Stage1 extends visual implements KeyListener, MouseListener, MouseMotionListener {
    

   
    private Timer timer;

    private boolean isBus1Clicked = false;
    private boolean isHorseClicked = false;
    private boolean isTrain1Cliked = false;
    private boolean isAirplane1Cliked = false;
    private boolean isToy1Cliked = false;
    private boolean isPlay1Cliked = false;
    private boolean isLadder1Cliked = false;
    private boolean isDoll1Cliked = false;
    
    private long startTime;
    private long endTime;
    private JPanel panel;
    howtoplay ha=new howtoplay();
    int cnt=0;
   // effect run=new effect("run");
    bgm music;
    bgm run=new bgm("run", true);
    
    public Stage1() {
        setTitle("Level-1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        startTime = System.currentTimeMillis();
       
        
        setResizable(false);
        setLayout(null);
        setSize(1200, 900);
        
        
        
        
        ha.setVisible(true);
        setVisible(true);
        addKeyListener(this);
        setFocusable(true);
        music=new bgm("배경",true);
        music.start();
        panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                paint(g);
            }
        };

    }

    @Override
    public void paint(Graphics g) {

        g.drawImage(background, 0, 0, null);
        g.drawImage(horse, horseX, horseY, null);
        g.drawImage(goal, 1050, 375, null);
        g.drawImage(bus1, bus1x, bus1y, null);
        g.drawImage(train1, train1x, train1y, null);
        g.drawImage(airplane1, airplane1x, airplane1y, null);
        g.drawImage(toy1, toy1x, toy1y, null);
        g.drawImage(play1, play1x, play1y, null);
        g.drawImage(doll1, doll1x, doll1y, null);
        g.drawImage(ladder1, ladder1x, ladder1y, null);
    }

    public void moveHorse(int dx, int dy) {
    	
    	
        int newHorseX = horseX + dx;
        int newHorseY = horseY + dy;

        if (newHorseX >= 150 && newHorseX + horse.getWidth(null) <= getWidth() - 150) {
        	  if ((newHorseX != train1x || newHorseY != train1y) &&  (newHorseX != play1x || (newHorseY != play1y && newHorseY != play1y+150))
        			  &&  (newHorseX != doll1x || (newHorseY != doll1y && newHorseY != doll1y+150)) 
        			  &&  (newHorseX != ladder1x || (newHorseY != ladder1y && newHorseY != ladder1y+150)))
                    {
            
                horseX = newHorseX;
            }
        }

        if (newHorseY >= 75 && newHorseY + horse.getHeight(null) <= getHeight() ) {
        	if ((newHorseX != train1x || newHorseY != train1y) &&  (newHorseX != play1x || (newHorseY != play1y && newHorseY != play1y+150))
      			  &&  (newHorseX != doll1x || (newHorseY != doll1y && newHorseY != doll1y+150)) 
      			  &&  (newHorseX != ladder1x || (newHorseY != ladder1y && newHorseY != ladder1y+150)))
                  {
            
                horseY = newHorseY;
            }
        }


        if (horseX == 900 && horseY == 375) {
            cnt++;
            Timer t = new Timer();
            System.out.println(cnt);
            horseX = 1050;
            TimerTask task = new TimerTask() {

                @Override
                public void run() {
                	endTime = System.currentTimeMillis();
                	long duration=(endTime-startTime)/1000;
                    
                    
                    
                	music.close();
                    setVisible(false);
                    ha.setVisible(false);
                    
                    success1 s = new success1();
                    
                    Timer t=new Timer();
            		TimerTask task=new TimerTask() {
            			
            			@Override
            			public void run() {
            				
            				new result1(duration,cnt);// success화면이 종료되고 결과 창이 뜨게한다.
            				effect yeah=new effect("성공");
            		        yeah.play();            				
            			}
            		};
            		t.schedule(task, 3000);
            		
                    
                   
                    
                    s.setVisible(true);
                    
                    dispose();
                   
                }

            };
            t.schedule(task, 1000);// 1초 뒤에 task가 작동되게한다
        }

        repaint();
    }
    
    

    public void moveBus(int dx, int dy) {
        int newBus1X = bus1x + dx;
        int newBus1Y = bus1y + dy;
        
        if (newBus1X >= 150 && newBus1X + bus1.getWidth(null) <= getWidth()-150) {
            if (((newBus1X != train1x && newBus1X+150 !=train1x)|| newBus1Y != train1y )&&
                	((newBus1X != play1x && newBus1X+150 !=play1x) || (newBus1Y != play1y && newBus1Y != play1y+150))&&
                	((newBus1X != ladder1x && newBus1X+150!=ladder1x) || (newBus1Y != ladder1y && newBus1Y != ladder1y+150))&&
                		((newBus1X != doll1x && newBus1X+150!=doll1x) || (newBus1Y != doll1y && newBus1Y != doll1y+150))){
                bus1x = newBus1X;
            }
        }

        if (newBus1X >= 150 && newBus1X + bus1.getWidth(null) <= getWidth()-150) {
            if (((newBus1X != train1x && newBus1X+150 !=train1x)|| newBus1Y != train1y )&&
                	((newBus1X != play1x && newBus1X+150 !=play1x) || (newBus1Y != play1y && newBus1Y != play1y+150))&&
                	((newBus1X != ladder1x && newBus1X+150 !=ladder1x) || (newBus1Y != ladder1y && newBus1Y != ladder1y+150))&&
                		((newBus1X != doll1x && newBus1X+150 !=doll1x) || (newBus1Y != doll1y && newBus1Y != doll1y+150))){
            		
                bus1y = newBus1Y;
            }
        }
        
        repaint();
    }
    
    public void moveTrain(int dx, int dy) {
        int newTrain1X = train1x + dx;
        int newTrain1Y = train1y + dy;

        if (newTrain1X>= 150 && newTrain1X + train1.getWidth(null) <= getWidth()-150) {
            if (((newTrain1X != bus1x && newTrain1X != bus1x+150)|| newTrain1Y != bus1y ) &&
                    (newTrain1X < horseX || newTrain1X >= horseX + horse.getWidth(null) || newTrain1Y != horseY) &&
                    ((newTrain1X != airplane1x && newTrain1X != airplane1x+150 && newTrain1X != airplane1x+300)|| newTrain1Y != airplane1y ) &&
            		((newTrain1X != toy1x && newTrain1X != toy1x+150 &&newTrain1X != toy1x+300)|| newTrain1Y != toy1y )){
                train1x = newTrain1X;
            }
        }

        if (newTrain1Y>= 75 && newTrain1Y + train1.getHeight(null) <= getHeight()) {
            if (((newTrain1X != bus1x && newTrain1X != bus1x+150)|| newTrain1Y != bus1y ) &&
                    (newTrain1X < horseX || newTrain1X >= horseX + horse.getWidth(null) || newTrain1Y != horseY) &&
                    ((newTrain1X != airplane1x && newTrain1X != airplane1x+150 && newTrain1X != airplane1x+300)|| newTrain1Y != airplane1y ) &&
            		((newTrain1X != toy1x && newTrain1X != toy1x+150 &&newTrain1X != toy1x+300)|| newTrain1Y != toy1y )){
                train1y = newTrain1Y;
            }
        }

        repaint();
    }
    public void moveAirplane(int dx, int dy) {
        int newAirplane1X = airplane1x + dx;
        int newAirplane1Y = airplane1y + dy;

        if (newAirplane1X>= 150 && newAirplane1X + airplane1.getWidth(null) <= getWidth()-150) {
        	if (((newAirplane1X != train1x && newAirplane1X+300 !=train1x) || newAirplane1Y != train1y)&&
        	((newAirplane1X != ladder1x && newAirplane1X+300 !=ladder1x) || (newAirplane1Y != ladder1y && newAirplane1Y != ladder1y+150))&&
        	((newAirplane1X != play1x && newAirplane1X+300 !=play1x) || (newAirplane1Y != play1y && newAirplane1Y != play1y+150))&&
        	((newAirplane1X != doll1x && newAirplane1X+300 !=doll1x) || (newAirplane1Y != doll1y && newAirplane1Y != doll1y+150))){
            	airplane1x = newAirplane1X;
            }
        }

        if (newAirplane1Y>= 75 && newAirplane1Y + airplane1.getHeight(null) <= getHeight()) {
        	if (((newAirplane1X != train1x && newAirplane1X+300 !=train1x) || newAirplane1Y != train1y)&&
        	((newAirplane1X != ladder1x && newAirplane1X+300 !=ladder1x) || (newAirplane1Y != ladder1y && newAirplane1Y != ladder1y+150))&&
        	((newAirplane1X != play1x && newAirplane1X+300 !=play1x) || (newAirplane1Y != play1y && newAirplane1Y != play1y+150))&&
        	((newAirplane1X != doll1x && newAirplane1X+300 !=doll1x) || (newAirplane1Y != doll1y && newAirplane1Y != doll1y+150))){
                    
            	airplane1y = newAirplane1Y;
            }
        }
        repaint();
    }
    public void moveToy(int dx, int dy) {
        int newToy1X = toy1x + dx;
        int newToy1Y = toy1y + dy;

        if (newToy1X>= 150 && newToy1X+ toy1.getWidth(null) <= getWidth()-150) {
        	if (((newToy1X != train1x && newToy1X+300 !=train1x) || newToy1Y != train1y)&&
                	((newToy1X != ladder1x && newToy1X+300 !=ladder1x) || (newToy1Y != ladder1y && newToy1Y != ladder1y+150))&&
        	((newToy1X != doll1x && newToy1X+300 !=doll1x) || (newToy1Y != doll1y && newToy1Y != doll1y+150))&&
        	((newToy1X != play1x && newToy1X+300 !=play1x) || (newToy1Y != play1y && newToy1Y != play1y+150))){
        		toy1x=newToy1X;
            }
        }

        if (newToy1X>= 150 && newToy1X+ toy1.getWidth(null) <= getWidth()-150) {
        	if (((newToy1X != train1x && newToy1X+300 !=train1x) || newToy1Y != train1y)&&
                	((newToy1X != ladder1x && newToy1X+300 !=ladder1x) || (newToy1Y != ladder1y && newToy1Y != ladder1y+150))&&
        	((newToy1X != doll1x && newToy1X+300 !=doll1x) || (newToy1Y != doll1y && newToy1Y != doll1y+150))&&
        	((newToy1X != play1x && newToy1X+300 !=play1x) || (newToy1Y != play1y && newToy1Y != play1y+150))){
        		toy1y=newToy1Y;
            }
        }
        repaint();
    }
    public void movePlay(int dx, int dy) {
        int newPlay1X = play1x + dx;
        int newPlay1Y = play1y + dy;

        if (newPlay1X>= 150 && newPlay1X + play1.getWidth(null) <= getWidth()-150) {
            if (((newPlay1X != bus1x && newPlay1X != bus1x+150)|| newPlay1Y != bus1y ) &&
                    (newPlay1X < horseX || newPlay1X >= horseX + horse.getWidth(null) || newPlay1Y != horseY) &&
                    ((newPlay1X != airplane1x && newPlay1X != airplane1x+150 && newPlay1X != airplane1x+300)|| (newPlay1Y != airplane1y&&newPlay1Y+150 != airplane1y )) &&
            		((newPlay1X != toy1x && newPlay1X != toy1x+150 &&newPlay1X != toy1x+300)|| newPlay1Y != toy1y)){
            	play1x = newPlay1X;
            }
        }

        if (newPlay1Y>= 75 && newPlay1Y +play1.getHeight(null) <= getHeight()) {
        	if (((newPlay1X != bus1x && newPlay1X != bus1x+150)|| newPlay1Y != bus1y ) &&
                    (newPlay1X < horseX || newPlay1X >= horseX + horse.getWidth(null) || newPlay1Y != horseY) &&
                    ((newPlay1X != airplane1x && newPlay1X != airplane1x+150 && newPlay1X != airplane1x+300)|| (newPlay1Y != airplane1y&&newPlay1Y+150 != airplane1y )) &&
            		((newPlay1X != toy1x && newPlay1X != toy1x+150 &&newPlay1X != toy1x+300)||newPlay1Y != toy1y )){
            	play1y = newPlay1Y;
            }
        }

        repaint();
    }
    public void moveLadder(int dx, int dy) {
        int newLadder1X = ladder1x + dx;
        int newLadder1Y = ladder1y + dy;

        if (newLadder1X>= 150 && newLadder1X + ladder1.getWidth(null) <= getWidth()-150) {
            if (((newLadder1X != bus1x && newLadder1X != bus1x+150)|| newLadder1Y != bus1y ) &&
                    (newLadder1X < horseX || newLadder1X >= horseX + horse.getWidth(null) || newLadder1Y != horseY) &&
                    ((newLadder1X != airplane1x && newLadder1X != airplane1x+150 && newLadder1X != airplane1x+300)|| (newLadder1Y != airplane1y&&newLadder1Y+150 != airplane1y )) &&
            		((newLadder1X != toy1x && newLadder1X != toy1x+150 &&newLadder1X != toy1x+300)|| newLadder1Y != toy1y)){
            	ladder1x = newLadder1X;
            }
        }

        if (newLadder1Y>= 75 && newLadder1Y +ladder1.getHeight(null) <= getHeight()) {
        	if (((newLadder1X != bus1x && newLadder1X != bus1x+150)|| newLadder1Y != bus1y ) &&
                    (newLadder1X < horseX || newLadder1X >= horseX + horse.getWidth(null) || newLadder1Y != horseY) &&
                    ((newLadder1X != airplane1x && newLadder1X != airplane1x+150 && newLadder1X != airplane1x+300)|| (newLadder1Y != airplane1y&&newLadder1Y+150 != airplane1y )) &&
            		((newLadder1X != toy1x && newLadder1X != toy1x+150 &&newLadder1X != toy1x+300)|| newLadder1Y != toy1y)){
            	ladder1y = newLadder1Y;
            }
        }


        repaint();
    }
    public void moveDoll(int dx, int dy) {
        int newDoll1X = doll1x + dx;
        int newDoll1Y = doll1y + dy;

        if (newDoll1X>= 150 && newDoll1X + ladder1.getWidth(null) <= getWidth()-150) {
            if (((newDoll1X != bus1x && newDoll1X != bus1x+150)|| newDoll1Y != bus1y ) &&
                    (newDoll1X < horseX || newDoll1X >= horseX + horse.getWidth(null) || newDoll1Y != horseY) &&
                    ((newDoll1X != airplane1x && newDoll1X != airplane1x+150 && newDoll1X != airplane1x+300)|| (newDoll1Y != airplane1y&&newDoll1Y+150 != airplane1y )) &&
            		((newDoll1X != toy1x && newDoll1X != toy1x+150 &&newDoll1X != toy1x+300)|| newDoll1Y != toy1y)){
            	doll1x = newDoll1X;
            }
        }

        if (newDoll1Y>= 75 && newDoll1Y +ladder1.getHeight(null) <= getHeight()) {
        	if (((newDoll1X != bus1x && newDoll1X != bus1x+150)||newDoll1Y != bus1y ) &&
                    (newDoll1X < horseX || newDoll1X >= horseX + horse.getWidth(null) || newDoll1Y != horseY) &&
                    ((newDoll1X != airplane1x && newDoll1X != airplane1x+150 && newDoll1X != airplane1x+300)|| (newDoll1Y != airplane1y&&newDoll1Y+150 != airplane1y )) &&
            		((newDoll1X != toy1x && newDoll1X != toy1x+150 &&newDoll1X != toy1x+300)|| newDoll1Y != toy1y)){
            	doll1y = newDoll1Y;
            }
        }


        repaint();
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        int stepSize = 150;

        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                if (isBus1Clicked) {
                	moveBus(-stepSize, 0);
                	effect bus=new effect("BusDriving");
                    bus.play();
                    
                    
                } else if (isAirplane1Cliked) {
                	moveAirplane(-stepSize, 0);
                	effect a=new effect("airplane");
                    a.play();
                }
                else if (isHorseClicked) {
                    moveHorse(-stepSize, 0);
                    effect h=new effect("run");
                    h.play();
                    
                }
                else if (isToy1Cliked) {
                    moveToy(-stepSize, 0);
                    effect t=new effect("toy");
                    t.play();
                }
                cnt++;
                break;
            case KeyEvent.VK_RIGHT:
            	if (isBus1Clicked) {   
            	moveBus(stepSize, 0);
                effect bus = new effect("BusDriving");
                bus.play();
                }
                else if (isAirplane1Cliked) {
                    moveAirplane(stepSize, 0);
                    effect a=new effect("airplane");
                    a.play();
                }
                else if (isHorseClicked) {
                    moveHorse(stepSize, 0);
                    effect h=new effect("run");
                    h.play();
                }else if (isToy1Cliked) {
                    moveToy(stepSize, 0);
                    effect t=new effect("toy");
                    t.play();
                }
                
                cnt++;
                break;
            case KeyEvent.VK_UP:
                if (isTrain1Cliked) {
                    moveTrain(0, -stepSize);
                    effect t=new effect("train");
                    t.play();
                } 
                else if (isPlay1Cliked) {
                    movePlay(0, -stepSize);
                    effect p=new effect("roller1");
                    p.play();
                }else if (isLadder1Cliked) {
                	moveLadder(0, -stepSize);
                	effect l=new effect("ladder");
                    l.play();
                }else if (isDoll1Cliked) {
                	moveDoll(0, -stepSize);
                	effect r=new effect("robot");
                    r.play();
                }
                cnt++;
                break;
            case KeyEvent.VK_DOWN:
                if (isTrain1Cliked) {
                    moveTrain(0, stepSize);
                    effect t=new effect("train");
                    t.play();
                }else if (isPlay1Cliked) {
                    movePlay(0, stepSize);
                    effect p=new effect("roller1");
                    p.play();
                }
                else if (isLadder1Cliked) {
                    moveLadder(0, stepSize);
                    effect l=new effect("ladder");
                    l.play();
                }else if (isDoll1Cliked) {
                	moveDoll(0, +stepSize);
                	effect r=new effect("robot");
                    r.play();
                }
                cnt++;
                break;
            case KeyEvent.VK_W:
            	
                isBus1Clicked = true;
                isHorseClicked = false;
                
                isTrain1Cliked=false;
                isAirplane1Cliked=false;
                isToy1Cliked=false;
                isPlay1Cliked=false;
                isLadder1Cliked=false;
                isDoll1Cliked = false;
                break;
            case KeyEvent.VK_Q:
            	
                isHorseClicked = true;
                
                isBus1Clicked = false;
                isTrain1Cliked=false;
                isAirplane1Cliked=false;
                isToy1Cliked=false;
                isPlay1Cliked=false;
                isLadder1Cliked=false;
                isDoll1Cliked = false;
                break;
            case KeyEvent.VK_E:
                isHorseClicked = false;
                isBus1Clicked = false;
                isTrain1Cliked=true;
                isAirplane1Cliked=false;
                isToy1Cliked=false;
                isPlay1Cliked=false;
                isLadder1Cliked=false;
                isDoll1Cliked = false;
                break;
            case KeyEvent.VK_S:
                isHorseClicked = false;
                isBus1Clicked = false;
                isTrain1Cliked=false;
                isAirplane1Cliked=true;
                isToy1Cliked=false;
                isPlay1Cliked=false;
                isLadder1Cliked=false;
                isDoll1Cliked = false;
                break;
            case KeyEvent.VK_R:
                isHorseClicked = false;
                isBus1Clicked = false;
                isTrain1Cliked=false;
                isAirplane1Cliked=false;
                isToy1Cliked=true;
                isPlay1Cliked=false;
                isLadder1Cliked=false;
                isDoll1Cliked = false;
                break;
            case KeyEvent.VK_A:
                isHorseClicked = false;
                isBus1Clicked = false;
                isTrain1Cliked=false;
                isAirplane1Cliked=false;
                isToy1Cliked=false;
                isPlay1Cliked=true;
                isLadder1Cliked=false;
                isDoll1Cliked = false;
                break;
            case KeyEvent.VK_F:
                isHorseClicked = false;
                isBus1Clicked = false;
                isTrain1Cliked=false;
                isAirplane1Cliked=false;
                isToy1Cliked=false;
                isPlay1Cliked=false;
                isLadder1Cliked=true;
                isDoll1Cliked = false;
                break;
            case KeyEvent.VK_D:
                isHorseClicked = false;
                isBus1Clicked = false;
                isTrain1Cliked=false;
                isAirplane1Cliked=false;
                isToy1Cliked=false;
                isPlay1Cliked=false;
                isLadder1Cliked=false;
                isDoll1Cliked = true;
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
   
    
    public static void main(String[] args) {
        
        Stage1 s=new Stage1();
        
    }
}
