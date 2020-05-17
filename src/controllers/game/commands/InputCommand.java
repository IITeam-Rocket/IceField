package controllers.game.commands;

import controllers.game.Game;
import controllers.game.GameJFrame;
import controllers.view.MapPresenter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputCommand implements Command {

    private final Game game;
    private final String[] args;

    /**
     * Constructor
     *
     * @param _game The Game Object
     * @param _args Command Arguments
     */
    public InputCommand(Game _game, String[] _args) {
        game = _game;
        args = _args;
    }

    /**
     * Command execution's logic.
     *
     */
    @Override
    public void execute() {
        if (args.length == 0) {
            GameJFrame.getInstance().outputToTextBox("Invalid Arguments");
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
            GameJFrame.getInstance().outputToTextBox(String.format("File %s does not exist!", args[0]));
        }
    }
}
