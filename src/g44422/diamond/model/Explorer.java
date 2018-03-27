package g44422.diamond.model;

import java.util.*;

/**
 * Représente un explorzteur
 * @author g44422
 * @version 0.1
 */
public class Explorer {

    private String pseudonym;
    private Bag bag;
    private State state;

    /**
     * Crée un nouvel explorateur.
     * @param pseudonym Le pseudonyme sous lequel le joueur se fait appeler
     */
    public Explorer(String pseudonym) {
        this.pseudonym = pseudonym;
        this.bag = new Bag();
        this.state = State.EXPLORING;
    }

	/**
	 * Accède au nom de l'explorateur.
	 * @return le nom de l'explorateur
	 */
	public String getPseudonym() {
        return pseudonym;
    }

	/**
	 * Retourne le nombre de rubis dans le sac de l'explorateur
	 * @return le nombre de rubis de l'explorateur
	 */
	public Bag getBag() {
        return bag;
    }

	/**
	 * Retourne l'état de l'explrateur dans la grotte.
	 * @return l'état de l'explorateur
	 */
	public State getState() {
        return state;
    }

	/**
	 * Ajoute le nombre de rubis spécifié au sac de l'explorateur.
	 * @param nbRubies Nombre de rubis à ajouter au sac
	 */
	public void addToBag(int nbRubies) {
        this.bag.addRubies(nbRubies);
    }

	/**
	 * Fais quitter l'explorteur de la grotte.
	 */
	public void takeDecisionToLeave() {
        this.state = State.LEAVING;
    }
}
