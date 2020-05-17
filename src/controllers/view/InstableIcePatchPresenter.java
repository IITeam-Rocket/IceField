package controllers.view;

import controllers.game.GameJFrame;
import models.policies.ProtectionPolicy;
import models.tiles.InstableIcePatch;
import models.tiles.Tile;

import javax.swing.*;
import java.awt.*;

public class InstableIcePatchPresenter extends TilePresenter {
    private final InstableIcePatch icePatch;

    public InstableIcePatchPresenter(InstableIcePatch icePatch, int x, int y) {
        super(x, y);
        this.icePatch = icePatch;

        button.setIcon(GameJFrame.getInstance().getTexture("stable"));

        button.setText(Integer.toString(icePatch.getID()));

        GameJFrame.getInstance().getContentPane().validate();
        GameJFrame.getInstance().getContentPane().repaint();
    }

    @Override
    public void draw() {
        int snowDepth = icePatch.getSnowDepth();
        int capacity = icePatch.getCapacity();
        boolean flipped = icePatch.isFlipped();
        boolean analyzed = icePatch.isAnalyzed();

        int protpririty = icePatch.getProtectionStrategy().getPriority(); //iglu 2 sátor 1 noprot 0

        String Protection = new String("");

        if(!flipped) {
            if (protpririty == 2)
                Protection = "_iglu";
            else if (protpririty == 1)
                Protection = "_tent";

            button.setIcon(GameJFrame.getInstance().getTexture("stable_" + String.valueOf(snowDepth) + Protection));
        }
        else
        {
            button.setIcon(GameJFrame.getInstance().getTexture("water"));
        }

        if(analyzed)
            button.setText(String.valueOf(capacity));
        else
            button.setText("");

        SwingUtilities.updateComponentTreeUI(GameJFrame.getInstance());



        //TODO implement further
    }

    @Override
    public boolean isNeighbour(TilePresenter tile) {
        return icePatch.getNeighbours().contains(tile.getTile());
    }

    @Override
    public Tile getTile() {
        return icePatch;
    }
}
