package Objects;

import entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;

public class Obj_AmuletoLua extends Entity {

    public Obj_AmuletoLua(GamePanel gp)
    {
        super(gp);
        name = "amuletoluaverde";
        description = "Amuleto da lua verde";
        down1 = setup("/objects/amuletoluaverde", gp.tileSize, gp.tileSize);
    }
}
