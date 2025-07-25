package Command1;

import Interface1.Command;
import entity1.Player;

public class DownFastCommand implements Command {
    private boolean run;

    public DownFastCommand(boolean run){
        this.run = run;
    }

    @Override
    public void execute(Player player) {
        int speed;
        player.direction = "down";
        if (run == true)
        {
            speed = player.speed*2;
        }
        else
        {
            speed = player.speed;
        }
        player.worldY += speed;
    }
}
