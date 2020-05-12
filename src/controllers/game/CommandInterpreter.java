package controllers.game;

import controllers.game.commands.*;

import java.util.ArrayList;
import java.util.Arrays;

class CommandInterpreter {
    private final Game game;

    public CommandInterpreter(Game game) {
        this.game = game;
    }

    private boolean hasArgs(String[] parts) {
        return parts.length > 1;
    }

    public void Interpret(String line) {
        if (line.length() == 0) {
            game.getOutput().println("No command to interpret");
            return;
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
                command = new InputCommand();
                break;
            case "output":
                command = new OutputCommand();
                break;
            case "load":
                command = new LoadCommand();
                break;
            case "save":
                command = new SaveCommand();
                break;
            case "random":
                command = new RandomCommand();
                break;
            case "nextcharacter":
                command = new NextCharacterCommand();
                break;
            case "move":
                command = new MoveCommand();
                break;
            case "unbury":
                command = new UnburyCommand();
                break;
            case "clearsnow":
                command = new ClearSnowCommand();
                break;
            case "simulateweather":
                command = new SimulateWeatherCommand();
                break;
            case "rescue":
                command = new RescueCommand();
                break;
            case "craftsignalflare":
                command = new CraftSignalFlateCommand();
                break;
            case "buildiglu":
                command = new BuildIgluCommand();
                break;
            case "buildtent":
                command = new BuildTentCommand();
                break;
            case "analyzetile":
                command = new AnalizeTileCommand();
                break;
            case "addtile":
                command = new AddTileCommand();
                break;
            case "neighbourtile":
                command = new NeighbourTileCommand();
                break;
            case "additemtotile":
                command = new AddItemtoTileCommand();
                break;
            case "addcharactertotile":
                command = new AddCharactertoTileCommand();
                break;
            case "addsnowtotile":
                command = new AddSnowtoTileCommand();
                break;
            case "reset":
                command = new ResetCommand();
                break;
            case "exit":
            case "quit":
                game.EndGame();
                return;
            default:
                command = new InvalidCommand();
                break;
        }
        command.execute(game, args);
    }
}
