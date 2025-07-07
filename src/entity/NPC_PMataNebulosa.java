package entity;

import main.GamePanel;

public class NPC_PMataNebulosa extends Entity {
    public NPC_PMataNebulosa(GamePanel gp) {
        super(gp);
        direction = "down1";
        speed = 0;
        dialogueSet = -1;
        getImage();
        setDialogue();
    }

    public void getImage() {
        down1 = setup("/npc/NpcPlacas/placamata", gp.tileSize, gp.tileSize);
    }

    public void setDialogue() {
        dialogues[0][0] = "Fale com Morceguita, quebre os fungos com/nseu poder e entregue os itens a ela para passar/nde fase!";
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