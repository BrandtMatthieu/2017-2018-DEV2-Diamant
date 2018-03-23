package g44422.diamond.model;
import java.util.*;
/**
 * Représente un explorzteur
 * @author g44422
 */
public class Explorer {
	private String pseudonym;
	private Bag bag;
	private State state;

	/**
	 * Crée un nouvel explorateur
	 * @param pseudonym Le pseudonyme sous lequel le joueur se fait appeler
	 */
	public Explorer(String pseudonym) {
		this.pseudonym = pseudonym;
		this.bag = new Bag();
		this.state = State.EXPLORING;
	}

	public String getPseudonym() {
		return pseudonym;
	}

	public Bag getBag() {
		return bag;
	}

	public State getState() {
		return state;
	}

	public void addToBag(int nbRubies) {
		this.bag.addRubies(nbRubies);
	}

	public void takeDecisionToLeave() {
		this.state = State.LEAVING;
	}
}
