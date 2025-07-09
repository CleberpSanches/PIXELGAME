package Tile_Items1;

import entity1.Entity;
import main1.GamePanel;

public class TI_PLua extends TileItems{
    GamePanel gp;
    public TI_PLua(GamePanel gp) {
        super(gp);
        this.gp = gp;
        name = "plua";
        down1 = setup("/tile_items/plua", gp.tileSize, gp.tileSize);
        destructible = true;
    }

    public boolean isCorrectMagic(Entity entity){
        return entity.currentMagicatk.type == Entity.type_magicBreak;
    }


}

