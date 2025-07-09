package Objects1;

import entity1.Entity;
import main1.GamePanel;

public class Obj_MonsterZero extends Entity {
    public Obj_MonsterZero(GamePanel gp) {
        super(gp);
        name = "monsterzero";
        description = "Monster";
        down1 = setup("/objects/monsterzero", gp.tileSize, gp.tileSize);
    }
}