package Objects1;

import entity1.Entity;
import main1.GamePanel;

public class Obj_AreiadaVerdade extends Entity {
    public Obj_AreiadaVerdade(GamePanel gp) {
        super(gp);
        name = "areiadavdd";
        description = "Areia da verdade";
        down1 = setup("/objects/areiradavdd", gp.tileSize, gp.tileSize);
    }
}
