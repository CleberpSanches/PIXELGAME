package entity;

import Objects.Obj_EssenciadeFogo;
import Objects.Obj_FragmentodeEspelho;
import Objects.Obj_NucleodeMagma;
import main.GamePanel;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class NPC_TotemCorreto extends Entity{
    public boolean totemCorreto = false;

    public NPC_TotemCorreto(GamePanel gp) {
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
        dialogues[0][0] = "Coloque a pedra aqui!";
    }

    public void setAction(){
        if (direction.equals("down1")){
            direction = "down1";
        }
    }

    public void speak(){
        if (!totemCorreto) {
            gp.player.Inventory.add(new Obj_EssenciadeFogo(gp)); // entrega o item
            totemCorreto = true;

            dialogues[0][0] = "Peso correto, a balança está equilibrada!";
            dialogues[0][1] = "Você recebeu Essencia de Fogo!";


            direction = "down2";
        } else {
            dialogues[0][0] = "Não há o que fazer aqui!";
            dialogues[0][1] = null;
        }

        startDialogue(this, 0);
    }

}
