package Objects;

import javax.imageio.ImageIO;

public class Obj_Placa extends SuperObject{
    public Obj_Placa()
    {
        name = "placa";
        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/placa.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
