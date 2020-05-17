package controllers.game.commands;

import controllers.game.Game;
import controllers.game.GameJFrame;
import models.Environment;
import models.figures.Figure;
import models.figures.Researcher;
import models.tiles.Tile;


/**
 * A command to analize tiles.
 *
 * @author Ábrahám Dániel
 */
public class AnalyzeTileCommand implements Command {

    private final Game game;
    private final String[] args;

    /**
     * Constructor
     *
     * @param _game The Game Object
     * @param _args Command Arguments
     */
    public AnalyzeTileCommand(Game _game, String[] _args) {
        game = _game;
        args = _args;
    }

    /**
     * Command execution's logic.
     */
    @Override
    public void execute() {
        if (args.length != 1)
            return;

        if (Environment.getInstance().getCurrentPlayer() == null) {
            GameJFrame.getInstance().outputToTextBox("There is no Figure currently selected, please use the\n \"nextcharacter\" command before!");
            return;
        }
        Figure figure = Environment.getInstance().getCurrentPlayer();

        int tileID = Integer.MIN_VALUE;

        try {
            tileID = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        if (Environment.getInstance().getIceTiles().size() - 1 < tileID || tileID < 0) {
            game.getOutput().println("Tile ID must be between 0 and the maximum ID of " + (Environment.getInstance().getIceTiles().size() - 1));
            return;
        }

        if (figure.getBaseBodyHeat() == 4) {
            Tile t = Environment.getInstance().getIceTiles().get(tileID);

            ((Researcher) figure).useSpecial(t);

        } else {
            game.getOutput().println("This figure cannot analyze tiles!");
        }
    }
}
