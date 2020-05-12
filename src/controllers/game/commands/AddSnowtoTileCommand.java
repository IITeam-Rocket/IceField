package controllers.game.commands;

import controllers.game.Game;
import models.Environment;

/**
 * A command to add snow to a tile.
 *
 * @author Ábrahám Dániel
 */
public class AddSnowtoTileCommand implements Command {
    /**
     * Command execution's logic.
     *
     * @param game The game object that is currently running
     * @param args Command arguments
     */
    @Override
    public void execute(Game game, String[] args) {
        if (args.length != 2) {
            //TODO printTiles()
        } else {
            int tileID = Integer.MIN_VALUE;
            int snowQuantity = Integer.MIN_VALUE;

            try {
                tileID = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                //TODO
                game.getOutput().println("Error!");
                return;
            }

            try {
                snowQuantity = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                //TODO
                game.getOutput().println("Error!");
                return;
            }

            if (Environment.getInstance().getIceTiles().size() - 1 < tileID || tileID < 0) {
                game.getOutput().println("Tile ID must be between 0 and the maximum ID of " + (Environment.getInstance().getIceTiles().size() - 1));
                return;
            }

            int result = Environment.getInstance().getIceTiles().get(tileID).addSnow(snowQuantity);

            game.getOutput().println("snow added: " + tileID + ", " + result);
        }
    }
}
