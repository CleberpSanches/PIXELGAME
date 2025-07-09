package Objects1;

import entity1.Entity;
import main1.GamePanel;

public class Obj_AmuletoSeiva extends Entity {
    GamePanel gp;

    public Obj_AmuletoSeiva(GamePanel gp) {
        super(gp);
        name = "amuletoseiva";
        description = "Amuleto da seiva";
        down1 = setup("/objects/amuletoseiva", gp.tileSize, gp.tileSize);
        stackable = true;

    }
}