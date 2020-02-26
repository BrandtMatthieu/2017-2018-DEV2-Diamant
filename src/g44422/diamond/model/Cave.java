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

    private int nbTakenRelics;

    /**
     * Creates a new cave, a new deck and sets the number of found relics to 0.
     */
    public Cave() {
        nbExploredEntrance = 0;
        deck = new Deck();
        nbTakenRelics = 0;
    }

    /**
     * Creates a new cave just to get the tiles from this cave.
     *
     * @param i A parameter just to create another different constructor to have
     * the tiles with the cave.
     */
    public Cave(int i) {
        nbExploredEntrance = 0;
        deck = new Deck();
        currentEntrance = new CaveEntrance(this);
        nbTakenRelics = 0;
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
     * Tells how much relics have already been taken.
     *
     * @return The amount of relics already taken by the other explorers.
     */
    public int getNbTakenRelics() {
        return nbTakenRelics;
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
     * Increments the number of taken relics.
     */
    public void incrementNbTakenRelics() {
        nbTakenRelics++;
    }

    /**
     * Checks if the last entrance is unsafe or not.
     *
     * @return True if the laste cave entrance is unsafe.
     */
    public boolean isLastEntranceUnsafe() {
        return this.getCurrentEntrance().isUnsafe();
    }

    /**
     * Locks the entry of the current cave entrance and increments the amount of
     * explored entrances.
     */
    public void lockOutCurrentEntrance() {
        this.currentEntrance.lockOut();
        nbExploredEntrance++;
    }

    /**
     * Opens a new entrance of the cave
     *
     * @throws GameException If the previous entrance is still not closed or if
     * 5 entrances have already been opened.
     */
    public void openNewEntrance() {
        if (currentEntrance != null && ((!hasNewEntranceToExplore()) || (!currentEntrance.isLockedOut()))) {
            throw new GameException("Cannot open a new cave entrance.\nEither 5 entrances have already been opened or the exploring phase is still not finished for some explorers");
        } else {
            currentEntrance = new CaveEntrance(this);
        }
    }
}
