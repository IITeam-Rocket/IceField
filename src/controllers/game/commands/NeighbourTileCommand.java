package controllers.game.commands;

import controllers.game.Game;
import models.Environment;
import models.tiles.Tile;

public class NeighbourTileCommand implements Command {

    private Game game;
    private String[] args;

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
            //TODO
            game.getOutput().println("Error");
            return;
        }

        try {
            secondID = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            //TODO
            game.getOutput().println("Error");
            return;
        }

        if (Environment.getInstance().getIceTiles().size() - 1 < firstID ||
                firstID < 0 ||
                Environment.getInstance().getIceTiles().size() - 1 < secondID ||
                secondID < 0) {
            game.getOutput().println("Tile IDs must be between 0 and the maximum ID of " + (Environment.getInstance().getIceTiles().size() - 1));
            return;
        }

        if (firstID == secondID) {
            game.getOutput().println("A tile can't be it's own neighbour!");
            return;
        }

        Tile tile1 = Environment.getInstance().getIceTiles().get(firstID);
        Tile tile2 = Environment.getInstance().getIceTiles().get(secondID);

        tile1.getNeighbours().forEach(tile -> {
            if (tile.equals(tile2)) {
                game.getOutput().println("These tiles are already neighbours!");
                return;
            }
        });

        tile2.getNeighbours().forEach(tile -> {
            if (tile.equals(tile1)) {
                game.getOutput().println("These tiles are already neighbours!");
                return;
            }
        });

        tile1.getNeighbours().add(tile2);
        tile2.getNeighbours().add(tile1);

        game.getOutput().println("neighbours: " + firstID + ", " + secondID);
    }
}
