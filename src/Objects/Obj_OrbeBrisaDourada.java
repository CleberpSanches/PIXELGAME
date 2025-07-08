package Objects;

import entity.Entity;
import main.GamePanel;

public class Obj_OrbeBrisaDourada extends Entity {
    public Obj_OrbeBrisaDourada(GamePanel gp) {
        super(gp);
        name = "orbebrisadourada";
        description = "Orbe da brisa dourada";
        down1 = setup("/objects/orbebrisadourada", gp.tileSize, gp.tileSize);
        stackable = true;
    }
}
