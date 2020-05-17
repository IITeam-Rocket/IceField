package controllers.game.commands;

import controllers.game.Game;
import controllers.game.GameJFrame;
import models.Environment;
import models.figures.Figure;
import models.tiles.Tile;


/**
 * A command to craft signal flare
 *
 * @author Ábrahám Dániel
 */
public class CraftSignalFlareCommand implements Command {

    private Game game;
    private String[] args;

    /**
     * Constructor
     *
     * @param _game The Game Object
     * @param _args Command Arguments
     */
    public CraftSignalFlareCommand(Game _game, String[] _args) {
        game = _game;
        args = _args;
    }

    /**
     * Command execution's logic.
     */
    @Override
    public void execute() {
        Figure currentPlayer = Environment.getInstance().getCurrentPlayer();

        if (currentPlayer == null) {
            GameJFrame.getInstance().OutputToTextBox("There is no Figure currently selected!");
            return;
        }

        switch (currentPlayer.getBaseBodyHeat()) {
            case -1:
                GameJFrame.getInstance().OutputToTextBox("A polar bear cannot craft!");
                break;
            case 4:
            case 5:
                if (onTheSamePage())
                    ((models.figures.Character) currentPlayer).craftSignalFlare();
                break;
            default:
                GameJFrame.getInstance().OutputToTextBox("Unknown Figure!");
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
            Tile TGun = Environment.getInstance().getGunLocation();
            Tile TCartridge = Environment.getInstance().getCartridgeLocation();
            Tile TBeacon = Environment.getInstance().getBeaconLocation();

            return TGun.equals(TCartridge) && TGun.equals(TBeacon);
        }

        return false;
    }
}
