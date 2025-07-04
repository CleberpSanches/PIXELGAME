package Objects;

import entity.Entity;
import main.GamePanel;

public class Obj_Pepsi extends Entity {
    public Obj_Pepsi(GamePanel gp) {
        super(gp);
        name = "pepsi";
        down1 = setup("/objects/bepsi", gp.tileSize, gp.tileSize);
        stackable = true;
    }
}