package controllers.game.commands;

import controllers.RandomController;
import controllers.game.Game;

public class RandomCommand implements Command {

    private Game game;
    private String[] args;

    public RandomCommand(Game _game, String[] _args) {
        game = _game;
        args = _args;
    }

    @Override
    public void execute() {
        if (args.length == 1) {
            switch (args[0]) {
                case "on":
                    RandomController.setRandom(true);
                    game.getOutput().println("set random: on");
                    break;
                case "off":
                    RandomController.setRandom(false);
                    game.getOutput().println("set random: off");
                    break;
                default:
                    break;
            }
        }
    }
}
