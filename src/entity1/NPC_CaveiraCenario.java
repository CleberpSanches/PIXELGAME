package entity1;

import main1.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class NPC_CaveiraCenario extends Entity{
    public NPC_CaveiraCenario(GamePanel gp) {
        super(gp);
        direction = "down1";
        speed = 0;
        dialogueSet = -1;
        name = "caveiracenario";
        getImage();
        setDialogue();

        solidArea.height = gp.tileSize*2;
        solidArea.width = gp.tileSize*2;
    }

    public void getImage() {
        down1 = setup("/npc/NpcparaPuzzles/NpcCaveiras/morto1", gp.tileSize*2, gp.tileSize*2);
    }

    public void setDialogue(){
        dialogues[0][0] = "Não há nada aqui!";
    }

    public void setAction(){
        if (direction.equals("down1")){
            direction = "down1";
        }
    }

    public void speak(){
        super.startDialogue(this, dialogueSet);
        dialogueSet++;

        if(dialogues[dialogueSet][0] == null){
            dialogueSet = 0;
        }
        gp.ui.npc = this;
    }

    @Override
    public void draw(Graphics2D g2) {
        BufferedImage image = down1;

        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        if (worldX + gp.tileSize * 2 > gp.player.worldX - gp.player.screenX &&
                worldX - gp.tileSize * 2 < gp.player.worldX + gp.player.screenX &&
                worldY + gp.tileSize * 2 > gp.player.worldY - gp.player.screenY &&
                worldY - gp.tileSize * 2 < gp.player.worldY + gp.player.screenY) {

            int drawWidth = gp.tileSize * 2;
            int drawHeight = gp.tileSize * 2;

            g2.drawImage(image, screenX, screenY, drawWidth, drawHeight, null);
        }
    }

}
