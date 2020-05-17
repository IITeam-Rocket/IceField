package controllers.game.commands;

import controllers.game.GameJFrame;
import models.Environment;

/**
 * A command to add snow to a tile.
 *
 * @author Ábrahám Dániel
 */
public class AddSnowToTileCommand implements Command {

    private final String[] args;

    /**
     * Constructor
     *
     * @param _args Command Arguments
     */
    public AddSnowToTileCommand(String[] _args) {
        args = _args;
    }

    /**
     * Command execution's logic.
     */
    @Override
    public void execute() {
        if (args.length == 2) {
            int tileID;
            int snowQuantity;

            try {
                tileID = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                GameJFrame.getInstance().outputToTextBox("TileID not a number!");
                return;
            }

            try {
                snowQuantity = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                GameJFrame.getInstance().outputToTextBox("Snow quantity not a number!");
                return;
            }

            if (Environment.getInstance().getIceTiles().size() - 1 < tileID || tileID < 0) {
                GameJFrame.getInstance().outputToTextBox("Tile ID must be between 0 and the maximum ID of " + (Environment.getInstance().getIceTiles().size() - 1));
                return;
            }

            int result = Environment.getInstance().getIceTiles().get(tileID).addSnow(snowQuantity);

            GameJFrame.getInstance().outputToTextBox("snow added: " + tileID + ", " + result);
        }
    }
}
