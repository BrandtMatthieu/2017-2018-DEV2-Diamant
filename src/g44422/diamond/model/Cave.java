
package g44422.diamond.model;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collection;

/**
 * Définit une grotte
 * @author 44422
 * @version 0.1
 */
public class Cave {

    Treasure lastDiscoveredTreasure;

	/**
	 * Retourne le dernier trésor découvert par le joueur.
	 * @return le dernier trésor découvert.
	 */
    public Treasure getLastDiscoveredTreasure() {
        return lastDiscoveredTreasure;
    }

	/**
	 * Crée un nouvelle grotte
	 */
	public Cave() {
        lastDiscoveredTreasure = new Treasure();
    }

	/**
	 * Indique aux explorateurs la dernière tuile qu'ils viennent de découvrir.
	 * @param explorers Les explorateurs qui découvrent la tuile.
	 */
    public void discoveredNewTreasure(List<Explorer> explorers) {
		getLastDiscoveredTreasure().explore(explorers);
    }
}
