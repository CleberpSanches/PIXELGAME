package entity1;

import main1.GamePanel;

public class NPC_Orus extends Entity{
    public NPC_Orus(GamePanel gp) {
        super(gp);
        direction = "down1";
        speed = 0;
        dialogueSet = -1;
        getImage();
        setDialogue();
    }

    public void getImage() {
        down1 = setup("/npc/NpcOrus/Orus1", gp.tileSize, gp.tileSize);
        down2 = setup("/npc/NpcOrus/Orus2", gp.tileSize, gp.tileSize);
        down3 = setup("/npc/NpcOrus/Orus3", gp.tileSize, gp.tileSize);
        down4 = setup("/npc/NpcOrus/Orus1", gp.tileSize, gp.tileSize);
    }

    public void setDialogue(){
        dialogues[0][0] = "Consegue ver direito? Então apenas/num olho é o correto!";
    }

    public void setAction(){
        actionLookCounter ++;
        if (actionLookCounter == 30) {
            if (direction.equals("down1")){
                direction = "down2";
            } else if (direction.equals("down2")){
                direction = "down3";
            }
            else if (direction.equals("down3")){
                direction = "down4";
            }
            else if (direction.equals("down4")){
                direction = "down1";
            } else {
                direction = "down1";
            }
            actionLookCounter = 0;

        }

    }



    public void speak(){
        dialogueSet++;

        if (dialogueSet >= dialogues.length || dialogues[dialogueSet][0] == null) {
            dialogueSet = 0;
            gp.gameState = gp.tradeState;
            dialogues[0][0] = "Manda pra cá!";
            dialogues[0][1] = null;
            return;
        }

        super.startDialogue(this, dialogueSet);
    }

}
