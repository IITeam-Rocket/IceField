package models.tiles;

import models.characters.Character;

import java.util.Random;

import static controllers.TabController.*;

/**
 * A tile with no solid platform.
 */
public class Hole extends Tile {

    private boolean isDiscovered = false;

    public Hole() {
        Random r = new Random();
        int i = 0;
        while (i == 0)
            i = r.nextInt(maxSnowDepth + 1);

        snowDepth = i;
    }

    /**
     * If the Hole has not been revealed, the
     * accepts the player, otherwise it doesn't.
     *
     * @param character the player to accept
     * @return true if successful, false otherwise
     */
    @Override
    public boolean acceptCharacter(Character character) {
        addIndent();
        printlnWithIndents("Hole.acceptCharacter()");

        if(!isDiscovered){
            reveal();
            character.swimToShore();

            printlnWithIndents("return: true");
            removeIndent();
            return true;
        }

        printlnWithIndents("return: false");
        removeIndent();
        return false;
    }

    /**
     * Realises the storm's effects.
     */
    @Override
    public void reactToStorm() {
        addIndent();
        printlnWithIndents("Hole.reactToStorm()");

        addSnow(1);

        printlnWithIndents("return");
        removeIndent();

    }

    /**
     * Returns the maximum number of characters the
     * Tile can hold at one time, which is zero.
     *
     * @return 0
     */
    @Override
    public int getCapacity() {
        addIndent();
        printlnWithIndents("Hole.getCapacity()");

        reveal();

        printlnWithIndents("return: 0");
        removeIndent();

        return 0;
    }
    /**
     * Sets isDiscovered true.
     */
    public void reveal(){
        addIndent();
        printlnWithIndents("Hole.reveals()");
        setDiscovered(true);

        printlnWithIndents("return");
        removeIndent();
    }

    public boolean isDiscovered() {
        return isDiscovered;
    }

    public void setDiscovered(boolean discovered) {
        isDiscovered = discovered;
    }
}
