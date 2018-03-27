
package g44422.diamond.model;

/**
 * Représent un sac pour chaque explorateur
 * @author 44422
 * @version 0.1
 */
public class Bag {

    private int nbRubies;

	/**
	 * Crée un nouveau sac pour le joueur.
	 */
    public Bag() {
        this.nbRubies = 0;
    }

	/**
	 * Ajoute le nombre de rubis spécifié au sac du joueur.
	 * @param nbRubies Nombre de rubis à ajouter
	 */
    public void addRubies(int nbRubies) {
        this.nbRubies = this.nbRubies + nbRubies;
    }

	/**
	 * Renvoit le nombre de rubis que possède le joueur.
	 * @return Le nombre de rubis possédé par le joueur
	 */
    public int getNbRubbies() {
        return this.nbRubies;
    }
}
