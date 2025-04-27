package main;

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
    public boolean gameFinished = false;
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

        }

        //PAUSE STATE
        if(gp.gameState == gp.pauseState){
            drawPauseScreen();
        }
    }

    public void drawTitleScreen() {
        // LOAD IMAGES
        BufferedImage menuarrow = null;
        BufferedImage bg = null;

        try {
            menuarrow = ImageIO.read(getClass().getResourceAsStream("/buttons/menuarrow.png"));
            bg = ImageIO.read(getClass().getResourceAsStream("/buttons/bg.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // DESENHAR BACKGROUND PRIMEIRO
        if (bg != null) {
            g2.drawImage(bg, 0, 0, gp.screenWidth, gp.screenHeight, null);
        }

        String text = "";
        int x = getXforCenterText(text);
        int y = gp.tileSize * 3;

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 96F));

        g2.setColor(Color.WHITE);
        g2.drawString(text, x, y);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 24F));

        // Itens do menu
        String[] menuOptions = {"NOVO JOGO", "OPÇÕES", "SAIR"};

        // Posição inicial do menu
        int menuX;
        int menuY = gp.screenHeight / 2; // meio da tela + descido um pouco

        for (int i = 0; i < menuOptions.length; i++) {
            String text1 = menuOptions[i];
            menuX = getXforCenterText(text1);

            g2.drawString(text1, menuX, menuY);

            // SE o commandNum for igual ao índice atual, desenha a seta
            if (commandNum == i) {
                g2.drawImage(menuarrow, menuX - gp.tileSize, menuY - 24, null);
            }

            // Avança para o próximo item
            menuY += gp.tileSize + 10; // espaço entre opções
        }

    }


    public void drawPauseScreen(){
        g2.setColor(new Color(0, 0, 0, 150));
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

        String text = "PAUSE";
        int x = getXforCenterText(text);
        int y = gp.screenHeight/2;

        g2.setFont(dotGothic16);
        g2.setColor(Color.WHITE);
        g2.drawString(text, x, y);
    }

    public int getXforCenterText(String text){
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth/2 - length/2;
        return x;
    }
}
