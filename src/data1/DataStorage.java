package data1;

import java.io.Serializable;
import java.util.ArrayList;

public class DataStorage implements Serializable {

    ArrayList<String> itemNames = new ArrayList<>();
    ArrayList<Integer> itemAmounts = new ArrayList<>();

    String mapObjectNames[][];
    int mapObjectWorldX[][];
    int mapObjectWorldY[][];

    public String[][] mapTileItemNames;
    public int[][] mapTileItemWorldX;
    public int[][] mapTileItemWorldY;

    public int currentMap;

    public int playerWorldX;
    public int playerWorldY;

    public boolean demonQuest;
    public boolean arkamQuest;
    public boolean MorceguitaQuest;
    public boolean RainbowQuest;
    public boolean questDeserto;
}
