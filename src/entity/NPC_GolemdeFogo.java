package entity;

import Objects.Obj_Garrafadagua;
import main.GamePanel;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class NPC_GolemdeFogo extends Entity{
    public NPC_GolemdeFogo(GamePanel gp) {
        super(gp);
        direction = "down1";
        speed = 0;
        dialogueSet = -1;
        getImage();
        setDialogue();
    }

    public void getImage() {
        down1 = setup("/npc/NpcGolemdeFogo/GolemdeFogo1", gp.tileSize, gp.tileSize);
        down2 = setup("/npc/NpcGolemdeFogo/GolemdeFogo2", gp.tileSize, gp.tileSize);
        down3 = setup("/npc/NpcGolemdeFogo/GolemdeFogo3", gp.tileSize, gp.tileSize);
        down4 = setup("/npc/NpcGolemdeFogo/GolemdeFogo1", gp.tileSize, gp.tileSize);

    }

    public void setDialogue(){
        dialogues[0][0] = "Não fique aqui garoto, pode se queimar!";
        dialogues[0][1] = "O que estou fazendo? Apenas os itens/n de minha armadura!";
        dialogues[0][2] = "Você quer ir ao Desertos Sombrio?/nOkay, me traga o último item da armadura/nque lhe ajudo!";

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
        Set<String> requiredItems = Set.of("cristalflamejante", "essenciadofogo", "nucleodemagma");
        List<Entity> itemsToRemove = new ArrayList<>();

        if (gp.golemQuest) {
            dialogues[0][0] = "Você já me entregou tudo. O círculo atrás de você está ativo./nE leve este brinde raro daqui!";
            dialogues[0][1] = null;
            startDialogue(this, 0);
            return;
        }

        for (Entity obj : gp.player.Inventory) {
            if (requiredItems.contains(obj.name)) {
                itemsToRemove.add(obj);
            }
        }

        if (itemsToRemove.size() == 3) {
            gp.player.Inventory.removeAll(itemsToRemove);
            gp.player.Inventory.add(new Obj_Garrafadagua(gp));
            gp.golemQuest = true;

            dialogues[0][0] = "Boa, pode ir embora nesse círculo atrás/nonde você! nE leve este brinde raro daqui!";
            dialogues[0][1] = "Você recebeu uma garrafa de água!";
            dialogues[0][2] = null;
        } else {
            dialogues[0][0] = "Você ainda não trouxe todos os itens./nFaltam " + (3 - itemsToRemove.size()) + ".";
            dialogues[0][1] = null;
        }

        startDialogue(this, 0);
    }

}
