package entity;

import Objects.Obj_AmuletoNevoa;
import Objects.Obj_CaliceVento;
import Objects.Obj_OrbeBrisaDourada;
import Objects.Obj_PocaoSangue;
import main.GamePanel;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Npc_Tigro extends Entity{

    public Npc_Tigro(GamePanel gp) {
        super(gp);
        direction = "down1";
        speed = 0;
        getImage();
        setDialogue();
    }

    public void getImage() {
        down1 = setup("/npc/NpcTigro/Tigro1", gp.tileSize, gp.tileSize);
        down2 = setup("/npc/NpcTigro/Tigro2", gp.tileSize, gp.tileSize);
        down3 = setup("/npc/NpcTigro/Tigro3", gp.tileSize, gp.tileSize);
        down4 = setup("/npc/NpcTigro/Tigro3", gp.tileSize, gp.tileSize);
    }

    public void setDialogue(){
        dialogues[0][0] = "Aquela sapeta disse que estou com /n o orbe da brisa dourada?";
        dialogues[0][1] = "Não posso ficar de mãos vazias!/nSe quiser o orbe terá que me dar /nalgo em troca";
        dialogues[0][2] = "";
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
        startDialogue(this, dialogueSet);

        Set<String> requiredItems = Set.of("pocaosangue");
        List<Entity> items = new ArrayList<>();
        Set<String> requiredItem = Set.of("orbebrisadourada");
        List<Entity> items2 = new ArrayList<>();
        for (Entity obj : gp.player.Inventory) {
            if (requiredItems.contains(obj.name)) {
                items.add(obj);
            }
        }
        for (Entity obj : gp.player.Inventory) {
            if (requiredItem.contains(obj.name)) {
                items2.add(obj);
            }
        }
        if (items.size() == 1) {
            dialogues[0][0] = "Aqui está sua recompensa! /nOlhe seu inventário";
            for (int i = 1; dialogues[0][i] != null ; i++) {
                dialogues[0][i] = null;
            }
            gp.player.Inventory.add(new Obj_OrbeBrisaDourada(gp));
            gp.player.Inventory.removeAll(items);
            this.Inventory.add(new Obj_PocaoSangue(gp));

        }
        else if (items2.size()==1) {
            dialogues[0][0] = "Tenho minha poção, se vá!";
        }

    }

}