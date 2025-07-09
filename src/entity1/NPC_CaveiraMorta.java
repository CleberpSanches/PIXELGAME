package entity1;

import Objects1.Obj_FragmentodeEspelho;
import main1.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class NPC_CaveiraMorta extends Entity{
    public boolean itemEntregue;

    public NPC_CaveiraMorta(GamePanel gp) {
        super(gp);
        direction = "down1";
        speed = 0;
        dialogueSet = -1;
        name = "caveiramorta";
        getImage();
        setDialogue();

        solidArea.height = gp.tileSize*2;
        solidArea.width = gp.tileSize*2;
    }

    public void getImage() {
        down1 = setup("/npc/NpcparaPuzzles/NpcCaveiras/morto1", gp.tileSize*2, gp.tileSize*2);
        down2 = setup("/npc/NpcparaPuzzles/NpcCaveiras/morto2", gp.tileSize*2, gp.tileSize*2);
        down3 = setup("/npc/NpcparaPuzzles/NpcCaveiras/morto3", gp.tileSize*2, gp.tileSize*2);
        down4 = setup("/npc/NpcparaPuzzles/NpcCaveiras/morto4", gp.tileSize*2, gp.tileSize*2);
    }

    public void setDialogue(){
        dialogues[0][0] = "Não há nada aqui!";
    }

    public void setAction(){
        actionLookCounter ++;
        if (actionLookCounter == 30) {
            if (direction.equals("down1")){
                direction = "down2";
            } else if (direction.equals("down2")){
                direction = "down3";
            }
            else if (direction.equals("down3")){
                direction = "down4";
            }
            else if (direction.equals("down4")){
                direction = "down1";
            } else {
                direction = "down1";
            }
            actionLookCounter = 0;
        }
    }

    public void speak(){
        if (!itemEntregue) {
            gp.player.Inventory.add(new Obj_FragmentodeEspelho(gp)); // entrega o item
            itemEntregue = true;

            dialogues[0][0] = "Você vê algo brilhando dentro do olho/ndesta caveira!";
            dialogues[0][1] = "Você pegou um fragmento de espelho!";

            direction = "down1";
        } else {
            dialogues[0][0] = "Não há mais nada aqui!";
            dialogues[0][1] = null;
        }

        startDialogue(this, 0);
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
