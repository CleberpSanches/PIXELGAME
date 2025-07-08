package entity;

import Objects.Obj_Garrafadagua;
import main.GamePanel;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class NPC_GolemdeFogo extends Entity{
    Entity npc;
    public NPC_GolemdeFogo(GamePanel gp) {
        super(gp);
        direction = "down1";
        speed = 0;
        dialogueSet = -1;
        getImage();
        setDialogue();
    }

    public void getImage() {
        down1 = setup("/npc/NpcGolemdeFogo/GolemdeFogo1", gp.tileSize, gp.tileSize);
        down2 = setup("/npc/NpcGolemdeFogo/GolemdeFogo2", gp.tileSize, gp.tileSize);
        down3 = setup("/npc/NpcGolemdeFogo/GolemdeFogo3", gp.tileSize, gp.tileSize);
        down4 = setup("/npc/NpcGolemdeFogo/GolemdeFogo1", gp.tileSize, gp.tileSize);

    }

    public void setDialogue(){
        dialogues[0][0] = "Eu sou Luminus, o golem protetor de Magméria./nO fogo queima, mas apenas os tolos que/nnão sabem idar com o mesmo!";
        dialogues[0][1] = "Interaja com eles e receba seu prêmio!";


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
        gp.ui.npc = this;
    }

}
