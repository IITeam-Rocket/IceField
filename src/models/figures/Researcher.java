package models.figures;

import models.exceptions.EndOfGameException;
import models.tiles.Tile;

import java.io.Serializable;

/**
 * A character with the ability to analyze
 * the surrounding tiles' capacity to hold
 * players.
 *
 * @author Józsa György
 * @version 2.0
 * @see models.figures.Character
 * @see models.figures.Figure
 * @since skeleton
 * @since 2020.03.10
 */
public class Researcher extends Character implements Serializable {

    /**
     * Creates a new eskimo with 4 body heat and 4 stamina.
     */
    public Researcher() {
        super(4, 4);
    }

    /**
     * Creates a new eskimo with the given tile and with 4 body heat and 4 stamina.
     */
    public Researcher(Tile starting) {
        super(4, 4);
        this.tile = starting;
    }

    /**
     * Analyzes the target tile, and finds its
     * capacity.
     *
     * @param target the Tile on which the ability
     *               is performed.
     */
    @Override
    public void useSpecial(Tile target) {
        if (stamina > 0) {
            if(!tile.getNeighbours().contains(target)) {
                System.out.println("Tile with ID " + target.getID() + " isn't a neighbour of the tile, the character is currently on!");
                return;
            }
            System.out.println("capacity: " + target.getCapacity());
        } else
            System.out.println("Not Enough Stamina available to complete this action!");
    }

    /**
     * TODO: description
     *
     * @throws EndOfGameException if the Researcher dies.
     */
    @Override
    public void step() throws EndOfGameException {
        if(tile.getCapacity() == 0){
            System.out.println("Researcher remains in water at the end of the turn, researcher dies!");
            System.out.println("Game over!");
        }
        stamina = 4;
        System.out.println("researcher");
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
     * @return four
     */
    @Override
    public int getBaseBodyHeat() {
        return 4;
    }
}
