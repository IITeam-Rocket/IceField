package controllers.game.commands;

import controllers.game.Game;
import models.Environment;
import models.exceptions.EndOfGameException;

public class SimulateWeatherCommand implements Command {

    private Game game;
    private String[] args;

    public SimulateWeatherCommand(Game _game, String[] _args) {
        game = _game;
        args = _args;
    }

    @Override
    public void execute() {
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
