package models.exceptions;

/**
 * Exception signifying the end of the game.
 *
 * @author Ábrahám Dániel
 * @version 2.0
 * @see Exception
 * @since skeleton
 * @since 2020.03.10
 */
public class EndOfGameException extends Exception {
    public EndOfGameException(String msg) {
        super(msg);
    }
}
