
package main;

import Adapter.KeyHandlerAdapter;
import Interface.PlayerInput;
import Objects.SuperObject;
import entity.Player;
import tile.TileManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable {
    final int originalTileSize = 32;

    public final int tileSize = 64;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = 1024;
    public final int screenHeight = 768;

    //WORLD SETTINGS
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;

    int FPS = 60;


    //SYSTEM
    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler(this);
    Sound sound = new Sound();
    PlayerInput input = new KeyHandlerAdapter(this.keyH);
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter asetter = new AssetSetter(this);
    public Player player;
    public SuperObject obj[] = new SuperObject[9];
    public UI ui = new UI(this);
    Thread gameThread;

    //GAME STATE
    public int gameState;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int titleState = 0;

    public GamePanel() {
        this.player = new Player(this, input);
        this.setPreferredSize(new Dimension(1024, 768));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(this.keyH);
        this.setFocusable(true);
    }

    public void setupGame(){
        asetter.setObject();
        gameState = titleState;

    }

    public void startGameThread() {
        this.gameThread = new Thread(this);
        this.gameThread.start();
    }

    public void run() {
        double drawInterval = 1000000000 / (double)this.FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long timer = 0;
        int drawCount = 0;

        while(this.gameThread != null) {
            long currentTime = System.nanoTime();
            delta += (double)(currentTime - lastTime) / drawInterval;
            timer += currentTime - lastTime;
            lastTime = currentTime;
            if (delta >= 1) {
                this.update();
                this.repaint();
                --delta;
                ++drawCount;
            }

            if (timer >= 1000000000) {
                System.out.println("FPS:" + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }

    }

    public void update() {
        if (gameState == titleState){

        }

        if(gameState == playState){
            player.update();
            if (!sound.isPlaying()) {
                playMusic(1);
            }
        }
        if(gameState == pauseState){
            //nada aqui! normal
            stopMusic();
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        for (int i = 0; i < obj.length; i++)
        {
            if (obj[i] !=null)
            {
                obj[i].draw(g2,this);
            }
        }

        //TITLE SCREEN
        if(gameState == titleState){

            ui.draw(g2);
        }//OTHERS
        else{
            tileM.draw(g2);
            player.draw(g2);
            ui.draw(g2);
        }

        g2.dispose();
    }

    public void playMusic(int i){

        sound.setFile(i);
        sound.setVolume(-20.0f);
        //sound.loop();
        sound.play();

    }

    public void stopMusic(){
        sound.stop();
    }

    public void playSE(int i){

        sound.setFile(i);
        sound.play();
    }


}


