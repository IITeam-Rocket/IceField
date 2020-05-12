package controllers.game.commands;

import controllers.game.Game;


/**
 * A generic Command design pattern class
 *
 * @author Ábrahám Dániel
 * @version 1.0
 * @since graphical Interface
 * @since 2020.05.01
 */
public interface Command {

    /**
     * Command execution's logic.
     *
     * @param game The game object that is currently running
     * @param args Command arguments
     */
    void execute(Game game, String[] args);
}
