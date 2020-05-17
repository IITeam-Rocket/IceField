package models.items;

import controllers.game.GameJFrame;
import models.figures.Character;
import models.policies.FragileShovelPolicy;

import java.io.Serializable;

/**
 * A class representing a fragile shovel
 * that can be used to clear 2 units of
 * snow from a tile. It however will break
 * upon its third use.
 *
 * @author Józsa György
 * @version 3.0
 * @see models.items.Item
 * @since prototype
 * @since 2020.04.24
 */
public class FragileShovel extends Item implements Serializable {
    /**
     * Changes the strategy of the finder to clear an
     * ice patch.
     *
     * @param finder the character who discovered the item
     */
    @Override
    public void uponDiscovery(Character finder) {
        System.out.println("unburied item: 3");
        finder.changeClearSnowPolicy(new FragileShovelPolicy());
        GameJFrame.getInstance().showItemDialog(this.toString());
    }

    /**
     * Returns a string representation of the object. In general, the
     * {@code toString} method returns a string that
     * "textually represents" this object. The result should
     * be a concise but informative representation that is easy for a
     * person to read.
     * It is recommended that all subclasses override this method.
     * <p>
     * The {@code toString} method for class {@code Object}
     * returns a string consisting of the name of the class of which the
     * object is an instance, the at-sign character `{@code @}', and
     * the unsigned hexadecimal representation of the hash code of the
     * object. In other words, this method returns a string equal to the
     * value of:
     * <blockquote>
     * <pre>
     * getClass().getName() + '@' + Integer.toHexString(hashCode())
     * </pre></blockquote>
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "Fragile shovel";
    }
}
