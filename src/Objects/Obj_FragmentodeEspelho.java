package Objects;

import entity.Entity;
import main.GamePanel;

public class Obj_FragmentodeEspelho extends Entity {
    public Obj_FragmentodeEspelho(GamePanel gp) {
        super(gp);
        name = "fragmentodeespelho";
        down1 = setup("/objects/fragmentodeespelho", gp.tileSize, gp.tileSize);
    }
}