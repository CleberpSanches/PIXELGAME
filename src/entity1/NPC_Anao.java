package entity1;

import Objects1.Obj_PocaoSangue;
import main1.GamePanel;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class NPC_Anao extends Entity{
    public NPC_Anao(GamePanel gp) {
        super(gp);
        direction = "down1";
        speed = 0;
        name = "anao";
        getImage();
        setDialogue();
    }

    private void PressN(){
        gp.keyH.spacePressed = false;
        dialogues[0][0] = "Você errou!";
    }

    private void PressS(){
        gp.keyH.spacePressed = false;
        dialogues[0][0] = "Você Acertou! Olhe seu inventário.";
    }

    public void getImage() {
        down1 = setup("/npc/NpcAnao/anao", gp.tileSize, gp.tileSize);
    }

    public void setDialogue(){
        dialogues[0][0] = "Se um número é divisível por 6, ele também/né divisível por 3(S/N)";
    }

    public void setAction(){
        actionLookCounter ++;
        if (actionLookCounter == 30) {
            if (direction.equals("down1")){
                direction = "down1";

            } else {
                direction = "down1";
            }
            actionLookCounter = 0;

        }

    }
    public void speak(){
        startDialogue(this, dialogueSet);
        if (gp.keyH.nPressed == true) {
            PressN();
            gp.keyH.nPressed = false;
        } else if (gp.keyH.sPressed == true) {
            PressS();
            Set<String> requiredItems = Set.of("pocaosangue");
            List<Entity> itemsToRemove = new ArrayList<>();

            for (Entity obj : gp.player.Inventory) {
                if (requiredItems.contains(obj.name)) {
                    itemsToRemove.add(obj);
                }
            }

            if (itemsToRemove.size() == 1) {
                gp.player.Inventory.removeAll(itemsToRemove);

            }
            gp.player.Inventory.add(new Obj_PocaoSangue(gp));
            gp.keyH.sPressed = false;
        }

    }
}
