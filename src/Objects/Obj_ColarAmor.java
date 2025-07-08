package Objects;

import entity.Entity;
import main.GamePanel;

public class Obj_ColarAmor extends Entity {
    public Obj_ColarAmor(GamePanel gp) {
        super(gp);
        name = "colaramor";
        down1 = setup("/objects/colaramor", gp.tileSize, gp.tileSize);
    }
}
