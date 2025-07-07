package data;

import Objects.*;
import entity.Entity;
import main.GamePanel;

import java.io.*;

public class SaveLoad {
    GamePanel gp;
    public Entity npc;
    public SaveLoad(GamePanel gp){
        this.gp = gp;
    }

    public Entity getObject(String itemName){
        Entity obj = null;

        switch (itemName){
            //magia
            case "atktoxina": obj = new Obj_AtkToxina(gp); break;
            case "atktoxina2": obj = new Obj_AtkToxina2(gp); break;
            //nv1
            case "amuletoluaverde": obj = new Obj_AmuletoLua(gp); break;
            case "amuletonevoa": obj = new Obj_AmuletoNevoa(gp); break;
            case "amuletoseiva": obj = new Obj_AmuletoSeiva(gp); break;
            case "chavecipestre": obj = new Obj_ChaveCipestre(gp); break;
            //nv2
            case "orbebrisadourada": obj = new Obj_OrbeBrisaDourada(gp); break;
            case "orbeoutono": obj = new Obj_OrbeOutono(gp); break;
            case "orberedemoinho": obj = new Obj_OrbeRedemoinho(gp); break;
            case "pocaosangue": obj = new Obj_PocaoSangue(gp); break;
            case "calicevento": obj = new Obj_CaliceVento(gp); break;
            //nv3
            case "cristalflamejante": obj = new Obj_CristalFlamejante(gp); break;
            case "essenciadofogo": obj = new Obj_EssenciadeFogo(gp); break;
            case "garrafadagua": obj = new Obj_Garrafadagua(gp); break;
            case "nucleodemagma": obj = new Obj_NucleodeMagma(gp); break;
            case "pedramagmeria": obj = new Obj_PedraMagmeria(gp); break;
            //nv4
            case "areiadavdd": obj = new Obj_AreiadaVerdade(gp); break;
            case "fragmentodeespelho": obj = new Obj_FragmentodeEspelho(gp); break;
            case "lagrimadalua": obj = new Obj_LagrimadaLua(gp); break;
            case "monsterzero": obj = new Obj_MonsterZero(gp); break;
            case "pepsi": obj = new Obj_Pepsi(gp); break;
        }
        return obj;
    }

    public void save(){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("save.dat")));
            DataStorage ds = new DataStorage();
            for (int i = 0; i < gp.player.Inventory.size(); i++) {
                ds.itemNames.add(gp.player.Inventory.get(i).name);
                ds.itemAmounts.add(gp.player.Inventory.get(i).amount);
            }


            ds.mapObjectNames = new String[gp.maxMap][gp.obj[1].length];
            ds.mapObjectWorldX= new int[gp.maxMap][gp.obj[1].length];
            ds.mapObjectWorldY= new int[gp.maxMap][gp.obj[1].length];

            for (int mapNum = 0; mapNum < gp.maxMap; mapNum++) {
                for (int i = 0; i < gp.obj[1].length; i++) {
                    if (gp.obj[mapNum][i] == null) {
                        ds.mapObjectNames[mapNum][i] = "NA";
                    }
                    else {
                        ds.mapObjectNames[mapNum][i] = gp.obj[mapNum][i].name;
                        ds.mapObjectWorldX[mapNum][i] = gp.obj[mapNum][i].worldX;
                        ds.mapObjectWorldY[mapNum][i] = gp.obj[mapNum][i].worldY;
                    }
                }
            }
            ds.currentMap = gp.currentMap;

            ds.playerWorldX = gp.player.worldX;
            ds.playerWorldY = gp.player.worldY;

            ds.demonQuest = gp.demonQuest;
            ds.arkamQuest = gp.arkamQuest;
            ds.MorceguitaQuest = gp.MorceguitaQuest;
            ds.RainbowQuest = gp.RainbowQuest;
            ds.questDeserto = gp.questDeserto;

            oos.writeObject(ds);
        } catch (IOException e) {
            System.out.println("Error saving game!");
        }
    }
    public void load(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("save.dat")));
            DataStorage ds = (DataStorage)ois.readObject();
            gp.player.Inventory.clear();

            for (int i = 0; i < ds.itemNames.size(); i++) {
                gp.player.Inventory.add(getObject(ds.itemNames.get(i)));
                gp.player.Inventory.get(i).amount= ds.itemAmounts.get(i);
            }

            for (int mapNum = 0; mapNum < gp.maxMap; mapNum++) {
                for (int i = 0; i < gp.obj[1].length; i++) {
                    if (ds.mapObjectNames[mapNum][i].equals("NA")) {
                        gp.obj[mapNum][i] = null;
                    }
                    else{
                        gp.obj[mapNum][i] = getObject(ds.mapObjectNames[mapNum][i]);
                        gp.obj[mapNum][i].worldX = ds.mapObjectWorldX[mapNum][i];
                        gp.obj[mapNum][i].worldY = ds.mapObjectWorldY[mapNum][i];
                    }

                }
            }

            gp.currentMap = ds.currentMap;

            gp.player.setPosition(ds.playerWorldX, ds.playerWorldY);

            gp.demonQuest = ds.demonQuest;
            gp.arkamQuest = ds.arkamQuest;
            gp.MorceguitaQuest = ds.MorceguitaQuest;
            gp.RainbowQuest = ds.RainbowQuest;
            gp.questDeserto = ds.questDeserto;
        } catch (Exception e) {
            System.out.println("Error loading game!");
        }
    }
}
