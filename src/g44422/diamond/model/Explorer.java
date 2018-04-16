package g44422.diamond.model;

/**
 * Represents an explorer.
 *
 * @author g44422
 * @version 0.1
 */
public class Explorer {

	private String pseudonym;
	private Bag bag;
	private State state;

	/**
	 * Creates a new explorer.
	 *
	 * @param pseudonym The explorer's nick.
	 */
	public Explorer(String pseudonym) {
		this.pseudonym = pseudonym;
		this.bag = new Bag();
		this.state = State.EXPLORING;
	}

	/**
	 * Get the explorer's nickname.
	 *
	 * @return The explorer's nick.
	 */
	public String getPseudonym() {
		return pseudonym;
	}

	/**
	 * Returns the amount of rubbies in the explorer's bag.
	 *
	 * @return The amount of rubbies in the explorer's bag.
	 */
	public Bag getBag() {
		return bag;
	}

	/**
	 * Returns the explorer's state.
	 *
	 * @return The explorer's state.
	 */
	public State getState() {
		return state;
	}

	/**
	 * Adds the amount of rubbies in the explorer's bag.
	 *
	 * @param nbRubies The amound of rubies to add in the explorer's bag.
	 */
	public void addToBag(int nbRubies) {
		this.bag.addRubies(nbRubies);
	}

	/**
	 * Makes the explorer leav the cave.
	 */
	public void takeDecisionToLeave() {
		this.state = State.LEAVING;
	}

	/**
	 * Says if two explorers are the same.
	 *
	 * @param explorer2 Another explorer to compate to.
	 * @return The result of the comparaison.
	 */
	public boolean equals(Explorer explorer2) {
		return explorer2 != null && (this.getPseudonym().equals(explorer2.getPseudonym()));
	}
}
