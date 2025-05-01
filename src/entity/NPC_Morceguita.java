package entity;

import main.GamePanel;

public class NPC_Morceguita extends Entity{
    public NPC_Morceguita(GamePanel gp) {
        super(gp);
        direction = "down1";
        speed = 0;
        getImage();
    }

    public void getImage() {
        down1 = setup("/npc/morceguita1");
        down2 = setup("/npc/morceguita2");
        down3 = setup("/npc/morceguita3");
        down4 = setup("/npc/morceguita4");

    }

    public void setAction(){
        actionLookCounter ++;
        if (actionLookCounter == 50) {
            if (direction.equals("down1")){
                direction = "down2";
            } else if (direction.equals("down2")){
                direction = "down3";
            }
            else if (direction.equals("down3")){
                direction = "down4";
            }
            else if (direction.equals("down4")){
                direction = "down1";
            } else {
                direction = "down1";
            }
            actionLookCounter = 0;

        }

    }

}
