package controllers.view;

import controllers.game.GameJFrame;
import models.tiles.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

abstract public class TilePresenter {
    protected final int x;
    protected final int y;
    protected JButton button;

    public TilePresenter(int x, int y) {
        this.x = x;
        this.y = y;

        button = new JButton();

        button.setBounds(x, y, 60, 60);
        button.setVisible(true);

        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.CENTER);

        GameJFrame.getInstance().add(button);
    }

    protected ImageIcon combineImage(ImageIcon tile, ImageIcon player, int x_offset, int y_offset)
    {
        int m_iconWidth = tile.getIconWidth();
        int m_iconHeight = tile.getIconHeight();

        BufferedImage m_buffer = new BufferedImage(m_iconWidth, m_iconHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D gr = (Graphics2D) m_buffer.getGraphics();
        gr.drawImage(tile.getImage(), 0, 0, null);
        if (player != null) {
            gr.drawImage(player.getImage(), x_offset, y_offset, null);
        }
        return new ImageIcon(m_buffer);
    }

    protected void drawFigures(ImageIcon base, Tile tile) {
        ImageIcon resultImage = base;

        for(int i = 0; i < tile.getEntities().size(); i++) {
            FigurePresenter figurePresenter = MapPresenter.getInstance().findFigure(tile.getEntities().get(i));
            if(figurePresenter != null) {
                resultImage = combineImage(resultImage, figurePresenter.getImage(), 0, 0);
            }
        }

        button.setIcon(resultImage);
    }

    public void draw() {
        // TODO implement draw()
    }

    abstract public boolean isNeighbour(TilePresenter tile);

    abstract public Tile getTile();

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
