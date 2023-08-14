package rushhour;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

import javazoom.jl.player.Player;

public class bgm extends Thread {
    private Player player;
    private boolean isLoop;
    private File file;
    private FileInputStream fis;
    private BufferedInputStream bis;

    public bgm(String name, boolean isLoop) {
        try {
            this.isLoop = isLoop;
            file = new File("src/mp3/" + name + ".mp3");
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            player = new Player(bis);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void close() {
        isLoop = false;
        player.close();
        this.interrupt();
    }

    public void run() {
        try {
            do {
                player.play();
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                player = new Player(bis);
            } while (isLoop && !Thread.currentThread().isInterrupted());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void play() {
        try {
            if (player != null) {
                player.play();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        bgm a = new bgm("run", true);
        a.start();

       
    }
}
