package entity;

import Objects.Obj_AreiadaVerdade;
import Objects.Obj_LagrimadaLua;
import main.GamePanel;
import main.ToolBox;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class NPC_LapideM extends Entity{
    public NPC_LapideM(GamePanel gp) {
        super(gp);
        direction = "down1";
        speed = 0;
        dialogueSet = -1;
        getImage();
        setDialogue();
    }

    public void getImage() {
        down1 = setup("/npc/NpcparaPuzzles/NpcLapideM/lapidem", gp.tileSize, gp.tileSize);
        down2 = setup("/npc/NpcparaPuzzles/NpcLapideM/lapidem", gp.tileSize, gp.tileSize);
        down3 = setup("/npc/NpcparaPuzzles/NpcLapideM/lapidem", gp.tileSize, gp.tileSize);
        down4 = setup("/npc/NpcparaPuzzles/NpcLapideM/lapidem", gp.tileSize, gp.tileSize);

    }

    public void setDialogue(){
        dialogues[0][0] = "Apenas uma lápide com um M gravado/ne abaixo diz: 'Aqui jaz Maria Eduarda,/ndesenvolvedora deste jogo! Deixe seu/nagradecimento aqui!'";
        dialogues[0][1] = "Deixe aqui seu agradecimento!";
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
        Set<String> requiredItems = Set.of("pepsi");
        List<Entity> itemsToRemove = new ArrayList<>();
        Set<String> requiredItem = Set.of("areiadavdd");
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
            gp.player.Inventory.add(new Obj_AreiadaVerdade(gp));
            dialogues[0][0] = "Obrigada meu bem! Leve isso pra te ajudar!";
            dialogues[0][1] = "Você recebeu areia da verdade!";

        } else if(items2.size() == 1){
            dialogues[0][0] = "Obrigada pela Pepsi!";
            dialogues[0][1] = null;
        }

        startDialogue(this, 0);
    }

}