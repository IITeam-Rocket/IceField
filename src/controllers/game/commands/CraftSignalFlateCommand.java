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

    private Game game;
    private String[] args;

    public CraftSignalFlateCommand(Game _game, String[] _args) {
        game = _game;
        args = _args;
    }

    /**
     * Command execution's logic.
     *
     */
    @Override
    public void execute() {
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
                break;
            default:
                game.getOutput().println("Unknown Figure!");
                break;
        }
    }

    /**
     * Helper method to determine if the necessary requirements are fulfilled to craft a signal flare.
     *
     * @return returns true is requirements fulfilled, otherwise return false.
     */
    private boolean onTheSamePage() {

        boolean gun;
        boolean cartridge;
        boolean beacon;
        gun = Environment.getInstance().isGunIsDiscovered();
        cartridge = Environment.getInstance().isCartridgeIsDiscovered();
        beacon = Environment.getInstance().isBeaconIsDiscovered();

        if (gun && cartridge && beacon) {
            Tile Tgun = Environment.getInstance().getGunLocation();
            Tile Tcartridge = Environment.getInstance().getCartidgeLocation();
            Tile Tbeacon = Environment.getInstance().getBeaconLocation();

            return Tgun.equals(Tcartridge) && Tgun.equals(Tbeacon);
        }

        return false;
    }
}
