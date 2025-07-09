package Objects1;

import entity1.Entity;
import main1.GamePanel;

public class Obj_ColarAmor extends Entity {
    public Obj_ColarAmor(GamePanel gp) {
        super(gp);
        name = "colaramor";
        description = "Um colar que representa amor";
        down1 = setup("/objects/colaramor", gp.tileSize, gp.tileSize);
    }
}
