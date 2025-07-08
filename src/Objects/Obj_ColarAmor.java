package Objects;

import entity.Entity;
import main.GamePanel;

public class Obj_ColarAmor extends Entity {
    public Obj_ColarAmor(GamePanel gp) {
        super(gp);
        name = "colaramor";
        description = "Um colar que representa amor";
        down1 = setup("/objects/colaramor", gp.tileSize, gp.tileSize);
    }
}
