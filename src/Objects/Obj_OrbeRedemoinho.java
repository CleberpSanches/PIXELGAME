package Objects;

import entity.Entity;
import main.GamePanel;

public class Obj_OrbeRedemoinho extends Entity {
    public Obj_OrbeRedemoinho(GamePanel gp) {
        super(gp);
        name = "orberedemoinho";
        down1 = setup("/objects/orberedemoinho", gp.tileSize, gp.tileSize);
    }
}
