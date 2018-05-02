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
	 * Creates a new cave, a new entrance and a new deck.
	 */
	public Cave() {
		nbExploredEntrance = 0;
		deck = new Deck();
	}

	/**
	 * Creates a new cave just to get the tiles from this cave.
	 *
	 * @param i A parameter just to create another different contructor to have the tiles with the cave.
	 */
	public Cave(int i) {
		nbExploredEntrance = 0;
		deck = new Deck();
		currentEntrance = new CaveEntrance(this);
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
	 * Gets the current deck.
	 *
	 * @return The current game's deck.
	 */
	public Deck getDeck() {
		return deck;
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
	 * @throws GameException If the previous entrance is still not closed or if
	 *                       5 entrances have already been opened.
	 */
	public void openNewEntrance() {
		if (((!hasNewEntranceToExplore()) || (!currentEntrance.isLockedOut())) && currentEntrance != null) {
			throw new GameException("Cannot open a new cave entrance.\nEither 5 entrances have already been opened or the exploring phase is still not finished for some explorers");
		} else {
			currentEntrance = new CaveEntrance(this);
		}
	}

	/**
	 * Locks the entry of the current cave entrance and increments the amount of explored entrances.
	 */
	public void lockOutCurrentEntrance() {
		this.currentEntrance.lockOut();
		nbExploredEntrance++;
	}

	/**
	 * Checks if the last entrance is unsafe or not.
	 *
	 * @return True if the laste cave entrance is unsafe.
	 */
	public boolean isLastEntranceUnsafe() {
		return this.getCurrentEntrance().isUnsafe();
	}
}
