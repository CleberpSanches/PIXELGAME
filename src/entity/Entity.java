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
import java.util.ArrayList;

public abstract class Entity {
    public Entity currentMagicatk;
    public ArrayList<Entity> Inventory = new ArrayList<>();
    public final int maxInventorySize = 14;
    public boolean stackable=false;
    public int amount = 1;

    public GamePanel gp;
    public int worldX;
    public int worldY;
    public int speed;
    public BufferedImage up1;
    public BufferedImage up2;
    public BufferedImage up3;
    public BufferedImage up4;
    public BufferedImage down1;
    public BufferedImage down2;
    public BufferedImage down3;
    public BufferedImage down4;
    public BufferedImage right1;
    public BufferedImage right2;
    public BufferedImage left3;
    public BufferedImage left4;
    public BufferedImage right3, right4;
    public BufferedImage left1;
    public BufferedImage left2;
    public BufferedImage upattack1;
    public BufferedImage upattack2;
    public BufferedImage downattack1;
    public BufferedImage downattack2;
    public BufferedImage rightattack1;
    public BufferedImage rightattack2;
    public BufferedImage leftattack1;
    public BufferedImage leftattack2;
    public String direction = "down1";
    public int spriteCounter = 0;
    public int spriteNum = 1;

    public Rectangle solidArea = new Rectangle(0, 0, 64, 64);
    public Rectangle attackArea = new Rectangle(0, 0, 0, 0);
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn=false;
    public boolean collision = false;

    public int actionLookCounter = 0;
    public String dialogues[][] = new String[20][20];
    public int dialogueIndex = 0;
    public int dialogueSet = 0;

    public BufferedImage image;
    public String name;

    //types
    public int type;
    static final int type_player = 0;
    static final int type_npc = 1;
    static final int type_monster = 2;
    public static final int type_magicAtk = 3;
    public static final int type_magicBreak = 4;

    //item
    public String description = "";

    //CHARACTER STATUS
    public int maxLife = 0;
    public int life;


    public Entity(GamePanel gp) {
        this.gp = gp;
    }

    public void setAction()
    {

    }

    public void speak(){

    }

    public void startDialogue(Entity entity, int setNum){
        gp.ui.npc = this;
        gp.ui.charIndex = 0;
        gp.ui.combinedText = "";
        gp.ui.currentDialogue = "";
        gp.gameState = gp.dialogueState;
        dialogueSet = setNum;
    }

    public void update(){
        setAction();
        gp.cChecker.checkEntity(this, gp.npc);
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
                    } else if (this.spriteNum == 2) {
                        image = down1;
                    }
                    break;
                case "down2":
                    if (this.spriteNum == 1) {
                        image = down2;
                    } else if (this.spriteNum == 2) {
                        image = down2;
                    }
                    break;
                case "down3":
                    if (this.spriteNum == 1) {
                        image = down3;
                    } else if (this.spriteNum == 2) {
                        image = right3;
                    }
                    break;
                case "down4":
                    if (this.spriteNum == 1) {
                        image = down4;
                    } else if (this.spriteNum == 2) {
                        image = right4;
                    }
            }

            g2.drawImage(image, screenX, screenY, 64, 64, null);
        }


    }

    public BufferedImage setup(String imagePath, int width, int height)
    {
        ToolBox tBox = new ToolBox();
        BufferedImage image = null;

        try {
            image = ImageIO.read(getClass().getResourceAsStream(imagePath + ".png"));
            image = tBox.scaleImage(image, width, height);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return image;
    }

}
