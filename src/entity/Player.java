//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package entity;

import java.awt.*;
import java.awt.image.BufferedImage;

import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;

import Interface.Command;
import Interface.PlayerInput;
import main.GamePanel;
import Adapter.KeyHandlerAdapter;

public class Player extends Entity {
    GamePanel gp;
    PlayerInput input;

    public final int screenX;
    public final int screenY;

    int hasCooler = 0;
    int hasCpu = 0;;
    int hasHd= 0;
    int hasMouse= 0;
    int hasMonitor= 0;
    int hasPlacamae= 0;
    int hasPlaca= 0;
    int hasPvideo= 0;
    int hasRam= 0;


    public Player(GamePanel gp, PlayerInput input) {
        this.gp = gp;
        this.input = input;

        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);

        solidArea = new Rectangle(8, 55,40,20);
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        this.setDefaultValues();
        this.getPlayerImage();


    }

    public void setDefaultValues() {
        this.worldX = gp.tileSize * 47;
        this.worldY = (int) (gp.tileSize * 23.5);
        this.speed = 4;
        this.direction = "left";
    }

    public void getPlayerImage() {
        try {
            this.up1 = ImageIO.read(this.getClass().getResourceAsStream("/player/gatuno_costas_1.png"));
            this.up2 = ImageIO.read(this.getClass().getResourceAsStream("/player/gatuno_costas_2.png"));
            this.down1 = ImageIO.read(this.getClass().getResourceAsStream("/player/gatuno_frente_1.png"));
            this.down2 = ImageIO.read(this.getClass().getResourceAsStream("/player/gatuno_frente_2.png"));
            this.left1 = ImageIO.read(this.getClass().getResourceAsStream("/player/gatuno_esquerda_1.png"));
            this.left2 = ImageIO.read(this.getClass().getResourceAsStream("/player/gatuno_esquerda_2.png"));
            this.right1 = ImageIO.read(this.getClass().getResourceAsStream("/player/gatuno_direita_1.png"));
            this.right2 = ImageIO.read(this.getClass().getResourceAsStream("/player/gatuno_direita_2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

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
            String objectName = gp.obj[index].name;

            switch (objectName)
            {
                case "placa":
                    hasPlaca++;
                    break;
                case "cooler":
                    hasCooler++;
                    break;
                case "cpu":
                    hasCpu++;
                    break;
                case "hd":
                    hasHd++;
                    break;
                case "monitor":
                    hasMonitor++;
                    break;
                case "mouse":
                    hasMouse++;
                    break;
                case "placamae":
                    hasPlacamae++;
                    break;
                case "pvideo":
                    hasPvideo++;
                    break;
                case "ram":
                    hasRam++; 
                    break;
            }
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        switch (this.direction) {
            case "up":
                if (this.spriteNum == 1) {
                    image = this.up1;
                } else if (this.spriteNum == 2) {
                    image = this.up2;
                }
                break;
            case "down":
                if (this.spriteNum == 1) {
                    image = this.down1;
                } else if (this.spriteNum == 2) {
                    image = this.down2;
                }
                break;
            case "left":
                if (this.spriteNum == 1) {
                    image = this.left1;
                } else if (this.spriteNum == 2) {
                    image = this.left2;
                }
                break;
            case "right":
                if (this.spriteNum == 1) {
                    image = this.right1;
                } else if (this.spriteNum == 2) {
                    image = this.right2;
                }
        }

        g2.drawImage(image, screenX, screenY, 64, 64, null);
    }
}
