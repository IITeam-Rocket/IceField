package controllers.game.commands;

import controllers.game.Game;

public interface Command {
    void execute(Game game, String[] args);
}
