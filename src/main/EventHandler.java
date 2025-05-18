package main;

import java.awt.*;

public class EventHandler {
    GamePanel gp;
    Rectangle eventRect;
    int eventRectDefaultX, eventRectDefaultY;

    public EventHandler(GamePanel gp){
        this.gp = gp;

        eventRect = new Rectangle();
        eventRect.x = 31;
        eventRect.y = 31;
        eventRect.width = 2;
        eventRect.height = 2;
        eventRectDefaultX = eventRect.x;
        eventRectDefaultY = eventRect.y;

    }

    public void checkEvent(){
        if (gp.currentMap == 0) {
            int tileX = gp.player.worldX / gp.tileSize;
            int tileY = gp.player.worldY / gp.tileSize;


        }

        if (gp.currentMap == 1) {
            int tileX = gp.player.worldX / gp.tileSize;
            int tileY = gp.player.worldY / gp.tileSize;

            if (tileX == 23 && tileY == 22) {
                teleportPlayer(2, 38, 25);
            }
        }

        if (gp.currentMap == 2) {
            int tileX = gp.player.worldX / gp.tileSize;
            int tileY = gp.player.worldY / gp.tileSize;

            if (tileX == 12 && tileY == 24) {
                teleportPlayer(3, 25, 36);
            }
        }

        if (gp.currentMap == 3) {
            int tileX = gp.player.worldX / gp.tileSize;
            int tileY = gp.player.worldY / gp.tileSize;

            if (tileX == 25 && tileY == 16 || tileX == 24 && tileY == 16) {
                teleportPlayer(4, 10, 41);
            }
        }

        if (gp.currentMap == 4) {
            int tileX = gp.player.worldX / gp.tileSize;
            int tileY = gp.player.worldY / gp.tileSize;

            if (tileX == 16 && tileY == 27) {
                teleportPlayer(5, 7, 44);
            }
        }
    }

    public void teleportPlayer(int targetMap, int tileX, int tileY) {
        gp.currentMap = targetMap;
        gp.player.worldX = tileX * gp.tileSize;
        gp.player.worldY = tileY * gp.tileSize;
    }
}
