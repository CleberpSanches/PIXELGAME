package entity;

import main.GamePanel;
import main.ToolBox;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class NPC_OlhoCenario extends Entity{
    public NPC_OlhoCenario(GamePanel gp) {
        super(gp);
        direction = "down1";
        speed = 0;
        dialogueSet = -1;
        name = "olhocenario";
        getImage();
        setDialogue();

        solidArea.height = gp.tileSize;
        solidArea.width = gp.tileSize;
    }

    public void getImage() {
        down1 = setup("/npc/NpcparaPuzzles/NpcOlho/olho1", gp.tileSize*2, gp.tileSize*2);
    }

    public void setDialogue(){
        dialogues[0][0] = "Olho errado!";
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

}
