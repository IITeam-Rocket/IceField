package controllers.game.commands;

import controllers.game.Game;
import controllers.game.GameJFrame;
import models.Environment;
import models.figures.Eskimo;
import models.figures.Figure;

public class BuildIgluCommand implements Command {

    private final Game game;
    private final String[] args;

    /**
     * Constructor
     *
     * @param _game The Game Object
     * @param _args Command Arguments
     */
    public BuildIgluCommand(Game _game, String[] _args) {
        game = _game;
        args = _args;
    }

    /**
     * Command execution's logic.
     */
    @Override
    public void execute() {
        Figure figure = Environment.getInstance().getCurrentPlayer();

        if (figure == null) {
            GameJFrame.getInstance().OutputToTextBox("There is no Figure selected, please use the \"nextcharacter\" command before the first buildiglu!");
            return;
        }

        switch (figure.getBaseBodyHeat()) {
            case -1:
                GameJFrame.getInstance().OutputToTextBox("A polar bear cannot build Iglu!");
                break;
            case 4:
                GameJFrame.getInstance().OutputToTextBox("A researcher cannot build Iglu!");
                break;
            case 5:
                ((Eskimo) figure).useSpecial(figure.getTile());
                GameJFrame.getInstance().OutputToTextBox("build iglu: successful");
                return;
            default:
                GameJFrame.getInstance().OutputToTextBox("Unknown Figure!");
                break;
        }

        GameJFrame.getInstance().OutputToTextBox("build iglu: unsuccessful");
    }
}
