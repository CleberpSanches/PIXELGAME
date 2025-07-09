package monster1;

import entity1.Entity;
import main1.GamePanel;

import java.util.Random;

public class Enemy_SlimedeFogo extends Entity {
    public Enemy_SlimedeFogo(GamePanel gp) {
        super(gp);
        name = "Fire Slime";
        speed = 1;
        solidArea.x = 3;
        solidArea.y = 18;
        solidArea.width = 42;
        solidArea.height = 30;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        getImage();
    }

    public void getImage() {
        down1 = setup("/npc/Enemy/Slime1", gp.tileSize, gp.tileSize);
        down2 = setup("/npc/Enemy/Slime2", gp.tileSize, gp.tileSize);
        down3 = setup("/npc/Enemy/Slime3", gp.tileSize, gp.tileSize);
        down4 = setup("/npc/Enemy/Slime4", gp.tileSize, gp.tileSize);
    }

    public void setDialogue(){
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
                spriteNum = 1;
            } else if (spriteNum == 1) {
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

    }

}
