package entity1;

import main1.GamePanel;

public class NPC_PMagmeria extends Entity {
    public NPC_PMagmeria(GamePanel gp) {
        super(gp);
        direction = "down1";
        speed = 0;
        dialogueSet = 0;
        getImage();
        setDialogue();
    }

    public void getImage() {
        down1 = setup("/npc/NpcPlacas/placamagmeria", gp.tileSize, gp.tileSize);
    }

    public void setDialogue() {
        dialogues[0][0] = "Fale com Arkam e passe os desafios de seus/nlacaios!";
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
