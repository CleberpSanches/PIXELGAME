package Command;

import Interface.Command;
import entity.Player;

public class RightFastCommand implements Command {
    private boolean run;

    public RightFastCommand(boolean run){
        this.run = run;
    }

    @Override
    public void execute(Player player) {
        int speed;
        player.direction = "right";
        if (run == true)
        {
            speed = player.speed*2;
        }
        else
        {
            speed = player.speed;
        }
        player.worldX += speed;
    }
}
