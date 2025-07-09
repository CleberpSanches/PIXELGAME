package entity1;

import Objects1.Obj_AmuletoNevoa;
import main1.GamePanel;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class NPC_Fantasmito extends Entity{
    public NPC_Fantasmito(GamePanel gp) {
        super(gp);
        direction = "down1";

        speed = 0;
        getImage();
        setDialogue();
    }

    public void getImage() {
        down1 = setup("/npc/NpcFantasmito/fantasmito1", gp.tileSize, gp.tileSize);
        down2 = setup("/npc/NpcFantasmito/fantasmito2", gp.tileSize, gp.tileSize);
        down3 = setup("/npc/NpcFantasmito/fantasmito3", gp.tileSize, gp.tileSize);

    }

    public void setDialogue(){
        dialogues[0][0] = "Um amuleto? Acho que tenho algum";
        dialogues[0][1] = "Aqui, nunca usei então pode ficar";

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
                direction = "down1";
            } else {
                direction = "down1";
            }
            actionLookCounter = 0;

        }

    }
    public void speak(){
        Set<String> requiredItems = Set.of("amuletonevoa");
        List<Entity> itemsToRemove = new ArrayList<>();

        for (Entity obj : gp.player.Inventory) {
            if (requiredItems.contains(obj.name)) {
                itemsToRemove.add(obj);
            }
        }

        if (itemsToRemove.size() == 1) {
            gp.player.Inventory.removeAll(itemsToRemove);
            dialogues[0][0] = "Já te dei o que você queria/npode ir";
            dialogues[0][1] = null;
        }
        startDialogue(this, dialogueSet);
        gp.player.Inventory.add(new Obj_AmuletoNevoa(gp));

    }
}
