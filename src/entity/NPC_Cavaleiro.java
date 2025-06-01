package entity;

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
        dialogues[0][0] = "Ah, um novo aventureiro!/nVejo que o destino o trouxe até aqui.";
        dialogues[0][1] = "Antes de empunhar sua lâmina contra/nas forças do mal, deve aprender o básico.";
        dialogues[0][2] = "Use as teclas W, A, S e D para mover-se/npelo mundo — um passo de cada vez,/njovem herói.";

        dialogues[1][0] = "Deseja atacar? Então pressione a tecla Q,/nhá alguns slimes pelo mapa, teste neles/ne volte!";
        dialogues[1][1] = "No seu inventário você pode verificar/nseu poder e seus itens, mas como você é pobre/nnão deve ter muito!";

        dialogues[2][0] = "Para ir para os outros mapa apenas/nvá para os portais como o que você chegou!";
        dialogues[2][1] = "Agora foco meu querido, sua aventura te espera!";
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

        if(dialogues[dialogueSet][0] == null){
            dialogueSet = 0;
        }

        gp.gameState = gp.tradeState;
        gp.ui.npc = this;
    }

}
