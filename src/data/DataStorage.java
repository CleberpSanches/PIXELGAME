package data;

import java.io.Serializable;
import java.util.ArrayList;

public class DataStorage implements Serializable {

    ArrayList<String> itemNames = new ArrayList<>();
    ArrayList<Integer> itemAmounts = new ArrayList<>();

    String mapObjectNames[][];
    int mapObjectWorldX[][];
    int mapObjectWorldY[][];

    public int currentMap;
}
