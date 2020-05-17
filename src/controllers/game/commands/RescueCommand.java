package controllers.game.commands;

import controllers.game.Game;
import models.Environment;
import models.figures.Character;
import models.figures.Figure;
import models.tiles.Tile;

public class RescueCommand implements Command {

    private Game game;
    private String[] args;

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
            game.getOutput().println("There is no Figure selected, please use the \"nextcharacter\" command before the first rescue!");
            return;
        }

        int tileID;
        try {
            tileID = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            //TODO invalid parameter
            return;
        }

        if (Environment.getInstance().getIceTiles().size() - 1 < tileID || tileID < 0) {
            game.getOutput().println(String.format("Tile ID must be between 0 and the maximum ID of %s",
                    (Environment.getInstance().getIceTiles().size() - 1)));
            return;
        }

        Tile basetile = findTilebyID(tileID);

        if (basetile == null) {
            game.getOutput().println(String.format("The tile with ID %d doesn't neighbour the tile, the character is on!", tileID));
            return;
        }
        Character characterToRescue = findFriendonTile(basetile);

        if (characterToRescue == null) {
            game.getOutput().println("friend rescue: unsuccessful");
            return;
        }

        switch (f.getBaseBodyHeat()) {
            case -1:
                game.getOutput().println("The polarbear can't rescue!");
                break;
            case 4:
            case 5:
                ((Character) f).rescueFriend(characterToRescue);
                break;
            default:
                game.getOutput().println("Unknown Figure!");
                break;
        }
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
