package Objects;

import entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;

public class Obj_AmuletoSeiva extends Entity {
    GamePanel gp;

    public Obj_AmuletoSeiva(GamePanel gp) {
        super(gp);
        name = "amuletoseiva";
        down1 = setup("/objects/amuletoseiva", gp.tileSize, gp.tileSize);
        stackable = true;

    }
}