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
	 * Creates a new cave, a new entrance and a new deck.
	 */
	public Cave() {
		nbExploredEntrance = 0;
		deck = new Deck();
	}

	public Cave(int i) {
		nbExploredEntrance = 0;
		deck = new Deck();
		currentEntrance = new CaveEntrance(this);
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
		if (currentEntrance == null) {
			currentEntrance = new CaveEntrance(this);
			nbExploredEntrance++;
		} else {
			if ((!hasNewEntranceToExplore()) || (!currentEntrance.isLockedOut())) {
				throw new GameException("Cannot open a new cave entrance.\nEither 5 entrances have already been opened or the exploring phase is still not finished for some explorers");
			} else {
				currentEntrance = new CaveEntrance(this);
				nbExploredEntrance++;
			}
		}
	}

	/**
	 * Locks the entry of the current cave entrance.
	 */
	public void lockOutCurrentEntrance() {
		this.currentEntrance.lockOut();
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
