package controllers.game.commands;

import controllers.game.Game;
import controllers.view.*;
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
        if (args.length < 3)
            return;

        int capacity = Integer.MIN_VALUE;
        int x = 0;
        int y = 0;

        if (args.length == 4) {
            try {
                x = Integer.parseInt(args[1]);
                y = Integer.parseInt(args[2]);
                capacity = Integer.parseInt(args[3]);
            } catch (NumberFormatException e) {
                //TODO
                game.getOutput().println(e.getStackTrace().toString());
            }
        }
        else if (args.length == 3) {
            try {
                x = Integer.parseInt(args[1]);
                y = Integer.parseInt(args[2]);
            } catch (NumberFormatException e) {
                //TODO
                game.getOutput().println(e.getStackTrace().toString());
            }
        }

        Tile t = null;
        TilePresenter presenter = null;

        switch (args[0]) {
            case "hole":
                Hole hole = new Hole();
                presenter = new HolePresenter(hole, x, y);
                t = hole;
                break;
            case "stable":
                StableIcePatch stableIcePatch = new StableIcePatch();
                presenter = new StableIcePatchPresenter(stableIcePatch, x, y);
                t = stableIcePatch;
                break;
            case "instable":
                InstableIcePatch instableIcePatch = new InstableIcePatch(capacity);
                presenter = new InstableIcePatchPresenter(instableIcePatch, x, y);
                t = instableIcePatch;
                break;
            default:
                System.out.println("Unknown tile type!");
                return;
        }

        if (t == null || presenter == null) {
            game.getOutput().println("Error!");
        }

        Environment.getInstance().getIceTiles().add(t);
        System.out.println("Size:" + Environment.getInstance().getIceTiles().size());
        MapPresenter.getInstance().addTilePresenter(presenter);
        game.getOutput().println("tile added\ntype: " + args[0] + "\nID: " + t.getID());
    }
}
