package entity;

import Objects.Obj_AmuletoNevoa;
import main.GamePanel;

public class NPC_Fantasmito extends Entity{
    public NPC_Fantasmito(GamePanel gp) {
        super(gp);
        direction = "down1";

        speed = 0;
        getImage();
        setDialogue();
    }

    public void getImage() {
        down1 = setup("/npc/NpcFantasmito/fantasmito1", gp.tileSize, gp.tileSize);
        down2 = setup("/npc/NpcFantasmito/fantasmito2", gp.tileSize, gp.tileSize);
        down3 = setup("/npc/NpcFantasmito/fantasmito3", gp.tileSize, gp.tileSize);

    }

    public void setDialogue(){
        dialogues[0][0] = "VOCE QUER O AMULETO DA NEVOA?";
        dialogues[0][1] = "OLHE SEU INVENTARIO";


    }

    public void setAction(){
        actionLookCounter ++;
        if (actionLookCounter == 30) {
            if (direction.equals("down1")){
                direction = "down2";
            } else if (direction.equals("down2")){
                direction = "down3";
            }
            else if (direction.equals("down3")){
                direction = "down1";
            } else {
                direction = "down1";
            }
            actionLookCounter = 0;

        }

    }
    public void speak(){
        startDialogue(this, dialogueSet);
        gp.player.Inventory.add(new Obj_AmuletoNevoa(gp));
    }
}
