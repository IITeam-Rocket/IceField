package controllers.game.commands;

import controllers.game.GameJFrame;
import controllers.view.MapPresenter;
import models.Environment;
import models.figures.Character;
import models.figures.Figure;
import models.tiles.Tile;

public class RescueCommand implements Command {

    private final String[] args;

    /**
     * Constructor
     *
     * @param _args Command Arguments
     */
    public RescueCommand(String[] _args) {
        args = _args;
    }

    /**
     * Command execution's logic.
     */
    @Override
    public void execute() {
        if (args.length != 1) { //2
            return;
        }

        Figure f = Environment.getInstance().getCurrentPlayer();

        if (f == null) { //*2
            GameJFrame.getInstance().outputToTextBox("There is no Figure selected, please use the\n \"nextcharacter\" command before the first rescue!");
            MapPresenter.getInstance().update();
            return;
        }

        int tileID;
        try {
            tileID = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            GameJFrame.getInstance().outputToTextBox("Invalid parameter!");
            MapPresenter.getInstance().update();
            return;
        }

        if (Environment.getInstance().getIceTiles().size() - 1 < tileID || tileID < 0) {
            GameJFrame.getInstance().outputToTextBox(String.format("Tile ID must be between 0 and the maximum ID of %s",
                    (Environment.getInstance().getIceTiles().size() - 1)));
            MapPresenter.getInstance().update();
            return;
        }

        Tile baseTile = findTileByID(tileID);

        if (baseTile == null) {
            GameJFrame.getInstance().outputToTextBox(String.format("The tile with ID %d doesn't neighbour the tile, the character is on!", tileID));
            MapPresenter.getInstance().update();
            return;
        }
        Character characterToRescue = findFriendOnTile(baseTile);

        if (characterToRescue == null) {
            GameJFrame.getInstance().outputToTextBox("friend rescue: unsuccessful");
            MapPresenter.getInstance().update();
            return;
        }

        switch (f.getBaseBodyHeat()) {
            case -1:
                GameJFrame.getInstance().outputToTextBox("The polar bear can't rescue!");
                break;
            case 4:
            case 5:
                ((Character) f).rescueFriend(characterToRescue);
                break;
            default:
                GameJFrame.getInstance().outputToTextBox("Unknown Figure!");
                break;
        }

        MapPresenter.getInstance().update();
    }

    private Tile findTileByID(int ID) {
        for (Tile tile : Environment.getInstance().getCurrentPlayer().getTile().getNeighbours()) {
            if (tile.getID() == ID) {
                return tile;
            }
        }

        return null;
    }

    private Character findFriendOnTile(Tile base) {
        for (Figure figure : base.getEntities()) {
            if (figure.getBaseBodyHeat() != 1) {
                return (Character) figure;
            }
        }

        return null;
    }
}
