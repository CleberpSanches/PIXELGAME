package main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

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

    public void drawTitleScreen(){
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 96F));
        String text = "Jogo";
        int x = getXforCenterText(text);
        int y = gp.tileSize * 3;

        g2.setColor(Color.WHITE);
        g2.drawString(text, x, y);

        //LOAD IMAGES
        BufferedImage menuarrow = null;

        try {
            menuarrow = ImageIO.read(getClass().getResourceAsStream("/buttons/menuarrow.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // MENU
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 24F));

        text = "Novo Jogo";
        x = getXforCenterText(text);
        y += gp.tileSize;
        g2.drawString(text, x, y);
//      //
        if (commandNum == 0) {
            g2.drawImage(menuarrow, x-gp.tileSize, y, null);
        }

        text = "Opções";
        x = getXforCenterText(text);
        y += gp.tileSize;
        g2.drawString(text, x, y);
        if (commandNum == 1) {
            g2.drawImage(menuarrow, x-gp.tileSize, y, null);
        }

        text = "Sair";
        x = getXforCenterText(text);
        y += gp.tileSize;
        g2.drawString(text, x, y);
        if (commandNum == 2) {
            g2.drawImage(menuarrow, x-gp.tileSize, y, null);
        }
    }

    public void drawPauseScreen(){
        g2.setColor(new Color(0, 0, 0, 150));
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

        String text = "PAUSADO";
        int x = getXforCenterText(text);
        int y = gp.screenHeight/2;

        g2.setFont(arial_40);         // fonte grande e visível
        g2.setColor(Color.WHITE);
        g2.drawString(text, x, y);
    }

    public int getXforCenterText(String text){
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth/2 - length/2;
        return x;
    }
}
