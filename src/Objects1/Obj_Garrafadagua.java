package Objects1;

import entity1.Entity;
import main1.GamePanel;

public class Obj_Garrafadagua extends Entity {
    public Obj_Garrafadagua(GamePanel gp) {
        super(gp);
        name = "garrafadagua";
        description = "Garrafa d'água";
        down1 = setup("/objects/garrafadagua", gp.tileSize, gp.tileSize);
    }
}
