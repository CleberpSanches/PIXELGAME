package entity;

import main.GamePanel;
import main.ToolBox;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class NPC_Sapita extends Entity{
    public NPC_Sapita(GamePanel gp) {
        super(gp);
        direction = "down1";
        speed = 0;
        getImage();
        setDialogue();
    }

    public void getImage() {
        down1 = setup("/npc/sapeta1");
        down2 = setup("/npc/sapeta2");
        down3 = setup("/npc/sapeta3");
        down4 = setup("/npc/sapeta4");

    }

    public void setDialogue(){
        dialogues[0] = "Hello";
        dialogues[1] = "Hellooooooooooooooooooooooooooooooooooooo/noooooooooooooooooooooooooooo";
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
        super.speak();
    }

}
