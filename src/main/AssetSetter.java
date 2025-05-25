package main;

import entity.Enemy_SlimedeFogo;
import Objects.*;
import Tile_Items.TI_PLua;
import entity.*;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp = gp;

    }

    public  void setObject(){
        int i=0;
        int mapNum = 0;
        gp.obj[mapNum][i] = new Obj_AmuletoLua(gp);
        gp.obj[mapNum][i].worldX = 7 * gp.tileSize;
        gp.obj[mapNum][i].worldY = 25 * gp.tileSize;
        i++;
        gp.obj[mapNum][i] = new Obj_AmuletoNevoa(gp);
        gp.obj[mapNum][i].worldX = 7 * gp.tileSize;
        gp.obj[mapNum][i].worldY = 26 * gp.tileSize;
        i++;
        gp.obj[mapNum][i] = new Obj_AmuletoSeiva(gp);
        gp.obj[mapNum][i].worldX = 7 * gp.tileSize;
        gp.obj[mapNum][i].worldY = 27 * gp.tileSize;
        i++;
        gp.obj[mapNum][i] = new Obj_ChaveCipestre(gp);
        gp.obj[mapNum][i].worldX = 7 * gp.tileSize;
        gp.obj[mapNum][i].worldY = 28 * gp.tileSize;
        i++;
        gp.obj[mapNum][i] = new Obj_OrbeOutono(gp);
        gp.obj[mapNum][i].worldX = 7 * gp.tileSize;
        gp.obj[mapNum][i].worldY = 29 * gp.tileSize;
        i++;
        gp.obj[mapNum][i] = new Obj_OrbeBrisaDourada(gp);
        gp.obj[mapNum][i].worldX = 7 * gp.tileSize;
        gp.obj[mapNum][i].worldY = 30 * gp.tileSize;
        i++;
        gp.obj[mapNum][i] = new Obj_OrbeRedemoinho(gp);
        gp.obj[mapNum][i].worldX = 7 * gp.tileSize;
        gp.obj[mapNum][i].worldY = 31 * gp.tileSize;
        i++;
        gp.obj[mapNum][i] = new Obj_CaliceVento(gp);
        gp.obj[mapNum][i].worldX = 7 * gp.tileSize;
        gp.obj[mapNum][i].worldY = 32 * gp.tileSize;
        i++;
    }

    public void setNPC(){
        int i=0;
        int mapNum = 0;
        gp.npc[mapNum][i] = new Npc_Tigro(gp);
        gp.npc[mapNum][i].worldX = 34 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 26 * gp.tileSize;
        i++;

        mapNum = 2;
        gp.npc[mapNum][i] = new NPC_Cavaleiro(gp);
        gp.npc[mapNum][i].worldX = 35 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 25 * gp.tileSize;
        i++;

        mapNum = 3;
        gp.npc[mapNum][i] = new NPC_Morceguita(gp);
        gp.npc[mapNum][i].worldX = 17 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 29 * gp.tileSize;
        i++;

        gp.npc[mapNum][i] = new NPC_Sapita(gp);
        gp.npc[mapNum][i].worldX = 15 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 27 * gp.tileSize;
        i++;

        mapNum = 4;
        gp.npc[mapNum][i] = new NPC_Orus(gp);
        gp.npc[mapNum][i].worldX = 12 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 42 * gp.tileSize;
        i++;

    }

    public void setTItens(){
        int i = 0;
        int mapNum = 0;
        gp.tItens[mapNum][i] = new TI_PLua(gp);
        gp.tItens[mapNum][i].worldX = 16 * gp.tileSize;
        gp.tItens[mapNum][i].worldY = 26 * gp.tileSize;
        i++;
    }

    public void setMonster(){
        int i=0;
        int mapNum = 0;

        mapNum = 4;
        gp.monster[mapNum][i] = new Enemy_SlimedeFogo(gp);
        gp.monster[mapNum][i].worldX = 7 * gp.tileSize;
        gp.monster[mapNum][i].worldY = 26 * gp.tileSize;
        i++;

        gp.monster[mapNum][i] = new Enemy_SlimedeFogo(gp);
        gp.monster[mapNum][i].worldX = 8 * gp.tileSize;
        gp.monster[mapNum][i].worldY = 31 * gp.tileSize;
        i++;

        gp.monster[mapNum][i] = new Enemy_SlimedeFogo(gp);
        gp.monster[mapNum][i].worldX = 11 * gp.tileSize;
        gp.monster[mapNum][i].worldY = 29 * gp.tileSize;
        i++;
    }
}

