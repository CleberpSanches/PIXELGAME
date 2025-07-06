package entity;

import main.GamePanel;

public class NPC_PDesertoSombrio extends Entity {
    public NPC_PDesertoSombrio(GamePanel gp) {
        super(gp);
        direction = "down1";
        speed = 0;
        dialogueSet = -1;
        getImage();
        setDialogue();
    }

    public void getImage() {
        down1 = setup("/npc/NpcPlacas/placadeserto", gp.tileSize, gp.tileSize);
    }

    public void setDialogue() {
        dialogues[0][0] = "Explore o mapa, fale com os locais e/njunte as peças do espelho da verdade/npara chegar até sua irmã!!";
    }

    public void setAction() {
        if (direction.equals("down1")) {
            direction = "down1";
        }
    }
}
