package controllers.game.commands;

import controllers.game.Game;
import models.Environment;

public class SaveCommand implements Command {
    @Override
    public void execute(Game game, String[] args) {
        if (args.length == 1 && Environment.serializeWrite(args[0])) {
            game.getOutput().println(String.format("saved: %s", args[0]));
        }
    }
}
