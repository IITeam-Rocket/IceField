package controllers.game.commands;

import controllers.game.Game;
import models.Environment;
import models.figures.Eskimo;
import models.figures.Figure;
import models.figures.Researcher;
import models.tiles.Tile;

public class RescueCommand implements Command {
    @Override
    public void execute(Game game, String[] args) {
        if (args.length != 1) {
            return;
        }

        if (Environment.getInstance().getCurrentPlayer() == null) {
            game.getOutput().println("There is no Figure selected, please use the \"nextcharacter\" command before the first rescue!");
            return;
        }

        Figure f = Environment.getInstance().getCurrentPlayer();

        int tileID;
        try {
            tileID = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            //TODO invalid parameter
            return;
        }

        if (Environment.getInstance().getIceTiles().size() - 1 < tileID || tileID < 0) {
            game.getOutput().println("Tile ID must be between 0 and the maximum ID of " +
                    (Environment.getInstance().getIceTiles().size() - 1));
            return;
        }

        boolean found = false;
        Figure characterToRescue = null;

        for (Tile tile : Environment.getInstance().getIceTiles()) {
            if (tile.getID() == tileID) {
                found = true;
                if (tile.getEntities().size() == 0) {
                    game.getOutput().println("friend rescue: unsuccessful");
                    return;
                }

                boolean nonPolarBear = false;
                for (Figure fi : tile.getEntities()) {
                    if (fi.getBaseBodyHeat() != -1) {
                        nonPolarBear = true;
                        characterToRescue = fi;
                        break;
                    }
                }

                if (!nonPolarBear) {
                    game.getOutput().println("There are no non polarbear characters on this tile!");
                    return;
                }

                break;
            }
        }

        if (!found) {
            game.getOutput().println("The tile with ID " + tileID + " doesn't neighbour the tile, the character is on!");
            return;
        }

        if (f.getBaseBodyHeat() == -1)
            game.getOutput().println("The polarbear can't rescue!");
        else if (f.getBaseBodyHeat() == 4)
            ((Researcher) f).rescueFriend((models.figures.Character) characterToRescue);
        else if (f.getBaseBodyHeat() == 5)
            ((Eskimo) f).rescueFriend((models.figures.Character) characterToRescue);
        else
            game.getOutput().println("Unknown Figure!");

    }
}
