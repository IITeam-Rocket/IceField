package controllers.game.commands;

import controllers.game.Game;
import models.Environment;

/**
 * A Reset Command to reset the game's environment.
 *
 * @author Ábrahám Dániel
 */
public class ResetCommand implements Command {

    /**
     * Command execution's logic.
     *
     * @param game The game object that is currently running
     * @param args Command arguments
     */
    @Override
    public void execute(Game game, String[] args) {
        Environment.getInstance().reset();
        game.getOutput().println("Game Reset!");
    }
}
