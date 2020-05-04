package controllers.game;

import controllers.game.commands.*;

import java.util.ArrayList;

public class CommandInterpreter {
    private Game game;

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
            ArrayList<String> a = new ArrayList<>();
            for (int i = 1; i < parts.length; i++) {
                a.add(parts[i]);
            }

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

                break;
            case "buildiglu":
                break;
            case "buildtent":
                break;
            case "analyzetile":
                break;
            case "addtile":
                break;
            case "neighbourtile":
                break;
            case "additemtotile":
                break;
            case "addcharactertotile":
                break;
            case "addsnowtotile":
                break;
            case "reset":
                break;
            case "exit":
            case "quit":
                break;
            default:
                command = new InvalidCommand();
                break;
        }
        command.execute(game, args);
    }
}
