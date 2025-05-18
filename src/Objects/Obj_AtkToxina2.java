package Objects;

import entity.Entity;
import main.GamePanel;

public class Obj_AtkToxina2 extends Entity {
    GamePanel gp;
    public Obj_AtkToxina2(GamePanel gp)
    {
        super(gp);

        this.type = Entity.type_magicBreak;
        name = "atktoxina2";
        down1 = setup("/objects/ataque_toxina2", gp.tileSize, gp.tileSize);

        description = "Habilidade Secundaria: \nToxína Deteriorante";
    }
}
