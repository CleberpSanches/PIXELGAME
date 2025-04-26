package Objects;

import javax.imageio.ImageIO;

public class Obj_monitor extends SuperObject{
    public Obj_monitor()
    {
        name = "monitor";
        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/monitor.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
