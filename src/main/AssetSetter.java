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
        int i=0;

        gp.obj[i] = new Obj_AmuletoLua(gp);
        gp.obj[i].worldX = 7 * gp.tileSize;
        gp.obj[i].worldY = 25 * gp.tileSize;
        i++;
        gp.obj[i] = new Obj_AmuletoNevoa(gp);
        gp.obj[i].worldX = 7 * gp.tileSize;
        gp.obj[i].worldY = 26 * gp.tileSize;
        i++;
        gp.obj[i] = new Obj_AmuletoSeiva(gp);
        gp.obj[i].worldX = 7 * gp.tileSize;
        gp.obj[i].worldY = 27 * gp.tileSize;
        i++;
        gp.obj[i] = new Obj_ChaveCipestre(gp);
        gp.obj[i].worldX = 7 * gp.tileSize;
        gp.obj[i].worldY = 28 * gp.tileSize;
        i++;
        gp.obj[i] = new Obj_OrbeOutono(gp);
        gp.obj[i].worldX = 7 * gp.tileSize;
        gp.obj[i].worldY = 29 * gp.tileSize;
        i++;
        gp.obj[i] = new Obj_OrbeBrisaDourada(gp);
        gp.obj[i].worldX = 7 * gp.tileSize;
        gp.obj[i].worldY = 30 * gp.tileSize;
        i++;
        gp.obj[i] = new Obj_OrbeRedemoinho(gp);
        gp.obj[i].worldX = 7 * gp.tileSize;
        gp.obj[i].worldY = 31 * gp.tileSize;
        i++;
        gp.obj[i] = new Obj_CaliceVento(gp);
        gp.obj[i].worldX = 7 * gp.tileSize;
        gp.obj[i].worldY = 32 * gp.tileSize;
        i++;
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

