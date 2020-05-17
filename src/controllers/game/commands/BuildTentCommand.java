package controllers.game.commands;

import controllers.game.Game;
import models.Environment;
import models.figures.Eskimo;
import models.figures.Figure;
import models.figures.Researcher;

/**
 * A command to build tent on a tile.
 *
 * @author Ábrahám Dániel
 */
public class BuildTentCommand implements Command {

    private Game game;
    private String[] args;

    public BuildTentCommand(Game _game, String[] _args) {
        game = _game;
        args = _args;
    }

    /**
     * Command execution's logic.
     *
     */
    @Override
    public void execute() {
        Figure figure = Environment.getInstance().getCurrentPlayer();

        if (figure == null) {
            game.getOutput().println("There is no Figure currently selected!");
            return;
        }

        switch (figure.getBaseBodyHeat()) {
            case -1:
                game.getOutput().println("A polar bear cannot build Tent!");
                break;
            case 4:
                ((Researcher) figure).buildTent();
                game.getOutput().println("build tent: successful");
                return;
            case 5:
                ((Eskimo) figure).buildTent();
                game.getOutput().println("build tent: successful");
                return;
            default:
                game.getOutput().println("Unknown Figure!");
                break;
        }

        game.getOutput().println("build tent: unsuccessful");
    }
}
