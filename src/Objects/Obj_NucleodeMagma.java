package Objects;

import entity.Entity;
import main.GamePanel;

public class Obj_NucleodeMagma extends Entity {
    public Obj_NucleodeMagma(GamePanel gp) {
        super(gp);
        name = "nucleodemagma";
        description = "Núcleo de magma";
        down1 = setup("/objects/nucleo_de_magma", gp.tileSize, gp.tileSize);
    }
}