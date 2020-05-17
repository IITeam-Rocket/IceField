package controllers.game.commands;

import controllers.game.GameJFrame;
import models.Environment;

/**
 * A Reset Command to reset the game's environment.
 *
 * @author Ábrahám Dániel
 */
public class ResetCommand implements Command {

    /**
     * Constructor
     */
    public ResetCommand() {
    }

    /**
     * Command execution's logic.
     *
     */
    @Override
    public void execute() {
        Environment.getInstance().reset();
        GameJFrame.getInstance().OutputToTextBox("Game Reset!");
    }
}
