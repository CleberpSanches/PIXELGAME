package Objects;

import entity.Entity;
import main.GamePanel;

public class Obj_AreiadaVerdade extends Entity {
    public Obj_AreiadaVerdade(GamePanel gp) {
        super(gp);
        name = "areiadavdd";
        description = "Areia da verdade";
        down1 = setup("/objects/areiradavdd", gp.tileSize, gp.tileSize);
    }
}
