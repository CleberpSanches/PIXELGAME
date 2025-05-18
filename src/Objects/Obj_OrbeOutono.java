package Objects;

import entity.Entity;
import main.GamePanel;

public class Obj_OrbeOutono extends Entity {
    public Obj_OrbeOutono(GamePanel gp) {
        super(gp);
        name = "orbeoutono";
        down1 = setup("/objects/orbeoutono", gp.tileSize, gp.tileSize);
    }
}
