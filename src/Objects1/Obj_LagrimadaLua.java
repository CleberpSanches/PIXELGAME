package Objects1;

import entity1.Entity;
import main1.GamePanel;

public class Obj_LagrimadaLua extends Entity {
    public Obj_LagrimadaLua(GamePanel gp) {
        super(gp);
        name = "lagrimadalua";
        description = "Lagrima da lua";
        down1 = setup("/objects/lagrimadalua", gp.tileSize, gp.tileSize);
    }
}