package entity;

import Objects.Obj_ChaveCipestre;
import main.GamePanel;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class NPC_Morceguita extends Entity{
    public NPC_Morceguita(GamePanel gp) {
        super(gp);
        direction = "down1";
        name = "anao";
        speed = 0;
        getImage();
        setDialogue();
    }

    public void getImage() {
        down1 = setup("/npc/NpcMorceguita/morceguita1", gp.tileSize, gp.tileSize);
        down2 = setup("/npc/NpcMorceguita/morceguita2", gp.tileSize, gp.tileSize);
        down3 = setup("/npc/NpcMorceguita/morceguita3", gp.tileSize, gp.tileSize);
        down4 = setup("/npc/NpcMorceguita/morceguita4", gp.tileSize, gp.tileSize);

    }

    public void setDialogue(){
            dialogues[0][0] = "Reúna todos os meus amuletos perdidos /n Lhe darei uma recompensa!";
            dialogues[0][1] = "Espero seu retorno!";

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
        Set<String> requiredItems = Set.of("amuletoluaverde", "amuletonevoa", "amuletoseiva");
        List<Entity> itemsToRemove = new ArrayList<>();

        for (Entity obj : gp.player.Inventory) {
            if (requiredItems.contains(obj.name)) {
                itemsToRemove.add(obj);
            }
        }

        if (itemsToRemove.size() == 3) {
            gp.player.Inventory.removeAll(itemsToRemove);

            gp.player.Inventory.add(new Obj_ChaveCipestre(gp));

            dialogues[0][0] = "Meus amuletos enfim se tornam meus!";

            dialogues[0][1] = "Aqui sua recompensa!";
        }
        startDialogue(this, dialogueSet);
        dialogueSet++;

        if(dialogues[dialogueSet][0] == null){
            dialogueSet = 0;
        }
    }

}
