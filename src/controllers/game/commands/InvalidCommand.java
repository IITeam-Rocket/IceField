package controllers.game.commands;

import controllers.game.Game;

public class InvalidCommand implements Command {

    private Game game;
    private String[] args;

    public InvalidCommand(Game _game, String[] _args) {
        game = _game;
        args = _args;
    }

    @Override
    public void execute() {
        game.getOutput().println("Invalid command");
    }
}
