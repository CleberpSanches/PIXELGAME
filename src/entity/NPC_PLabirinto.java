package entity;

import main.GamePanel;

public class NPC_PLabirinto extends Entity {
    public NPC_PLabirinto(GamePanel gp) {
        super(gp);
        direction = "down1";
        speed = 0;
        dialogueSet = 0;
        getImage();
        setDialogue();
    }

    public void getImage() {
        down1 = setup("/npc/NpcPlacas/placalabirinto", gp.tileSize, gp.tileSize);
    }

    public void setDialogue() {
        dialogues[0][0] = "Exploque o labirinto e encontre sua irmã!";
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
