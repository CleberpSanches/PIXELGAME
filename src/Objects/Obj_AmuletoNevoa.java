package Objects;

import entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;

public class Obj_AmuletoNevoa extends Entity {
    GamePanel gp;
    public Obj_AmuletoNevoa(GamePanel gp)
    {
        super(gp);
        name = "amuletonevoa";
        down1 = setup("/objects/amuletonevoa", gp.tileSize, gp.tileSize);
        stackable = true;
    }
}
