package monster1;

import Objects1.Obj_OrbeRedemoinho;
import entity1.Entity;
import main1.GamePanel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Monster_Lagarta extends Entity {
    public Monster_Lagarta(GamePanel gp) {
        super(gp);
        name = "Lagarta";
        speed = 1;
        solidArea.x = 3;
        solidArea.y = 18;
        solidArea.width = 42;
        solidArea.height = 30;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        getImage();
        setDialogue();
    }

    public void getImage() {
        down1 = setup("/npc/Lagarta/lagarta4", gp.tileSize, gp.tileSize);
        right3 = setup("/npc/Lagarta/lagarta_1", gp.tileSize, gp.tileSize);
        down2 = setup("/npc/Lagarta/lagarta3", gp.tileSize, gp.tileSize);
        right4 = setup("/npc/Lagarta/lagarta_2", gp.tileSize, gp.tileSize);
        down3 = setup("/npc/Lagarta/lagarta1", gp.tileSize, gp.tileSize);
        down4 = setup("/npc/Lagarta/lagarta2", gp.tileSize, gp.tileSize);
    }

    public void setDialogue(){
        dialogues[0][0] = "Lagarta comilona estava na boca dessa";
    }

    @Override
    public void update() {
        super.update();
        gp.cChecker.checkTile(this);
        if (collisionOn == false) {
            switch (direction){
                case "down1":
                    worldY -= speed;
                    break;
                case "down2":
                    worldY += speed;
                    break;
                case "down3":
                    worldX -= speed;
                    break;
                case "down4":
                    worldX += speed;
                    break;
            }
        }

        spriteCounter++;
        if (this.spriteCounter > 10) {
            if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 1;
            }

            spriteCounter = 0;
        }
    }

    @Override
    public void setAction() {
        actionLookCounter++;

        if (actionLookCounter == 40) {
            Random random = new Random();
            int i = random.nextInt(100)+1;

            if (i<= 25) {
                direction = "down1";
            } else if (i > 25 && i<= 50) {
                direction = "down2";
            } else if (i > 50 && i<= 75) {
                direction = "down3";
            } else if((i > 75 && i<= 100)){
                direction = "down4";
            }

            actionLookCounter = 0;
        }
    }



    public void speak(){
        Set<String> requiredItems = Set.of("orberedemoinho");
        List<Entity> itemsToRemove = new ArrayList<>();
        for (Entity obj : gp.player.Inventory) {
            if (requiredItems.contains(obj.name)) {
                itemsToRemove.add(obj);
            }
        }
        if (itemsToRemove.size() == 1) {
            gp.player.Inventory.removeAll(itemsToRemove);
            dialogues[0][0] = "Não tem nada na boca dessa aqui";
        }
        super.startDialogue(this, dialogueSet);

        gp.player.Inventory.add(new Obj_OrbeRedemoinho(gp));
    }

}

