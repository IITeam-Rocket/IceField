package controllers.game.commands;

import controllers.game.Game;
import controllers.game.GameJFrame;
import models.Environment;

public class LoadCommand implements Command {

    private Game game;
    private String[] args;

    public LoadCommand(Game _game, String[] _args) {
        game = _game;
        args = _args;
    }

    @Override
    public void execute() {
        if (args.length != 1) {
            return;
        }
        if (Environment.serializeRead(args[0])) {
            GameJFrame.getInstance().OutputToTextBox(String.format("loaded: %s", args[0]));
        }
    }
}
