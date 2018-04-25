package g44422.diamond.controller;

import g44422.diamond.model.Explorer;
import g44422.diamond.model.Model;
import g44422.diamond.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Class containing the differents main methods of the game.
 *
 * @author 44422
 * @version 0.1
 */
public class Controller {

	private Model game;
	private View view;

	/**
	 * Creates a new controller for the game.
	 *
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
		while (!game.isThereEnoughExplorer()) {
			game.addExplorer(view.askExplorer());
		}
		while (game.isItPossibleToAddExplorer() && view.isThereNewExplorerToAdd()) {
			game.addExplorer(view.askExplorer());
		}
		game.start();
		while (!game.isOver()) {
			game.startNewExplorationPhase();
			while (!game.isExplorationPhaseOver()) {
				game.moveForward(); //make the explorers discover tiles, does not initialise anything
				view.displayGame(); //displays a message, does not initialise anything
				view.turnResumeDisplay();
				List<Explorer> leavingExplorers = new ArrayList<Explorer>();
				for (int j = 0; j < game.getExploringExplorers().size(); j++) {
					Explorer explorerToAsk = game.getExploringExplorers().get(j);
					if (view.askExplorerChoiceToContinue(explorerToAsk)) {
						leavingExplorers.add(explorerToAsk);

					}
				}
				for (Explorer leavingExplorer : leavingExplorers) {
					game.handleExplorerDecisionToLeave(leavingExplorer);
				}
			}
			game.makeExplorersLeave();
			game.endExplorationPhase();
		}
		view.displayWinner();
	}
}