package Objects;

import entity.Entity;
import main.GamePanel;

public class Obj_ArmaduradeMagma extends Entity {
    public Obj_ArmaduradeMagma(GamePanel gp) {
        super(gp);
        name = "lagrimadalua";
        down1 = setup("/objects/armadura_de_magma", gp.tileSize, gp.tileSize);
    }
}