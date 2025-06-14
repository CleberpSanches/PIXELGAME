 package main;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Main {
    public Main() {

    }

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(3);
        window.setResizable(false);
        window.setTitle("Aniventures");
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.pack();
        window.setLocationRelativeTo((Component)null);
        window.setVisible(true);
        gamePanel.setupGame();
        gamePanel.startGameThread();
        try {
            InputStream iconStream = Main.class.getResourceAsStream("/icon/bg.png");
            if (iconStream != null) {
                Image icon = ImageIO.read(iconStream);
                window.setIconImage(icon);
            } else {
                System.err.println("Ícone não encontrado.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}