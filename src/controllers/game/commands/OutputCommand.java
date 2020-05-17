package controllers.game.commands;

import controllers.game.Game;
import controllers.game.GameJFrame;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class OutputCommand implements Command {

    private Game game;
    private String[] args;

    public OutputCommand(Game _game, String[] _args) {
        game = _game;
        args = _args;
    }

    @Override
    public void execute() {
        if (args.length != 1) {
            return;
        }
        if (args[0].equals("console")) {
            GameJFrame.getInstance().OutputToTextBox("set output: console");
            game.changeOutput(System.out);
            GameJFrame.getInstance().OutputToTextBox("set output: console");
            return;
        }

        try {
            GameJFrame.getInstance().OutputToTextBox(String.format("set output: %s", args[0]));
            game.changeOutput(new PrintStream(new File(args[0])));
            GameJFrame.getInstance().OutputToTextBox(String.format("set output: %s", args[0]));
        } catch (FileNotFoundException e) {
            GameJFrame.getInstance().OutputToTextBox(String.format("File %s does not exist!", args[0]));
        }
    }
}
