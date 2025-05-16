package Adapter;

import Interface.Command;
import Interface.PlayerInput;
import entity.Player;
import main.KeyHandler;

import java.util.ArrayList;
import java.util.List;
import Command.UpFastCommand;
import Command.DownFastCommand;
import Command.LeftFastCommand;
import Command.RightFastCommand;

public class KeyHandlerAdapter implements PlayerInput {

    private KeyHandler keyHandler;

    public KeyHandlerAdapter(KeyHandler keyHandler) {
        this.keyHandler = keyHandler;
    }

    @Override
    public boolean upButtonPressed() {
        return keyHandler.upPressed;
    }

    @Override
    public boolean downButtonPressed() {
        return keyHandler.downPressed;
    }

    @Override
    public boolean leftButtonPressed() {
        return keyHandler.leftPressed;
    }

    @Override
    public boolean rightButtonPressed() {
        return keyHandler.rightPressed;
    }

    @Override
    public boolean enterButtonPressed() {
        return keyHandler.enterPressed;
    }

    @Override
    public boolean qButtonPressed() {
        return keyHandler.qPressed;
    }

    @Override
    public List<Command> getActiveCommands(Player player) {
        return List.of();
    }

    public List<Command> getCommands(Player player)
    {
        List<Command> commands = new ArrayList<>();

        boolean run = keyHandler.shiftPressed;

        if (keyHandler.upPressed)
        {
            commands.add(new UpFastCommand(run));
        }

        if (keyHandler.downPressed)
        {
            commands.add(new DownFastCommand(run));
        }

        if (keyHandler.leftPressed)
        {
            commands.add(new LeftFastCommand(run));
        }

        if (keyHandler.rightPressed)
        {
            commands.add(new RightFastCommand(run));
        }


        return commands;
    }

}
