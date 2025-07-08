package main;

import java.awt.*;

public class EventHandler {
    GamePanel gp;
    Rectangle eventRect;
    int eventRectDefaultX, eventRectDefaultY;
    int tempMap, tempCol, tempRow;

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

        //TP QUARTO - LOJA
        if (gp.currentMap == 0) {
            int tileX = gp.player.worldX / gp.tileSize;
            int tileY = gp.player.worldY / gp.tileSize;
            gp.playSE(1);

            if (tileX == 25 && tileY == 29 || tileX == 24 && tileY == 29) {
                teleportPlayer(1, 26, 28);
            }
        }

        //TP LOJA - INICIO
        if (gp.currentMap == 1) {
            int tileX = gp.player.worldX / gp.tileSize;
            int tileY = gp.player.worldY / gp.tileSize;

            if (tileX == 23 && tileY == 22) {
                teleportPlayer(2, 39, 25);
            }
        }

        //TP INICIO - MATA NEBULOSA
        if (gp.currentMap == 2) {
            int tileX = gp.player.worldX / gp.tileSize;
            int tileY = gp.player.worldY / gp.tileSize;

            if (tileX == 12 && tileY == 24) {
                teleportPlayer(3, 25, 36);
            }
        }

        //TP MATA NEBULOSA - CAMPOS INFINITOS
        if (gp.currentMap == 3) {
            int tileX = gp.player.worldX / gp.tileSize;
            int tileY = gp.player.worldY / gp.tileSize;

            if ((tileX == 25 && tileY == 17 || tileX == 25 && tileY == 16) && gp.MorceguitaQuest) {
                teleportPlayer(4, 24, 48);
            }
        }

        //TP CAMPOS INFINITOS - INFERNO DE MAGMERIA
        if (gp.currentMap == 4) {
            int tileX = gp.player.worldX / gp.tileSize;
            int tileY = gp.player.worldY / gp.tileSize;

            if (tileX == 25 && tileY == 14 && gp.RainbowQuest) {
                teleportPlayer(5, 10, 44);
            }
        }

        //TP INFERNO DE MAGMERIA - DESERTO SOMBRIO
        if (gp.currentMap == 5) {
            int tileX = gp.player.worldX / gp.tileSize;
            int tileY = gp.player.worldY / gp.tileSize;

            if ((tileX == 16 && tileY == 28) && gp.arkamQuest) {
                teleportPlayer(6, 7, 45);
            }
        }

        //TP DESERTO SOMBRIO - FINAL
        if (gp.currentMap == 6) {
            int tileX = gp.player.worldX / gp.tileSize;
            int tileY = gp.player.worldY / gp.tileSize;

            if ((tileX == 26 && tileY == 8) && gp.questDeserto) {
                teleportPlayer(7, 24, 41);
            }
        }

        //FALA MAPA QUARTO
        if (gp.currentMap == 0 && !gp.speakEvent[0]) {
            if (hit(23, 25, "any") || hit(24, 25, "any") || hit(25, 24, "any")) {
                gp.ui.currentDialogue = "Bom dia irmãzinha!... Irmã? Será que ela/nestá na loja?/n*Aperte ESPAÇO para continuar";
                gp.gameState = gp.dialogueState;
                gp.speakEvent[0] = true;
            }
        }

        //FALA MAPA LOJA
        if (gp.currentMap == 1 && !gp.speakEvent[1]) {
            if (hit(26, 28, "any")) {
                gp.ui.currentDialogue = "A loja está intacta... Onde ela está?/n*Pressione ENTER para falar com os/npersonagens e ler placas.";
                gp.gameState = gp.dialogueState;
                gp.speakEvent[1] = true;
            }
        }
    }

    public void teleportPlayer(int targetMap, int tileX, int tileY) {
        gp.ui.targetMap = targetMap;
        gp.ui.targetTileX = tileX;
        gp.ui.targetTileY = tileY;
        gp.ui.teleportRequested = true;
        gp.gameState = gp.transitionState;
        gp.ui.counter = 0;
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
