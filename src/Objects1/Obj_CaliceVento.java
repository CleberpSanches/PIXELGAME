package Objects1;

import entity1.Entity;
import main1.GamePanel;

public class Obj_CaliceVento extends Entity {
    public Obj_CaliceVento(GamePanel gp) {
        super(gp);
        name = "calicevento";
        down1 = setup("/objects/calicevento", gp.tileSize, gp.tileSize);
        description = "Calice de vento";
        stackable = true;
    }
}
