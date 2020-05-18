package models.figures;

import controllers.game.GameJFrame;
import controllers.view.MapPresenter;
import models.policies.IglooPolicy;
import models.tiles.IcePatch;
import models.tiles.Tile;

import java.io.Serializable;

/**
 * A character with the ability to build Igloos
 *
 * @author Józsa György
 * @version 3.0
 * @see models.figures.Figure
 * @see models.figures.Character
 * @see models.Subject
 * @see java.io.Serializable
 * @since skeleton
 * @since 2020.03.10
 */
public class Eskimo extends Character implements Serializable {

    /**
     * Creates a new eskimo with 5 body heat and 4 stamina.
     */
    public Eskimo() {
        super(5, 4);
        register(MapPresenter.getInstance());
        initObservers();
    }

    /**
     * Creates a new eskimo with the given tile and with 5 body heat and 4 stamina.
     */
    public Eskimo(Tile starting) {
        super(5, 4);
        this.tile = starting;
        initObservers();
    }

    /**
     * Helper method to initialize observers
     */
    @Override
    protected void initObservers() {
        register(MapPresenter.getInstance());
    }

    /**
     * Builds an Igloo on the target Tile,
     * changing its FrostBitePolicy.
     *
     * @param target the Tile on which the ability
     */
    @Override
    public void useSpecial(Tile target) {
        if (stamina > 0) {
            if (target == tile) {
                ((IcePatch) tile).changeProtectionPolicy(new IglooPolicy());
                --stamina;
                notifyObservers();
            }
        } else {
            GameJFrame.getInstance().outputToTextBox("Not Enough Stamina available to complete this action!");
            MapPresenter.getInstance().update();
        }
    }

    /**
     * Returns the base body heat of the figure
     *
     * @return five
     */
    @Override
    public int getBaseBodyHeat() {
        return 5;
    }
}
