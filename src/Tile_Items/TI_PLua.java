package Tile_Items;

import entity.Entity;
import main.GamePanel;

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

