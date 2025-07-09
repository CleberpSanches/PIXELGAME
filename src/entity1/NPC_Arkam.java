package entity1;

import Objects1.Obj_Garrafadagua;
import main1.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class NPC_Arkam extends Entity{
    public NPC_Arkam(GamePanel gp) {
        super(gp);
        direction = "down1";
        speed = 0;
        dialogueSet = -1;
        name = "arkam";
        getImage();
        setDialogue();

        solidArea.height = gp.tileSize*3;
        solidArea.width = gp.tileSize*3;
    }

    public void getImage() {
        down1 = setup("/npc/NPC_Arkam/Arkam1", gp.tileSize*3, gp.tileSize*3);
        down2 = setup("/npc/NPC_Arkam/Arkam2", gp.tileSize*3, gp.tileSize*3);
    }

    public void setDialogue(){
        dialogues[0][0] = "Eu sou Arkam o guardião do Inferno de/nMagméria e também do Deserto das Sombras!";
        dialogues[0][1] = "Para ter acesso ao Deserto das Sombras/n você terá que se mostrar digno!";
        dialogues[0][2] = "Passe pelo julgamento dos meus/nsubordinados: Ilusino, Orus e Belbu pegando os itens/npara colocar nos totems atrás do meu altar!";
    }

    public void setAction() {
        actionLookCounter++;
        if (actionLookCounter == 30) {
            if (direction.equals("down1")) {
                direction = "down2";
            } else {
                direction = "down1";
            }
            actionLookCounter = 0;
        }
    }

    public void speak(){
        Set<String> requiredItems = Set.of("cristalflamejante", "essenciadofogo", "nucleodemagma");
        List<Entity> itemsToRemove = new ArrayList<>();

        if (gp.arkamQuest) {
            dialogues[0][0] = "Você já me entregou tudo. O círculo atrás de você está ativo. /nLeve este brinde raro daqui!";
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
            gp.arkamQuest = true;

            dialogues[0][0] = "Boa, pode ir embora nesse círculo atrás de você! /nE leve este brinde raro daqui!";
            dialogues[0][1] = "Você recebeu uma garrafa de água!";
            dialogues[0][2] = null;
        } else if (itemsToRemove.size()>0 && itemsToRemove.size()<3){
            dialogues[0][0] = "Você ainda não trouxe todos os itens./nFaltam " + (3 - itemsToRemove.size()) + ".";
            dialogues[0][1] = null;
        }

        startDialogue(this, 0);
    }

    @Override
    public void draw(Graphics2D g2) {
        BufferedImage image = down1;

        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        if (worldX + gp.tileSize * 3 > gp.player.worldX - gp.player.screenX &&
                worldX - gp.tileSize * 3 < gp.player.worldX + gp.player.screenX &&
                worldY + gp.tileSize * 3 > gp.player.worldY - gp.player.screenY &&
                worldY - gp.tileSize * 3 < gp.player.worldY + gp.player.screenY) {

            int drawWidth = gp.tileSize * 3;
            int drawHeight = gp.tileSize * 3;

            g2.drawImage(image, screenX, screenY, drawWidth, drawHeight, null);
        }
    }

}