package controllers.game.commands;

import controllers.game.Game;
import controllers.game.GameJFrame;
import models.Environment;

/**
 * A Reset Command to reset the game's environment.
 *
 * @author Ábrahám Dániel
 */
public class ResetCommand implements Command {

    private Game game;
    private String[] args;

    /**
     * Constructor
     *
     * @param _game The Game Object
     * @param _args Command Arguments
     */
    public ResetCommand(Game _game, String[] _args) {
        game = _game;
        args = _args;
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
