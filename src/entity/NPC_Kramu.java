package entity;

import Objects.Obj_CristalFlamejante;
import Objects.Obj_Garrafadagua;
import Objects.Obj_MonsterZero;
import Objects.Obj_Pepsi;
import main.GamePanel;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class NPC_Kramu extends Entity{
    public NPC_Kramu(GamePanel gp) {
        super(gp);
        direction = "down1";
        speed = 0;
        dialogueSet = -1;
        getImage();
        setDialogue();
    }

    public void getImage() {
        down1 = setup("/npc/NpcKramu/Kramu1", gp.tileSize, gp.tileSize);
        down2 = setup("/npc/NpcKramu/Kramu2", gp.tileSize, gp.tileSize);
        down3 = setup("/npc/NpcKramu/Kramu3", gp.tileSize, gp.tileSize);
        down4 = setup("/npc/NpcKramu/Kramu4", gp.tileSize, gp.tileSize);

    }

    public void setItems(){
        Inventory.add(new Obj_MonsterZero(gp));
        Inventory.add(new Obj_Pepsi(gp));
    }

    public void setDialogue(){
        dialogues[0][0] = "Olá gatinho, tá um calor aqui né?/nEu queria muito beber uma água!";

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
        Set<String> requiredItems = Set.of("garrafadagua");
        List<Entity> itemsToRemove = new ArrayList<>();

        if (gp.demonQuest) {
            dialogues[0][0] = "Valeu pela água! Tava morrendo de sede!";
            dialogues[0][1] = null;
            startDialogue(this, 0);
            return;
        }

        for (Entity obj : gp.player.Inventory) {
            if (requiredItems.contains(obj.name)) {
                itemsToRemove.add(obj);
            }
        }

        if (itemsToRemove.size() == 1) {
            gp.player.Inventory.removeAll(itemsToRemove);
            gp.player.Inventory.add(new Obj_Pepsi(gp));
            gp.player.Inventory.add(new Obj_MonsterZero(gp));
            gp.demonQuest = true;

            dialogues[0][0] = "Olá gatinho, tá um calor aqui né?/nEu queria muito beber uma água!";
            dialogues[0][1] = "Valeu, você gosta de bebida sem açúcar?/nEu não gosto! Você quer? Leve essas/nduas aqui!!";
            dialogues[0][2] = "Você recebeu uma monster zero!";
            dialogues[0][3] = "Você recebeu pepsi!";
            dialogues[0][4] = null;
        } else {
            dialogues[0][0] = "Olá gatinho, tá um calor aqui né?/nEu queria muito beber uma água!";
            dialogues[0][1] = null;
        }

        startDialogue(this, 0);
    }

}
