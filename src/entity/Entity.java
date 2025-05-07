//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package entity;

import main.GamePanel;
import main.ToolBox;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public abstract class Entity {
    GamePanel gp;
    public int worldX;
    public int worldY;
    public int speed;
    public BufferedImage up1;
    public BufferedImage up2;
    public BufferedImage down1;
    public BufferedImage down2;
    public BufferedImage down3;
    public BufferedImage down4;
    public BufferedImage right1;
    public BufferedImage right2;
    public BufferedImage left1;
    public BufferedImage left2;
    public String direction = "down1";
    public int spriteCounter = 0;
    public int spriteNum = 1;
    public Rectangle solidArea = new Rectangle(0, 0, 64, 64);
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn=false;
    public int actionLookCounter = 0;
    String dialogues[] = new String[20];
    int dialogueIndex;
    public BufferedImage image;
    public String name;
    public boolean collision = false;

    public Entity(GamePanel gp) {
        this.gp = gp;
    }

    public void setAction()
    {

    }

    public void speak(){
        if(dialogues[dialogueIndex] == null)
        {
            dialogueIndex=0;
        }
        gp.ui.currentDialogue = dialogues[dialogueIndex];
        dialogueIndex++;
    }

    public void update(){
        setAction();
        gp.cChecker.checkPlayer(this);

    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;
        if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                worldY - gp.tileSize < gp.player.worldY + gp.player.screenY){
            switch (this.direction) {
                case "down1":
                    if (this.spriteNum == 1) {
                        image = down1;
                    }
                    break;
                case "down2":
                    if (this.spriteNum == 1) {
                        image = down2;
                    }
                    break;
                case "down3":
                    if (this.spriteNum == 1) {
                        image = down3;
                    }
                    break;
                case "down4":
                    if (this.spriteNum == 1) {
                        image = down4;
                    }
            }

            g2.drawImage(image, screenX, screenY, 64, 64, null);
        }


    }

    public BufferedImage setup(String imagePath)
    {
        ToolBox tBox = new ToolBox();
        BufferedImage image = null;

        try {
            image = ImageIO.read(getClass().getResourceAsStream(imagePath + ".png"));
            image = tBox.scaleImage(image, gp.tileSize, gp.tileSize);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return image;
    }

}
