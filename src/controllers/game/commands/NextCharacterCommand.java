package controllers.game.commands;

import controllers.RandomController;
import controllers.game.Game;
import models.Environment;
import models.exceptions.EndOfGameException;
import models.figures.Figure;

public class NextCharacterCommand implements Command {
    @Override
    public void execute(Game game, String[] args) {
        if (Environment.getInstance().getPlayers().size() == 0) {
            game.getOutput().println("There are currently no characters!");
            return;
        }

        if (Environment.getInstance().getCurrentPlayer() == null) {
            Environment.getInstance().setCurrentPlayer(Environment.getInstance().getPlayers().get(0));
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
                            game.getOutput().println(e.getMessage());
                            Environment.getInstance().winGame();
                        } else {
                            game.getOutput().println(e.getMessage());
                            Environment.getInstance().gameOver();
                        }
                    }
                });
            } else {
                ++ID;
            }

            Environment.getInstance().setCurrentPlayer(Environment.getInstance().getPlayers().get(ID));
        }

        if (Environment.getInstance().getCurrentPlayer().getBaseBodyHeat() == -1 && RandomController.getRandom()) {
            new NextCharacterCommand().execute(game, args);
        }
    }
}
