package Objects;

import entity.Entity;
import main.GamePanel;

public class Obj_LagrimadaLua extends Entity {
    public Obj_LagrimadaLua(GamePanel gp) {
        super(gp);
        name = "lagrimadalua";
        down1 = setup("/objects/lagrimadalua", gp.tileSize, gp.tileSize);
    }
}