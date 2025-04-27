package Objects;

import javax.imageio.ImageIO;

public class Obj_ram extends SuperObject{
    public Obj_ram()
    {
        name = "ram";
        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/ram.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}