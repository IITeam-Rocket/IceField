package controllers.view;

import controllers.game.GameJFrame;
import models.tiles.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.Serializable;

abstract public class TilePresenter implements Serializable {
    protected final int x;
    protected final int y;
    protected final JButton button;

    /**
     * Constructor
     * @param x where X
     * @param y where Y
     */
    public TilePresenter(int x, int y) {
        this.x = x;
        this.y = y;

        button = new JButton();

        button.addActionListener(e -> GameJFrame.getInstance().setActiveTile(getTile()));

        button.setBounds(x, y, 60, 60);
        button.setVisible(true);

        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.CENTER);

        GameJFrame.getInstance().add(button);
    }

    /**
     * Initialize
     */
    public void init() {
        GameJFrame.getInstance().add(button);

        if(button.getActionListeners().length != 0)
            button.removeActionListener(button.getActionListeners()[0]);

        button.addActionListener(e -> GameJFrame.getInstance().setActiveTile(getTile()));

        GameJFrame.getInstance().repaint();
    }

    /**
     * Destroy
     */
    public void destroy() {
        GameJFrame.getInstance().remove(button);
    }

    /**
     * Put the second image on the first one with an offset.
     * @param tile First ImageIcon
     * @param player Second ImageIcon
     * @param x_offset x offset
     * @param y_offset y offset
     * @return ImageIcon combined
     */
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

    /**
     * Get the next figure's X
     * @param num figure num
     * @return next X
     */
    protected int getFigureX(int num) {
        switch (num) {
            case 1:
            case 4:
            case 7:
                return 21;
            case 2:
            case 5:
            case 8:
                return 42;
            default:
                return 0;
        }
    }

    /**
     * Get the next figure's Y
     * @param num figure num
     * @return next Y
     */
    protected int getFigureY(int num) {
        switch (num) {
            case 3:
            case 4:
            case 5:
                return 21;
            case 6:
            case 7:
            case 8:
                return 42;
            default:
                return 0;
        }
    }

    /**
     * Draw Figures
     * @param base Base Tile ImageIcon
     * @param tile Tile where we look for Figures
     */
    protected void drawFigures(ImageIcon base, Tile tile) {
        ImageIcon resultImage = base;

        for(int i = 0; i < tile.getEntities().size(); i++) {
            FigurePresenter figurePresenter = MapPresenter.getInstance().findFigure(tile.getEntities().get(i));
            if(figurePresenter != null) {
                    resultImage = combineImage(resultImage, figurePresenter.getImage(), getFigureX(i), getFigureY(i));
            }
        }

        button.setIcon(resultImage);
    }

    /**
     * Draw
     */
    public void draw() {
        //Empty
    }

    /**
     * Check if the TilePresenter's Tile whether is a neighbour of the current Tile
     * @param tile TilePresenter to test
     * @return Boolean result
     */
    abstract public boolean isNeighbour(TilePresenter tile);

    /**
     * Get Tile
     * @return Tile
     */
    abstract public Tile getTile();

    /**
     * Get X
     * @return X
     */
    public int getX() {
        return x;
    }

    /**
     * Get Y
     * @return Y
     */
    public int getY() {
        return y;
    }
}
