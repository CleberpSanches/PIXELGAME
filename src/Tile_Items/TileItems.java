package Tile_Items;

import entity.Entity;
import main.GamePanel;

public class TileItems extends Entity {
    GamePanel gp;
    public boolean destructible = false;

    public TileItems(GamePanel gp) {
        super(gp);
        this.gp = gp;
    }

    public boolean isCorrectMagic(Entity entity){
        boolean correctMagic = false;
        return correctMagic;
    }

    public void update() {

    }
}
