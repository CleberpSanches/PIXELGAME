package Objects;

import entity.Entity;
import main.GamePanel;

public class Obj_NucleodeMagma extends Entity {
    public Obj_NucleodeMagma(GamePanel gp) {
        super(gp);
        name = "nucleodemagma";
        down1 = setup("/objects/fragmentodeespelho", gp.tileSize, gp.tileSize);
    }
}