package Objects1;

import entity1.Entity;
import main1.GamePanel;

public class Obj_OrbeOutono extends Entity {
    public Obj_OrbeOutono(GamePanel gp) {
        super(gp);
        name = "orbeoutono";
        description = "Orbe do outono";
        down1 = setup("/objects/orbeoutono", gp.tileSize, gp.tileSize);
        stackable = true;
    }
}
