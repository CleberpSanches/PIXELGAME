package Tile_Items1;

import entity1.Entity;
import main1.GamePanel;

public class TI_Porta extends TileItems{
    public TI_Porta(GamePanel gp) {
        super(gp);
        this.gp = gp;
        name = "portafinalTI";
        down1 = setup("/tile_items/257", gp.tileSize, gp.tileSize);
        destructible = true;
    }
    public boolean isCorrectMagic(Entity entity){
        return entity.currentMagicatk.type == Entity.type_magicAtk;
    }

}
