package g44422.diamond.model;

/**
 * Creates new custom exceptions for the game.
 *
 * @author g44422
 * @version 0.1
 */
public class GameException extends RuntimeException {

    /**
     * Creates a new instance of GameException without detail message.
     */
    public GameException() {
    }

    /**
     * Constructs an instance of GameException with the specified detail message.
     *
     * @param msg The detail message.
     */
    public GameException(String msg) {
        super(msg);
    }
}