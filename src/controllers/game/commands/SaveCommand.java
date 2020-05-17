package controllers.game.commands;

import controllers.game.Game;
import models.Environment;

public class SaveCommand implements Command {

    private Game game;
    private String[] args;

    public SaveCommand(Game _game, String[] _args) {
        game = _game;
        args = _args;
    }

    @Override
    public void execute() {
        if (args.length == 1 && Environment.serializeWrite(args[0])) {
            game.getOutput().println(String.format("saved: %s", args[0]));
        }
    }
}
