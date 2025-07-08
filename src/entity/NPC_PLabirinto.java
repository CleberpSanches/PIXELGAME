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
        dialogues[0][1] = "Para a primeira porta se você ter o/ncalice de vento a porta se abrirá";
        dialogues[0][2] = "Para a segunda porta você deve usar/nseu poder principal";
        dialogues[0][3] = "Para a terceira porta se você ter a/nchave cipestre a porta se abrirá";
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
