package controllers.game.commands;

import controllers.game.Game;
import models.Environment;
import models.figures.Figure;
import models.figures.Researcher;
import models.tiles.Tile;


/**
 * A command to analize tiles.
 *
 * @author Ábrahám Dániel
 */
public class AnalizeTileCommand implements Command {
    /**
     * Command execution's logic.
     *
     * @param game The game object that is currently running
     * @param args Command arguments
     */
    @Override
    public void execute(Game game, String[] args) {
        if (args.length != 1)
            return;

        if (Environment.getInstance().getCurrentPlayer() == null) {
            game.getOutput().println("There is no Figure currently selected, please use the \"nextcharacter\" command before!");
            return;
        }
        Figure figure = Environment.getInstance().getCurrentPlayer();

        int tileID = Integer.MIN_VALUE;

        try {
            tileID = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        if (Environment.getInstance().getIceTiles().size() - 1 < tileID || tileID < 0) {
            game.getOutput().println("Tile ID must be between 0 and the maximum ID of " + (Environment.getInstance().getIceTiles().size() - 1));
            return;
        }

        if (figure.getBaseBodyHeat() == 4) {
            Tile t = Environment.getInstance().getIceTiles().get(tileID);

            ((Researcher) figure).useSpecial(t);

        } else {
            game.getOutput().println("This figure cannot analyze tiles!");
        }
    }
}
