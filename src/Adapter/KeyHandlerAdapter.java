package Adapter;

import Interface.PlayerInput;
import main.KeyHandler;

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
}
