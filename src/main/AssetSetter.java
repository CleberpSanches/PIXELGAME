package main;

import Tile_Items.TI_ArvoreSeiva;
import Objects.*;
import Tile_Items.TI_PLua;
import entity.*;
import monster.Enemy_SlimedeFogo;
import monster.Monster_Lagarta;
import monster.Monster_LagartaNormal;

//ORDEM DOS MAPAS
//        0-Quarto;
//        1-Loja;
//        2-Inicio;
//        3-Mata Nebulosa;
//        4-Campos Infinitos;
//        5-Inferno de Magmeria;
//        6-Deserto Sombrio;

public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp){
        this.gp = gp;

    }

    public  void setObject(){
        int i=0;

        int mapNum;

        //INFERNO DE MAGMERIA
        mapNum = 5;
        gp.obj[mapNum][i] = new Obj_PedraMagmeria(gp);
        gp.obj[mapNum][i].worldX = 35 * gp.tileSize;
        gp.obj[mapNum][i].worldY = 22 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new Obj_PedraMagmeria(gp);
        gp.obj[mapNum][i].worldX = 36 * gp.tileSize;
        gp.obj[mapNum][i].worldY = 22 * gp.tileSize;
        i++;

        gp.obj[mapNum][i] = new Obj_PedraMagmeria(gp);
        gp.obj[mapNum][i].worldX = 37 * gp.tileSize;
        gp.obj[mapNum][i].worldY = 22 * gp.tileSize;
        i++;
    }

    public void setNPC(){
        int i=0;
        int mapNum = 0;

        //MAPA INICIAL
        //NPCS : Cavaleiro do Tutorial ✅
        mapNum = 2;
        gp.npc[mapNum][i] = new NPC_Cavaleiro(gp);
        gp.npc[mapNum][i].worldX = 35 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 25 * gp.tileSize;
        i++;

        gp.npc[mapNum][i] = new NPC_PInicio(gp);
        gp.npc[mapNum][i].worldX = 39 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 23 * gp.tileSize;

        gp.npc[mapNum][i] = new NPC_PInicio(gp);
        gp.npc[mapNum][i].worldX = 39 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 27 * gp.tileSize;

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

        gp.npc[mapNum][i] = new NPC_PMataNebulosa(gp);
        gp.npc[mapNum][i].worldX = 23 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 35 * gp.tileSize;
        i++;

        gp.npc[mapNum][i] = new NPC_PMataNebulosa(gp);
        gp.npc[mapNum][i].worldX = 26 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 35 * gp.tileSize;
        i++;

        //CAMPOS INFINITOS
        //NPC : Sapita✅, Tigro✅, Totem Rainbow✅
        mapNum = 4;
        gp.npc[mapNum][i] = new NPC_Sapita(gp);
        gp.npc[mapNum][i].worldX = 25 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 12 * gp.tileSize;
        i++;

        gp.npc[mapNum][i] = new NPC_Rainbow(gp);
        gp.npc[mapNum][i].worldX = 24 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 8 * gp.tileSize;
        i++;

        gp.npc[mapNum][i] = new Npc_Tigro(gp);
        gp.npc[mapNum][i].worldX = 9 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 18 * gp.tileSize;
        i++;

        gp.npc[mapNum][i] = new NPC_Anao(gp);
        gp.npc[mapNum][i].worldX = 41 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 15 * gp.tileSize;
        i++;

        gp.npc[mapNum][i] = new NPC_PCamposInfinitos(gp);
        gp.npc[mapNum][i].worldX = 23 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 46 * gp.tileSize;
        i++;

        gp.npc[mapNum][i] = new NPC_PCamposInfinitos(gp);
        gp.npc[mapNum][i].worldX = 26 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 46 * gp.tileSize;
        i++;

        //INFERNO DE MAGMÉRIA
        //NPC: ORUS✅, GOLEM DE FOGO✅
        mapNum = 5;
        gp.npc[mapNum][i] = new NPC_Orus(gp);
        gp.npc[mapNum][i].worldX = 29 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 6 * gp.tileSize;
        i++;

        gp.npc[mapNum][i] = new NPC_GolemdeFogo(gp);
        gp.npc[mapNum][i].worldX = 10 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 9 * gp.tileSize;
        i++;

        gp.npc[mapNum][i] = new NPC_Arkam(gp);
        gp.npc[mapNum][i].worldX = 15 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 24 * gp.tileSize;
        i++;

        gp.npc[mapNum][i] = new NPC_Ilusina(gp);
        gp.npc[mapNum][i].worldX = 36 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 18 * gp.tileSize;
        i++;

        gp.npc[mapNum][i] = new NPC_OlhoCenario(gp);
        gp.npc[mapNum][i].worldX = 29 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 9 * gp.tileSize;
        i++;

        gp.npc[mapNum][i] = new NPC_OlhoCenario(gp);
        gp.npc[mapNum][i].worldX = 26 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 9 * gp.tileSize;
        i++;

        gp.npc[mapNum][i] = new NPC_OlhoMagmeria(gp);
        gp.npc[mapNum][i].worldX = 32 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 9 * gp.tileSize;
        i++;

        gp.npc[mapNum][i] = new NPC_TotemCenario(gp);
        gp.npc[mapNum][i].worldX = 35 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 20 * gp.tileSize;
        i++;

        gp.npc[mapNum][i] = new NPC_TotemCorreto(gp);
        gp.npc[mapNum][i].worldX = 36 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 20 * gp.tileSize;
        i++;

        gp.npc[mapNum][i] = new NPC_TotemCenario(gp);
        gp.npc[mapNum][i].worldX = 37  * gp.tileSize;
        gp.npc[mapNum][i].worldY = 20 * gp.tileSize;
        i++;

        gp.npc[mapNum][i] = new NPC_FogoMagmeria(gp);
        gp.npc[mapNum][i].worldX = 8  * gp.tileSize;
        gp.npc[mapNum][i].worldY = 10 * gp.tileSize;
        i++;

        gp.npc[mapNum][i] = new NPC_FogoMagmeria(gp);
        gp.npc[mapNum][i].worldX = 10 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 11 * gp.tileSize;
        i++;

        gp.npc[mapNum][i] = new NPC_FogoCorreto(gp);
        gp.npc[mapNum][i].worldX = 12 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 10 * gp.tileSize;
        i++;

        gp.npc[mapNum][i] = new NPC_PMagmeria(gp);
        gp.npc[mapNum][i].worldX = 8 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 43 * gp.tileSize;
        i++;

        gp.npc[mapNum][i] = new NPC_PMagmeria(gp);
        gp.npc[mapNum][i].worldX = 12 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 43 * gp.tileSize;
        i++;


        //DESERTO SOMBRIO
        //NPCS : Kramu✅, Tasmo✅, LapideM✅, LapideJ✅, NPC Cenário Caveiras✅, NPC Puzzle Caveira✅
        mapNum = 6;
        gp.npc[mapNum][i] = new NPC_PDesertoSombrio(gp);
        gp.npc[mapNum][i].worldX = 5 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 42 * gp.tileSize;
        i++;

        gp.npc[mapNum][i] = new NPC_PDesertoSombrio(gp);
        gp.npc[mapNum][i].worldX = 10 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 42 * gp.tileSize;
        i++;

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

        gp.npc[mapNum][i] = new NPC_CaveiraCenario(gp);
        gp.npc[mapNum][i].worldX = 10 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 45 * gp.tileSize;
        i++;

        gp.npc[mapNum][i] = new NPC_CaveiraCenario(gp);
        gp.npc[mapNum][i].worldX = 4 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 39 * gp.tileSize;
        i++;

        gp.npc[mapNum][i] = new NPC_CaveiraMorta(gp);
        gp.npc[mapNum][i].worldX = 17 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 40 * gp.tileSize;
        i++;

        gp.npc[mapNum][i] = new NPC_CaveiraCenario(gp);
        gp.npc[mapNum][i].worldX = 12 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 35 * gp.tileSize;
        i++;

        gp.npc[mapNum][i] = new NPC_CaveiraCenario(gp);
        gp.npc[mapNum][i].worldX = 15 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 31 * gp.tileSize;
        i++;

        gp.npc[mapNum][i] = new NPC_CaveiraCenario(gp);
        gp.npc[mapNum][i].worldX = 6 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 29 * gp.tileSize;
        i++;

        gp.npc[mapNum][i] = new NPC_CaveiraCenario(gp);
        gp.npc[mapNum][i].worldX = 12 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 20 * gp.tileSize;
        i++;

        gp.npc[mapNum][i] = new NPC_CaveiraCenario(gp);
        gp.npc[mapNum][i].worldX = 5 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 17 * gp.tileSize;
        i++;

        gp.npc[mapNum][i] = new NPC_CaveiraCenario(gp);
        gp.npc[mapNum][i].worldX = 7 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 8 * gp.tileSize;
        i++;

        gp.npc[mapNum][i] = new NPC_CaveiraCenario(gp);
        gp.npc[mapNum][i].worldX = 3 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 5 * gp.tileSize;
        i++;

        gp.npc[mapNum][i] = new NPC_CaveiraCenario(gp);
        gp.npc[mapNum][i].worldX = 12 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 3 * gp.tileSize;
        i++;

        gp.npc[mapNum][i] = new NPC_CaveiraCenario(gp);
        gp.npc[mapNum][i].worldX = 38 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 40 * gp.tileSize;
        i++;

        gp.npc[mapNum][i] = new NPC_CaveiraCenario(gp);
        gp.npc[mapNum][i].worldX = 41 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 35 * gp.tileSize;
        i++;

        gp.npc[mapNum][i] = new NPC_CaveiraCenario(gp);
        gp.npc[mapNum][i].worldX = 47 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 37 * gp.tileSize;
        i++;

        gp.npc[mapNum][i] = new NPC_CaveiraCenario(gp);
        gp.npc[mapNum][i].worldX = 44 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 29 * gp.tileSize;
        i++;

        gp.npc[mapNum][i] = new NPC_EspelhodaVerdade(gp);
        gp.npc[mapNum][i].worldX = 25 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 5 * gp.tileSize;
        i++;

        gp.npc[mapNum][i] = new NPC_Gatita(gp);
        gp.npc[mapNum][i].worldX = 25 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 4 * gp.tileSize;
        i++;

    }

    public void setTItens(){
        int i = 0;
        int mapNum = 0;

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

    public void setMonster(){
        int i = 0;
        int mapNum = 0;

        mapNum = 4;
        gp.npc[mapNum][i] = new Monster_Lagarta(gp);
        gp.npc[mapNum][i].worldX = 38 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 15 * gp.tileSize;
        i++;
        gp.npc[mapNum][i] = new Monster_LagartaNormal(gp);
        gp.npc[mapNum][i].worldX = 41 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 34 * gp.tileSize;
        i++;
        gp.npc[mapNum][i] = new Monster_LagartaNormal(gp);
        gp.npc[mapNum][i].worldX = 25 * gp.tileSize;
        gp.npc[mapNum][i].worldY = 25 * gp.tileSize;
        i++;

        mapNum = 5;
        gp.monster[mapNum][i] = new Enemy_SlimedeFogo(gp);
        gp.monster[mapNum][i].worldX = 9 * gp.tileSize;
        gp.monster[mapNum][i].worldY = 41 * gp.tileSize;
        i++;
    }
}

