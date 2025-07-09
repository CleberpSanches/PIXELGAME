package entity1;

import Objects1.Obj_LagrimadaLua;
import main1.GamePanel;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class NPC_LapideJ extends Entity{
    public NPC_LapideJ(GamePanel gp) {
        super(gp);
        direction = "down1";
        speed = 0;
        dialogueSet = -1;
        getImage();
        setDialogue();
    }

    public void getImage() {
        down1 = setup("/npc/NpcparaPuzzles/NpcLapideJ/lapidej", gp.tileSize, gp.tileSize);
        down2 = setup("/npc/NpcparaPuzzles/NpcLapideJ/lapidej", gp.tileSize, gp.tileSize);
        down3 = setup("/npc/NpcparaPuzzles/NpcLapideJ/lapidej", gp.tileSize, gp.tileSize);
        down4 = setup("/npc/NpcparaPuzzles/NpcLapideJ/lapidej", gp.tileSize, gp.tileSize);

    }



    public void setDialogue(){
        dialogues[0][0] = "Apenas uma lápide com um J gravado/ne abaixo diz: 'Aqui jaz João Cleber,/ndesenvolvedor deste jogo!'";
        dialogues[0][1] = "Deixe aqui seu agradecimento!";
    }

    public void setAction(){
        if (direction.equals("down1")){
            direction = "down1";
        }
    }

    public void speak(){
        Set<String> requiredItems = Set.of("monsterzero");
        List<Entity> itemsToRemove = new ArrayList<>();
        Set<String> requiredItem = Set.of("lagrimadalua");
        List<Entity> items2 = new ArrayList<>();
        for (Entity obj : gp.player.Inventory) {
            if (requiredItems.contains(obj.name)) {
                itemsToRemove.add(obj);
            }
        }
        for (Entity obj : gp.player.Inventory) {
            if (requiredItem.contains(obj.name)) {
                items2.add(obj);
            }
        }

        if (itemsToRemove.size() == 1) {
            gp.player.Inventory.removeAll(itemsToRemove);
            gp.player.Inventory.add(new Obj_LagrimadaLua(gp));

            dialogues[0][0] = "Ei, valeu carinha, aqui pra te ajudar!";
            dialogues[0][1] = "Você recebeu lágrima da lua!";
        } else if(items2.size() == 1){
            dialogues[0][0] = "Obrigado pelo monster!";
            dialogues[0][1] = null;
        }

        startDialogue(this, 0);
    }

}