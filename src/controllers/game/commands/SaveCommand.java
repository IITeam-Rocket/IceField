package controllers.game.commands;

import controllers.game.GameJFrame;
import models.Environment;

public class SaveCommand implements Command {

    private final String[] args;

    /**
     * Constructor
     *
     * @param _args Command Arguments
     */
    public SaveCommand(String[] _args) {
        args = _args;
    }

    /**
     * Command execution's logic.
     *
     */
    @Override
    public void execute() {
        if (args.length == 1 && Environment.serializeWrite(args[0])) {
            GameJFrame.getInstance().outputToTextBox(String.format("saved: %s", args[0]));
        }
    }
}
