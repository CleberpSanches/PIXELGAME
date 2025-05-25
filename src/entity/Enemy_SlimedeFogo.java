package entity;

import main.GamePanel;

import java.util.Random;

public class Enemy_SlimedeFogo extends Entity{
    public Enemy_SlimedeFogo(GamePanel gp) {
        super(gp);
        direction = "down1";
        speed = 1;
        maxLife = 4;
        life  = maxLife;
        dialogueSet = -1;
        getImage();
        setDialogue();
    }

    public void getImage() {
        down1 = setup("/npc/Enemy/Slime1", gp.tileSize, gp.tileSize);
        down2 = setup("/npc/Enemy/Slime2", gp.tileSize, gp.tileSize);
        down3 = setup("/npc/Enemy/Slime3", gp.tileSize, gp.tileSize);
        down4 = setup("/npc/Enemy/Slime4", gp.tileSize, gp.tileSize);
    }

    public void setDialogue(){
    }

    @Override
    public void setAction() {
        actionLookCounter++;

        if (actionLookCounter == 120) {
            int random = new Random().nextInt(100);

            if (random < 25) {
                direction = "up";
            } else if (random < 50) {
                direction = "down";
            } else if (random < 75) {
                direction = "left";
            } else {
                direction = "right";
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
    }

}
