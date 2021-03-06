package controllers.game.commands;

import controllers.game.GameJFrame;
import controllers.view.*;
import models.Environment;
import models.tiles.Hole;
import models.tiles.InstableIcePatch;
import models.tiles.StableIcePatch;
import models.tiles.Tile;

import java.util.Arrays;

public class AddTileCommand implements Command {

    private final String[] args;

    /**
     * Constructor
     *
     * @param _args Command Arguments
     */
    public AddTileCommand(String[] _args) {
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
                GameJFrame.getInstance().outputToTextBox(Arrays.toString(e.getStackTrace()));
            }
        } else if (args.length == 3) {
            try {
                x = Integer.parseInt(args[1]);
                y = Integer.parseInt(args[2]);
            } catch (NumberFormatException e) {
                GameJFrame.getInstance().outputToTextBox(Arrays.toString(e.getStackTrace()));
            }
        }

        Tile t;
        TilePresenter presenter;

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

        Environment.getInstance().getIceTiles().add(t);
        MapPresenter.getInstance().addTilePresenter(presenter);

        GameJFrame.getInstance().outputToTextBox("tile added\ntype: " + args[0] + "\nID: " + t.getID());
    }
}
