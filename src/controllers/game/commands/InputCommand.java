package controllers.game.commands;

import controllers.game.Game;
import controllers.view.MapPresenter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputCommand implements Command {

    private Game game;
    private String[] args;

    public InputCommand(Game _game, String[] _args) {
        game = _game;
        args = _args;
    }


    @Override
    public void execute() {
        if (args.length == 0) {
            game.getOutput().println("Invalid Arguments");
            return;
        }

        if (args[0].equals("console")) {
            MapPresenter.getInstance().update();
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
