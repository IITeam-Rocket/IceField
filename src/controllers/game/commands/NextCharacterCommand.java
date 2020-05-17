package controllers.game.commands;

import controllers.RandomController;
import controllers.game.Game;
import controllers.game.GameJFrame;
import controllers.view.MapPresenter;
import models.Environment;
import models.exceptions.EndOfGameException;
import models.figures.Figure;

import java.util.Random;

public class NextCharacterCommand implements Command {

    private Game game;
    private String[] args;

    public NextCharacterCommand(Game _game, String[] _args) {
        game = _game;
        args = _args;
    }

    @Override
    public void execute() {
        if (Environment.getInstance().getPlayers().size() == 0) {
            GameJFrame.getInstance().OutputToTextBox("There are currently no characters!");
            return;
        }

        if (Environment.getInstance().getCurrentPlayer() == null) {
            Environment.getInstance().setCurrentPlayer(0);
        } else {
            Figure current = Environment.getInstance().getCurrentPlayer();
            int ID = Environment.getInstance().getPlayers().indexOf(current);

            if (ID == Environment.getInstance().getPlayers().size() - 1) {
                ID = 0;
                Environment.getInstance().getIceTiles().forEach(t -> {
                    try {
                        t.step();
                    } catch (EndOfGameException e) {
                        if (e.getMessage().equals("Win")) {
                            GameJFrame.getInstance().OutputToTextBox(e.getMessage());
                            Environment.getInstance().winGame();
                        } else {
                            GameJFrame.getInstance().OutputToTextBox(e.getMessage());
                            Environment.getInstance().gameOver();
                        }
                    }
                });
                if (RandomController.getRandom())
                    new SimulateWeatherCommand(game, args).execute();
            } else {
                ++ID;
            }

            Environment.getInstance().setCurrentPlayer(ID);
        }

        if (Environment.getInstance().getCurrentPlayer().getBaseBodyHeat() == -1 && RandomController.getRandom()) {
            try {
                Environment.getInstance().getCurrentPlayer().moveTo(Environment.getInstance().getCurrentPlayer().getTile().getNeighbours().get(new Random().nextInt(Environment.getInstance().getCurrentPlayer().getTile().getNeighbours().size())));
            } catch (EndOfGameException e) {
                GameJFrame.getInstance().OutputToTextBox(e.getMessage());
                Environment.getInstance().gameOver();
            }
            new NextCharacterCommand(game, args).execute();
        }

        Environment.getInstance().getCurrentPlayer().notifyObservers();
        MapPresenter.getInstance().update();
    }
}
