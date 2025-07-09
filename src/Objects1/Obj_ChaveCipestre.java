package Objects1;

import entity1.Entity;
import main1.GamePanel;

public class Obj_ChaveCipestre extends Entity {
    public Obj_ChaveCipestre(GamePanel gp)
    {
        super(gp);
        name = "chavecipestre";
        down1 = setup("/objects/ChaveCipestre", gp.tileSize, gp.tileSize);

        description = "Chave cipestre";

    }
}
