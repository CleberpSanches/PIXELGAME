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
    public boolean qPressed;
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

    private void tradeState(int code) {
        if(code == KeyEvent.VK_ENTER){
            enterPressed = true;
        }
        if (gp.ui.subState == 0){
            if (code == KeyEvent.VK_W){
                gp.ui.commandNum--;
                if (gp.ui.commandNum < 0){
                    gp.ui.commandNum = 2;
                }
            }

            if (code == KeyEvent.VK_S){
                gp.ui.commandNum++;
                if (gp.ui.commandNum > 2){
                    gp.ui.commandNum = 0;
                }
            }
        }
    }

    private void mapState(int code) {
        if (code == KeyEvent.VK_M) {
            gp.gameState = gp.playState;
        }
    }

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
                gp.playMusic(0);
            }
            if (gp.ui.commandNum == 1){
                //permanência de dados
            }
            if (gp.ui.commandNum == 2){
                System.exit(0);
            }
        }

    }

    public void playState(int code){

        //PLAY STATE
        if (code == KeyEvent.VK_W) {
            this.upPressed = true;
        }

        if (code == KeyEvent.VK_S) {
            this.downPressed = true;
        }

        if (code == KeyEvent.VK_A) {
            this.leftPressed = true;
        }

        if (code == KeyEvent.VK_D) {
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

    public void pauseState(int code){
        if ((code == KeyEvent.VK_P) || (code == KeyEvent.VK_ESCAPE)) {
            gp.gameState = gp.playState;
        }

        int maxCommandNum = 0;
        switch (gp.ui.subState){
            case 0: maxCommandNum = 2;
        }

        if (code == KeyEvent.VK_W) {
            gp.ui.commandNum--;
            if (gp.ui.commandNum < 0) {
                gp.ui.commandNum = maxCommandNum;
            }
        }

        if (code == KeyEvent.VK_S) {
            gp.ui.commandNum++;
            if (gp.ui.commandNum > maxCommandNum){
                gp.ui.commandNum = 0;
            }
        }

        if (code == KeyEvent.VK_ENTER){
            gp.keyH.enterPressed = true;
            if(gp.ui.commandNum == 2){
                gp.gameState = gp.playState;
            }
            if (gp.ui.commandNum == 1){
                System.exit(0);
            }
        }
    }

    public void dialogueState(int code){
        if (code == KeyEvent.VK_ENTER)
        {
            enterPressed = true;
        }
    }

    public void characterState(int code){
        if (code == KeyEvent.VK_C)
        {
            gp.gameState = gp.playState;
        }
        if (code == KeyEvent.VK_W)
        {
            if(gp.ui.slotRow != 0){
                gp.ui.slotRow--;
            }

        }
        if (code == KeyEvent.VK_A)
        {
            if(gp.ui.slotCol != 0){
                gp.ui.slotCol--;
            }

        }
        if (code == KeyEvent.VK_S)
        {
            if(gp.ui.slotRow != 1){
                gp.ui.slotRow++;
            }

        }
        if (code == KeyEvent.VK_D)
        {
            if(gp.ui.slotCol != 6){
                gp.ui.slotCol++;
            }

        }
        if (code == KeyEvent.VK_ENTER)
        {
            gp.player.selectItem();
        }
    }

    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W) {
            this.upPressed = false;
        }

        if (code == KeyEvent.VK_S) {
            this.downPressed = false;
        }

        if (code == KeyEvent.VK_A) {
            this.leftPressed = false;
        }

        if (code == KeyEvent.VK_D) {
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
