package g44422.diamond.model;

import java.util.ArrayList;
import java.util.List;

import static g44422.diamond.model.State.*;

/**
 * Creates a game.
 *
 * @author 44422
 * @version 0.1
 */
public class Game implements Model {

	private List<Explorer> explorers;
	private Cave cave;

	/**
	 * Creates a new game.
	 */
	public Game() {
		this.explorers = new ArrayList<>();
		this.cave = new Cave();
	}

	/**
	 * Adds a new explorer to the current game.
	 *
	 * @param explorer The explorer to add to the game.
	 * @throws GameException Thrown if it isn't possible to add any new explorer to the game.
	 */
	public void addExplorer(Explorer explorer) {
		if (isItPossibleToAddExplorer()) {
			this.explorers.add(explorer);
		} else {
			throw new GameException("Not possible to add any new explorer to the game.");
		}
	}

	/**
	 * Makes the explorer go forward in the cave.
	 */
	public void moveForward() {
		getCave().discoverNewTreasure(getExploringExplorers());
	}

	/**
	 * Says if the game is finished or not.
	 *
	 * @return The game's state.
	 */
	public boolean isOver() {
		/* TODO */
		return getExploringExplorers().isEmpty();
	}

	/**
	 * Returns the cave's number the explorers are in.
	 *
	 * @return The actual cave's number.
	 */
	public Cave getCave() {
		return cave;
	}

	/**
	 * Makes a list of all the explorers.
	 *
	 * @return A list with all the explorers.
	 */
	public List<Explorer> getExplorers() {
		return this.explorers;
	}

	/**
	 * Makes a list of all explorers curerntly exploring.
	 *
	 * @return All the exploring explorers.
	 */
	public List<Explorer> getExploringExplorers() {
		List<Explorer> exploringExplorers = new ArrayList<Explorer>();
		for (Explorer explorer : getExplorers()) {
			if (explorer.getState().equals(EXPLORING)) {
				exploringExplorers.add(explorer);
			}
		}
		return exploringExplorers;
	}

	/**
	 * Makes the wishing explorers leave the cave.
	 *
	 * @param explorer The explorer who want to leave the cave.
	 * @throws GameException Exception thrown if the explorer isn't in the list with the exploring explorers.
	 */
	public void handleExplorerDecisionToLeave(Explorer explorer) {
		if (getExploringExplorers().contains(explorer)) {
			explorer.takeDecisionToLeave();
		} else {
			throw new GameException("The explorer " + explorer.toString() + " does not makes part of all explorers in this game instance.");
		}
	}

	/**
	 * Checks if there are enough explorers.
	 *
	 * @throws GameException Exception thrown if the amount of players is incorrect.
	 */
	public void start() {
		if (!(isThereEnoughExplorer() && isItPossibleToAddExplorer())) {
			throw new GameException("Incorrect amount of players.");
		}
	}

	/**
	 * Checks if there is at least 3 explorers.
	 *
	 * @return True if there is at least 3 explorers.
	 */
	public boolean isThereEnoughExplorer() {
		return explorers.size() >= 3;
	}

	/**
	 * Checks if it is still possible to add new explorers to the game.
	 *
	 * @return True if it is possible to add new explorers to the game
	 */
	public boolean isItPossibleToAddExplorer() {
		return explorers.size() < 9;
	}
}
