package Objects;

import entity.Entity;
import main.GamePanel;

public class Obj_PocaoSangue extends Entity {
    public Obj_PocaoSangue(GamePanel gp) {
        super(gp);
        name = "pocaosangue";
        down1 = setup("/objects/potionblood", gp.tileSize, gp.tileSize);
    }
}
