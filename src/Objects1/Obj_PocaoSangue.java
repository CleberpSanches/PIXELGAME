package Objects1;

import entity1.Entity;
import main1.GamePanel;

public class Obj_PocaoSangue extends Entity {
    public Obj_PocaoSangue(GamePanel gp) {
        super(gp);
        name = "pocaosangue";
        description = "Poção de sangue";
        down1 = setup("/objects/potionblood", gp.tileSize, gp.tileSize);
        stackable = true;
    }
}
