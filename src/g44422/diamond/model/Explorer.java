package g44422.diamond.model;

import java.util.Objects;

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
		//this.state = State.CAMPING;
	}

	/**
	 * Checks if an explorer is equals to itself.
	 *
	 * @param o An empty obeject.
	 * @return True if the explorer isn't null, is an explorer and if it's equals to itself.
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Explorer explorer = (Explorer) o;
		return (Objects.equals(this.getPseudonym(), explorer.getPseudonym()) && Objects.equals(this.getBag(), explorer.getBag()) && this.getState() == explorer.getState());
	}

	/**
	 * Returns the hashCode of an explorer
	 *
	 * @return The hashcode of the explorer.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(pseudonym, bag, state);
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
		return this.bag;
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
	 * Returns the amount of rubies a player has in it's bag.
	 *
	 * @return The amount of rubies a player has in it's bag.
	 */
	public int getFortune() {
		return this.getBag().getNbRubies();
	}

	/**
	 * Makes the explorers reach the camp and set the as camping.
	 */
	public void reachCamp() {
		this.state = State.CAMPING;
	}

	/**
	 * Set the explorer's state to exploring so he can begin to explore.
	 */
	public void startExploration() {
		this.state = State.EXPLORING;
	}

	public void runAway() {
		this.getBag().loseContent();
		this.reachCamp();
	}
}
