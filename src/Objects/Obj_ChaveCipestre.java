package Objects;

import entity.Entity;
import main.GamePanel;

public class Obj_ChaveCipestre extends Entity {
    public Obj_ChaveCipestre(GamePanel gp)
    {
        super(gp);
        name = "chavecipestre";
        down1 = setup("/objects/ChaveCipestre", gp.tileSize, gp.tileSize);
    }
}
