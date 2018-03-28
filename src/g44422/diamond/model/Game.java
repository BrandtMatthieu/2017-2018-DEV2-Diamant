package g44422.diamond.model;

import java.util.List;

/**
 * Créé une partie
 * @author 44422
 * @version 0.1
 */
public class Game implements Model {

    public List<Explorer> explorers;
    public Cave cave;

	/**
	 * Crée une nouvelle partie
	 */
	public Game() {
        this.explorers = null;
        this.cave = null;
    }

	/**
	 * Ajoute un explorateur à la partie en cours.
	 * @param explorer l'explorateur à ajouter
	 */
	public void addExplorer(Explorer explorer) {
        explorers.add(explorer);
    }

	/**
	 * Fais avancer l'explorateur à la case suivante
	 */
	public void moveForward() {
        /* TODO */
        /*
        for (int i = 0; i < explorers.size(); i++) {
		if (explorers.get(i).getState() == EXPLORING) {
			e
		}
        } */

    }

	/**
	 * Détermine si la partie est finie ou non.
	 * @return l'état de la partie
	 */
	public boolean isOver() {
        return !(getExploringExplorers().size()>0);
    }

	/**
	 * Retourne le numéro de la grotte dans laquelle sont les explorateurs.
	 * @return le noméro de la grotte actuelle
	 */
	public Cave getCave() {
        return cave;
    }

	/**
	 * Etablit la liste des explorateurs de la partie.
	 * @return les explorteurs inscrit dans la partie
	 */
	public List<Explorer> getExplorers() {
        return explorers;
    }

	/**
	 * Etablit la liste des explorateurs qui sont actuellement en exploration.
	 * @return les explorateurs qui explorent
	 */
	public List<Explorer> getExploringExplorers() {
        List <Explorer> exploringExplorers = getExplorers();
        for(int i=0;i<exploringExplorers.size();i++) {
            if(explorer.get(i).state==EXPLORING) {
                exploringExplorers.add(explorers.get(i));
            }
        }
        return exploringExplorers;
    }

	/**
	 * Fait quitter la grotte à l'explorateur qui le souhaite.
	 * @param explorer l'explorateur souhaitant quitter la grotte
	 * @throws RuntimeException si l'explorateur n'est pas dans la partie
	 */
	public void handleExplorerDecisionToLeave(Explorer explorer) {
        if(!getExplorers().contains(explorer)) {
            explorer.takeDecisionToLeave();
        } else {
            throw new RuntimeException();
        }
        
    }

}
