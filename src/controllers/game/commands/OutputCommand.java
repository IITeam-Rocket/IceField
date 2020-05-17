package controllers.game.commands;

import controllers.game.Game;

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
            game.getOutput().println("set output: console");
            game.changeOutput(System.out);
            game.getOutput().println("set output: console");
            return;
        }

        try {
            game.getOutput().println(String.format("set output: %s", args[0]));
            game.changeOutput(new PrintStream(new File(args[0])));
            game.getOutput().println(String.format("set output: %s", args[0]));
        } catch (FileNotFoundException e) {
            game.getOutput().println(String.format("File %s does not exist!", args[0]));
        }
    }
}
