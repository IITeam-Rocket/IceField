package controllers.game.commands;

import controllers.game.Game;
import models.Environment;
import models.tiles.Hole;
import models.tiles.InstableIcePatch;
import models.tiles.StableIcePatch;
import models.tiles.Tile;

public class AddTileCommand implements Command {

    private Game game;
    private String[] args;

    public AddTileCommand(Game _game, String[] _args) {
        game = _game;
        args = _args;
    }

    /**
     * Command execution's logic.
     *
     */
    @Override
    public void execute() {
        if (args.length < 1 || 2 < args.length)
            return;

        int capcity = Integer.MIN_VALUE;

        if (args.length == 2) {
            try {
                capcity = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                //TODO
                game.getOutput().println(e.getStackTrace().toString());
            }
        }

        Tile t = getTilebyName(args[0], capcity);

        if (t == null) {
            game.getOutput().println("Error!");
        }

        Environment.getInstance().getIceTiles().add(t);
        game.getOutput().println("tile added\ntype: " + args[0] + "\nID: " + t.getID());
    }


    /**
     * A helper method to get a new instance of a Tile.
     *
     * @param name     Type of a Tile.
     * @param capacity Capacity of an InstableIcePatch
     * @return Return a new Tile instance.
     */
    private Tile getTilebyName(String name, int capacity) {
        switch (name) {
            case "hole":
                return new Hole();
            case "stable":
                return new StableIcePatch();
            case "instable":
                return new InstableIcePatch(capacity);
            default:
                return null;
        }

    }
}
