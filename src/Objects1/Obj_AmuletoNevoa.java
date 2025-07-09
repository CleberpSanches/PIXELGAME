package Objects1;

import entity1.Entity;
import main1.GamePanel;

public class Obj_AmuletoNevoa extends Entity {
    GamePanel gp;
    public Obj_AmuletoNevoa(GamePanel gp)
    {
        super(gp);
        name = "amuletonevoa";
        description = "Amuleto da névoa";
        down1 = setup("/objects/amuletonevoa", gp.tileSize, gp.tileSize);
        stackable = true;
    }
}
