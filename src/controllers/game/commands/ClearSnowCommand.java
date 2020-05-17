package controllers.game.commands;

import controllers.game.GameJFrame;
import controllers.view.MapPresenter;
import models.Environment;
import models.figures.Eskimo;
import models.figures.Figure;
import models.figures.Researcher;

/**
 * A command to clear the snow a the current tile
 *
 * @author Ábaráhm Dániel
 */
public class ClearSnowCommand implements Command {

    /**
     * Command execution's logic.
     */
    @Override
    public void execute() {
        Environment e = Environment.getInstance();
        if (e.getCurrentPlayer() == null) {
            GameJFrame.getInstance().OutputToTextBox("Nincs elérhető karakter");
        }
        Figure f = e.getCurrentPlayer();

        switch (f.getBaseBodyHeat()) {
            case -1:
                GameJFrame.getInstance().OutputToTextBox("Polar bear can't clear snow!");
                break;
            case 4:
                ((Researcher) f).clearPatch();
                break;
            case 5:
                ((Eskimo) f).clearPatch();
                break;
            default:
                GameJFrame.getInstance().OutputToTextBox("Error occurred");
                break;
        }

        MapPresenter.getInstance().update();
    }
}
