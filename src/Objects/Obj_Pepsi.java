package Objects;

import entity.Entity;
import main.GamePanel;

public class Obj_Pepsi extends Entity {
    public Obj_Pepsi(GamePanel gp) {
        super(gp);
        name = "monsterzero";
        down1 = setup("/objects/bepsi.png", gp.tileSize, gp.tileSize);
    }
}