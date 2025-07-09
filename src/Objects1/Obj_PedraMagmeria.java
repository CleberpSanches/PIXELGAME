package Objects1;

import entity1.Entity;
import main1.GamePanel;

public class Obj_PedraMagmeria extends Entity {
    public Obj_PedraMagmeria(GamePanel gp) {
        super(gp);
        name = "pedramagmeria";
        description = "Pedra pesada?";
        down1 = setup("/objects/pedramagmeria", gp.tileSize, gp.tileSize);
    }
}
