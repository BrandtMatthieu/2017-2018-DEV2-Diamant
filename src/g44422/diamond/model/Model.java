package g44422.diamond.model;

import java.util.List;

/**
 * Facade of Diamant.
 *
 * @author EsiProf
 * @see <a href="https://en.wikipedia.org/wiki/Facade_pattern">
 * Facade pattern
 * </a>
 * @see <a href="https://fr.wikipedia.org/wiki/Fa%C3%A7ade_(patron_de_conception)">
 * Façade (patron de conception)
 * </a>
 */
public interface Model {

	/**
	 * This methode can be used to add new player (explorer) in the game.
	 *
	 * @param explorer the explorer to add.
	 * @throws GameException Thrown if it isn't possible to add any new explorer to the game.
	 */
	void addExplorer(Explorer explorer);

	/**
	 * Make all exploring explorers move forward in the cave.
	 * The explorers share what they found.
	 */
	void moveForward();

	/**
	 * Declares if it's the end of the game.
	 *
	 * @return true if it's the end of the game.
	 */
	boolean isOver();

	/**
	 * Return the cave of the game.
	 *
	 * @return the game's cave.
	 */
	Cave getCave();

	/**
	 * Give all explorers of the game. They could be exploring or leaving.
	 *
	 * @return all the explorers of the game.
	 */
	List<Explorer> getExplorers();

	/**
	 * Give all explorers which are exploring.
	 *
	 * @return explorers in the cave.
	 */
	List<Explorer> getExploringExplorers();

	/**
	 * Consider the choice of the explorer to leave the cave.
	 *
	 * @param explorer The explorer who make the choice to leave.
	 * @throws GameException If the explorer is not in the current game.
	 */
	void handleExplorerDecisionToLeave(Explorer explorer);

	/**
	 * Checks if there are enough explorers before the game starts.
	 *
	 * @throws GameException Exception thrown if the amount of players is incorrect.
	 */
	void start();

	/**
	 * Checks if there is at least 3 explorers.
	 *
	 * @return True if there is at least 3 explorers.
	 */
	boolean isThereEnoughExplorer();

	/**
	 * Checks if it is still possible to add new explorers to the game.
	 *
	 * @return True if it is possible to add new explorers to the game
	 */
	boolean isItPossibleToAddExplorer();
}
