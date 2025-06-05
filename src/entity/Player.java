package entity;

import java.awt.*;
import java.awt.image.BufferedImage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.imageio.ImageIO;
import javax.swing.*;

import Interface.Command;
import Interface.PlayerInput;
import Objects.*;
import main.GamePanel;
import Adapter.KeyHandlerAdapter;
import main.ToolBox;

public class Player extends Entity {
    PlayerInput input;

    public final int screenX;
    public final int screenY;



    public Player(GamePanel gp, PlayerInput input) {
        super(gp);

        this.input = input;

        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);

        solidArea = new Rectangle(8, 55,40,20);
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        attackArea.width = 68;
        attackArea.height = 68;

        this.setDefaultValues();
        this.getPlayerImage();
        getAttackImage();
        setItems();

    }

    public void setDefaultValues() {
        this.worldX = gp.tileSize * 24;
        this.worldY = gp.tileSize * 24;
        this.speed = 4;
        this.direction = "left";

        currentMagicatk = new Obj_AtkToxina(gp);
    }


    public void setItems() {
        Inventory.add(currentMagicatk);
        Inventory.add(new Obj_AtkToxina2(gp));
        Inventory.add(new Obj_OrbeRedemoinho(gp));
        Inventory.add(new Obj_OrbeOutono(gp));
        Inventory.add(new Obj_OrbeBrisaDourada(gp));
    }

    public void getPlayerImage() {
            up1 = setup("/player/gatuno_costas_1", gp.tileSize, gp.tileSize);
            up2 = setup("/player/gatuno_costas_2", gp.tileSize, gp.tileSize);
            down1 = setup("/player/gatuno_frente_1", gp.tileSize, gp.tileSize);
            down2 = setup("/player/gatuno_frente_2", gp.tileSize, gp.tileSize);
            left1 = setup("/player/gatuno_esquerda_1", gp.tileSize, gp.tileSize);
            left2 = setup("/player/gatuno_esquerda_2", gp.tileSize, gp.tileSize);
            right1 = setup("/player/gatuno_direita_1", gp.tileSize, gp.tileSize);
            right2 = setup("/player/gatuno_direita_2", gp.tileSize, gp.tileSize);
    }

    public void getAttackImage() {
        if (currentMagicatk.type == Entity.type_magicAtk){
            upattack1 = setup("/player/gatuno_costasatk_1", gp.tileSize, gp.tileSize * 2);
            upattack2 = setup("/player/gatuno_costasatk_2", gp.tileSize, gp.tileSize * 2);
            downattack1 = setup("/player/gatuno_frenteatk_1", gp.tileSize, gp.tileSize * 2);
            downattack2 = setup("/player/gatuno_frenteatk_2", gp.tileSize, gp.tileSize * 2);
            leftattack1 = setup("/player/gatuno_esquerdaatk_1", gp.tileSize *2, gp.tileSize);
            leftattack2 = setup("/player/gatuno_esquerdaatk_2", gp.tileSize*2, gp.tileSize);
            rightattack1 = setup("/player/gatuno_direitaatk_1", gp.tileSize*2, gp.tileSize);
            rightattack2 = setup("/player/gatuno_direitaatk_2", gp.tileSize*2, gp.tileSize);
        }
        if (currentMagicatk.type == Entity.type_magicBreak){
            upattack1 = setup("/player/gatuno_costasb_2", gp.tileSize, gp.tileSize * 2);
            upattack2 = setup("/player/gatuno_costasb_3", gp.tileSize, gp.tileSize * 2);
            downattack1 = setup("/player/gatuno_frenteb_2", gp.tileSize, gp.tileSize * 2);
            downattack2 = setup("/player/gatuno_frenteb_3", gp.tileSize, gp.tileSize * 2);
            leftattack1 = setup("/player/gatuno_esquerdab_2", gp.tileSize *2, gp.tileSize);
            leftattack2 = setup("/player/gatuno_esquerdab_3", gp.tileSize*2, gp.tileSize);
            rightattack1 = setup("/player/gatuno_direitab_2", gp.tileSize*2, gp.tileSize);
            rightattack2 = setup("/player/gatuno_direitab_3", gp.tileSize*2, gp.tileSize);
        }

    }

    public void setPosition(int x, int y) {
        this.worldX = x;
        this.worldY = y;
    }

    public void update() {
        if (input.qButtonPressed()){
            attacking();
        }
        else if (input.upButtonPressed()|| input.downButtonPressed()|| input.leftButtonPressed()|| input.rightButtonPressed()||input.enterButtonPressed()) {
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

            //tile items collision
            int tTileIndex = gp.cChecker.checkEntity(this, gp.tItens);

            gp.eHandler.checkEvent();

            //without collision the command movement runs
            if (!collisionOn && !input.enterButtonPressed()) {

                for (Command command : commands) {
                    command.execute(this);
                }

            }
            gp.keyH.enterPressed = false;

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

    private void attacking() {
        spriteCounter++;
        if (spriteCounter<=5){
            spriteNum =1;
        }
        if (spriteCounter>10 && spriteCounter<=35){
            spriteNum =2;
            int currentWorldX = worldX;
            int currentWorldY = worldY;
            int solidAreaWidth = solidArea.width;
            int solidAreaHeight = solidArea.height;

            //ajuste para a posição ser a da magia de ataque
            switch (direction){
                case"up":
                    worldY -=attackArea.height;
                    break;
                case"down":
                    worldY +=gp.tileSize;
                    break;
                case"left":
                    worldX -=attackArea.width;
                    break;
                case"right":
                    worldX +=gp.tileSize;
                    break;
            }
            // a area do ataque vira solida
            solidArea.width = attackArea.width;
            solidArea.height = attackArea.height;
            //para o futuro monstro
            int monsterIndex = gp.cChecker.checkEntity(this, gp.monster);
            //int monsterIndex = gp.cChecker.checkEntity(this,gp.tItens);
            int tItemsIndex = gp.cChecker.checkEntity(this, gp.tItens);
            damagetItems(tItemsIndex);
            //de volta para o original
            worldX = currentWorldX;
            worldY = currentWorldY;
            solidArea.width = solidAreaWidth;
            solidArea.height = solidAreaHeight;
        }
        if (spriteCounter>35){
            spriteNum =1;
            spriteCounter = 0;
        }
    }


    public void pickUpObject(int index){
      if (index != 999)
        {
            if (Inventory.size() != maxInventorySize)
            {
                Inventory.add(gp.obj[gp.currentMap][index]);
            }
            gp.obj[gp.currentMap][index] = null;
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
                gp.npc[gp.currentMap][i].speak();
            }
        }
        gp.keyH.enterPressed = false;
    }

    public void damagetItems(int index) {
        if (index != 999 && gp.tItens[gp.currentMap][index].destructible && gp.tItens[gp.currentMap][index].isCorrectMagic(this)){
            if (gp.tItens[gp.currentMap][index].name == "plua"){
                Inventory.add(new Obj_AmuletoLua(gp));
            } else if ((gp.tItens[gp.currentMap][index].name == "aseiva")) {
                    Inventory.add(new Obj_AmuletoSeiva(gp));
            }
            gp.tItens[gp.currentMap][index] = null;

        }

    }

    public void selectItem(){
        int itemIndex = gp.ui.getItemIndexOnSlot(gp.ui.playerSlotCol, gp.ui.playerSlotRow);

        if (itemIndex < Inventory.size()){
            Entity selectedItem = Inventory.get(itemIndex);
            if(selectedItem.type == Entity.type_magicAtk || selectedItem.type == Entity.type_magicBreak){
                currentMagicatk = selectedItem;
                getAttackImage();
            }
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        int tempScreenX = screenX;
        int tempScreenY = screenY;
        switch (this.direction) {
            case "up":
                if (!input.qButtonPressed()){
                    if (this.spriteNum == 1) {
                        image = up1;
                    } else if (this.spriteNum == 2) {
                        image = up2;
                    }
                } else {
                    tempScreenY = screenY - gp.tileSize;
                    if (this.spriteNum == 1) {
                        image = upattack1;
                    } else if (this.spriteNum == 2) {
                        image = upattack2;
                    }
                }
                break;
            case "down":
                if (!input.qButtonPressed()){
                    if (this.spriteNum == 1) {
                        image = down1;
                    } else if (this.spriteNum == 2) {
                        image = down2;
                    }
                } else {
                    if (this.spriteNum == 1) {
                        image = downattack1;
                    } else if (this.spriteNum == 2) {
                        image = downattack2;
                    }
                }
                break;
            case "left":
                if (!input.qButtonPressed()){
                    if (this.spriteNum == 1) {
                        image = left1;
                    } else if (this.spriteNum == 2) {
                        image = left2;
                    }
                } else {
                    tempScreenX = screenX - gp.tileSize;
                    if (this.spriteNum == 1) {
                        image = leftattack1;
                    } else if (this.spriteNum == 2) {
                        image = leftattack2;
                    }
                }
                break;
            case "right":
                if (!input.qButtonPressed()){
                    if (this.spriteNum == 1) {
                        image = right1;
                    } else if (this.spriteNum == 2) {
                        image = right2;
                    }
                } else {
                    if (this.spriteNum == 1) {
                        image = rightattack1;
                    } else if (this.spriteNum == 2) {
                        image = rightattack2;
                    }
                }
        }

        g2.drawImage(image, tempScreenX, tempScreenY, null);
    }
}
