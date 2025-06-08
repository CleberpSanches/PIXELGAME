package Objects;

import entity.Entity;
import main.GamePanel;

public class Obj_EssenciadeFogo extends Entity {
    public Obj_EssenciadeFogo(GamePanel gp) {
        super(gp);
        name = "essenciadofogo";
        down1 = setup("/objects/essencia_do_fogo", gp.tileSize, gp.tileSize);
    }
}