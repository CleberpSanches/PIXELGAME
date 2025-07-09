package Objects1;

import entity1.Entity;
import main1.GamePanel;

public class Obj_Pepsi extends Entity {
    public Obj_Pepsi(GamePanel gp) {
        super(gp);
        name = "pepsi";
        description = "Pepsi";
        down1 = setup("/objects/bepsi", gp.tileSize, gp.tileSize);
        stackable = true;
    }
}