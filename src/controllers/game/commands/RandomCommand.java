package controllers.game.commands;

import controllers.RandomController;
import controllers.game.GameJFrame;
import controllers.view.MapPresenter;

public class RandomCommand implements Command {

    private final String[] args;

    /**
     * Constructor
     *
     * @param _args Command Arguments
     */
    public RandomCommand(String[] _args) {
        args = _args;
    }

    /**
     * Command execution's logic.
     *
     */
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

        MapPresenter.getInstance().update();
    }
}
