package Objects1;

import entity1.Entity;
import main1.GamePanel;

public class Obj_OrbeRedemoinho extends Entity {
    public Obj_OrbeRedemoinho(GamePanel gp) {
        super(gp);
        name = "orberedemoinho";
        description = "Orbe do redemoinho";
        down1 = setup("/objects/orberedemoinho", gp.tileSize, gp.tileSize);
        stackable = true;
    }
}
