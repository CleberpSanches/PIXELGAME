package Command1;

import Interface1.Command;
import entity1.Player;

public class UpFastCommand implements Command {

    private boolean run;

    public UpFastCommand(boolean run){
    this.run = run;
    }


    @Override
    public void execute(Player player) {
        int speed;
        player.direction = "up";
        if (run == true)
        {
            speed = player.speed*2;
        }
        else
        {
            speed = player.speed;
        }
        player.worldY -= speed;
    }
}
