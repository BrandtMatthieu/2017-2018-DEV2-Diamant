/**
 * @author g44422
 */
package g44422.diamond.model;

public class GameException extends RuntimeException {

	/**
	 * Creates a new instance of GameException without detail message.
	 */
	public GameException() {
	}

	/**
	 * Constructs an instance of GameException with the specified detail message.
	 *
	 * @param msg the detail message.
	 */
	public GameException(String msg) {
		super(msg);
	}
}