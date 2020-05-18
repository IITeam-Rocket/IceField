package controllers;

import controllers.game.Game;
import controllers.game.commands.*;
import models.Environment;

import java.util.ArrayList;
import java.util.Arrays;

public class TextToCommandInterpreter {
    public final Game game;

    public TextToCommandInterpreter(Game _game) {
        this.game = _game;
    }

    private boolean hasArgs(String[] parts) {
        return parts.length > 1;
    }

    /**
     * Interpret command
     * @param line Line to interpret
     * @return Command created from line
     */
    public Command interpreter(String line) {
        if (line.length() == 0) {
            game.getOutput().println("No command to interpret");
            return null;
        }
        Command command = new InvalidCommand();
        String[] parts = line.split(" ");
        String cmd = parts[0];
        String[] args = {};
        if (hasArgs(parts)) {
            ArrayList<String> a = new ArrayList<>(Arrays.asList(parts).subList(1, parts.length));

            args = a.toArray(new String[]{});
        }
        switch (cmd) {
            case "input":
                command = new InputCommand(game, args);
                break;
            case "output":
                command = new OutputCommand(game, args);
                break;
            case "load":
                command = new LoadCommand(args);
                break;
            case "save":
                command = new SaveCommand(args);
                break;
            case "random":
                command = new RandomCommand(args);
                break;
            case "nextcharacter":
                command = new NextCharacterCommand(game, args);
                break;
            case "move":
                command = new MoveCommand(args);
                break;
            case "unbury":
                command = new UnburyCommand(args);
                break;
            case "clearsnow":
                command = new ClearSnowCommand();
                break;
            case "simulateweather":
                command = new SimulateWeatherCommand();
                break;
            case "rescue":
                command = new RescueCommand(game, args);
                break;
            case "craftsignalflare":
                command = new CraftSignalFlareCommand();
                break;
            case "buildiglu":
                command = new BuildIgluCommand();
                break;
            case "buildtent":
                command = new BuildTentCommand();
                break;
            case "analyzetile":
                command = new AnalyzeTileCommand(game, args);
                break;
            case "addtile":
                command = new AddTileCommand(args);
                break;
            case "neighbourtile":
                command = new NeighbourTileCommand(args);
                break;
            case "additemtotile":
                command = new AddItemToTileCommand(game, args);
                break;
            case "addcharactertotile":
                command = new AddCharacterToTileCommand(args);
                break;
            case "addsnowtotile":
                command = new AddSnowToTileCommand(args);
                break;
            case "reset":
                command = new ResetCommand();
                break;
            case "usespecial":
                int bodyheat = Environment.getInstance().getCurrentPlayer().getBaseBodyHeat();
                if (bodyheat == 4) {
                    command = new AnalyzeTileCommand(game, args);
                } else if (bodyheat == 5) {
                    command = new BuildIgluCommand();
                }
                break;
            case "exit":    // empty case
            case "quit":
                game.endGame();
                break;
            default:
                command = new InvalidCommand();
                break;
        }
        return command;
    }
}
