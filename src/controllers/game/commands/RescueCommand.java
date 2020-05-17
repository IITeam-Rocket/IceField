package controllers.game.commands;

import controllers.game.Game;
import controllers.game.GameJFrame;
import controllers.view.MapPresenter;
import models.Environment;
import models.figures.Character;
import models.figures.Figure;
import models.tiles.Tile;

public class RescueCommand implements Command {

    private final Game game;
    private final String[] args;

    public RescueCommand(Game _game, String[] _args) {
        game = _game;
        args = _args;
    }

    @Override
    public void execute() {
        if (args.length != 1) { //2
            return;
        }

        Figure f = Environment.getInstance().getCurrentPlayer();

        if (f == null) { //*2
            GameJFrame.getInstance().OutputToTextBox("There is no Figure selected, please use the \"nextcharacter\" command before the first rescue!");
            MapPresenter.getInstance().update();
            return;
        }

        int tileID;
        try {
            tileID = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            GameJFrame.getInstance().OutputToTextBox("Invalid parameter!");
            MapPresenter.getInstance().update();
            return;
        }

        if (Environment.getInstance().getIceTiles().size() - 1 < tileID || tileID < 0) {
            GameJFrame.getInstance().OutputToTextBox(String.format("Tile ID must be between 0 and the maximum ID of %s",
                    (Environment.getInstance().getIceTiles().size() - 1)));
            MapPresenter.getInstance().update();
            return;
        }

        Tile basetile = findTilebyID(tileID);

        if (basetile == null) {
            GameJFrame.getInstance().OutputToTextBox(String.format("The tile with ID %d doesn't neighbour the tile, the character is on!", tileID));
            MapPresenter.getInstance().update();
            return;
        }
        Character characterToRescue = findFriendonTile(basetile);

        if (characterToRescue == null) {
            GameJFrame.getInstance().OutputToTextBox("friend rescue: unsuccessful");
            MapPresenter.getInstance().update();
            return;
        }

        switch (f.getBaseBodyHeat()) {
            case -1:
                GameJFrame.getInstance().OutputToTextBox("The polar bear can't rescue!");
                break;
            case 4:
            case 5:
                ((Character) f).rescueFriend(characterToRescue);
                break;
            default:
                GameJFrame.getInstance().OutputToTextBox("Unknown Figure!");
                break;
        }

        MapPresenter.getInstance().update();
    }

    private Tile findTilebyID(int ID) {
        for (Tile tile : Environment.getInstance().getCurrentPlayer().getTile().getNeighbours()) {
            if (tile.getID() == ID) {
                return tile;
            }
        }

        return null;
    }

    private Character findFriendonTile(Tile base) {
        for (Figure figure : base.getEntities()) {
            if (figure.getBaseBodyHeat() != 1) {
                return (Character) figure;
            }
        }

        return null;
    }
}
