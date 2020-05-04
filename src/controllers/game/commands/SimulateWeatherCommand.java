package controllers.game.commands;

import controllers.game.Game;
import models.Environment;
import models.exceptions.EndOfGameException;

public class SimulateWeatherCommand implements Command {
    @Override
    public void execute(Game game, String[] args) {
        try {
            game.getOutput().println("weather simulated");
            Environment.getInstance().makeStorm();
        } catch (EndOfGameException e) {
            game.getOutput().println(e.getMessage());
            if (e.getMessage().equals("Win")) {
                Environment.getInstance().winGame();
            } else {
                Environment.getInstance().gameOver();
            }
        }
    }
}
