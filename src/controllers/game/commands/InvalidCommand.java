package controllers.game.commands;

import controllers.game.Game;

public class InvalidCommand implements Command {
    @Override
    public void execute(Game game, String[] args) {
        game.getOutput().println("Invalid command");
    }
}
