package controllers.game.commands;

import controllers.game.Game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class OutputCommand implements Command {
    @Override
    public void execute(Game game, String[] args) {
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
