package controllers.game.commands;

import controllers.game.Game;
import controllers.game.GameJFrame;
import models.Environment;
import models.items.*;
import models.tiles.IcePatch;
import models.tiles.Tile;

/**
 * A command to add a new item to a tile.
 *
 * @author Ábrahám Dániel
 */
public class AddItemToTileCommand implements Command {

    private final Game game;
    private final String[] args;

    /**
     * Constructor
     *
     * @param _game The Game Object
     * @param _args Command Arguments
     */
    public AddItemToTileCommand(Game _game, String[] _args) {
        game = _game;
        args = _args;
    }

    /**
     * Command execution's logic.
     */
    @Override
    public void execute() {
        if (args.length == 2) {
            int tileID = Integer.MIN_VALUE;
            int itemID = Integer.MIN_VALUE;

            try {
                tileID = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                game.getOutput().println("Error!");
            }

            try {
                itemID = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                game.getOutput().println("Error!");
            }

            if (Environment.getInstance().getIceTiles().size() - 1 < tileID || tileID < 0) {
                GameJFrame.getInstance().outputToTextBox("Tile ID must be between 0 and the maximum ID of " + (Environment.getInstance().getIceTiles().size() - 1));
                return;
            }

            Tile tile = Environment.getInstance().getIceTiles().get(tileID);

            if (tile.getCapacity() == 0) {
                game.getOutput().println("Items cannot be placed on a hole!");
                return;
            }

            IcePatch patch = (IcePatch) tile;
            Item item = getItemFromID(itemID);

            if (item == null) {
                game.getOutput().println("Item ID must be between 1 and 9!");
                return;
            }

            patch.setBuriedItem(item);

            game.getOutput().println("item added: " + tileID + ", " + itemID);
        }
    }

    /**
     * A helper method for getting a new item.
     *
     * @param ID itemID.
     *
     * @return return a new item instance based on the ID.
     */
    private Item getItemFromID(int ID) {
        switch (ID) {
            case 1:
                return new Food();
            case 2:
                return new Rope();
            case 3:
                return new FragileShovel();
            case 4:
                return new Shovel();
            case 5:
                return new DiveSuit();
            case 6:
                return new Beacon();
            case 7:
                return new Gun();
            case 8:
                return new Cartridge();
            case 9:
                return new Tent();
            default:
                return null;
        }
    }
}
