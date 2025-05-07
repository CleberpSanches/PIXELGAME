package main;

import Objects.*;
import entity.NPC_Morceguita;
import entity.NPC_Sapita;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp = gp;

    }

    public  void setObject(){
        gp.obj[0] = new Obj_AmuletoLua(gp);
        gp.obj[0].worldX = 7 * gp.tileSize;
        gp.obj[0].worldY = 25 * gp.tileSize;

        gp.obj[1] = new Obj_AmuletoNevoa(gp);
        gp.obj[1].worldX = 7 * gp.tileSize;
        gp.obj[1].worldY = 26 * gp.tileSize;

        gp.obj[2] = new Obj_AmuletoSeiva(gp);
        gp.obj[2].worldX = 7 * gp.tileSize;
        gp.obj[2].worldY = 27 * gp.tileSize;

        gp.obj[3] = new Obj_ChaveCipestre(gp);
        gp.obj[3].worldX = 7 * gp.tileSize;
        gp.obj[3].worldY = 28 * gp.tileSize;

        gp.obj[4] = new Obj_OrbeOutono(gp);
        gp.obj[4].worldX = 7 * gp.tileSize;
        gp.obj[4].worldY = 29 * gp.tileSize;

        gp.obj[5] = new Obj_OrbeBrisaDourada(gp);
        gp.obj[5].worldX = 7 * gp.tileSize;
        gp.obj[5].worldY = 30 * gp.tileSize;

        gp.obj[6] = new Obj_OrbeRedemoinho(gp);
        gp.obj[6].worldX = 7 * gp.tileSize;
        gp.obj[6].worldY = 31 * gp.tileSize;

        gp.obj[7] = new Obj_CaliceVento(gp);
        gp.obj[7].worldX = 7 * gp.tileSize;
        gp.obj[7].worldY = 32 * gp.tileSize;
    }

    public void setNPC(){
        gp.npc[0] = new NPC_Sapita(gp);
        gp.npc[0].worldX = 3 * gp.tileSize;
        gp.npc[0].worldY = 33 * gp.tileSize;

        gp.npc[1] = new NPC_Morceguita(gp);
        gp.npc[1].worldX = 4 * gp.tileSize;
        gp.npc[1].worldY = 33 * gp.tileSize;
    }
}

