package Objects;

import entity.Entity;
import main.GamePanel;

public class Obj_CaliceVento extends Entity {
    public Obj_CaliceVento(GamePanel gp) {
        super(gp);
        name = "calicevento";
        down1 = setup("/objects/calicevento", gp.tileSize, gp.tileSize);
        description = name;
        stackable = true;
    }
}
