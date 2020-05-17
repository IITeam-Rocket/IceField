package controllers.game.commands;

import controllers.game.GameJFrame;
import models.Environment;

/**
 * A command to load a serialized game
 *
 * @author Ábrahám Dániel
 */
public class LoadCommand implements Command {

    private final String[] args;

    /**
     * Constructor
     *
     * @param _args Command Arguments
     */
    public LoadCommand(String[] _args) {
        args = _args;
    }

    /**
     * Command execution's logic.
     *
     */
    @Override
    public void execute() {
        if (args.length != 1) {
            return;
        }
        if (Environment.serializeRead(args[0])) {
            GameJFrame.getInstance().OutputToTextBox(String.format("loaded: %s", args[0]));
        }
    }
}
