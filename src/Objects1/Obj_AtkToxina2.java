package Objects1;

import entity1.Entity;
import main1.GamePanel;

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
