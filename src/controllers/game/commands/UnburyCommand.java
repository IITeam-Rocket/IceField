package controllers.game.commands;

import controllers.game.Game;
import models.Environment;
import models.figures.Eskimo;
import models.figures.Figure;
import models.figures.Researcher;

public class UnburyCommand implements Command {
    @Override
    public void execute(Game game, String[] args) {
        if (args.length != 0) {
            game.getOutput().println("IllegalArgumentException");
            return;
        }

        if (Environment.getInstance().getCurrentPlayer() == null) {
            game.getOutput().println("There is no Figure selected, please use the \"nextcharacter\" command before the first unbury!");
            return;
        }

        Figure f = Environment.getInstance().getCurrentPlayer();

        switch (f.getBaseBodyHeat()) {
            case -1:
                game.getOutput().println("The polar bear can't unbury!");
                break;
            case 4:
                ((Researcher) f).retrieveItem();
                break;
            case 5:
                ((Eskimo) f).retrieveItem();
                break;
            default:
                game.getOutput().println("Unknown Figure Type!");
                break;
        }
    }
}
