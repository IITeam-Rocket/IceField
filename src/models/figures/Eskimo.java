package models.figures;

import models.exceptions.EndOfGameException;
import models.policies.IglooPolicy;
import models.tiles.IcePatch;
import models.tiles.Tile;

import java.io.Serializable;

/**
 * A character with the ability to build Igloos
 *
 * @author Józsa György
 * @version 2.0
 * @see models.figures.Figure
 * @see models.figures.Character
 * @since skeleton
 * @since 2020.03.10
 */
public class Eskimo extends Character implements Serializable {

    /**
     * Creates a new eskimo with 5 body heat and 4 stamina.
     */
    public Eskimo() {
        super(5, 4);
    }

    /**
     * Creates a new eskimo with the given tile and with 5 body heat and 4 stamina.
     */
    public Eskimo(Tile starting) {
        super(5, 4);
        this.tile = starting;
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
            if (target == tile)
                ((IcePatch) tile).changeProtectionPolicy(new IglooPolicy());
        } else
            System.out.println("Not enough stamina!");
    }

    /**
     * TODO: description
     *
     * @throws EndOfGameException if the Eskimo dies.
     */
    @Override
    public void step() throws EndOfGameException {
        System.out.println("eskimo");
        System.out.println("bodyheat: " + bodyHeat);
        System.out.println("stamina: " + stamina);
        System.out.println("clearPatchStrategy: " + clearPatchStrategy.toString());
        System.out.println("helpFriendStrategy: " + helpFriendStrategy.toString());
        System.out.println("swimToShoreStrategy: " + swimToShoreStrategy.toString());
        System.out.println("tile: " + tile.getID());

        //TODO Ha meghal?

        stamina = 4;
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
