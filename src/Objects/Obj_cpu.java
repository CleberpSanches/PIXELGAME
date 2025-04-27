package Objects;

import javax.imageio.ImageIO;

public class Obj_cpu extends SuperObject{
    public Obj_cpu()
    {
        name = "cpu";
        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/cpu.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}