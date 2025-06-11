package entity;

import Objects.Obj_EssenciadeFogo;
import main.GamePanel;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class NPC_FogoMagmeria extends Entity{
    public boolean totemCorreto = false;

    public NPC_FogoMagmeria(GamePanel gp) {
        super(gp);
        direction = "down1";
        speed = 0;
        dialogueSet = -1;
        name = "fogomagmeria";
        getImage();
        setDialogue();
    }

    public void getImage() {
        down1 = setup("/npc/NpcparaPuzzles/NPC_FogoCenario/fogo1", gp.tileSize, gp.tileSize);
        down2 = setup("/npc/NpcparaPuzzles/NPC_FogoCenario/fogo2", gp.tileSize, gp.tileSize);
        down3 = setup("/npc/NpcparaPuzzles/NPC_FogoCenario/fogo3", gp.tileSize, gp.tileSize);
        down3 = setup("/npc/NpcparaPuzzles/NPC_FogoCenario/fogo4", gp.tileSize, gp.tileSize);
    }

    public void setDialogue(){
        dialogues[0][0] = "O fogo te queima/nvocê saí rápido de perto!";
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
        direction = "down2";
    }

}
