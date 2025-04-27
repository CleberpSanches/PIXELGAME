package Objects;

import javax.imageio.ImageIO;

public class Obj_pvideo extends SuperObject{
    public Obj_pvideo()
    {
        name = "pvideo";
        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/pvideo.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
