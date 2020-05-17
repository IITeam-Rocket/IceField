package controllers.game.commands;

import controllers.game.GameJFrame;

public class InvalidCommand implements Command {

    /**
     * Constructor
     */
    public InvalidCommand() {
    }

    /**
     * Command execution's logic.
     *
     */
    @Override
    public void execute() {
        GameJFrame.getInstance().OutputToTextBox("Invalid command");
    }
}
