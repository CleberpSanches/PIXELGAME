package Objects1;

import entity1.Entity;
import main1.GamePanel;

public class Obj_AtkToxina extends Entity {
    GamePanel gp;
    public Obj_AtkToxina(GamePanel gp)
    {
        super(gp);
        this.type = type_magicAtk;
        name = "atktoxina";
        down1 = setup("/objects/ataque_toxina", gp.tileSize, gp.tileSize);

        description = "Habilidade Principal: \nToxína Nevoeira";
    }
}
