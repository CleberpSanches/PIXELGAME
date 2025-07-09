package Objects1;

import entity1.Entity;
import main1.GamePanel;

public class Obj_CristalFlamejante extends Entity {
    public Obj_CristalFlamejante(GamePanel gp) {
        super(gp);
        name = "cristalflamejante";
        down1 = setup("/objects/cristal_flamejante", gp.tileSize, gp.tileSize);

        description = "Objeto sólido muito usado em armaduras!";
    }
}