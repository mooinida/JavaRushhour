package rushhour;

import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

public class StageSet {

}
public void moveHorse(int dx, int dy) {
    int newHorseX = horseX + dx;
    int newHorseY = horseY + dy;

    if (newHorseX >= 150 && newHorseX + horse.getWidth(null) <= getWidth() - 150) {
        if ((newHorseX != train1x || newHorseY != train1y))
                {
        
            horseX = newHorseX;
        }
    }

    if (newHorseX >= 150 && newHorseX + horse.getWidth(null) <= getWidth() - 150) {
        if ((newHorseX != train1x || newHorseY != train1y))
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

                success1 s = new success1();
                s.setVisible(true);
                setVisible(false);
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
        if (((newBus1X != train1x && newBus1X+150 !=train1x)|| newBus1Y != train1y ) &&
                (newBus1X < horseX || newBus1X >= horseX + horse.getWidth(null) || newBus1Y != horseY)) {
            bus1x = newBus1X;
        }
    }

    if (newBus1Y >= 75 && newBus1Y + bus1.getHeight(null) <= getHeight()) {
        if (((newBus1X != train1x && newBus1X+150 !=train1x) || newBus1Y != train1y) &&
                (newBus1X < horseX || newBus1X >= horseX + horse.getWidth(null) || newBus1Y != horseY)) {
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
                	((newTrain1X < airplane1x && newTrain1X > airplane1x+300)|| newTrain1Y != airplane1y )) {
            train1x = newTrain1X;
        }
    }

    if (newTrain1X>= 150 && newTrain1X + train1.getWidth(null) <= getWidth()-150) {
        if (((newTrain1X != bus1x && newTrain1X != bus1x+150)|| newTrain1Y != bus1y ) &&
                (newTrain1X < horseX || newTrain1X >= horseX + horse.getWidth(null) || newTrain1Y != horseY) &&
                ((newTrain1X < airplane1x && newTrain1X > airplane1x+300)|| newTrain1Y != airplane1y )) {
            train1y = newTrain1Y;
        }
    }

    repaint();
}
public void moveAirplane(int dx, int dy) {
    int newAirplane1X = airplane1x + dx;
    int newAirplane1Y = airplane1y + dy;

    if (newAirplane1X>= 150 && newAirplane1X + airplane1.getWidth(null) <= getWidth()-150) {
    	if (((newAirplane1X != train1x && newAirplane1X+300 !=train1x) || newAirplane1Y != train1y))
                {
        	airplane1x = newAirplane1X;
        }
    }

    if (newAirplane1X>= 150 && newAirplane1X + airplane1.getWidth(null) <= getWidth()-150) {
    	if (((newAirplane1X != train1x && newAirplane1X+300 !=train1x) || newAirplane1Y != train1y))
                {
        	airplane1y = newAirplane1Y;
        }
    }
    repaint();
}
public void moveToy(int dx, int dy) {
    int newToy1X = toy1x + dx;
    int newToy1Y = toy1y + dy;

    if (newToy1X>= 150 && newToy1X+ toy1.getWidth(null) <= getWidth()-150) {
    	if (((newToy1X != train1x && newToy1X+300 !=train1x) || newToy1Y != train1y))
                {
    		toy1x=newToy1X;
        }
    }

    if (newToy1X>= 150 && newToy1X+ toy1.getWidth(null) <= getWidth()-150) {
    	if (((newToy1X != train1x && newToy1X+300 !=train1x) || newToy1Y != train1y))
                {
    		toy1y=newToy1Y;
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
            } else if (isAirplane1Cliked) {
            	moveAirplane(-stepSize, 0);
            }
            else if (isHorseClicked) {
                moveHorse(-stepSize, 0);
            }
            else if (isToy1Cliked) {
                moveToy(-stepSize, 0);
            }
            cnt++;
            break;
        case KeyEvent.VK_RIGHT:
            if (isBus1Clicked) {
                moveBus(stepSize, 0);
            } else if (isAirplane1Cliked) {
                moveAirplane(stepSize, 0);
            }
            else if (isHorseClicked) {
                moveHorse(stepSize, 0);
            }else if (isToy1Cliked) {
                moveToy(stepSize, 0);
            }
            
            cnt++;
            break;
        case KeyEvent.VK_UP:
            if (isTrain1Cliked) {
                moveTrain(0, -stepSize);
            } else if (isHorseClicked) {
                moveHorse(0, -stepSize);
            }
            cnt++;
            break;
        case KeyEvent.VK_DOWN:
            if (isTrain1Cliked) {
                moveTrain(0, stepSize);
            } else if (isHorseClicked) {
                moveHorse(0, stepSize);
            }
            cnt++;
            break;
        case KeyEvent.VK_B:
            isBus1Clicked = true;
            isHorseClicked = false;
            isTrain1Cliked=false;
            isAirplane1Cliked=false;
            isToy1Cliked=false;
            break;
        case KeyEvent.VK_H:
            isHorseClicked = true;
            isBus1Clicked = false;
            isTrain1Cliked=false;
            isAirplane1Cliked=false;
            isToy1Cliked=false;
            break;
        case KeyEvent.VK_T:
            isHorseClicked = false;
            isBus1Clicked = false;
            isTrain1Cliked=true;
            isAirplane1Cliked=false;
            isToy1Cliked=false;
            break;
        case KeyEvent.VK_A:
            isHorseClicked = false;
            isBus1Clicked = false;
            isTrain1Cliked=false;
            isAirplane1Cliked=true;
            isToy1Cliked=false;
            break;
        case KeyEvent.VK_R:
            isHorseClicked = false;
            isBus1Clicked = false;
            isTrain1Cliked=false;
            isAirplane1Cliked=false;
            isToy1Cliked=true;
            break;
    }
}

@Override
public void keyTyped(KeyEvent e) {
}

@Override
public void keyReleased(KeyEvent e) {
}