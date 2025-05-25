package entity;

import main.GamePanel;

import java.util.Random;

public class Enemy_SlimedeFogo extends Entity {
    int width;
    int height;

    public Enemy_SlimedeFogo(GamePanel gp) {
        super(gp);

        name = "SlimedeLava";
        speed = 1;
        maxLife = 4;
        life = maxLife;
        System.out.println("SlimedeFogo criado!");

        solidArea.x = 3;
        solidArea.y = 24;
        solidArea.width = 42;
        solidArea.height = 30;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        getImage();
    }

    public void getImage() {
        up1 = setup("/npc/Enemy/Slime1", gp.tileSize, gp.tileSize);
        up2 = setup("/npc/Enemy/Slime2", gp.tileSize, gp.tileSize);
        up3 = setup("/npc/Enemy/Slime3", gp.tileSize, gp.tileSize);
        up4 = setup("/npc/Enemy/Slime4", gp.tileSize, gp.tileSize);
        down1 = setup("/npc/Enemy/Slime1", gp.tileSize, gp.tileSize);
        down2 = setup("/npc/Enemy/Slime2", gp.tileSize, gp.tileSize);
        down3 = setup("/npc/Enemy/Slime3", gp.tileSize, gp.tileSize);
        down4 = setup("/npc/Enemy/Slime4", gp.tileSize, gp.tileSize);
        right1 = setup("/npc/Enemy/Slime1", gp.tileSize, gp.tileSize);
        right2 = setup("/npc/Enemy/Slime2", gp.tileSize, gp.tileSize);
        right3 = setup("/npc/Enemy/Slime3", gp.tileSize, gp.tileSize);
        right4 = setup("/npc/Enemy/Slime4", gp.tileSize, gp.tileSize);
        left1 = setup("/npc/Enemy/Slime1", gp.tileSize, gp.tileSize);
        left2 = setup("/npc/Enemy/Slime2", gp.tileSize, gp.tileSize);
        left3 = setup("/npc/Enemy/Slime3", gp.tileSize, gp.tileSize);
        left4 = setup("/npc/Enemy/Slime4", gp.tileSize, gp.tileSize);
    }

    public void setAction(){
        actionLookCounter ++;
        if (actionLookCounter == 120) {
            Random random = new Random();
            int i = random.nextInt(100)+1;

            if(i <= 25){
                direction = "up";
            }
            if(i > 25 && i<= 50){
                direction = "down";
            }
            if(i > 50 && i <=75){
                direction = "left";
            }
            if (i > 75 && i <= 100){
                direction = "right";
            }

            actionLookCounter = 0;
        }
    }
}
