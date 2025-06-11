package entity;

import Objects.Obj_EssenciadeFogo;
import main.GamePanel;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class NPC_TotemCenario extends Entity{
    public boolean totemCorreto = false;

    public NPC_TotemCenario(GamePanel gp) {
        super(gp);
        direction = "down1";
        speed = 0;
        dialogueSet = -1;
        name = "totemcenario";
        getImage();
        setDialogue();
    }

    public void getImage() {
        down1 = setup("/npc/NpcparaPuzzles/totemmagemeria", gp.tileSize, gp.tileSize);
        down2 = setup("/npc/NpcparaPuzzles/totemcorreto", gp.tileSize, gp.tileSize);


    }

    public void setDialogue(){
        dialogues[0][0] = "Totem incorreto, a balança pesa para a/ndireita!";
    }

    public void setAction(){
        if (direction.equals("down1")){
            direction = "down1";
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
