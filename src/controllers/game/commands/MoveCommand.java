package controllers.game.commands;

import controllers.game.Game;
import models.Environment;
import models.exceptions.EndOfGameException;
import models.tiles.Tile;

public class MoveCommand implements Command {
    @Override
    public void execute(Game game, String[] args) {
        if (Environment.getInstance().getCurrentPlayer() == null) {
            game.getOutput().println("There is no Figure selected, please use the \"nextcharacter\" command before the first move!");
            return;
        }

        Tile currentTile = Environment.getInstance().getCurrentPlayer().getTile();

        if (args.length == 0) {
            game.getOutput().println("neigbours: ");
            StringBuilder sb = new StringBuilder();
            currentTile.getNeighbours().forEach(t -> sb.append(String.format("{0} ", t.getID())));
            game.getOutput().println(sb.toString().trim());
        } else if (args.length == 1) {
            int tileID;
            try {
                tileID = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                //TODO invalid parameter
                return;
            }

            for (Tile tile : currentTile.getNeighbours()) {
                if (tile.getID() == tileID) {
                    try {
                        Environment.getInstance().getCurrentPlayer().moveTo(tile);
                    } catch (EndOfGameException e) {
                        game.getOutput().println(e.getMessage());
                        Environment.getInstance().gameOver();
                    }
                    return;
                }
            }

            game.getOutput().println(String.format("move character to {0}: unsuccessful", tileID));
            game.getOutput().println(String.format("The current Tile has no neighbor with the ID {0}", tileID));
        }
    }
}
