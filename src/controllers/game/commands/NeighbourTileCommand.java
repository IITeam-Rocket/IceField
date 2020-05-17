package controllers.game.commands;

import controllers.game.Game;
import controllers.game.GameJFrame;
import models.Environment;
import models.tiles.Tile;

public class NeighbourTileCommand implements Command {

    private Game game;
    private String[] args;

    /**
     * Constructor
     *
     * @param _game The Game Object
     * @param _args Command Arguments
     */
    public NeighbourTileCommand(Game _game, String[] _args) {
        game = _game;
        args = _args;
    }

    /**
     * Command execution's logic.
     *
     */
    @Override
    public void execute() {
        if (args.length != 2)
            return;

        int firstID;
        int secondID;

        try {
            firstID = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            GameJFrame.getInstance().OutputToTextBox("First Tile ID not a number");
            return;
        }

        try {
            secondID = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            GameJFrame.getInstance().OutputToTextBox("Second Tile ID not a number");
            return;
        }

        if (Environment.getInstance().getIceTiles().size() - 1 < firstID ||
                firstID < 0 ||
                Environment.getInstance().getIceTiles().size() - 1 < secondID ||
                secondID < 0) {
            GameJFrame.getInstance().OutputToTextBox("Tile IDs must be between 0 and the maximum ID of " + (Environment.getInstance().getIceTiles().size() - 1));
            return;
        }

        if (firstID == secondID) {
            GameJFrame.getInstance().OutputToTextBox("A tile can't be it's own neighbour!");
            return;
        }

        Tile tile1 = Environment.getInstance().getIceTiles().get(firstID);
        Tile tile2 = Environment.getInstance().getIceTiles().get(secondID);

        tile1.getNeighbours().forEach(tile -> {
            if (tile.equals(tile2)) {
                GameJFrame.getInstance().OutputToTextBox("These tiles are already neighbours!");
                return;
            }
        });

        tile2.getNeighbours().forEach(tile -> {
            if (tile.equals(tile1)) {
                GameJFrame.getInstance().OutputToTextBox("These tiles are already neighbours!");
                return;
            }
        });

        tile1.getNeighbours().add(tile2);
        tile2.getNeighbours().add(tile1);

        GameJFrame.getInstance().OutputToTextBox("neighbours: " + firstID + ", " + secondID);
    }
}
