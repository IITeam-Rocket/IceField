package controllers.view;

import controllers.game.GameJFrame;
import models.tiles.Hole;
import models.tiles.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class HolePresenter extends TilePresenter {
    private final Hole hole;

    public HolePresenter(Hole hole, int x, int y) {
        super(x, y);
        this.hole = hole;

        button.setIcon(GameJFrame.getInstance().getTexture("stable"));

        button.setText(Integer.toString(hole.getID()));

        draw();
    }

    @Override
    public void draw() {
        int snowDepth = hole.getSnowDepth();
        boolean isDiscovered = hole.isAnalyzed();

        if(!isDiscovered)
        {
            button.setIcon(GameJFrame.getInstance().getTexture("stable_" + String.valueOf(snowDepth)));
            button.setText("");
        }
        else
        {
            button.setIcon(GameJFrame.getInstance().getTexture("water"));
            button.setText("0");
        }

            //TODO implement further
        }




    @Override
    public boolean isNeighbour(TilePresenter tile) {
        return hole.getNeighbours().contains(tile.getTile());
    }

    @Override
    public Tile getTile() {
        return hole;
    }
}
