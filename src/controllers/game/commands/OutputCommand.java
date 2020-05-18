package controllers.game.commands;

import controllers.game.Game;
import controllers.game.GameJFrame;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class OutputCommand implements Command {

    private final Game game;
    private final String[] args;

    /**
     * Constructor
     *
     * @param _game The Game Object
     * @param _args Command Arguments
     */
    public OutputCommand(Game _game, String[] _args) {
        game = _game;
        args = _args;
    }

    /**
     * Command execution's logic.
     *
     */
    @Override
    public void execute() {
        if (args.length != 1) {
            return;
        }
        if (args[0].equals("console")) {
            GameJFrame.getInstance().outputToTextBox("set output: console");
            game.changeOutput(System.out);
            GameJFrame.getInstance().outputToTextBox("set output: console");
            return;
        }

        try {
            GameJFrame.getInstance().outputToTextBox(String.format("set output: %s", args[0]));
            game.changeOutput(new PrintStream(new File(args[0])));
            GameJFrame.getInstance().outputToTextBox(String.format("set output: %s", args[0]));
        } catch (FileNotFoundException e) {
            GameJFrame.getInstance().outputToTextBox(String.format("File %s does not exist!", args[0]));
        }
    }
}
