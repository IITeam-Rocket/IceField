package controllers.view;

import controllers.game.GameJFrame;
import models.tiles.InstableIcePatch;
import models.tiles.Tile;

import javax.swing.*;
import java.io.Serializable;

public class InstableIcePatchPresenter extends TilePresenter implements Serializable {
    private final InstableIcePatch icePatch;

    public InstableIcePatchPresenter(InstableIcePatch icePatch, int x, int y) {
        super(x, y);
        this.icePatch = icePatch;

        button.setIcon(GameJFrame.getInstance().getTexture("stable"));

        button.setText(Integer.toString(icePatch.getID()));

        draw();
    }

    @Override
    public void draw() {
        int snowDepth = icePatch.getSnowDepth();
        int capacity = icePatch.getCapacity();
        boolean flipped = icePatch.isFlipped();
        boolean analyzed = icePatch.isAnalyzed();

        int protectionPriority = icePatch.getProtectionStrategy().getPriority(); //iglu 2 sátor 1 noProtection 0

        String Protection = "";

        ImageIcon base;

        if(!flipped) {
            if (protectionPriority == 2)
                Protection = "_iglu";
            else if (protectionPriority == 1)
                Protection = "_tent";

            base = GameJFrame.getInstance().getTexture("stable_" + snowDepth + Protection);
        }
        else
        {
            base = GameJFrame.getInstance().getTexture("water");
        }

        if(analyzed)
            button.setText(String.valueOf(capacity));
        else
            button.setText("");

        super.drawFigures(base, icePatch);
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
