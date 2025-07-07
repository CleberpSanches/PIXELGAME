package entity;

import main.GamePanel;

public class NPC_PInicio extends Entity {
    public NPC_PInicio(GamePanel gp) {
        super(gp);
        name = "placainicio";
        direction = "down1";
        speed = 0;
        dialogueSet = 0;
        getImage();
        setDialogue();
    }

    public void getImage() {
        down1 = setup("/npc/NpcPlacas/placainicio", gp.tileSize, gp.tileSize);
    }

    public void setDialogue() {
        dialogues[0][0] = "Fale com o Cavaleiro e aprenda os controles do jogo/npara se comunicas aperte ENTER no personagem!";
    }

    public void setAction() {
        if (direction.equals("down1")) {
            direction = "down1";
        }
    }

    public void speak(){
        startDialogue(this, dialogueSet);
    }
}