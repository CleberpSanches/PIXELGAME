package entity;

import main.GamePanel;
import main.ToolBox;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class NPC_Placa extends Entity{
    public NPC_Placa(GamePanel gp) {
        super(gp);
        direction = "down1";
        speed = 0;
        dialogueSet = -1;
        getImage();
        setDialogue();
    }

    public void getImage() {
        down1 = setup("/npc/NpcparaPuzzles/Placa", gp.tileSize, gp.tileSize);
        down2 = setup("/npc/NpcparaPuzzles/Placa", gp.tileSize, gp.tileSize);
        down3 = setup("/npc/NpcparaPuzzles/Placa", gp.tileSize, gp.tileSize);
        down4 = setup("/npc/NpcparaPuzzles/Placa", gp.tileSize, gp.tileSize);

    }

    public void setDialogue(){
        dialogues[0][0] = "Norte - Fazenda dos mortos./nLeste - Castelo da verdade & Cemitério/ndos esquecidos.";
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
        super.startDialogue(this, dialogueSet);
        dialogueSet++;

        if(dialogues[dialogueSet][0] == null){
            dialogueSet = 0;
        }

        gp.gameState = gp.tradeState;
        gp.ui.npc = this;
    }

}
