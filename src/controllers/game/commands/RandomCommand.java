package controllers.game.commands;

import controllers.RandomController;
import controllers.game.Game;
import controllers.game.GameJFrame;

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
                    GameJFrame.getInstance().OutputToTextBox("set random: on");
                    break;
                case "off":
                    RandomController.setRandom(false);
                    GameJFrame.getInstance().OutputToTextBox("set random: off");
                    break;
                default:
                    break;
            }
        }
    }
}
