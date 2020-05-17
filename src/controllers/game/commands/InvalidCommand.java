package controllers.game.commands;

import controllers.game.GameJFrame;

/**
 * A command that implement unknown command
 *
 * @author Ábrahám Dániel
 */
public class InvalidCommand implements Command {

    /**
     * Command execution's logic.
     *
     */
    @Override
    public void execute() {
        GameJFrame.getInstance().outputToTextBox("Invalid command");
    }
}
