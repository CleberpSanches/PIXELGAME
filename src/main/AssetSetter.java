package main;

import Objects.*;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp = gp;

    }

    public  void setObject(){
        gp.obj[0] = new Obj_Placa();
        gp.obj[0].worldX = 3 * gp.tileSize;
        gp.obj[0].worldY = 24 * gp.tileSize;

        gp.obj[1] = new Obj_cooler();
        gp.obj[1].worldX = 3 * gp.tileSize;
        gp.obj[1].worldY = 25 * gp.tileSize;

        gp.obj[2] = new Obj_cpu();
        gp.obj[2].worldX = 3 * gp.tileSize;
        gp.obj[2].worldY = 26 * gp.tileSize;

        gp.obj[3] = new Obj_hd();
        gp.obj[3].worldX = 3 * gp.tileSize;
        gp.obj[3].worldY = 27 * gp.tileSize;

        gp.obj[4] = new Obj_monitor();
        gp.obj[4].worldX = 3 * gp.tileSize;
        gp.obj[4].worldY = 28 * gp.tileSize;

        gp.obj[5] = new Obj_mouse();
        gp.obj[5].worldX = 3 * gp.tileSize;
        gp.obj[5].worldY = 29 * gp.tileSize;

        gp.obj[6] = new Obj_placamae();
        gp.obj[6].worldX = 3 * gp.tileSize;
        gp.obj[6].worldY = 30 * gp.tileSize;

        gp.obj[7] = new Obj_pvideo();
        gp.obj[7].worldX = 3 * gp.tileSize;
        gp.obj[7].worldY = 31 * gp.tileSize;

        gp.obj[8] = new Obj_ram();
        gp.obj[8].worldX = 3 * gp.tileSize;
        gp.obj[8].worldY = 32 * gp.tileSize;

    }
}

