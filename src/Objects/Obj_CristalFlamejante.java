package Objects;

import entity.Entity;
import main.GamePanel;

public class Obj_CristalFlamejante extends Entity {
    public Obj_CristalFlamejante(GamePanel gp) {
        super(gp);
        name = "cristalflamejante";
        down1 = setup("/objects/cristal_flamejante", gp.tileSize, gp.tileSize);
    }
}