package controllers.game.commands;

import controllers.game.Game;
import models.Environment;

public class LoadCommand implements Command {
    @Override
    public void execute(Game game, String[] args) {
        if (args.length != 1) {
            return;
        }
        if (Environment.serializeRead(args[0])) {
            game.getOutput().println(String.format("loaded: %s", args[0]));
        }
    }
}
