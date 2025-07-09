package entity1;

import main1.GamePanel;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class NPC_PortaFinal2 extends Entity{
    public NPC_PortaFinal2(GamePanel gp) {
        super(gp);
        direction = "down1";
        speed = 0;
        name = "pfinal2";
        getImage();
        setDialogue();
    }
    public void getImage() {
        down1 = setup("/tile_items/257", gp.tileSize, gp.tileSize);
    }

    public void setDialogue(){
        dialogues[0][0] = "*Você entregou um artefato a porta/ne ela lhe mostrou o caminho*";
    }

    public void setAction(){
        actionLookCounter ++;
        if (actionLookCounter == 30) {
            if (direction.equals("down1")){
                direction = "down1";
            }else {
                direction = "down1";
            }
            actionLookCounter = 0;

        }

    }

    public void speak(){
        Set<String> requiredItems = Set.of("calicevento");
        List<Entity> itemsToRemove = new ArrayList<>();

        for (Entity obj : gp.player.Inventory) {
            if (requiredItems.contains(obj.name)) {
                itemsToRemove.add(obj);
            }
        }

        for (int i = 0; i < gp.npc[gp.currentMap].length; i++) {
            if (gp.npc[gp.currentMap][i] == this) {
                gp.player.Inventory.removeAll(itemsToRemove);
                gp.npc[gp.currentMap][i] = null;
                break;
            }
        }
    }
}
