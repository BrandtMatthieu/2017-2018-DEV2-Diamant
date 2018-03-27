
package g44422.diamond.controller;

import g44422.diamond.model.*;
import g44422.diamond.view.*;

/**
 * Classe controlant différents paramètres du jeu.
 * @author 44422
 * @version 0.1
 */
public class Controller {
	/**
	 * Crée un nouveau contrôleur pour la partie
	 * @param game La partie en cours
	 * @param view La vue actuelle
	 */
    public Controller(Model game, View view) {
        this.game = game;
        this.view = view;
    }

    /**
	 * Commence la partie
	 */
    void startGame() {
        /* TODO */
        new Controller(new Game(), new View(new Model()));
        int i=0;
        for(;i<3;i++) { // minimum 3 joueurs
            askExplorer();
        }
        while(isThereNewExplorerToAdd && i<8) {
            askExplorer();
        }
        
        while(!isOver()) {
            /* TODO */
        }
        
        displayEnd();
    }
}