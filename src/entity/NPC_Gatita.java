package entity;

import Objects.Obj_AmuletoNevoa;
import Objects.Obj_ColarAmor;
import Objects.Obj_OrbeOutono;
import main.GamePanel;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class NPC_Gatita extends Entity{
    private boolean gone = false;
    public NPC_Gatita(GamePanel gp) {
        super(gp);
        direction = "down1";
        speed = 0;
        name = "gatita";
        getImage();
        setDialogue();
    }

    public void getImage() {
        down1 = setup("/npc/NpcGatita/catita1", gp.tileSize, gp.tileSize);
        down2 = setup("/npc/NpcGatita/catita2", gp.tileSize, gp.tileSize);
        down3 = setup("/npc/NpcGatita/catita3", gp.tileSize, gp.tileSize);
    }

    public void setDialogue(){
        dialogues[0][0] = "Oi oi irmãozinho, gostou da aventura que fiz/npra você?";
        dialogues[0][1] = "Hihihi não precisa ficar estressado você/nandava muito entendiado!!/nPreparei essa surpresinha pra você";
        dialogues[0][2] = "Me dê os artefatos que você coletou/nvou te dar um presentinho";
        dialogues[0][2] = "Você recebeu o colar do amor!";

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
        Set<String> requiredItems = Set.of("colaramor");
        List<Entity> itemsToRemove = new ArrayList<>();

        for (Entity obj : gp.player.Inventory) {
            if (requiredItems.contains(obj.name)) {
                itemsToRemove.add(obj);
            }
        }

        if (itemsToRemove.size() == 1) {
            if (gone == false){
                gp.player.Inventory.removeAll(itemsToRemove);
                dialogues[0][0] = "Tchau tchauuuuuuuuuuuuuuu";
                for (int i = 1; dialogues[0][i] != null ; i++) {
                    dialogues[0][i] = null;
                }
                down1 = setup("/npc/NpcGatita/catita4", gp.tileSize, gp.tileSize);
                down2 = setup("/npc/NpcGatita/catita5", gp.tileSize, gp.tileSize);
                down3 = setup("/npc/NpcGatita/catita6", gp.tileSize, gp.tileSize);
                gone = true;
            }
            else {
                gp.player.Inventory.removeAll(itemsToRemove);
                dialogues[0][0] = "*Sua irmã foi embora para uma nova/naventura*";
                for (int i = 1; dialogues[0][i] != null ; i++) {
                    dialogues[0][i] = null;
                }
            }
        }
        startDialogue(this, dialogueSet);
        gp.player.Inventory.add(new Obj_ColarAmor(gp));
    }
}
