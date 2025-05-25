package main;

import entity.Entity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class UI {


    GamePanel gp;
    Font arial_40, arial_80B;
    Graphics2D g2;
    Font dotGothic16;
    public String message = "";
    public boolean messageOn = false;
    public String currentDialogue;
    public boolean gameFinished = false;
    boolean pauseJustOpened = true;


    int slotCol = 0;
    int slotRow = 0;
    public Entity npc;
    int charIndex = 0;
    String combinedText = "";
    int counter =  0;
    public int targetMap, targetTileX, targetTileY;
    public boolean teleportRequested = false;


    int subState = 0;

    public int commandNum = 0;

    public UI(GamePanel gp){
        this.gp = gp;

        try{
            InputStream is = getClass().getResourceAsStream("/font/DotGothic16-Regular.ttf");
            dotGothic16 = Font.createFont(Font.TRUETYPE_FONT, is);
        }catch (FontFormatException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void showMessage(String text){
        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2){
        this.g2 = g2;

        g2.setFont(dotGothic16);
        g2.setColor(Color.WHITE);

        //TITLE STATE
        if(gp.gameState == gp.titleState){
            drawTitleScreen();
        }

        //PLAY STATE
        if(gp.gameState == gp.playState){
            drawPlayScreen();
        }

        //PAUSE STATE
        if(gp.gameState == gp.pauseState){
            drawPauseScreen();
        }
        //PAUSE STATE
        if(gp.gameState == gp.dialogueState){
            drawDialogueScreen();
        }

        //CHARACTER STATE
        if(gp.gameState == gp.characterState){
            drawCharacterScreen();
            drawInventory();
        }

        //TRANSITION STATE
        if(gp.gameState == gp.transitionState){
            drawTransition();
        }

        //TRADE STATE
        if(gp.gameState == gp.tradeState){
            drawTradeScreen();
        }
    }




    private void drawDialogueScreen() {
        //SUBWINDOW POSITION
        int x = gp.tileSize*2;
        int y = gp.tileSize*8;
        int width = gp.screenWidth - (gp.tileSize*4);
        int height = (gp.tileSize*3);
        drawSubWindow(x,y,width,height);

        //TEXT POSITION
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 32));
        x += gp.tileSize;
        y += gp.tileSize;

        if(npc.dialogues[npc.dialogueSet][npc.dialogueIndex] != null){

           // currentDialogue = npc.dialogues[npc.dialogueSet][npc.dialogueIndex];

            char character[] = npc.dialogues[npc.dialogueSet][npc.dialogueIndex].toCharArray();

            if (charIndex < character.length){
                String s = String.valueOf(character[charIndex]);
                combinedText = combinedText + s;
                currentDialogue = combinedText;
                charIndex++;
            }

            if (gp.keyH.enterPressed == true){
                charIndex = 0;
                combinedText = "";
                if (gp.gameState == gp.dialogueState){
                    npc.dialogueIndex++;
                    gp.keyH.enterPressed = false;
                }
            }
        }
        else {
            npc.dialogueIndex = 0;

            if(gp.gameState == gp.dialogueState)
            {
                gp.gameState = gp.playState;
            }
        }

        if(currentDialogue != null) {
            for(String line : currentDialogue.split("/n")) {
                g2.drawString(line, x, y);
                y += 40;
            }
        }

    }

    //TITLE SCREEN
    public void drawTitleScreen() {
        // LOAD IMAGES
        BufferedImage menuarrow = null;
        BufferedImage bg = null;

        try {
            menuarrow = ImageIO.read(getClass().getResourceAsStream("/buttons/menuarrow.png"));
            bg = ImageIO.read(getClass().getResourceAsStream("/buttons/bg1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // DESENHAR BACKGROUND PRIMEIRO
        if (bg != null) {
            g2.drawImage(bg, 0, 0, gp.screenWidth, gp.screenHeight, null);
        }

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 24F));

        String[] menuOptions = {"NOVO JOGO", "OPÇÕES", "SAIR"};

        int menuY = (int) (gp.screenHeight / 1.5);

        for (int i = 0; i < menuOptions.length; i++) {
            String option = menuOptions[i];
            int optionX = getXforCenterText(option);

            g2.drawString(option, optionX, menuY);

            if (commandNum == i && menuarrow != null) {
                g2.drawImage(menuarrow, optionX - gp.tileSize, menuY - 24, null);
            }

            menuY += gp.tileSize;
        }
    }



    //PAUSE SCREEM
    public void drawSubWindow(int x, int y, int width, int height){
        Color c = new Color(0, 0, 0, 175);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35);

        c = new Color(255,255,255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+5, y+5 , width-10, height-10, 25, 25);
    }

    public void drawPauseScreen(){
        if (pauseJustOpened) {
            gp.keyH.enterPressed = false;
            pauseJustOpened = false;
        }

        g2.setColor(new Color(0, 0, 0, 150));
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

        g2.setFont(dotGothic16.deriveFont(64f));
        g2.setColor(Color.WHITE);

        //SUBWINDOW
        int frameX = gp.tileSize*4;
        int frameY = gp.tileSize*2;
        int frameWidth = gp.tileSize*8;
        int frameHeight = gp.tileSize*8;

        drawSubWindow(frameX, frameY, frameWidth, frameHeight);
        switch (subState){
            case 0: options_top(frameX, frameY);
            break;
            case 1:
            break;
            case 2: options_control(frameX, frameY);
            break;
        }
    }

    public void options_top(int frameX, int frameY) {
        int textX;
        int textY;

        BufferedImage menuarrow = null;

        try {
            menuarrow = ImageIO.read(getClass().getResourceAsStream("/buttons/menuarrow.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //MENUPAUSE TITLE
        String text = "MENU";
        textX = getXforCenterText(text);
        textY = frameY+96;
        g2.drawString(text, textX, textY);


        //CONTROL
        g2.setFont(dotGothic16.deriveFont(48f));
        textY += gp.tileSize+64;
        textX = getXforCenterText(text)-96;
        g2.drawString("CONTROLES", textX, textY);
        if(gp.ui.commandNum == 0){
            g2.drawImage(menuarrow, textX-48, textY-24, null);
            if (gp.keyH.enterPressed == true){
                subState = 2;
                gp.ui.commandNum = 0;
                gp.keyH.enterPressed = false;
            }
        }


        //EXIT
        textY += gp.tileSize+32;
        textX = getXforCenterText(text)-96;
        g2.drawString("SAIR", textX, textY);
        if(gp.ui.commandNum == 1){
            g2.drawImage(menuarrow, textX-48, textY-24 , null);
        }

        //GET BACK TO THE GAME
        g2.setFont(dotGothic16.deriveFont(56f));
        String text1 = "VOLTAR";
        textX = getXforCenterText(text1);
        textY = gp.tileSize*9;
        g2.drawString(text1, textX, textY);
        if(gp.ui.commandNum == 2){
            g2.drawImage(menuarrow, textX-48, textY-24 , null);
            if(gp.keyH.enterPressed == true){
                subState = 0;
                gp.ui.commandNum = 0;
                gp.keyH.enterPressed = false;
            }
        }

    }

    public void options_control(int frameX, int frameY){

        int textX;
        int textY;

        BufferedImage menuarrow = null;

        try {
            menuarrow = ImageIO.read(getClass().getResourceAsStream("/buttons/menuarrow.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //TITTLE CONTROL SCREEN
        g2.setFont(dotGothic16.deriveFont(32f));
        String text = "CONTROLES";
        textX = getXforCenterText(text);
        textY = frameY + gp.tileSize;
        g2.drawString(text, textX, textY);

        //CONTROLS
        g2.setFont(dotGothic16.deriveFont(18f));
        textX = frameX + gp.tileSize;
        textY += frameY-128;
        g2.drawString("Mover", textX, textY+=gp.tileSize);
        g2.drawString("Poder", textX, textY+=gp.tileSize);
        g2.drawString("Correr", textX, textY+=gp.tileSize);
        g2.drawString("Inventário", textX, textY+=gp.tileSize);
        g2.drawString("Tela de Personagem", textX, textY+=gp.tileSize);
        g2.drawString("Menu", textX, textY+=gp.tileSize);

        textX = frameX + gp.tileSize*6;
        textY = frameY + gp.tileSize*2;
        g2.drawString("WASD", textX, textY); textY += gp.tileSize;
        g2.drawString("ESPAÇO", textX, textY); textY += gp.tileSize;
        g2.drawString("SHIFT+WASD", textX, textY); textY += gp.tileSize;
        g2.drawString("I", textX, textY); textY += gp.tileSize;
        g2.drawString("C", textX, textY); textY += gp.tileSize;
        g2.drawString("P ou ESC", textX, textY); textY += gp.tileSize;

        //VOLTAR
        g2.setFont(dotGothic16.deriveFont(48f));
        textX = frameX + gp.tileSize*3;
        textY = frameY + gp.tileSize*9;
        g2.drawString("VOLTAR", textX, textY);
        if (commandNum == 0){
            g2.drawImage(menuarrow, textX-48, textY-24 , null);
            if(gp.keyH.enterPressed == true){
                subState = 0;
                gp.ui.commandNum = 0;
                gp.keyH.enterPressed = false;
            }
        }
    }

    //PLAY SCREEN
    public void drawPlayScreen(){

    }

    private void drawCharacterScreen() {
        final int frameX;
        final int frameY;
        final int frameWidth;
        final int frameHeight;
    }

    private void drawInventory() {
        final int frameX= (int) (gp.tileSize *8.5);
        final int frameY= (int) (gp.tileSize *8.5);
        final int frameWidth= (int) (gp.tileSize *7.5);
        final int frameHeight= (int) (gp.tileSize *2.5);
        drawSubWindow(frameX, frameY, frameWidth, frameHeight);

        //SLOTS
        final int slotXstart = frameX +20;
        final int slotYstart = frameY + 20;

        int slotX = slotXstart;
        int slotY = slotYstart;

        for (int i = 0; i < gp.player.Inventory.size(); i++) {

            if(gp.player.Inventory.get(i) == gp.player.currentMagicatk){
                g2.setColor(new Color(178, 159, 255));
                g2.fillRoundRect(slotX, slotY, gp.tileSize, gp.tileSize, 10, 10);
            }

            g2.drawImage(gp.player.Inventory.get(i).down1, slotX, slotY, null);
            slotX +=gp.tileSize;

            if (i == 6) {
                slotX = slotXstart;
                slotY += gp.tileSize;
            }
        }

        //selector
        int cursorX = slotXstart + (gp.tileSize * slotCol);
        int cursorY = slotYstart + (gp.tileSize * slotRow);
        int cursorWidth = gp.tileSize;
        int cursorHeight = gp.tileSize;
        //cursor
        g2.setColor(Color.white);
        g2.setStroke(new BasicStroke(2));
        g2.drawRoundRect(cursorX, cursorY, cursorWidth, cursorHeight, 10 , 10);

        //description screen
        int dframeX = frameX;
        int dframeY = frameY - frameHeight;
        int dframeWidth = frameWidth;
        int dframeHeight = gp.tileSize*2;

        //desc text
        int textX = dframeX + 20;
        int textY = dframeY + gp.tileSize;
        g2.setFont(g2.getFont().deriveFont(28F ));

        int itemIndex = getItemIndexOnSlot();

        if (itemIndex < gp.player.Inventory.size())
        {
            drawSubWindow(dframeX, dframeY, dframeWidth, dframeHeight);

            for (String line: gp.player.Inventory.get(itemIndex).description.split("\n")) {
                g2.drawString(line, textX, textY);
                textY+=32;
            }
        }

    }

    public void drawTransition() {
        if (counter <= 50) {
            counter++;
            g2.setColor(new Color(0, 0, 0, counter * 5));
            g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
        }

        if (counter == 50) {
            counter = 0;

            // Transição completa: troca o mapa e volta pro jogo
            gp.gameState = gp.playState;
            gp.currentMap = gp.ui.targetMap;
            gp.player.worldX = gp.ui.targetTileX * gp.tileSize;
            gp.player.worldY = gp.ui.targetTileY * gp.tileSize;
            gp.ui.teleportRequested = false;
        }
    }

    private void drawTradeScreen() {

        switch(subState){
            case 0: trade_select(); break;
            case 1: trade_buy(); break;
            case 2: trade_sell(); break;
        }
        gp.keyH.enterPressed = false;
    }

    public void trade_select(){
        drawDialogueScreen();

        int x = gp.tileSize * 15;
        int y =  gp.tileSize * 4;
        int width = gp.tileSize * 3;
        int height = (int)(gp.tileSize * 3.5);
        drawSubWindow(x,y,width,height);
    }

    public void trade_buy(){

    }
    public void trade_sell(){

    }
    public  int getItemIndexOnSlot(){
        int itemIndex = slotCol + (slotRow * 7);
        return itemIndex;
    }

    public int getXforCenterText(String text){
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth/2 - length/2;
        return x;
    }


}
