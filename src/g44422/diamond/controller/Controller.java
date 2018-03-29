package g44422.diamond.controller;

import g44422.diamond.model.*;
import g44422.diamond.view.*;

/**
 * Class containing the differents main methods of the game.
 * @author 44422
 * @version 0.1
 */
public class Controller {

    Model game;
    View view;

    /**
	 * Creates a new controller for the game.
	 * @param game The current game.
	 * @param view The actual view.
	 */
    public Controller(Model game, View view) {
        this.game = game;
        this.view = view;
    }

    /**
	 * Begins the game.
	 */
    public void startGame() {
        new Controller(new Game(), new View(new Game()));
        int i=0;
        for(;i<3;i++) { // minimum 3 joueurs
            game.addExplorer(view.askExplorer());
        }
        while(view.isThereNewExplorerToAdd() && i<8) {
			game.addExplorer(view.askExplorer());
        }
        while(!game.isOver()) {
            /* TODO */
        }
        view.displayEnd();
    }
}