package controllers.game.commands;

import controllers.game.Game;
import controllers.game.GameJFrame;

public class InvalidCommand implements Command {

    private Game game;
    private String[] args;

    /**
     * Constructor
     *
     * @param _game The Game Object
     * @param _args Command Arguments
     */
    public InvalidCommand(Game _game, String[] _args) {
        game = _game;
        args = _args;
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
