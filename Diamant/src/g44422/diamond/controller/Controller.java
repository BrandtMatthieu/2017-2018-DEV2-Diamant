package g44422.diamond.controller;

import g44422.diamond.model.*;
import g44422.diamond.view.*;

import java.util.ArrayList;
import java.util.List;

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
    	int i=0;
        for(;i<3;i++) { // minimum 3 joueurs
            game.addExplorer(view.askExplorer());
        }
        while(view.isThereNewExplorerToAdd() && i<=7) {
			game.addExplorer(view.askExplorer());
			i++;
        }
        while(!game.isOver()) {
            game.moveForward();
            view.displayGame();
            List <Explorer> leavingExplorers = new ArrayList<Explorer>();
			for(int j = 0;j<game.getExploringExplorers().size();j++) {
			    Explorer explorerToAsk = game.getExploringExplorers().get(j);
			    if(view.askExplorerChoiceToContinue(explorerToAsk)) {
                    leavingExplorers.add(explorerToAsk);
                }
			}
            for (Explorer leavingExplorer : leavingExplorers) {
                game.handleExplorerDecisionToLeave(leavingExplorer);
            }
        }
        view.displayEnd();
    }
}