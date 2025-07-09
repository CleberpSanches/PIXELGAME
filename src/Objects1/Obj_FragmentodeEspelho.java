package Objects1;

import entity1.Entity;
import main1.GamePanel;

public class Obj_FragmentodeEspelho extends Entity {
    public Obj_FragmentodeEspelho(GamePanel gp) {
        super(gp);
        name = "fragmentodeespelho";
        description = "Fragmento de espelho";
        down1 = setup("/objects/fragmentodeespelho", gp.tileSize, gp.tileSize);
    }
}