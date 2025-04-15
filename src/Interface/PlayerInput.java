package Interface;

import entity.Player;

import java.util.List;

public interface PlayerInput {
    boolean upButtonPressed();
    boolean downButtonPressed();
    boolean leftButtonPressed();
    boolean rightButtonPressed();
    List<Command> getActiveCommands(Player player);

    List<Command> getCommands(Player player);
}
