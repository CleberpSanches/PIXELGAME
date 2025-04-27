package Objects;

import main.GamePanel;

import javax.imageio.ImageIO;

public class Obj_Placa extends SuperObject{
    GamePanel gp;
    public Obj_Placa(GamePanel gp)
    {
        this.gp = gp;
        name = "placa";
        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/placa.png"));
            tBox.scaleImage(image, this.gp.tileSize, this.gp.tileSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
