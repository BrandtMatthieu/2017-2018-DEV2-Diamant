package g44422.diamond.model;

/**
 * Defines a cave
 *
 * @author 44422
 * @version 0.1
 */
public class Cave {

	private int nbExploredEntrance;

	private CaveEntrance currentEntrance;

	private Deck deck;

	/**
	 * Gets the current deck.
	 *
	 * @return The current game's deck.
	 */
	public Deck getDeck() {
		return deck;
	}

	/**
	 * Creates a new cave.
	 */
	public Cave() {
		this.nbExploredEntrance = 0;
	}

	/**
	 * Returns the number of explored cave entrances.
	 *
	 * @return the number of explored cave entrances.
	 */
	public int getNbExploredEntrance() {
		return nbExploredEntrance;
	}

	/**
	 * Returns the current explored cave entrance.
	 *
	 * @return the current explored cave entrance.
	 */
	public CaveEntrance getCurrentEntrance() {
		return currentEntrance;
	}

	/**
	 * Returns true if less than 5 cave entrances have been explored.
	 *
	 * @return true if less than 5 cave entrances have been explored.
	 */
	public boolean hasNewEntranceToExplore() {
		return nbExploredEntrance < 5;
	}

	/**
	 * Opens a new entrance of the cave
	 *
	 * @throws GameException If the previous entrance is still not closed or if 5 entrances have already been opened.
	 */
	public void openNewEntrance() {
		if ((!hasNewEntranceToExplore()) || (!currentEntrance.isLockedOut())) {
			throw new GameException("Cannot open a new cave entrance.\nEither 5 entrances have already been opened or the exploring phase is still not finished for some explorers");
		} else {
			currentEntrance = new CaveEntrance();
		}
	}

	/**
	 * Locks the entry of the current cave entrance.
	 */
	public void lockOutCurrentEntrance() {
		this.currentEntrance.lockOut();
	}
}
