package controllers.view;

import controllers.game.GameJFrame;
import models.figures.Figure;
import models.tiles.Tile;

import javax.swing.*;

public abstract class FigurePresenter {
    protected JButton button;

    public FigurePresenter() {
        button = new JButton();

        button.setBounds(0, 0, 18, 18);
        button.setVisible(true);

        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.CENTER);

        GameJFrame.getInstance().add(button);
    }

    public abstract Figure getFigure();

    public void draw(int x, int y) {
        button.setBounds(x, y, 18, 18);
    }
}
