package controllers.game.commands;

import controllers.game.Game;
import controllers.game.GameJFrame;
import controllers.view.MapPresenter;
import models.Environment;
import models.exceptions.EndOfGameException;
import models.tiles.Tile;

public class MoveCommand implements Command {

    private final Game game;
    private final String[] args;

    /**
     * Constructor
     *
     * @param _game The Game Object
     * @param _args Command Arguments
     */
    public MoveCommand(Game _game, String[] _args) {
        game = _game;
        args = _args;
    }

    /**
     * Command execution's logic.
     *
     */
    @Override
    public void execute() {
        if (Environment.getInstance().getCurrentPlayer() == null) {
            GameJFrame.getInstance().OutputToTextBox("There is no Figure selected, please use the\n \"nextcharacter\" command before the first move!");
            return;
        }

        Tile currentTile = Environment.getInstance().getCurrentPlayer().getTile();

        if (args.length == 0) {
            GameJFrame.getInstance().OutputToTextBox("neighbours: ");
            StringBuilder sb = new StringBuilder();
            currentTile.getNeighbours().forEach(t -> sb.append(String.format("%d ", t.getID())));
            GameJFrame.getInstance().OutputToTextBox(sb.toString().trim());
        } else if (args.length == 1) {
            int tileID;
            try {
                tileID = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                MapPresenter.getInstance().update();
                return;
            }

            for (Tile tile : currentTile.getNeighbours()) {
                if (tile.getID() == tileID) {
                    try {
                        Environment.getInstance().getCurrentPlayer().moveTo(tile);
                        MapPresenter.getInstance().update();
                    } catch (EndOfGameException e) {
                        GameJFrame.getInstance().OutputToTextBox(e.getMessage());
                        Environment.getInstance().gameOver();
                    }
                    MapPresenter.getInstance().update();
                    return;
                }
            }

            GameJFrame.getInstance().OutputToTextBox(String.format("move character to %d: unsuccessful", tileID));
            GameJFrame.getInstance().OutputToTextBox(String.format("The current Tile has no neighbor with the ID %d", tileID));

            MapPresenter.getInstance().update();
        }
    }
}
