
package main;

import Adapter.KeyHandlerAdapter;
import Interface.PlayerInput;
import Tile_Items.TileItems;
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
    public  int maxWorldCol = 50;
    public  int maxWorldRow = 50;
    public final int maxMap = 10;
    public int currentMap = 0;
    public Sound music;
    public Sound se;

    int FPS = 60;

    //MAP
    public String[][][] mapTileName = new String[maxMap][maxWorldCol][maxWorldRow];
    public TileManager tileManager;

    //SYSTEM
    public TileManager tileM = new TileManager(this);
    public KeyHandler keyH = new KeyHandler(this);
    Sound sound = new Sound();
    PlayerInput input = new KeyHandlerAdapter(this.keyH);
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter asetter = new AssetSetter(this);
    public Player player;
    public UI ui = new UI(this);
    public EventHandler eHandler = new EventHandler(this);
    Thread gameThread;

    //ENTITYS
    public Entity obj[][] = new Entity[maxMap][16];
    public Entity npc[][] = new Entity[maxMap][10];
    public Entity monster[][] = new Entity[maxMap][20];
    ArrayList<Entity> entityList = new ArrayList<>();
    public TileItems tItens[][] = new TileItems[maxMap][50];

    //GAME STATE
    public int gameState;
    int previousState;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int dialogueState = 3;
    public final int titleState = 0;
    public final int characterState = 4;
    public final int transitionState = 5;

    public GamePanel() {
        this.player = new Player(this, input);
        tileManager = new TileManager(this);
        music = new Sound();
        se = new Sound();
        this.setPreferredSize(new Dimension(1024, 768));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(this.keyH);
        this.setFocusable(true);
        setPlayerSpawn();
    }

    public void teleportPlayer(int targetMap) {
        currentMap = targetMap;
        setPlayerSpawn();
    }

    public void checkTeleport() {
        int playerTileX = player.worldX / tileSize;
        int playerTileY = player.worldY / tileSize;

        System.out.println("Player tile: " + playerTileX + ", " + playerTileY);
    }

    public void setPlayerSpawn() {
        int spawnX = tileManager.spawnPoints[currentMap][0];
        int spawnY = tileManager.spawnPoints[currentMap][1];

        player.setPosition(spawnX * tileSize, spawnY * tileSize);
    }

    public void setupGame(){
        asetter.setObject();
        asetter.setNPC();
        asetter.setTItens();
        asetter.setMonster();
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

        //GAME STATE UPDATE
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

        //CHARACTER UPDATE
        if (gameState == playState) {
            player.update();
            checkTeleport();
            for (int i = 0; i < npc[1].length; i++) {
                if (npc[currentMap][i] != null) {
                    npc[currentMap][i].update();
                }
            }

            for (int i = 0; i < tItens[1].length; i++) {
                if (tItens[currentMap][i] != null) {
                    tItens[currentMap][i].update();
                }
            }

            for (int i = 0; i < monster[1].length; i++){
                if (monster[currentMap][i] != null){
                    monster[currentMap][i].update();
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

        //TITLE SCREEN
        if(gameState == titleState){
            ui.draw(g2);
        }//OTHERS
        else{
            tileM.draw(g2);

            //CHARACTER PAINTCOMPONENT
            entityList.add(player);
            for (int i = 0; i < tItens[1].length; i++) {
                if (tItens[currentMap][i] != null){
                    tItens[currentMap][i].draw(g2);
                }

            }
            for (int i = 0; i < npc[1].length; i++) {
                if (npc[currentMap][i] != null){
                    entityList.add(npc[currentMap][i]);
                    npc[currentMap][i].draw(g2);

                }

            }
            for (int i = 0; i < obj[1].length; i++) {
                if (obj[currentMap][i] != null){
                    entityList.add(obj[currentMap][i]);
                }

            }
            for (int i = 0; i < monster[1].length; i++){
                if (monster[currentMap][i] != null){
                    entityList.add(monster[currentMap][i]);
                    monster[currentMap][i].draw(g2);
                }
            }

            Collections.sort(entityList, new Comparator<Entity>() {
                @Override
                public int compare(Entity e1, Entity e2) {
                    int result = Integer.compare(e1.worldY, e2.worldY);
                    return result;
                }
            });

            for (int i = 0; i < entityList.size(); i++) {
                entityList.get(i).draw(g2);
            }

            entityList.clear();

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
        se.setFile(i);
        se.stop();
        se.play();
    }


}


