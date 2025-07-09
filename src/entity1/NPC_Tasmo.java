package entity1;

import main1.GamePanel;

public class NPC_Tasmo extends Entity{
    public NPC_Tasmo(GamePanel gp) {
        super(gp);
        direction = "down1";
        speed = 0;
        name = "tasmo";
        dialogueSet = -1;
        getImage();
        setDialogue();
    }

    public void getImage() {
        down1 = setup("/npc/NpcTasmo/TAS1", gp.tileSize, gp.tileSize);
        down2 = setup("/npc/NpcTasmo/TAS2", gp.tileSize, gp.tileSize);
        down3 = setup("/npc/NpcTasmo/TAS3", gp.tileSize, gp.tileSize);
        down4 = setup("/npc/NpcTasmo/TAS4", gp.tileSize, gp.tileSize);

    }

    public void setDialogue(){
        dialogues[0][0] = "Vi algo brilhante dentro dos olhos/nde um desses mortos!";
        dialogues[0][1] = "Parece interessante!";

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
        super.startDialogue(this, dialogueSet);
        dialogueSet++;

        if(dialogues[dialogueSet][0] == null){
            dialogueSet = 0;
        }
    }

}
