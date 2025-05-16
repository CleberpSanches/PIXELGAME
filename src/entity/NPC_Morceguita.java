package entity;

import main.GamePanel;

public class NPC_Morceguita extends Entity{
    public NPC_Morceguita(GamePanel gp) {
        super(gp);
        direction = "down1";
        speed = 0;
        getImage();
        setDialogue();
    }

    public void getImage() {
        down1 = setup("/npc/morceguita1", gp.tileSize, gp.tileSize);
        down2 = setup("/npc/morceguita2", gp.tileSize, gp.tileSize);
        down3 = setup("/npc/morceguita3", gp.tileSize, gp.tileSize);
        down4 = setup("/npc/morceguita4", gp.tileSize, gp.tileSize);

    }

    public void setDialogue(){
        dialogues[0][0] = "OIIIIIIIII";
        dialogues[0][1] = "ESTAMOS SOFRENDO UMA CENSURA";

        dialogues[1][0] = "ISSE KRIEN SILERS";
        dialogues[1][1] = "OLD";
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
        startDialogue(this, dialogueSet);
    }

}
