package controllers.game.commands;

import controllers.game.GameJFrame;
import models.Environment;
import models.tiles.Tile;

public class NeighbourTileCommand implements Command {

    private final String[] args;

    /**
     * Constructor
     *
     * @param _args Command Arguments
     */
    public NeighbourTileCommand(String[] _args) {
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
            GameJFrame.getInstance().outputToTextBox("First Tile ID not a number");
            return;
        }

        try {
            secondID = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            GameJFrame.getInstance().outputToTextBox("Second Tile ID not a number");
            return;
        }

        if (Environment.getInstance().getIceTiles().size() - 1 < firstID ||
                firstID < 0 ||
                Environment.getInstance().getIceTiles().size() - 1 < secondID ||
                secondID < 0) {
            GameJFrame.getInstance().outputToTextBox("Tile IDs must be between 0 and the maximum ID of " + (Environment.getInstance().getIceTiles().size() - 1));
            return;
        }

        if (firstID == secondID) {
            GameJFrame.getInstance().outputToTextBox("A tile can't be it's own neighbour!");
            return;
        }

        Tile tile1 = Environment.getInstance().getIceTiles().get(firstID);
        Tile tile2 = Environment.getInstance().getIceTiles().get(secondID);

        tile1.getNeighbours().forEach(tile -> {
            if (tile.equals(tile2)) {
                GameJFrame.getInstance().outputToTextBox("These tiles are already neighbours!");
            }
        });

        tile2.getNeighbours().forEach(tile -> {
            if (tile.equals(tile1)) {
                GameJFrame.getInstance().outputToTextBox("These tiles are already neighbours!");
            }
        });

        tile1.getNeighbours().add(tile2);
        tile2.getNeighbours().add(tile1);

        GameJFrame.getInstance().outputToTextBox("neighbours: " + firstID + ", " + secondID);
    }
}
