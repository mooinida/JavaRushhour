package rushhour;

import java.io.FileInputStream;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import javazoom.jl.player.Player;

public class effect {
    private Player player;
    public effect(String name) {
    	try {
    		FileInputStream fileInputStream=new FileInputStream("src/mp3/"+name+".mp3");
    		player=new Player(fileInputStream);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    public void play() {
    	try {if(player!=null) {
    		player.play();
    		while(!player.isComplete()) {
    	
    		Thread.sleep(1000);
    		}
    		
    		close();
    	}
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    public void close() {
    	try {
    	if(player!=null) {
    		player.close();}
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    public static void main(String[] args) {
        effect a=new effect("run");
        a.play();
    }
}
