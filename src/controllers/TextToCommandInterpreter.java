package controllers;

import controllers.game.Game;
import controllers.game.commands.*;
import models.Environment;

import java.util.ArrayList;
import java.util.Arrays;

public class TextToCommandInterpreter {
    public Game game;

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
        Command command = new InvalidCommand(game, new String[]{});
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
                command = new LoadCommand(game, args);
                break;
            case "save":
                command = new SaveCommand(game, args);
                break;
            case "random":
                command = new RandomCommand(game, args);
                break;
            case "nextcharacter":
                command = new NextCharacterCommand(game, args);
                break;
            case "move":
                command = new MoveCommand(game, args);
                break;
            case "unbury":
                command = new UnburyCommand(game, args);
                break;
            case "clearsnow":
                command = new ClearSnowCommand(game, args);
                break;
            case "simulateweather":
                command = new SimulateWeatherCommand(game, args);
                break;
            case "rescue":
                command = new RescueCommand(game, args);
                break;
            case "craftsignalflare":
                command = new CraftSignalFlareCommand(game, args);
                break;
            case "buildiglu":
                command = new BuildIgluCommand(game, args);
                break;
            case "buildtent":
                command = new BuildTentCommand(game, args);
                break;
            case "analyzetile":
                command = new AnalyzeTileCommand(game, args);
                break;
            case "addtile":
                command = new AddTileCommand(game, args);
                break;
            case "neighbourtile":
                command = new NeighbourTileCommand(game, args);
                break;
            case "additemtotile":
                command = new AddItemToTileCommand(game, args);
                break;
            case "addcharactertotile":
                command = new AddCharacterToTileCommand(game, args);
                break;
            case "addsnowtotile":
                command = new AddSnowToTileCommand(game, args);
                break;
            case "reset":
                command = new ResetCommand(game, args);
                break;
            case "usespecial":
                int bodyheat = Environment.getInstance().getCurrentPlayer().getBaseBodyHeat();
                if (bodyheat == 4) {
                    command = new AnalyzeTileCommand(game, args);
                } else if (bodyheat == 5) {
                    command = new BuildIgluCommand(game, args);
                }
            case "exit":
            case "quit":
                game.endGame();
                break;
            default:
                command = new InvalidCommand(game, args);
                break;
        }
        return command;
    }
}