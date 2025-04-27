package Objects;

import javax.imageio.ImageIO;

public class Obj_mouse extends SuperObject{
    public Obj_mouse()
    {
        name = "mouse";
        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/mouse.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
