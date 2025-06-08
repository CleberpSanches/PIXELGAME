package Objects;

import entity.Entity;
import main.GamePanel;

public class Obj_MonsterZero extends Entity {
    public Obj_MonsterZero(GamePanel gp) {
        super(gp);
        name = "monsterzero";
        down1 = setup("/objects/monsterzero.png", gp.tileSize, gp.tileSize);
    }
}