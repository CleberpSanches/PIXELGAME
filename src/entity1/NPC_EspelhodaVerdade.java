package entity1;

import main1.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class NPC_EspelhodaVerdade extends Entity{
    public NPC_EspelhodaVerdade(GamePanel gp) {
        super(gp);
        direction = "down1";
        speed = 0;
        dialogueSet = -1;
        name = "caveiramorta";
        getImage();
        setDialogue();

        solidArea.height = gp.tileSize*3;
        solidArea.width = gp.tileSize*3;
    }

    public void getImage() {
        down1 = setup("/npc/NpcparaPuzzles/espelhodaverdade", gp.tileSize*3, gp.tileSize*3);
        down2 = setup("/npc/NpcparaPuzzles/espelhopronto", gp.tileSize*3, gp.tileSize*3);
    }

    public void setDialogue(){
        dialogues[0][0] = "O espelho da verdade! Revela a verdade/n para qualquer pergunta!";
    }

    public void setAction(){
        if (direction.equals("down1")){
            direction = "down1";
        }
    }

    public void speak(){
        Set<String> requiredItems = Set.of("areiadavdd", "fragmentodeespelho", "lagrimadalua");
        List<Entity> itemsToRemove = new ArrayList<>();

        for (Entity obj : gp.player.Inventory) {
            if (requiredItems.contains(obj.name)) {
                itemsToRemove.add(obj);
            }
        }

        if (gp.questDeserto) {
            dialogues[0][0] = "A passagem foi liberada! Fique a frente do espelho!";
            dialogues[0][1] = null;
            startDialogue(this, 0);
            return;
        }

        if (itemsToRemove.size() == 3) {
            gp.player.Inventory.removeAll(itemsToRemove);
            gp.questDeserto = true;
            direction = "down2";

            dialogues[0][0] = "O espelho brilha com a sua imagem e você/nvê sua irmã ao lado de um monstro!";
            dialogues[0][1] = "A passagem foi liberada!";

        } else {
            dialogues[0][0] = "Você ainda não trouxe todos os itens./nFaltam " + (3 - itemsToRemove.size()) + ".";
            dialogues[0][1] = null;
        }

        startDialogue(this, 0);
    }

    @Override
    public void draw(Graphics2D g2) {
        BufferedImage image = null;

        // Seleciona a imagem com base na direção atual
        switch (direction) {
            default: image = down1; break;
        }

        // Calcula a posição do NPC na tela com base na posição do jogador
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        // Verifica se o NPC está dentro da área visível
        if (worldX + gp.tileSize * 3 > gp.player.worldX - gp.player.screenX &&
                worldX - gp.tileSize * 3 < gp.player.worldX + gp.player.screenX &&
                worldY + gp.tileSize * 3 > gp.player.worldY - gp.player.screenY &&
                worldY - gp.tileSize * 3 < gp.player.worldY + gp.player.screenY) {

            g2.drawImage(image, screenX, screenY, gp.tileSize * 3, gp.tileSize * 3, null);
        }
    }


}
