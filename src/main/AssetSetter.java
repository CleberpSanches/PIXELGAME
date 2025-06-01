package main;

import Tile_Items.TI_ArvoreSeiva;
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
        int mapNum = 2;
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
        //NPCS TESTE
        mapNum = 0;
        gp.npc[mapNum][i] = new NPC_Cavaleiro(gp);
        gp.npc[mapNum][i].worldX = 24 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 28 * gp.tileSize;
        i++;

        //MAPA INICIAL
        //NPCS : Cavaleiro do Tutorial ✅
        mapNum = 2;
        gp.npc[mapNum][i] = new NPC_Cavaleiro(gp);
        gp.npc[mapNum][i].worldX = 35 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 25 * gp.tileSize;
        i++;

        //MATA NEBULOSA
        //NPCS : Morceguita✅ e Fantasmito ✅
        mapNum = 3;
        gp.npc[mapNum][i] = new NPC_Morceguita(gp);
        gp.npc[mapNum][i].worldX = (int) (24.5 * gp.tileSize);
        gp.npc[mapNum][i].worldY = 23 * gp.tileSize;
        i++;
        gp.npc[mapNum][i] = new NPC_Fantasmito(gp);
        gp.npc[mapNum][i].worldX = 13 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 12 * gp.tileSize;
        i++;

        //INFERNO DE MAGMÉRIA
        //NPCS : Orus✅ e Golem de Fogo✅
        mapNum = 4;
        gp.npc[mapNum][i] = new NPC_Orus(gp);
        gp.npc[mapNum][i].worldX = 13 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 41 * gp.tileSize;
        i++;

        gp.npc[mapNum][i] = new NPC_GolemdeFogo(gp);
        gp.npc[mapNum][i].worldX = 16 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 25 * gp.tileSize;
        i++;

        //DESERTO SOMBRIO
        //NPCS : Kramu✅, Tasmo✅, LapideM✅ e LapideJ✅
        mapNum = 5;
        gp.npc[mapNum][i] = new NPC_LapideJ(gp);
        gp.npc[mapNum][i].worldX = 45 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 8 * gp.tileSize;
        i++;

        gp.npc[mapNum][i] = new NPC_LapideM(gp);
        gp.npc[mapNum][i].worldX = 42 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 8 * gp.tileSize;
        i++;

        gp.npc[mapNum][i] = new NPC_Tasmo(gp);
        gp.npc[mapNum][i].worldX = 5 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 9 * gp.tileSize;
        i++;

        gp.npc[mapNum][i] = new NPC_Kramu(gp);
        gp.npc[mapNum][i].worldX = 13 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 26 * gp.tileSize;
        i++;

        //CAMPOS INFINITOS
        //NPC : Sapita, Tigro
        mapNum = 6;
        gp.npc[mapNum][i] = new NPC_Sapita(gp);
        gp.npc[mapNum][i].worldX = 18 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 37 * gp.tileSize;
        i++;

        gp.npc[mapNum][i] = new Npc_Tigro(gp);
        gp.npc[mapNum][i].worldX = 9 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 18 * gp.tileSize;
        i++;


    }

    public void setTItens(){
        int i = 0;
        int mapNum = 0;
        mapNum = 1;

        mapNum = 2;

        mapNum = 3;
        gp.tItens[mapNum][i] = new TI_PLua(gp);
        gp.tItens[mapNum][i].worldX = 11 * gp.tileSize;
        gp.tItens[mapNum][i].worldY = 27 * gp.tileSize;
        i++;
        gp.tItens[mapNum][i] = new TI_ArvoreSeiva(gp);
        gp.tItens[mapNum][i].worldX = 39 * gp.tileSize;
        gp.tItens[mapNum][i].worldY = 13 * gp.tileSize;
        i++;
    }

//    public void setMonster(){
//
//    }
}

