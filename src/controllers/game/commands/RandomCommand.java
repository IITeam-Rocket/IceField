package controllers.game.commands;

import controllers.RandomController;
import controllers.game.Game;

public class RandomCommand implements Command {
    @Override
    public void execute(Game game, String[] args) {
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
