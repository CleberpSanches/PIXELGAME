package entity;

import Objects.Obj_Garrafadagua;
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
        Set<String> requiredItems = Set.of("monsterzero");
        List<Entity> itemsToRemove = new ArrayList<>();

        if (gp.golemQuest) {
            dialogues[0][0] = "Você já realizou sua oferenda!";
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
            gp.player.Inventory.add(new Obj_LagrimadaLua(gp));
            gp.golemQuest = true;

            dialogues[0][0] = "Ei, valeu carinha, aqui pra te ajudar!";
            dialogues[0][1] = "Você recebeu lágrima da lua!";
            dialogues[0][2] = null;
        } else {
            dialogues[0][0] = "Para realizar seu agradecimento você/nnecessita do item correto!";
            dialogues[0][1] = null;
        }

        startDialogue(this, 0);
    }

}
