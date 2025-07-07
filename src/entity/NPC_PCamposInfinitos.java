package entity;

import main.GamePanel;

public class NPC_PCamposInfinitos extends Entity {
    public NPC_PCamposInfinitos(GamePanel gp) {
        super(gp);
        direction = "down1";
        speed = 0;
        dialogueSet = -1;
        getImage();
        setDialogue();
    }

    public void getImage() {
        down1 = setup("/npc/NpcPlacas/placalabirinto", gp.tileSize, gp.tileSize);
    }

    public void setDialogue() {
        dialogues[0][0] = "Fale com os cidadãos do campo, cumpra suas/nmissões e alimente o arco-íris com os orbes!!";
    }

    public void setAction() {
        if (direction.equals("down1")) {
            direction = "down1";
        }
    }

    public void speak(){
        super.startDialogue(this, dialogueSet);
        dialogueSet++;
    }
}
