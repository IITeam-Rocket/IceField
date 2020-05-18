package controllers.game.commands;

import controllers.game.GameJFrame;
import controllers.view.*;
import models.Environment;
import models.figures.Eskimo;
import models.figures.Figure;
import models.figures.PolarBear;
import models.figures.Researcher;
import models.tiles.IcePatch;
import models.tiles.Tile;

/**
 * A command to add a new character to a tile.
 *
 * @author Ábrahám Dániel
 */
public class AddCharacterToTileCommand implements Command {

    private final String[] args;

    /**
     * Constructor
     *
     * @param _args Command Arguments
     */
    public AddCharacterToTileCommand(String[] _args) {
        args = _args;
    }

    /**
     * Command execution's logic.
     */
    @Override
    public void execute() {
        if (args.length == 2) {
            int tileID = Integer.MIN_VALUE;
            int characterID = Integer.MIN_VALUE;

            try {
                tileID = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                GameJFrame.getInstance().outputToTextBox("Error!");
            }

            try {
                characterID = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                GameJFrame.getInstance().outputToTextBox("Error!");
            }

            if (tileID < 0 || Environment.getInstance().getIceTiles().size() - 1 < tileID) {
                GameJFrame.getInstance().outputToTextBox("Tile ID must be between 0 and the maximum ID of " + (Environment.getInstance().getIceTiles().size() - 1));
                return;
            }

            Tile tile = Environment.getInstance().getIceTiles().get(tileID);

            if (tile.getCapacity() == 0) {
                GameJFrame.getInstance().outputToTextBox("Characters can't be placed in a hole!");
                return;
            }

            IcePatch patch = (IcePatch) tile;

            Figure figure;
            FigurePresenter presenter;

            switch (characterID) {
                case 1:
                    Eskimo eskimo = new Eskimo();
                    figure = eskimo;
                    presenter = new EskimoPresenter(eskimo);
                    break;
                case 2:
                    Researcher researcher = new Researcher();
                    presenter = new ResearcherPresenter(researcher);
                    figure = researcher;
                    break;
                case 3:
                    PolarBear polarBear = new PolarBear();
                    presenter = new PolarBearPresenter(polarBear);
                    figure = polarBear;
                    break;
                default:
                    GameJFrame.getInstance().outputToTextBox("Character ID mush be between 1 and 3!");
                    return;
            }

            patch.addCharacter(figure);
            figure.setTile(patch);
            Environment.getInstance().getPlayers().add(figure);
            MapPresenter.getInstance().addFigurePresenter(presenter);

            GameJFrame.getInstance().outputToTextBox("character added: " + tileID + ", " + characterID);
        }
    }
}
