package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public boolean upPressed;
    public boolean downPressed;
    public boolean leftPressed;
    public boolean rightPressed;
    public boolean shiftPressed;
    public boolean enterPressed;
    public boolean spacePressed;
    public boolean qPressed;
    public boolean nPressed;
    public boolean sPressed;
    boolean checkDrawTime;
    GamePanel gp;


    public KeyHandler(GamePanel gp){
        this.gp = gp;
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        //TITLE STATE
        if(gp.gameState == gp.titleState){
            tittleState(code);
        }

        //PLAY STATE
        if(gp.gameState == gp.playState){
            playState(code);
        }

        //PAUSE STATE
        else if (gp.gameState == gp.pauseState)
        {
            pauseState(code);
        }

        //DIALOGUE STATE
        else if (gp.gameState == gp.dialogueState)
        {
            dialogueState(code);
        }

        //CHARACTER STATE
        else if (gp.gameState == gp.characterState)
        {
            characterState(code);
        }
        //MAP STATE
        else if (gp.gameState == gp.mapState)
        {
            mapState(code);
        }
        //TRADE STATE
        else if (gp.gameState == gp.tradeState)
        {
            tradeState(code);
        }

    }

    //TITLE CONTROLS
    public void tittleState(int code){

        if (code == KeyEvent.VK_W) {
            gp.ui.commandNum--;
            if (gp.ui.commandNum < 0){
                gp.ui.commandNum = 2;
            }
        }

        if (code == KeyEvent.VK_S) {
            gp.ui.commandNum++;
            if (gp.ui.commandNum > 2){
                gp.ui.commandNum = 0;
            }
        }

        if (code == KeyEvent.VK_ENTER){
            if(gp.ui.commandNum == 0){
                gp.gameState = gp.playState;
            }
            if (gp.ui.commandNum == 1){
                gp.saveload.load();
                gp.gameState = gp.playState;
            }
            if (gp.ui.commandNum == 2){
                System.exit(0);
            }
        }

    }

    //GAME STATE CONTROLS
    public void playState(int code){

        //PLAY STATE
        if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
            this.upPressed = true;
        }

        if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
            this.downPressed = true;
        }

        if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
            this.leftPressed = true;
        }

        if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
            this.rightPressed = true;
        }

        if (code == KeyEvent.VK_SHIFT) {
            this.shiftPressed = true;
        }

        if (code == KeyEvent.VK_Q) {
            this.qPressed = true;
        }

        if (code == KeyEvent.VK_C) {
            gp.gameState = gp.characterState;
        }

        if (code == KeyEvent.VK_P) {
            gp.gameState = gp.pauseState;
        }

        if (code == KeyEvent.VK_ENTER) {
            enterPressed = true;
        }

        if (code == KeyEvent.VK_T) {
            if(checkDrawTime == false){
                checkDrawTime = true;
            }
            else if(checkDrawTime == true)
            {
                checkDrawTime = false;
            }
        }

        if (code == KeyEvent.VK_M) {
            gp.gameState = gp.mapState;
        }
        if (code == KeyEvent.VK_X) {
            if (gp.map.miniMapOn == false){
                gp.map.miniMapOn =true;
            }
            else {
                gp.map.miniMapOn =false;
            }
        }

    }

    //PAUSE CONTROLS
    public void pauseState(int code){
        if ((code == KeyEvent.VK_P) || (code == KeyEvent.VK_ESCAPE)) {
            gp.gameState = gp.playState;
        }

        int maxCommandNum = 0;
        switch (gp.ui.subState){
            case 0: maxCommandNum = 3;
        }

        if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
            gp.ui.commandNum--;
            if (gp.ui.commandNum < 0) {
                gp.ui.commandNum = maxCommandNum;
            }
        }

        if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
            gp.ui.commandNum++;
            if (gp.ui.commandNum > maxCommandNum){
                gp.ui.commandNum = 0;
            }
        }

        if (code == KeyEvent.VK_ENTER){
            gp.keyH.enterPressed = true;

            //SALVAR E VOLTAR O JOGO
            if (gp.ui.commandNum == 1){
                gp.saveload.save();
                gp.gameState = gp.titleState;
            }

            //SAIR
            if(gp.ui.commandNum == 2){
                System.exit(0);
            }

            //VOLTAR AO JOGO
            if(gp.ui.commandNum == 3){
                gp.gameState = gp.playState;
            }


        }
    }

    //DIALOGUE CONTROLS
    public void dialogueState(int code){
        if (code == KeyEvent.VK_SPACE)
        {
            spacePressed = true;
        }
        if (code == KeyEvent.VK_N)
        {
            nPressed = true;
        }
        if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN)
        {
            sPressed = true;
        }
    }

    //CHARACTER CONTROLS
    public void characterState(int code){
        if (code == KeyEvent.VK_C)
        {
            gp.gameState = gp.playState;
        }

        if (code == KeyEvent.VK_ENTER)
        {
            gp.player.selectItem();
        }

        playerInventory(code);
    }

    //PLAYER INVENTORY CONTROLS
    public void playerInventory(int code){
        if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP)
        {
            if(gp.ui.playerSlotRow != 0){
                gp.ui.playerSlotRow--;
            }

        }
        if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT)
        {
            if(gp.ui.playerSlotCol != 0){
                gp.ui.playerSlotCol --;
            }

        }
        if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN)
        {
            if(gp.ui.playerSlotRow != 1){
                gp.ui.playerSlotRow++;
            }

        }
        if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT)
        {
            if(gp.ui.playerSlotCol != 6){
                gp.ui.playerSlotCol ++;
            }

        }
    }

    //NPC INVENTORY CONTROLS
    public void npcInventory(int code){
        if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP)
        {
            if(gp.ui.npcSlotRow != 0){
                gp.ui.npcSlotRow--;
            }

        }
        if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT)
        {
            if(gp.ui.npcSlotCol != 0){
                gp.ui.npcSlotCol --;
            }

        }
        if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN)
        {
            if(gp.ui.npcSlotRow != 1){
                gp.ui.npcSlotRow++;
            }

        }
        if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT)
        {
            if(gp.ui.npcSlotCol != 6){
                gp.ui.npcSlotCol ++;
            }

        }
    }

    //TRADE CONTROLS
    private void tradeState(int code) {
        if(code == KeyEvent.VK_ENTER){
            enterPressed = true;
        }

        if (gp.ui.subState == 0){
            if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP){
                gp.ui.commandNum--;
                if (gp.ui.commandNum < 0){
                    gp.ui.commandNum = 2;
                }
            }

            if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN){
                gp.ui.commandNum++;
                if (gp.ui.commandNum > 2){
                    gp.ui.commandNum = 0;
                }
            }
        }

        if (gp.ui.subState == 1){
            npcInventory(code);
            if (code == KeyEvent.VK_ESCAPE){
                gp.ui.subState = 0;
            }
        }

        if (gp.ui.subState == 2){
            playerInventory(code);
            if (code == KeyEvent.VK_ESCAPE){
                gp.ui.subState = 0;
            }
        }
    }

    //MAP CONTROLS
    private void mapState(int code) {
        if (code == KeyEvent.VK_M ) {
            gp.gameState = gp.playState;
        }
    }


    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
            this.upPressed = false;
        }

        if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
            this.downPressed = false;
        }

        if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
            this.leftPressed = false;
        }

        if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
            this.rightPressed = false;
        }

        if (code == KeyEvent.VK_SHIFT) {
            this.shiftPressed = false;
        }
        if (code == KeyEvent.VK_Q) {
            this.qPressed = false;
        }


    }
}
