package main1;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ToolBox {
    public BufferedImage scaleImage(BufferedImage original, int width, int height){
        BufferedImage scaledImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = scaledImage.createGraphics();
        g2.drawImage(original, 0, 0, width, height, null);
        g2.dispose();

        return scaledImage;
    }
}
