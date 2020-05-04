package controllers.game.commands;

import controllers.game.Game;
import models.Environment;
import models.figures.Eskimo;
import models.figures.Figure;
import models.figures.Researcher;

import java.io.PrintStream;

public class ClearSnowCommand implements Command {
    @Override
    public void execute(Game game, String[] args) {
        Environment e = Environment.getInstance();
        PrintStream out = game.getOutput();
        if (e.getCurrentPlayer() == null) {
            out.println("Nincs elérhető karakter");
        }
        Figure f = e.getCurrentPlayer();

        switch (f.getBaseBodyHeat()) {
            case -1:
                out.println("Polarbear can't clear snow!");
                break;
            case 4:
                ((Researcher) f).clearPatch();
                break;
            case 5:
                ((Eskimo) f).clearPatch();
                break;
            default:
                out.println("Error occurred");
                break;
        }
    }
}
