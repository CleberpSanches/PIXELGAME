
package main;

import Adapter.KeyHandlerAdapter;
import Interface.PlayerInput;
import entity.Entity;
import entity.Player;
import tile.TileManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable {
    final int originalTileSize = 32;

    public final int tileSize = 64;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = 1024;
    public final int screenHeight = 768;

    //WORLD SETTINGS
    public  int maxWorldCol;
    public  int maxWorldRow;
    public final int maxMap = 10;
    public int currentMap = 0;

    int FPS = 60;


    //SYSTEM
    TileManager tileM = new TileManager(this);
    public KeyHandler keyH = new KeyHandler(this);
    Sound sound = new Sound();
    PlayerInput input = new KeyHandlerAdapter(this.keyH);
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter asetter = new AssetSetter(this);
    public Player player;
    public Entity obj[] = new Entity[16];
    public UI ui = new UI(this);
    public EventHandler eHandler = new EventHandler(this);
    Thread gameThread;
    public Entity npc[] = new Entity[5];
    ArrayList<Entity> entityList = new ArrayList<>();


    //GAME STATE
    public int gameState;
    int previousState;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int dialogueState = 3;
    public final int titleState = 0;
    public final int characterState = 4;

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
        asetter.setNPC();
        gameState = titleState;
        previousState = titleState;
        playMusic(0);

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


        if (gameState != previousState) {
            stopMusic();

            if (gameState == titleState) {
                playMusic(0);
            } else if (gameState == playState) {
                playMusic(1);
            } else if (gameState == pauseState) {

            }

            previousState = gameState;
        }

        if (gameState == playState) {
            player.update();

            for (int i = 0; i < npc.length; i++) {
                if (npc[i] != null) {
                    npc[i].update();
                }
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        long drawStart = 0;
        if (keyH.checkDrawTime == true)
        {
            drawStart = System.nanoTime();
        }


        //prestar atenção aqui que provavelmente é o que está fazendo não carregar os itens

        //TITLE SCREEN
        if(gameState == titleState){
            ui.draw(g2);
        }//OTHERS
        else{
            tileM.draw(g2);

            entityList.add(player);

            for (int i = 0; i < npc.length; i++) {
                if (npc[i] != null){
                    entityList.add(npc[i]);
                }

            }

            for (int i = 0; i < obj.length; i++) {
                if (obj[i] != null){
                    entityList.add(obj[i]);
                }

            }

            Collections.sort(entityList, new Comparator<Entity>() {
                @Override
                public int compare(Entity e1, Entity e2) {
                    int result = Integer.compare(e1.worldY, e1.worldY);
                    return result;
                }
            });

            for (int i = 0; i < entityList.size(); i++) {
                entityList.get(i).draw(g2);
            }

            for (int i = 0; i < entityList.size(); i++) {
                entityList.remove(i);
            }

            ui.draw(g2);
        }
        if (keyH.checkDrawTime == true){
            long drawEnd = System.nanoTime();
            long passed = drawEnd - drawStart;
            g2.setColor(Color.white);
            g2.drawString("Draw Time: " + passed, 10, 400);
            System.out.println("Draw Time: " + passed);
        }

        g2.dispose();
    }

    public void playMusic(int i){

        if (sound.clip != null) {
            sound.stop();  // para o que tá tocando antes
        }

        sound.setFile(i);
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


