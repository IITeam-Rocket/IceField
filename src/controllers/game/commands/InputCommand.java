package controllers.game.commands;

import controllers.game.Game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputCommand implements Command {
    @Override
    public void execute(Game game, String[] args) {
        if (args.length == 0) {
            game.getOutput().println("Invalid Arguments");
            return;
        }

        if (args[1].equals("console")) {
            System.out.println("set input: console");
            game.changeInput(new Scanner(System.in));
            return;
        }

        try {
            game.changeInput(new Scanner(new File(args[0])));
        } catch (FileNotFoundException e) {
            game.getOutput().println(String.format("File %s does not exist!", args[0]));
        }
    }
}
