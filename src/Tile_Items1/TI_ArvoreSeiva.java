package Tile_Items1;

import entity1.Entity;
import main1.GamePanel;

public class TI_ArvoreSeiva extends TileItems{
    GamePanel gp;
    public TI_ArvoreSeiva(GamePanel gp) {
        super(gp);
        this.gp = gp;
        name = "aseiva";
        down1 = setup("/tile_items/aseiva", gp.tileSize, gp.tileSize);
        destructible = true;
    }

    public boolean isCorrectMagic(Entity entity){
        return entity.currentMagicatk.type == Entity.type_magicBreak;
    }


}
