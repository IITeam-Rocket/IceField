package controllers.game.commands;

import controllers.game.GameJFrame;
import controllers.view.MapPresenter;
import models.Environment;
import models.figures.Eskimo;
import models.figures.Figure;
import models.figures.Researcher;

public class UnburyCommand implements Command {

    private final String[] args;

    /**
     * Constructor
     *
     * @param _args Command Arguments
     */
    public UnburyCommand(String[] _args) {
        args = _args;
    }

    /**
     * Command execution's logic.
     *
     */
    @Override
    public void execute() {
        if (args.length != 0) {
            GameJFrame.getInstance().outputToTextBox("IllegalArgument");
            return;
        }

        if (Environment.getInstance().getCurrentPlayer() == null) {
            GameJFrame.getInstance().outputToTextBox("There is no Figure selected, please use the\n \"nextcharacter\" command before the first unbury!");
            return;
        }

        Figure f = Environment.getInstance().getCurrentPlayer();

        switch (f.getBaseBodyHeat()) {
            case -1:
                GameJFrame.getInstance().outputToTextBox("The polar bear can't unbury!");
                break;
            case 4:
                ((Researcher) f).retrieveItem();
                break;
            case 5:
                ((Eskimo) f).retrieveItem();
                break;
            default:
                GameJFrame.getInstance().outputToTextBox("Unknown Figure Type!");
                break;
        }

        MapPresenter.getInstance().update();
    }
}
