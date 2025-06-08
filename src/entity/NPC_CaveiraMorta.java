package entity;

import Objects.Obj_FragmentodeEspelho;
import main.GamePanel;
import main.ToolBox;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

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
        BufferedImage image = null;

        // Seleciona a imagem com base na direção atual
        switch (direction) {
            case "down1": image = down1; break;
            case "down2": image = down2; break;
            case "down3": image = down3; break;
            case "down4": image = down4; break;
            default: image = down1; break;
        }

        // Calcula a posição do NPC na tela com base na posição do jogador
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        // Verifica se o NPC está dentro da área visível
        if (worldX + gp.tileSize * 2 > gp.player.worldX - gp.player.screenX &&
                worldX - gp.tileSize * 2 < gp.player.worldX + gp.player.screenX &&
                worldY + gp.tileSize * 2 > gp.player.worldY - gp.player.screenY &&
                worldY - gp.tileSize * 2 < gp.player.worldY + gp.player.screenY) {

            g2.drawImage(image, screenX, screenY, gp.tileSize * 2, gp.tileSize * 2, null);
        }
    }


}
