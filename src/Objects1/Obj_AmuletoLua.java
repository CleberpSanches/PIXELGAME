package Objects1;

import entity1.Entity;
import main1.GamePanel;

public class Obj_AmuletoLua extends Entity {

    public Obj_AmuletoLua(GamePanel gp)
    {
        super(gp);
        name = "amuletoluaverde";
        description = "Amuleto da lua verde";
        down1 = setup("/objects/amuletoluaverde", gp.tileSize, gp.tileSize);
    }
}
