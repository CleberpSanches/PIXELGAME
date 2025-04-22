package main;

import Objects.Obj_Placa;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp = gp;

    }

    public  void setObject(){
        gp.obj[0] = new Obj_Placa();
        gp.obj[0].worldX = 3 * gp.tileSize;
        gp.obj[0].worldY = 24 * gp.tileSize;

    }
}

