package controllers.game.commands;

import controllers.game.Game;
import controllers.game.GameJFrame;
import models.Environment;

/**
 * A command to add snow to a tile.
 *
 * @author Ábrahám Dániel
 */
public class AddSnowtoTileCommand implements Command {

    private Game game;
    private String[] args;

    public AddSnowtoTileCommand(Game _game, String[] _args) {
        game = _game;
        args = _args;
    }

    /**
     * Command execution's logic.
     *
     */
    @Override
    public void execute() {
        if (args.length != 2) {
            //TODO printTiles()
        } else {
            int tileID;
            int snowQuantity;

            try {
                tileID = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                //TODO
                GameJFrame.getInstance().OutputToTextBox("Error!");
                return;
            }

            try {
                snowQuantity = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                //TODO
                GameJFrame.getInstance().OutputToTextBox("Error!");
                return;
            }

            if (Environment.getInstance().getIceTiles().size() - 1 < tileID || tileID < 0) {
                GameJFrame.getInstance().OutputToTextBox("Tile ID must be between 0 and the maximum ID of " + (Environment.getInstance().getIceTiles().size() - 1));
                return;
            }

            int result = Environment.getInstance().getIceTiles().get(tileID).addSnow(snowQuantity);

            GameJFrame.getInstance().OutputToTextBox("snow added: " + tileID + ", " + result);
        }
    }
}
