package Objects;

import entity.Entity;
import main.GamePanel;

public class Obj_AtkToxina extends Entity {
    GamePanel gp;
    public Obj_AtkToxina(GamePanel gp)
    {
        super(gp);
        name = "atktoxina";
        down1 = setup("/objects/ataque_toxina", gp.tileSize, gp.tileSize);
    }
}
