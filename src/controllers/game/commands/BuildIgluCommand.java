package controllers.game.commands;

import controllers.game.Game;
import models.Environment;
import models.figures.Eskimo;
import models.figures.Figure;

public class BuildIgluCommand implements Command {
    /**
     * Command execution's logic.
     *
     * @param game The game object that is currently running
     * @param args Command arguments
     */
    @Override
    public void execute(Game game, String[] args) {
        Figure figure = Environment.getInstance().getCurrentPlayer();

        if (figure == null) {
            game.getOutput().println("There is no Figure selected, please use the \"nextcharacter\" command before the first buildiglu!");
            return;
        }

        switch (figure.getBaseBodyHeat()) {
            case -1:
                game.getOutput().println("A polar bear cannot build Iglu!");
                break;
            case 4:
                game.getOutput().println("A researcher cannot build Iglu!");
                break;
            case 5:
                ((Eskimo) figure).useSpecial(figure.getTile());
                game.getOutput().println("build iglu: successful");
                return;
            default:
                game.getOutput().println("Unknown Figure!");
                break;
        }

        game.getOutput().println("build iglu: unseccessful");
    }
}
