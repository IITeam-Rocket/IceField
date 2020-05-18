package controllers.game.commands;

import controllers.game.GameJFrame;
import models.Environment;
import models.figures.Eskimo;
import models.figures.Figure;
import models.figures.Researcher;

/**
 * A command to build tent on a tile.
 *
 * @author Ábrahám Dániel
 */
public class BuildTentCommand implements Command {

    /**
     * Command execution's logic.
     *
     */
    @Override
    public void execute() {
        Figure figure = Environment.getInstance().getCurrentPlayer();

        if (figure == null) {
            GameJFrame.getInstance().outputToTextBox("There is no Figure currently selected!");
            return;
        }

        switch (figure.getBaseBodyHeat()) {
            case -1:
                GameJFrame.getInstance().outputToTextBox("A polar bear cannot build Tent!");
                break;
            case 4:
                ((Researcher) figure).buildTent();
                GameJFrame.getInstance().outputToTextBox("build tent: successful");
                return;
            case 5:
                ((Eskimo) figure).buildTent();
                GameJFrame.getInstance().outputToTextBox("build tent: successful");
                return;
            default:
                GameJFrame.getInstance().outputToTextBox("Unknown Figure!");
                break;
        }

        GameJFrame.getInstance().outputToTextBox("build tent: unsuccessful");
    }
}
