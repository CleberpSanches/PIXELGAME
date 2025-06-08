package Objects;

import entity.Entity;
import main.GamePanel;

public class Obj_Garrafadagua extends Entity {
    public Obj_Garrafadagua(GamePanel gp) {
        super(gp);
        name = "garrafadagua";
        down1 = setup("/objects/garrafadagua", gp.tileSize, gp.tileSize);
    }
}
