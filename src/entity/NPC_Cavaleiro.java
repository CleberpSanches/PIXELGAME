package entity;

import Objects.Obj_AmuletoLua;
import main.GamePanel;
import main.ToolBox;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class NPC_Cavaleiro extends Entity{
    public NPC_Cavaleiro(GamePanel gp) {
        super(gp);
        direction = "down1";
        name = "cavaleiro";
        speed = 0;
        dialogueSet = -1;
        getImage();
        setDialogue();
    }

    public void getImage() {
        down1 = setup("/npc/NpcCavaleiroTutor/CavaleiroTutorial1", gp.tileSize, gp.tileSize);
        down2 = setup("/npc/NpcCavaleiroTutor/CavaleiroTutorial2", gp.tileSize, gp.tileSize);
        down3 = setup("/npc/NpcCavaleiroTutor/CavaleiroTutorial3", gp.tileSize, gp.tileSize);
        down4 = setup("/npc/NpcCavaleiroTutor/CavaleiroTutorial1", gp.tileSize, gp.tileSize);
    }

    public void setDialogue(){
        dialogues[0][0] = "Ah, o novo aventureiro! Ainda bem que o/ndestino o trouxe até aqui. *Pressione ESPAÇO/npara continuar conversando.";
        dialogues[0][1] = "Antes de empunhar sua lâmina contra/nas forças do mal, deve aprender o básico.";
        dialogues[0][2] = "Como você é um mago pode soltar magias/npressione Q para testar!";
        dialogues[0][3] = "No seu inventário você pode verificar/nseus poderes e seus itens! *Pressione/nI para ver seu inventário.";
        dialogues[0][4] = "Para ir para os outros mapa apenas/nvá para os portais, há um ao outro lado da/nilha!";
        dialogues[0][5] = "Agora foco meu querido, sua irmãzinha está/nprecisando de você!";
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
        super.startDialogue(this, dialogueSet);
        dialogueSet++;
    }

}
