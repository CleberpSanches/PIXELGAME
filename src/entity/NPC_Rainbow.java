package entity;

import Objects.Obj_AmuletoLua;
import Objects.Obj_CaliceVento;
import Objects.Obj_ChaveCipestre;
import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class NPC_Rainbow extends Entity{

    public NPC_Rainbow(GamePanel gp) {
        super(gp);
        direction = "down1";
        speed = 0;
        dialogueSet = -1;
        getImage();
        setDialogue();
        name = "rainbow";
        solidArea.height = 144;
        solidArea.width = 144;
    }

    public void getImage() {
        down1 = setup("/relic/rainbow", gp.tileSize * 3, gp.tileSize * 3);
        down2 = setup("/relic/rainbow_complete", gp.tileSize * 3, gp.tileSize * 3);
    }

    public void setDialogue(){
        dialogues[0][0] = "Você possui todos os meus orbes? Me dê!/nLhe darei uma grande recompensa!";
    }

    public void setAction(){
            if (direction.equals("down1")){
                direction = "down1";
            }
    }

    public void setItems(){

    }

    public void speak(){
        startDialogue(this, dialogueSet);
        dialogueSet++;

        if(dialogues[dialogueSet][0] == null){
            dialogueSet = 0;
        }
        Set<String> requiredItems = Set.of("orbebrisadourada", "orbeoutono", "orberedemoinho");
        List<Entity> items = new ArrayList<>();
        Set<String> requiredItem = Set.of("calicevento");
        List<Entity> items2 = new ArrayList<>();
        for (Entity obj : this.Inventory) {
            if (requiredItems.contains(obj.name)) {
                items.add(obj);
            }
        }
        for (Entity obj : this.Inventory) {
            if (requiredItem.contains(obj.name)) {
                items2.add(obj);
            }
        }
        if (items.size() == 3) {
            dialogues[0][0] = "Aqui está sua recompensa! /nOlhe seu inventário";
            direction = "down2";
            gp.player.Inventory.add(new Obj_CaliceVento(gp));
            gp.RainbowQuest = true;
            this.Inventory.removeAll(items);
            this.Inventory.add(new Obj_CaliceVento(gp));

        }
        else if (items2.size()==1) {
            dialogues[0][0] = "Tenho todos os meus orbes, se vá!" +
                    "/nAtrás de Tigro há uma passagem secreta";
        } else {
            if (name.equals("rainbow") && dialogueIndex == 0) {
                gp.gameState = gp.tradeState;
            }

        }

    }

    @Override
    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {

            switch (this.direction) {
                case "down1":
                    if (this.spriteNum == 1) {
                        image = down1;
                    }
                    break;
                case "down2":
                    if (this.spriteNum == 1) {
                        image = down2;
                    }
                    break;
            }

            int drawWidth = gp.tileSize * 3;
            int drawHeight = gp.tileSize * 3;

            g2.drawImage(image, screenX, screenY, drawWidth, drawHeight, null);
        }
    }
}

