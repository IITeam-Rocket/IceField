package controllers.game.commands;

import controllers.game.GameJFrame;
import models.Environment;
import models.figures.Figure;


/**
 * A command to craft signal flare
 *
 * @author Ábrahám Dániel
 */
public class CraftSignalFlareCommand implements Command {

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

        boolean gun;
        boolean cartridge;
        boolean beacon;
        gun = Environment.getInstance().isGunIsDiscovered();
        cartridge = Environment.getInstance().isCartridgeIsDiscovered();
        beacon = Environment.getInstance().isBeaconIsDiscovered();

        switch (currentPlayer.getBaseBodyHeat()) {
            case -1:
                GameJFrame.getInstance().OutputToTextBox("A polar bear cannot craft!");
                break;
            case 4:
            case 5:
                if (gun && cartridge && beacon) {
                    ((models.figures.Character) currentPlayer).craftSignalFlare();
                }
                else
                    GameJFrame.getInstance().OutputToTextBox("At least one part is missing");
                break;
            default:
                GameJFrame.getInstance().OutputToTextBox("Unknown Figure!");
                break;
        }
    }

}
