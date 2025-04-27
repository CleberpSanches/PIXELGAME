package Objects;

import javax.imageio.ImageIO;

public class Obj_hd extends SuperObject{
    public Obj_hd()
    {
        name = "hd";
        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/hd.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
