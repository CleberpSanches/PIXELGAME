package Objects;

import javax.imageio.ImageIO;

public class Obj_placamae extends SuperObject{
    public Obj_placamae()
    {
        name = "placamae";
        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/placamae.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
