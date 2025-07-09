package Command1;

import Interface1.Command;
import entity1.Player;

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
