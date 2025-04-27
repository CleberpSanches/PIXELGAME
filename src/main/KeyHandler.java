package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public boolean upPressed;
    public boolean downPressed;
    public boolean leftPressed;
    public boolean rightPressed;
    public boolean shiftPressed;
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
                    //permanência de dados
                }
                if (gp.ui.commandNum == 2){
                    System.exit(0);
                }
            }
        }



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

        if (code == KeyEvent.VK_P) {
            if(gp.gameState == gp.playState){
                gp.gameState = gp.pauseState;
            } else if (gp.gameState == gp.pauseState) {
                gp.gameState = gp.playState;
            }
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
    }
}
