package Tile_Items1;

import entity1.Entity;
import main1.GamePanel;

public class TileItems extends Entity {
    GamePanel gp;
    public boolean destructible = false;

    public TileItems(GamePanel gp) {
        super(gp);
        this.gp = gp;
    }

    public boolean isCorrectMagic(Entity entity){
        return entity.currentMagicatk.type == Entity.type_magicBreak;
    }


    public void update() {

    }
}
