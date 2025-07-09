package entity1;

import Objects1.Obj_OrbeOutono;
import main1.GamePanel;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class NPC_Sapita extends Entity{
    public NPC_Sapita(GamePanel gp) {
        super(gp);
        direction = "down1";
        speed = 0;

        getImage();
        setDialogue();
    }

    public void getImage() {
        down1 = setup("/npc/NpcSapeta/sapeta1", gp.tileSize, gp.tileSize);
        down2 = setup("/npc/NpcSapeta/sapeta2", gp.tileSize, gp.tileSize);
        down3 = setup("/npc/NpcSapeta/sapeta3", gp.tileSize, gp.tileSize);
        down4 = setup("/npc/NpcSapeta/sapeta4", gp.tileSize, gp.tileSize);

    }

    public void setDialogue(){
        dialogues[0][0] = "Atrás de mim está a grande relíquia de/narco-íris";
        dialogues[0][1] = "Precisamos retornar todos os orbes para ela!!";
        dialogues[0][2] = "Aqui está o orbe que já tenho/nfaltam dois";

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
        Set<String> requiredItems = Set.of("orbeoutono");
        List<Entity> itemsToRemove = new ArrayList<>();

        for (Entity obj : gp.player.Inventory) {
            if (requiredItems.contains(obj.name)) {
                itemsToRemove.add(obj);
            }
        }

        if (itemsToRemove.size() == 1) {
            gp.player.Inventory.removeAll(itemsToRemove);

        }
        startDialogue(this, dialogueSet);
        gp.player.Inventory.add(new Obj_OrbeOutono(gp));

    }

}
