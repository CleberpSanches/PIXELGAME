//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package entity;

import java.awt.*;
import java.awt.image.BufferedImage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.imageio.ImageIO;

import Interface.Command;
import Interface.PlayerInput;
import Objects.Obj_CaliceVento;
import Objects.Obj_ChaveCipestre;
import main.GamePanel;
import Adapter.KeyHandlerAdapter;
import main.ToolBox;

public class Player extends Entity {
    PlayerInput input;

    public final int screenX;
    public final int screenY;
    public ArrayList<Entity> Inventory = new ArrayList<>();
    public final int maxInventorySize = 15;

    int hasCalice= 0;



    public Player(GamePanel gp, PlayerInput input) {
        super(gp);

        this.input = input;

        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);

        solidArea = new Rectangle(8, 55,40,20);
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        this.setDefaultValues();
        this.getPlayerImage();
        setItems();

    }

    public void setDefaultValues() {
        this.worldX = gp.tileSize * 47;
        this.worldY = (int) (gp.tileSize * 23.5);
        this.speed = 4;
        this.direction = "left";
    }


    public void setItems() {
        //Inventory.add(new Obj_CaliceVento(gp));

    }

    public void getPlayerImage() {
            up1 = setup("/player/gatuno_costas_1");
            up2 = setup("/player/gatuno_costas_2");
            down1 = setup("/player/gatuno_frente_1");
            down2 = setup("/player/gatuno_frente_2");
            left1 = setup("/player/gatuno_esquerda_1");
            left2 = setup("/player/gatuno_esquerda_2");
            right1 = setup("/player/gatuno_direita_1");
            right2 = setup("/player/gatuno_direita_2");
    }



    public void update() {
        if (input.upButtonPressed()|| input.downButtonPressed()|| input.leftButtonPressed()|| input.rightButtonPressed()) {
            if (input.upButtonPressed()) {
                this.direction = "up";

            } else if (input.downButtonPressed()) {
                this.direction = "down";

            } else if (input.leftButtonPressed()) {
                this.direction = "left";

            } else if (input.rightButtonPressed()) {
                this.direction = "right";
            }
            List<Command> commands = input.getCommands(this);
            //collision state
            collisionOn = false;
            gp.cChecker.checkTile(this);

            // obj collision state
            int objIndex = gp.cChecker.checkObject(this, true);
            pickUpObject(objIndex);
            // if collisionOn is false means he can move

            //npc collision
            int npcIndex = gp.cChecker.checkEntity(this, gp.npc);
            interactNPC(npcIndex);

            gp.eHandler.checkEvent();

            //without collision the command movement runs
            if (collisionOn == false) {

                for (Command command : commands) {
                    command.execute(this);
                }

            }
            ++this.spriteCounter;
            if (this.spriteCounter > 10) {
                if (this.spriteNum == 1) {
                    this.spriteNum = 2;
                } else if (this.spriteNum == 2) {
                    this.spriteNum = 1;
                }

                this.spriteCounter = 0;
            }
        }

    }

    public void pickUpObject(int index){
      if (index != 999)
        {
            if (Inventory.size() != maxInventorySize)
            {
                Inventory.add(gp.obj[index]);
            }
            gp.obj[index] = null;
            transformItem();
        }

    }

    public void transformItem(){
        Set<String> requiredItems = Set.of("amuletoluaverde", "amuletonevoa", "amuletoseiva");
        List<Entity> itemsToRemove = new ArrayList<>();

        for (Entity obj : Inventory) {
            if (requiredItems.contains(obj.name)) {
                itemsToRemove.add(obj);
            }
        }

        if (itemsToRemove.size() == 3) {
            Inventory.removeAll(itemsToRemove);

            Inventory.add(new Obj_ChaveCipestre(gp));
        }
    }

    public void interactNPC(int i) {
        if (i != 999) {

            if(gp.keyH.enterPressed == true){
                gp.gameState = gp.dialogueState;
                gp.npc[i].speak();
            }
        }
        gp.keyH.enterPressed = false;
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        switch (this.direction) {
            case "up":
                if (this.spriteNum == 1) {
                    image = up1;
                } else if (this.spriteNum == 2) {
                    image = up2;
                }
                break;
            case "down":
                if (this.spriteNum == 1) {
                    image = down1;
                } else if (this.spriteNum == 2) {
                    image = down2;
                }
                break;
            case "left":
                if (this.spriteNum == 1) {
                    image = left1;
                } else if (this.spriteNum == 2) {
                    image = left2;
                }
                break;
            case "right":
                if (this.spriteNum == 1) {
                    image = right1;
                } else if (this.spriteNum == 2) {
                    image = right2;
                }
        }

        g2.drawImage(image, screenX, screenY, 64, 64, null);
    }
}
