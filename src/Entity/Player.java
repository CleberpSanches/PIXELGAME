//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Entity;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.util.Objects;
import javax.imageio.ImageIO;
import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;


    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);

        solidArea = new Rectangle(12, 28,40,36);

        this.setDefaultValues();
        this.getPlayerImage();


    }

    public void setDefaultValues() {
        this.worldX = gp.tileSize * 14;
        this.worldY = gp.tileSize * 5;
        this.speed = 4;
        this.direction = "down";
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
        if (this.keyH.upPressed ==true|| this.keyH.downPressed ==true|| this.keyH.leftPressed ==true|| this.keyH.rightPressed==true) {
            if (this.keyH.upPressed) {
                this.direction = "up";
                this.worldY -= this.speed;
            } else if (this.keyH.downPressed) {
                this.direction = "down";
                this.worldY += this.speed;
            } else if (this.keyH.leftPressed) {
                this.direction = "left";
                this.worldX -= this.speed;
            } else if (this.keyH.rightPressed) {
                this.direction = "right";
                this.worldX += this.speed;
            }

            collisionOn = false;
            gp.cChecker.checkTile(this);

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

        g2.drawImage(image, screenX, screenY, 64, 64, (ImageObserver)null);
    }
}
