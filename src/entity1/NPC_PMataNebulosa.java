package entity1;

import main1.GamePanel;

public class NPC_PMataNebulosa extends Entity {
    public NPC_PMataNebulosa(GamePanel gp) {
        super(gp);
        direction = "down1";
        speed = 0;
        dialogueSet = 0;
        getImage();
        setDialogue();
    }

    public void getImage() {
        down1 = setup("/npc/NpcPlacas/placamata", gp.tileSize, gp.tileSize);
    }

    public void setDialogue() {
        dialogues[0][0] = "Fale com Morceguita, quebre os itens com/nseu poder e entregue os itens a ela para passar/nde fase!";
        dialogues[0][1] = "Primeiro: Fale com a morceguita a frente";
        dialogues[0][2] = "Segundo: Fale com o fantasmito lá em cima,/nele lhe dará algo...";
        dialogues[0][3] ="Terceiro: Quebre, com sua magia de destruição,/na estrutura no oeste e nordeste";
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