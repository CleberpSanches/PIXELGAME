package Objects;

import entity.Entity;
import main.GamePanel;

public class Obj_PedraMagmeria extends Entity {
    public Obj_PedraMagmeria(GamePanel gp) {
        super(gp);
        name = "pedramagmeria";
        description = "Pedra pesada?";
        down1 = setup("/objects/pedramagmeria", gp.tileSize, gp.tileSize);
    }
}
