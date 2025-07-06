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


    public int playerSlotCol = 0;
    public int playerSlotRow = 0;
    public int npcSlotRow = 0;
    public int npcSlotCol = 0;
    int playerInventoryIndex = 0;
    int npcInventoryIndex = 0;
    public Entity npc;
    public int charIndex = 0;
    public String combinedText = "";
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
            drawInventory(gp.player, true);
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


    //DIALOGUE SCREEN
    private void drawDialogueScreen() {
        BufferedImage dialogueWindowImg = null;

        try {
            dialogueWindowImg = ImageIO.read(getClass().getResourceAsStream("/tile_items/falaimg.png")); // ajuste o caminho
        } catch (IOException e) {
            e.printStackTrace();
        }

        //SUBWINDOW POSITION
        int x = gp.tileSize*2;
        int y = gp.tileSize*8;
        int width = gp.screenWidth - (gp.tileSize*4);
        int height = (gp.tileSize*3);
        if (dialogueWindowImg != null) {
            g2.drawImage(dialogueWindowImg, x, y, width, height, null);
        } else {
            drawSubWindow(x, y, width, height); // fallback se imagem não carregar
        }

        //TEXT POSITION
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 32));
        g2.setColor(Color.black);
        x += gp.tileSize;
        y += gp.tileSize;

        if (npc != null && npc.dialogues[npc.dialogueSet][npc.dialogueIndex] != null) {

            char character[] = npc.dialogues[npc.dialogueSet][npc.dialogueIndex].toCharArray();

            if (charIndex < character.length) {
                String s = String.valueOf(character[charIndex]);
                combinedText = combinedText + s;
                currentDialogue = combinedText;
                charIndex++;
            }

            if (gp.keyH.spacePressed) {
                charIndex = 0;
                combinedText = "";

                if (npc.name != null && npc.name.equals("anao") && npc.dialogueIndex == 0 && npc.dialogueSet == 0) {
                    npc.dialogues[0][0] = "Se um número é divisível por 6, ele também/né divisível por 3(S/N)";
                    npc.dialogueIndex = 0;
                }

                npc.dialogueIndex++;
                gp.keyH.spacePressed = false;
            }

        } else if (npc == null && currentDialogue != null) {
            char character[] = currentDialogue.toCharArray();

            if (charIndex < character.length) {
                String s = String.valueOf(character[charIndex]);
                combinedText += s;
                charIndex++;
            }

            if (gp.keyH.spacePressed) {
                charIndex = 0;
                combinedText = "";
                currentDialogue = null;
                gp.keyH.spacePressed = false;
                gp.gameState = gp.playState;
            }

        } else {
            if (npc != null) {
                npc.dialogueIndex = 0;
            }

            if (gp.gameState == gp.dialogueState) {
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

        String[] menuOptions = {"NOVO JOGO", "CONTINUAR JOGO", "SAIR"};

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
    public void drawPauseScreen(){
        if (pauseJustOpened) {
            gp.keyH.enterPressed = false;
            pauseJustOpened = false;
        }

        BufferedImage pauseWindowimg = null;

        try {
            pauseWindowimg = ImageIO.read(getClass().getResourceAsStream("/tile_items/menuimg.png")); // ajuste o caminho
        } catch (IOException e) {
            e.printStackTrace();
        }

        g2.setColor(new Color(0, 0, 0, 150));
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

        g2.setFont(dotGothic16.deriveFont(64f));
        g2.setColor(Color.black);

        //SUBWINDOW
        int frameX = gp.tileSize*4;
        int frameY = gp.tileSize*2;
        int frameWidth = gp.tileSize*8;
        int frameHeight = gp.tileSize*8;
        if (pauseWindowimg != null) {
            g2.drawImage(pauseWindowimg, frameX, frameY, frameWidth, frameHeight, null);
        } else {
            drawSubWindow(frameX, frameY, frameWidth, frameHeight);
        }

        switch (subState){
            case 0: options_top(frameX, frameY);
            break;
            case 1:
            break;
            case 2: options_control(frameX, frameY);
            break;
        }
    }

    //PLAY SCREEN
    public void drawPlayScreen(){

    }

    //CHARACTER SCREEN
    private void drawCharacterScreen() {
        final int frameX;
        final int frameY;
        final int frameWidth;
        final int frameHeight;
    }

    //TRADE SCREEN
    private void drawTradeScreen() {
        switch (subState){
            case 0 : tradeSelect(); break;
            case 1 : tradeTake(); break;
            case 2 : tradeGive(); break;
        }
        gp.keyH.enterPressed = false;
    }

    public void tradeSelect(){
        BufferedImage menuarrow = null;

        try {
            menuarrow = ImageIO.read(getClass().getResourceAsStream("/buttons/menuarrow.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        drawDialogueScreen();

        //WINDOW
        int x = gp.tileSize * 11;
        int y = gp.tileSize * 4;
        int width = gp.tileSize * 3;
        int height = (int) (gp.tileSize * 3.5);
        drawSubWindow(x,y,width, height);

        //TEXT
        x += gp.tileSize;
        y += gp.tileSize;
        g2.drawString("Pegar", x, y);
        if(gp.ui.commandNum == 0){
            g2.drawImage(menuarrow, x-42, y-24, null);
            if(gp.keyH.enterPressed == true){
                subState = 1;
            }
        }
        y += gp.tileSize;

        g2.drawString("Entregar", x, y);
        if(gp.ui.commandNum == 1){
            g2.drawImage(menuarrow, x-42, y-24, null);
            if(gp.keyH.enterPressed == true){
                subState = 2;
            }
        }
        y += gp.tileSize;

        g2.drawString("Sair", x, y);
        if(gp.ui.commandNum == 2){
            g2.drawImage(menuarrow, x-42, y-24, null);
            if(gp.keyH.enterPressed == true){
                commandNum = 0;
                gp.gameState = gp.playState;
            }
        }
    }

    public void tradeTake(){
        //DRAW PLAYER INVENTORY
        drawInventory(npc, true);

        drawInventory(gp.player, false);

        // TAKE ITEM
        int selectedItemIndex = getItemIndexOnSlot(npcSlotCol, npcSlotRow);
        if (gp.keyH.enterPressed) {
            if (!npc.Inventory.isEmpty() && selectedItemIndex >= 0 && selectedItemIndex < npc.Inventory.size()) {
                if (gp.player.Inventory.size() < gp.player.maxInventorySize) {
                    Entity selectedItem = npc.Inventory.get(selectedItemIndex);

                    npc.Inventory.remove(selectedItemIndex);
                    gp.player.Inventory.add(selectedItem);
                    gp.gameState = gp.playState;
                    gp.keyH.enterPressed = false;

                    subState = 0;
                    gp.gameState = gp.dialogueState;
                    gp.keyH.enterPressed = false;
                }
            }
        }

    }

    public void tradeGive(){
        //DRAW PLAYER INVENTORY
        drawInventory(gp.player, true);

        //DRAW NPC INVENTORY
        drawInventory(npc, false);

        // GIVE ITEM (do Player para o NPC)
        int selectedItemIndex = getItemIndexOnSlot(playerSlotCol, playerSlotRow);

        if (gp.keyH.enterPressed) {
            if (!gp.player.Inventory.isEmpty() &&
                    selectedItemIndex >= 0 &&
                    selectedItemIndex < gp.player.Inventory.size()) {

                if (npc.Inventory.size() < npc.maxInventorySize) {
                    Entity itemToGive = gp.player.Inventory.get(selectedItemIndex);

                    gp.player.Inventory.remove(selectedItemIndex);
                    npc.Inventory.add(itemToGive);

                    subState = 0;
                    gp.gameState = gp.playState;
                    gp.keyH.enterPressed = false;
                }
            }
        }

    }

    //CHARACTER & INVENTORY STATE
    private void drawInventory(Entity entity, boolean cursor) {

         int frameX = 0;
         int frameY = 0;
         int frameWidth = 0;
         int frameHeight = 0;
         int slotCol = 0;
         int slotRow = 0;

         //FRAME SE FOR PLAYER
         if (entity == gp.player){
             frameX = (int) (gp.tileSize*0.5);
             frameY = (int) (gp.tileSize*8.5);
             frameWidth = gp.tileSize*8;
             frameHeight = gp.tileSize*3;
             slotCol  = playerSlotCol;
             slotRow = playerSlotRow;
         }
         //FRAME SE FOR ENTIDADE DE TROCA
         else{
             frameX = (int) (gp.tileSize*8);
             frameY = (int) (gp.tileSize*2);
             frameWidth = gp.tileSize*8;
             frameHeight = gp.tileSize*3;
             slotCol  = npcSlotCol;
             slotRow = npcSlotRow;
         }


        drawSubWindow(frameX, frameY, frameWidth, frameHeight);

        //SLOTS
        final int slotXstart = frameX + 24;
        final int slotYstart = frameY + 24;

        int slotX = slotXstart;
        int slotY = slotYstart;

        for (int i = 0; i < entity.Inventory.size(); i++) {
            //BACKGROUND DO ITEM SELECIONADO
            if(entity.Inventory.get(i) == entity.currentMagicatk){
                g2.setColor(new Color(178, 159, 255));
                g2.fillRoundRect(slotX, slotY, gp.tileSize, gp.tileSize, 6, 6);
            }

            //DESENHAR ITEMS
            g2.drawImage(entity.Inventory.get(i).down1, slotX, slotY, null);
            slotX +=gp.tileSize;

            if (i == 6) {
                slotX = slotXstart;
                slotY += gp.tileSize;
            }
        }

        if (cursor == true){
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
            int dframeY = frameY-128;
            int dframeWidth = frameWidth;
            int dframeHeight = gp.tileSize*2;

            //desc text
            int textX = dframeX + 24;
            int textY = dframeY + 56;
            g2.setFont(g2.getFont().deriveFont(28F ));

            int itemIndex = getItemIndexOnSlot(slotCol, slotRow);

            if (itemIndex < entity.Inventory.size())
            {
                drawSubWindow(dframeX, dframeY, dframeWidth, dframeHeight);
                for (String line: entity.Inventory.get(itemIndex).description.split("\n")) {
                    g2.drawString(line, textX, textY);
                    textY+=32;
                }
            }
        }

    }

    //TRANSITION STATE
    public void drawTransition() {
        if (counter <= 50) {
            counter++;
            g2.setColor(new Color(0, 0, 0, counter * 5));
            g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
        }

        if (counter == 50) {
            counter = 0;

            gp.gameState = gp.playState;
            gp.currentMap = gp.ui.targetMap;
            gp.player.worldX = gp.ui.targetTileX * gp.tileSize;
            gp.player.worldY = gp.ui.targetTileY * gp.tileSize;
            gp.ui.teleportRequested = false;
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

        // SAVE (nova opção)
        textY += gp.tileSize + 32;
        g2.drawString("SALVAR", textX, textY);
        if (gp.ui.commandNum == 1) {
            g2.drawImage(menuarrow, textX - 48, textY - 24, null);
            if (gp.keyH.enterPressed == true) {
                // Aqui você coloca a ação de salvar

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

    public void drawSubWindow(int x, int y, int width, int height){
        Color c = new Color(0, 0, 0, 175);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35);

        c = new Color(255,255,255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+5, y+5 , width-10, height-10, 25, 25);
    }

    public  int getItemIndexOnSlot(int SlotCol, int SlotRow){
        int itemIndex = SlotCol + (SlotRow * 7);
        return itemIndex;
    }

    public int getXforCenterText(String text){
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth/2 - length/2;
        return x;
    }
}
