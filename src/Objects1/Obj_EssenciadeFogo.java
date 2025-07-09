package Objects1;

import entity1.Entity;
import main1.GamePanel;

public class Obj_EssenciadeFogo extends Entity {
    public Obj_EssenciadeFogo(GamePanel gp) {
        super(gp);
        name = "essenciadofogo";
        description = "Essência de fogo";
        down1 = setup("/objects/essencia_do_fogo", gp.tileSize, gp.tileSize);
    }
}