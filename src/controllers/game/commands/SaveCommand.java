package controllers.game.commands;

import controllers.game.Game;
import models.Environment;

public class SaveCommand implements Command {
    @Override
    public void execute(Game game, String[] args) {
        if (args.length == 1) {
            if (Environment.serializeWrite(args[0])) {
                game.getOutput().println(String.format("saved: {0}", args[0]));
            }
        }
    }
}
