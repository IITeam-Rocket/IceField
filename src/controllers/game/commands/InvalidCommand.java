package controllers.game.commands;

import controllers.game.Game;
import controllers.game.GameJFrame;

public class InvalidCommand implements Command {

    private Game game;
    private String[] args;

    public InvalidCommand(Game _game, String[] _args) {
        game = _game;
        args = _args;
    }

    @Override
    public void execute() {
        GameJFrame.getInstance().OutputToTextBox("Invalid command");
    }
}
