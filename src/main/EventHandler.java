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
        if(hit(2, 24, "left") == true){
            teleport();
        }

        if (gp.currentMap == 0) {
            int tileX = gp.player.worldX / gp.tileSize;
            int tileY = gp.player.worldY / gp.tileSize;

            if (tileX == 25 && tileY == 29) {
                teleportPlayer(1, 26, 28);
            }
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
//
//        if (gp.currentMap == 3) {
//            int tileX = gp.player.worldX / gp.tileSize;
//            int tileY = gp.player.worldY / gp.tileSize;
//
//            if (tileX == 24 && tileY == 17) {
//                teleportPlayer(4, 10, 41);
//            }
//        }
//
//        if (gp.currentMap == 4) {
//            int tileX = gp.player.worldX / gp.tileSize;
//            int tileY = gp.player.worldY / gp.tileSize;
//
//            if (tileX == 16 && tileY == 27) {
//                teleportPlayer(5, 7, 44);
//            }
//        }
    }

    public void teleportPlayer(int targetMap, int tileX, int tileY) {
        gp.currentMap = targetMap;
        gp.player.worldX = tileX * gp.tileSize;
        gp.player.worldY = tileY * gp.tileSize;
    }


    private boolean hit(int eventCol, int eventRow, String reqDirection) {
        boolean hit = false;

        gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
        gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
        eventRect.x = eventCol * gp.tileSize + eventRect.x;
        eventRect.y = eventRow * gp.tileSize + eventRect.y;

        if(gp.player.solidArea.intersects(eventRect))
        {
            if(gp.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any"))
            {
                hit = true;
            }
        }

        gp.player.solidArea.x = gp.player.solidAreaDefaultX;
        gp.player.solidArea.y = gp.player.solidAreaDefaultY;
        eventRect.x = eventRectDefaultX;
        eventRect.y = eventRectDefaultY;

        return hit;
    }

    private void teleport() {
        gp.player.worldX = gp.tileSize*2;
        gp.player.worldY = gp.tileSize*26;
    }


}
