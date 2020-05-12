package controllers.game.commands;

import controllers.game.Game;
import models.Environment;
import models.figures.Figure;
import models.tiles.Tile;


/**
 * A command to creaft signalflare
 *
 * @author Ábrahám Dániel
 */
public class CraftSignalFlateCommand implements Command {
    /**
     * Command execution's logic.
     *
     * @param game The game object that is currently running
     * @param args Command arguments
     */
    @Override
    public void execute(Game game, String[] args) {
        Figure currentPlayer = Environment.getInstance().getCurrentPlayer();

        if (currentPlayer == null) {
            game.getOutput().println("There is no Figure currently selected!");
            return;
        }

        switch (currentPlayer.getBaseBodyHeat()) {
            case -1:
                game.getOutput().println("A polar bear cannot craft!");
                break;
            case 4:
            case 5:
                if (onTheSamePage())
                    ((models.figures.Character) currentPlayer).craftSignalFlare();
            default:
                game.getOutput().println("Unknown Figure!");
        }
    }

    /**
     * Helper method to determine if the necessary requirements are fulfilled to craft a signal flare.
     *
     * @return returns true is requirements fulfilled, otherwise return false.
     */
    boolean onTheSamePage() {

        boolean gun, cartridge, beacon;
        gun = Environment.getInstance().isGunIsDiscovered();
        cartridge = Environment.getInstance().isCartridgeIsDiscovered();
        beacon = Environment.getInstance().isBeaconIsDiscovered();

        if (gun && cartridge && beacon) {
            Tile Tgun = Environment.getInstance().getGunLocation();
            Tile Tcartridge = Environment.getInstance().getCartidgeLocation();
            Tile Tbeacon = Environment.getInstance().getBeaconLocation();

            if (Tgun.equals(Tcartridge) && Tgun.equals(Tbeacon)) {
                return true;
            }
        }

        return false;
    }
}
