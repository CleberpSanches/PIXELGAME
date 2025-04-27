package Objects;

import javax.imageio.ImageIO;

public class Obj_cooler extends SuperObject{
    public Obj_cooler()
    {
        name = "cooler";
        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/cooler.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
