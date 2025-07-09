package entity1;

import main1.GamePanel;

public class NPC_Ilusina extends Entity{
    public NPC_Ilusina(GamePanel gp) {
        super(gp);
        direction = "down1";
        speed = 0;
        dialogueSet = -1;
        name = "ilusino";
        getImage();
        setDialogue();

        solidArea.width = gp.tileSize;
        solidArea.height = gp.tileSize;
    }

    public void getImage() {
        down1 = setup("/npc/NPC_Ilusina/Ilusina1", gp.tileSize, gp.tileSize);
        down2 = setup("/npc/NPC_Ilusina/Ilusina2", gp.tileSize, gp.tileSize);
        down3 = setup("/npc/NPC_Ilusina/Ilusina3", gp.tileSize, gp.tileSize);
    }

    public void setDialogue(){
        dialogues[0][0] = "Eu sou Ilusina, rainha do fogo e do/nequilíbrio para conseguir o item você tem de/nencontrar o equilíbrio!";
        dialogues[0][1] = "Dos três totens a sua frente apenas um/npode equilibrar a balança da forma/ncorreta!";
        dialogues[0][2] = "Pegue as três pedras e teste-as nos totens!";


    }

    public void setAction(){
        actionLookCounter ++;
        if (actionLookCounter == 30) {
            if (direction.equals("down1")){
                direction = "down2";
            } else if (direction.equals("down2")){
                direction = "down3";
            }
            else {
                direction = "down1";
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
        gp.ui.npc = this;
    }

}
