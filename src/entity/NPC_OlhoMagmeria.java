package entity;

import Objects.Obj_FragmentodeEspelho;
import Objects.Obj_NucleodeMagma;
import main.GamePanel;
import main.ToolBox;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class NPC_OlhoMagmeria extends Entity{
    public boolean olhocorreto = false;

    public NPC_OlhoMagmeria(GamePanel gp) {
        super(gp);
        direction = "down1";
        speed = 0;
        dialogueSet = -1;
        name = "olhomagmeria";
        getImage();
        setDialogue();

        solidArea.height = gp.tileSize;
        solidArea.width = gp.tileSize;
    }

    public void getImage() {
        down1 = setup("/npc/NpcparaPuzzles/NpcOlho/olho1", gp.tileSize, gp.tileSize);
        down2 = setup("/npc/NpcparaPuzzles/NpcOlho/olho2", gp.tileSize, gp.tileSize);
        down3 = setup("/npc/NpcparaPuzzles/NpcOlho/olho3", gp.tileSize, gp.tileSize);
        down4 = setup("/npc/NpcparaPuzzles/NpcOlho/olho1", gp.tileSize, gp.tileSize);

    }

    public void setDialogue(){
        dialogues[0][0] = "Olho errado!";
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

    public void speak(){
        if (!olhocorreto) {
            gp.player.Inventory.add(new Obj_NucleodeMagma(gp)); // entrega o item
            olhocorreto = true;

            dialogues[0][0] = "Olho correto, parabéns jovem aventureiro!";
            dialogues[0][1] = "Você pegou Núcleo de Magma!";

            direction = "down1";
        } else {
            dialogues[0][0] = "Não há mais o que fazer aqui!";
            dialogues[0][1] = null;
        }

        startDialogue(this, 0);
    }

}
