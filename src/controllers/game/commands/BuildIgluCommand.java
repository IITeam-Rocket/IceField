package controllers.game.commands;

import controllers.game.GameJFrame;
import models.Environment;
import models.figures.Eskimo;
import models.figures.Figure;

/**
 * A command to build Iglu on the current tile.
 *
 * @author Ábrahám Dániel
 * @version 1.0
 */
public class BuildIgluCommand implements Command {

    /**
     * Command execution's logic.
     */
    @Override
    public void execute() {
        Figure figure = Environment.getInstance().getCurrentPlayer();

        if (figure == null) {
            GameJFrame.getInstance().outputToTextBox("There is no Figure selected, please use the\n \"nextcharacter\" command before the first buildiglu!");
            return;
        }

        switch (figure.getBaseBodyHeat()) {
            case -1:
                GameJFrame.getInstance().outputToTextBox("A polar bear cannot build Iglu!");
                break;
            case 4:
                GameJFrame.getInstance().outputToTextBox("A researcher cannot build Iglu!");
                break;
            case 5:
                ((Eskimo) figure).useSpecial(figure.getTile());
                GameJFrame.getInstance().outputToTextBox("build iglu: successful");
                return;
            default:
                GameJFrame.getInstance().outputToTextBox("Unknown Figure!");
                break;
        }

        GameJFrame.getInstance().outputToTextBox("build iglu: unsuccessful");
    }
}
