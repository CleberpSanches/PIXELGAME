package entity;

import main.GamePanel;

public class NPC_PCamposInfinitos extends Entity {
    public NPC_PCamposInfinitos(GamePanel gp) {
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
        dialogues[0][0] = "Fale com os cidadãos do campo, cumpra suas/nmissões e alimente o arco-íris com os orbes!!";
        dialogues[0][1] = "Primeiro: Fale com a Sapita";
        dialogues[0][2] = "Segundo: Fale com o Tigro";
        dialogues[0][3] = "Terceiro: Acerte a pergunta do Sr.Anão";
        dialogues[0][4] = "Quarto: Fale mais uma vez com o tigro/ndepois de entregar o que ele quer,/nele lhe dirá algo...";
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
