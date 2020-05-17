package controllers.game.commands;

import controllers.game.GameJFrame;
import controllers.view.MapPresenter;
import models.Environment;
import models.exceptions.EndOfGameException;

public class SimulateWeatherCommand implements Command {

    /**
     * Command execution's logic.
     *
     */
    @Override
    public void execute() {
        try {
            GameJFrame.getInstance().OutputToTextBox("weather simulated");
            Environment.getInstance().makeStorm();
        } catch (EndOfGameException e) {
            GameJFrame.getInstance().OutputToTextBox(e.getMessage());
            if (e.getMessage().equals("Win")) {
                Environment.getInstance().winGame();
            } else {
                Environment.getInstance().gameOver();
            }
        }

        MapPresenter.getInstance().update();
    }
}
